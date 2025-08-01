package com.ispan.sb.exam.repository;

import com.ispan.sb.exam.Table1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Table1Repository extends JpaRepository<Table1, Long> {

    // 🔍 支援關鍵字模糊查詢（起站、訖站、票價、距離）
    @Query("SELECT t FROM Table1 t WHERE " +
           "LOWER(t.startStation) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.endStation) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "CAST(t.fullPrice AS string) LIKE %:keyword% OR " +
           "CAST(t.discountPriceNewTaipei AS string) LIKE %:keyword% OR " +
           "CAST(t.discountPriceTaipei AS string) LIKE %:keyword% OR " +
           "CAST(t.distance AS string) LIKE %:keyword%")
    Page<Table1> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

    // 🔍 判斷起訖站是否存在（只比站名）
    boolean existsByStartStationAndEndStation(String startStation, String endStation);

    // 🔍 判斷整筆資料是否完全一樣（六欄位）
    boolean existsByStartStationAndEndStationAndFullPriceAndDiscountPriceNewTaipeiAndDiscountPriceTaipeiAndDistance(
            String startStation, String endStation,
            Integer fullPrice, Integer discountPriceNewTaipei,
            Integer discountPriceTaipei, Double distance
    );
}
