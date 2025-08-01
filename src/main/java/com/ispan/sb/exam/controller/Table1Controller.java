package com.ispan.sb.exam.controller;

import com.ispan.sb.exam.Table1;
import com.ispan.sb.exam.User;
import com.ispan.sb.exam.services.Table1Service;
import com.ispan.sb.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class Table1Controller {

    @Autowired
    private Table1Service table1Service;

    @Autowired
    private UserService userService;

    // ✅ 取得所有資料（分頁、排序）
    @GetMapping("/all")
    public ResponseEntity<?> getAllData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        Page<Table1> resultPage = table1Service.searchAndSort("", page, sortField, sortOrder);
        return ResponseEntity.ok(Map.of(
                "data", resultPage.getContent(),
                "currentPage", resultPage.getNumber(),
                "totalPages", resultPage.getTotalPages(),
                "totalElements", resultPage.getTotalElements()
        ));
    }

    // ✅ 查詢資料（支援關鍵字）
    @GetMapping("/search")
    public ResponseEntity<?> searchData(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        Page<Table1> resultPage = table1Service.searchAndSort(keyword, page, sortField, sortOrder);
        return ResponseEntity.ok(Map.of(
                "data", resultPage.getContent(),
                "currentPage", resultPage.getNumber(),
                "totalPages", resultPage.getTotalPages(),
                "totalElements", resultPage.getTotalElements()
        ));
    }

    // ✅ 新增資料
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addData(@RequestBody Table1 table1, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());

        if (!isValidTable1(table1)) {
            return ResponseEntity.badRequest().body("資料欄位不可為空，起訖站必須是中文");
        }

        if (table1Service.isDuplicate(table1)) {
            return ResponseEntity.badRequest().body("已有該筆資料");
        }

        table1Service.addData(table1, user);
        return ResponseEntity.ok("新增成功");
    }

    // ✅ 更新資料（這裡改成 POST /api/update，符合你的前端）
    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateData(@RequestBody Table1 table1, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());

        if (!isValidTable1(table1)) {
            return ResponseEntity.badRequest().body("資料欄位不可為空，起訖站必須是中文");
        }

        if (table1.getId() == null) {
            return ResponseEntity.badRequest().body("缺少資料ID");
        }

        table1Service.updateData(table1.getId(), table1, user);
        return ResponseEntity.ok("修改成功");
    }

    // ✅ 刪除單筆資料
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteData(@PathVariable Long id) {
        table1Service.deleteData(id);
        return ResponseEntity.ok("刪除成功");
    }

    // ✅ 刪除全部資料
    @PostMapping("/deleteAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteAllData() {
        table1Service.deleteAllData();
        return ResponseEntity.ok("所有資料已清除");
    }

    // ✅ 上傳CSV
    @PostMapping("/upload")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file, Authentication authentication) {
        try {
            table1Service.importFromCsv(file, authentication.getName());
            return ResponseEntity.ok("CSV匯入成功");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("匯入失敗：" + e.getMessage());
        }
    }

    // 👉 資料驗證：起訖站必須中文，票價、距離不可為null
    private boolean isValidTable1(Table1 table1) {
        return table1.getStartStation() != null && table1.getEndStation() != null &&
               isChineseOnly(table1.getStartStation()) && isChineseOnly(table1.getEndStation()) &&
               table1.getFullPrice() != null &&
               table1.getDiscountPriceNewTaipei() != null &&
               table1.getDiscountPriceTaipei() != null &&
               table1.getDistance() != null;
    }

    private boolean isChineseOnly(String input) {
        return input != null && input.matches("^[\\u4e00-\\u9fa5]+$");
    }
}
