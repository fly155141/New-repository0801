package com.ispan.sb.exam.services;

import com.ispan.sb.exam.Table1;
import com.ispan.sb.exam.User;
import com.ispan.sb.exam.repository.FavoriteRepository;
import com.ispan.sb.exam.repository.Table1Repository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

@Service
public class Table1Service {

    @Autowired
    private Table1Repository table1Repository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    // 🔍 查詢 + 排序（支援關鍵字）
    public Page<Table1> searchAndSort(String keyword, int page, String sortField, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page, 20, sort);

        if (keyword == null || keyword.isBlank()) {
            return table1Repository.findAll(pageable);
        } else {
            return table1Repository.searchByKeyword(keyword, pageable);
        }
    }

    // ➕ 新增資料
    public void addData(Table1 table1, User user) {
        table1.setCreatedBy(user.getUsername());
        table1.setCreatedAt(LocalDateTime.now());
        table1Repository.save(table1);
    }

    // ✏️ 更新資料（拋出例外）
    public void updateData(Long id, Table1 updatedData, User user) {
        Table1 existing = table1Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到 ID 為 " + id + " 的資料"));

        existing.setStartStation(updatedData.getStartStation());
        existing.setEndStation(updatedData.getEndStation());
        existing.setFullPrice(updatedData.getFullPrice());
        existing.setDiscountPriceNewTaipei(updatedData.getDiscountPriceNewTaipei());
        existing.setDiscountPriceTaipei(updatedData.getDiscountPriceTaipei());
        existing.setDistance(updatedData.getDistance());
        existing.setCreatedBy(user.getUsername());
        existing.setCreatedAt(LocalDateTime.now());

        table1Repository.save(existing);
    }

    // 🗑️ 刪除單筆（含收藏）
    @Transactional
    public void deleteData(Long id) {
        Table1 data = table1Repository.findById(id).orElse(null);
        if (data != null) {
            favoriteRepository.deleteByTable1(data); // 🔥 先刪除收藏
            table1Repository.delete(data);           // ✅ 再刪除資料
        }
    }

    // 🧹 刪除全部（含收藏）
    @Transactional
    public void deleteAllData() {
        favoriteRepository.deleteAll();     // ✅ 先刪除 favorites
        table1Repository.deleteAll();       // ✅ 再刪除主資料
    }

    // 🔍 檢查是否存在相同起設站
    public boolean exists(String startStation, String endStation) {
        return table1Repository.existsByStartStationAndEndStation(startStation, endStation);
    }

    // 🔍 檢查完整資料是否重複
    public boolean isDuplicate(Table1 table1) {
        return table1Repository.existsByStartStationAndEndStationAndFullPriceAndDiscountPriceNewTaipeiAndDiscountPriceTaipeiAndDistance(
                table1.getStartStation(),
                table1.getEndStation(),
                table1.getFullPrice(),
                table1.getDiscountPriceNewTaipei(),
                table1.getDiscountPriceTaipei(),
                table1.getDistance()
        );
    }

    // ⬆️ 匯入 CSV（Big5 + 防呆 + log）
    public void importFromCsv(MultipartFile file, String createdBy) throws Exception {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), Charset.forName("Big5")));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            for (CSVRecord record : csvParser) {
                System.out.println("--- 匯入中 ---");
                System.out.println("起站: " + record.get("起站"));
                System.out.println("訖站: " + record.get("訖站"));
                System.out.println("全票票價: " + record.get("全票票價"));
                System.out.println("新北優惠: " + record.get("敬老卡愛心卡愛心陪伴卡及新北市兒童優惠票價"));
                System.out.println("台北優惠: " + record.get("臺北市兒童優惠票價"));
                System.out.println("距離: " + record.get("距離"));

                Table1 row = new Table1();
                row.setStartStation(record.get("起站").trim());
                row.setEndStation(record.get("訖站").trim());
                row.setFullPrice(parseInt(record.get("全票票價")));
                row.setDiscountPriceNewTaipei(parseInt(record.get("敬老卡愛心卡愛心陪伴卡及新北市兒童優惠票價")));
                row.setDiscountPriceTaipei(parseInt(record.get("臺北市兒童優惠票價")));
                row.setDistance(parseDouble(record.get("距離")));
                row.setCreatedBy(createdBy);
                row.setCreatedAt(LocalDateTime.now());

                if (isValidData(row) && !isDuplicate(row)) {
                    table1Repository.save(row);
                    System.out.println("✅ 已匯入: " + row.getStartStation() + " → " + row.getEndStation());
                } else {
                    System.out.println("⚠️ 資料無效或重複，跳過");
                }
            }
        }
    }

    // ✅ 驗證資料欄位完整性
    private boolean isValidData(Table1 data) {
        return data.getStartStation() != null && !data.getStartStation().isBlank() &&
               data.getEndStation() != null && !data.getEndStation().isBlank() &&
               data.getFullPrice() != null &&
               data.getDiscountPriceNewTaipei() != null &&
               data.getDiscountPriceTaipei() != null &&
               data.getDistance() != null;
    }

    // 🔢 安全轉 Int
    private Integer parseInt(String value) {
        try {
            String trimmed = value != null ? value.trim() : null;
            System.out.println("parseInt: [" + trimmed + "]");
            return (trimmed != null && !trimmed.isEmpty()) ? Integer.parseInt(trimmed) : null;
        } catch (NumberFormatException e) {
            System.out.println("parseInt 錯誤，輸入值為: [" + value + "]");
            return null;
        }
    }

    // 🔢 安全轉 Double
    private Double parseDouble(String value) {
        try {
            String trimmed = value != null ? value.trim() : null;
            System.out.println("parseDouble: [" + trimmed + "]");
            return (trimmed != null && !trimmed.isEmpty()) ? Double.parseDouble(trimmed) : null;
        } catch (NumberFormatException e) {
            System.out.println("parseDouble 錯誤，輸入值為: [" + value + "]");
            return null;
        }
    }

    // 🔍 查詢單筆
    public Table1 findById(Long id) {
        return table1Repository.findById(id).orElse(null);
    }
}
