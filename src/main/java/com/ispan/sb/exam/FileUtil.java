package com.ispan.sb.exam;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

public class FileUtil {

    // ✅ 相對於 resources/static 的儲存資料夾
    private static final String RELATIVE_DIR = "uploads/product-images";

    // ✅ 實際儲存在 static 目錄下（可供瀏覽器讀取）
    private static final Path STATIC_UPLOAD_PATH = Paths.get("src/main/resources/static", RELATIVE_DIR);

    // ✅ 儲存圖片
    public static String saveImage(MultipartFile file) throws IOException {
        // 建立資料夾（若不存在）
        if (Files.notExists(STATIC_UPLOAD_PATH)) {
            Files.createDirectories(STATIC_UPLOAD_PATH);
        }

        // 取得副檔名
        String extension = getExtension(file.getOriginalFilename());
        String filename = UUID.randomUUID() + "." + extension;

        // 儲存檔案
        Path targetPath = STATIC_UPLOAD_PATH.resolve(filename);
        Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

        // 回傳前端可讀取的 URL 路徑
        return "/" + RELATIVE_DIR + "/" + filename;
    }

    // ✅ 刪除圖片（傳入 imageUrl，例如：/uploads/product-images/xxx.jpg）
    public static void deleteImage(String imageUrl) {
        if (imageUrl == null || !imageUrl.startsWith("/" + RELATIVE_DIR)) return;

        // 移除開頭的 "/"，拼接成絕對路徑
        String relativePath = imageUrl.substring(1);
        Path fullPath = Paths.get("src/main/resources/static", relativePath);

        try {
            Files.deleteIfExists(fullPath);
        } catch (IOException e) {
            System.err.println("❌ 刪除圖片失敗：" + fullPath + " - " + e.getMessage());
        }
    }

    // ✅ 取得副檔名
    private static String getExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        return (dotIndex >= 0) ? filename.substring(dotIndex + 1) : "png"; // 預設 png 避免 null
    }
}
