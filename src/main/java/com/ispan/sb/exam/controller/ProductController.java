package com.ispan.sb.exam.controller;

import com.ispan.sb.exam.Product;
import com.ispan.sb.exam.User;
import com.ispan.sb.exam.repository.ProductRepository;
import com.ispan.sb.exam.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    // ✅ 取得所有商品（依建立時間排序，最新在前）
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAllByOrderByCreatedAtDesc();
    }

    // ✅ 原本的：用 name 檢查庫存（保留）
    @GetMapping("/check-stock")
    public ResponseEntity<?> checkStock(@RequestParam String name, @RequestParam int quantity) {
        Product product = productRepository.findByName(name);
        if (product == null) {
            return ResponseEntity.badRequest().body("❌ 商品不存在");
        }
        if (product.getStock() < quantity) {
            return ResponseEntity.badRequest().body("❌ 商品庫存不足，剩餘數量：" + product.getStock());
        }
        return ResponseEntity.ok("✅ 可加入購物車");
    }

    // ✅ 新增的：用 ID 檢查庫存（建議前端使用這個）
    @GetMapping("/check-stock-by-id")
    public ResponseEntity<?> checkStockById(@RequestParam Long id, @RequestParam int quantity) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().body("❌ 商品不存在");
        }
        if (product.getStock() < quantity) {
            return ResponseEntity.badRequest().body("❌ 商品庫存不足，剩餘數量：" + product.getStock());
        }
        return ResponseEntity.ok("✅ 可加入購物車");
    }

    // ✅ 上傳商品（含圖片與存貨）-- 只有 ADMIN 可用
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<?> createProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Integer price,
            @RequestParam("stock") Integer stock,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            Principal principal
    ) {
        try {
            // ✅ 商品名稱驗證
            if (name == null || name.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("錯誤：商品名稱不得為空");
            }
            if (!name.matches("^[\\u4e00-\\u9fa5a-zA-Z0-9\\s]{1,20}$")) {
                return ResponseEntity.badRequest().body("錯誤：商品名稱僅限中英文、數字與空格，最多20字");
            }

            // ✅ 敘述驗證
            if (description != null && description.length() > 100) {
                return ResponseEntity.badRequest().body("錯誤：商品敘述不得超過100字");
            }

            // ✅ 價格驗證
            if (price == null || price <= 0) {
                return ResponseEntity.badRequest().body("錯誤：價格必須為正整數");
            }

            // ✅ 存貨驗證
            if (stock == null || stock < 0) {
                return ResponseEntity.badRequest().body("錯誤：存貨必須為 0 或正整數");
            }

            // ✅ 儲存圖片
            String imageUrl = null;
            if (imageFile != null && !imageFile.isEmpty()) {
                String originalFilename = imageFile.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
                String filename = UUID.randomUUID() + extension;
                Path uploadDir = Paths.get("uploads/images");
                Files.createDirectories(uploadDir);
                Path imagePath = uploadDir.resolve(filename);
                Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
                imageUrl = "/uploads/images/" + filename;
            }

            // ✅ 查詢使用者
            User user = userService.findByUsername(principal.getName());

            // ✅ 儲存商品
            Product product = new Product();
            product.setName(name.trim());
            product.setDescription(description != null ? description.trim() : null);
            product.setPrice(price);
            product.setStock(stock);
            product.setImageUrl(imageUrl);
            product.setCreatedBy(user);

            productRepository.save(product);
            return ResponseEntity.ok("✅ 商品新增成功");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("錯誤：伺服器發生例外 - " + e.getMessage());
        }
    }

    // ✅ 根據 ID 刪除商品（僅 ADMIN）
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().body("錯誤：找不到該商品");
        }

        // ✅ 刪除圖片
        if (product.getImageUrl() != null && product.getImageUrl().startsWith("/uploads/images/")) {
            try {
                Path imagePath = Paths.get("uploads", "images", Paths.get(product.getImageUrl()).getFileName().toString());
                Files.deleteIfExists(imagePath);
            } catch (Exception e) {
                // 忽略圖片刪除錯誤
            }
        }

        productRepository.deleteById(id);
        return ResponseEntity.ok("✅ 商品已刪除");
    }
}
