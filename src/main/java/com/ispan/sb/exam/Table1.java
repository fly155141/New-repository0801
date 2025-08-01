package com.ispan.sb.exam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * 對應 SSMS MRT 資料庫的 table1 表格。
 * 儲存捷運票價資訊、站點、價格與建立紀錄。
 */
@Entity
@Table(name = "table1")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Table1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custoner_id") // ⚠️ 注意拼字，請確認資料庫主鍵為此名稱
    private Long id;

    @Column(name = "起站")
    private String startStation;

    @Column(name = "訖站")
    private String endStation;

    @Column(name = "全票票價")
    private Integer fullPrice;

    @Column(name = "敬老卡愛心卡愛心陪伴卡及新北市兒童優惠票價")
    private Integer discountPriceNewTaipei;

    @Column(name = "臺北市兒童優惠票價")
    private Integer discountPriceTaipei;

    @Column(name = "距離")
    private Double distance;

    @Column(name = "建立時間")
    private LocalDateTime createdAt;

    @Column(name = "建立人")
    private String createdBy;

    /**
     * ✅ 非資料庫欄位，用來表示是否為會員已收藏
     */
    @Transient
    private boolean favorited;

    // ===== Getter / Setter =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Integer getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Integer fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Integer getDiscountPriceNewTaipei() {
        return discountPriceNewTaipei;
    }

    public void setDiscountPriceNewTaipei(Integer discountPriceNewTaipei) {
        this.discountPriceNewTaipei = discountPriceNewTaipei;
    }

    public Integer getDiscountPriceTaipei() {
        return discountPriceTaipei;
    }

    public void setDiscountPriceTaipei(Integer discountPriceTaipei) {
        this.discountPriceTaipei = discountPriceTaipei;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }
}
