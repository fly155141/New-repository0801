package com.ispan.sb.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/i18n")
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public Map<String, String> getI18nMessages(Locale locale) {
        Map<String, String> messages = new HashMap<>();

        // ✅ 公告相關
        messages.put("announcement.updated", messageSource.getMessage("announcement.updated", null, locale));
        messages.put("announcement.error", messageSource.getMessage("announcement.error", null, locale));
        messages.put("announcement.empty", messageSource.getMessage("announcement.empty", null, locale));

        // ✅ 收藏相關
        messages.put("favorite.saved", messageSource.getMessage("favorite.saved", null, locale));
        messages.put("favorite.label", messageSource.getMessage("favorite.label", null, locale));
        messages.put("favorite.add", messageSource.getMessage("favorite.add", null, locale));
        messages.put("favorite.remove", messageSource.getMessage("favorite.remove", null, locale));
        messages.put("favorite.error", messageSource.getMessage("favorite.error", null, locale));

        // ✅ 上傳提示
        messages.put("file.none", messageSource.getMessage("file.none", null, locale));

        // ✅ 地圖提示
        messages.put("map.showRoute", messageSource.getMessage("map.showRoute", null, locale));
        messages.put("map.noFavorites", messageSource.getMessage("map.noFavorites", null, locale));
        messages.put("map.note", messageSource.getMessage("map.note", null, locale));
        messages.put("map.sameStation", messageSource.getMessage("map.sameStation", null, locale));
        messages.put("map.coordMissing", messageSource.getMessage("map.coordMissing", null, locale));

        // ✅ 購物車錯誤與提示
        messages.put("cart.error.noQtyInput", messageSource.getMessage("cart.error.noQtyInput", null, locale));
        messages.put("cart.error.quantity", messageSource.getMessage("cart.error.quantity", null, locale));
        messages.put("cart.error.exceedStock", messageSource.getMessage("cart.error.exceedStock", null, locale));
        messages.put("cart.error.totalExceedStock", messageSource.getMessage("cart.error.totalExceedStock", null, locale));
        messages.put("cart.error.general", messageSource.getMessage("cart.error.general", null, locale));
        messages.put("cart.success.add", messageSource.getMessage("cart.success.add", null, locale));
        messages.put("cart.empty", messageSource.getMessage("cart.empty", null, locale));
        messages.put("cart.clear.success", messageSource.getMessage("cart.clear.success", null, locale));

        // ✅ 商品錯誤提示
        messages.put("product.confirm.delete", messageSource.getMessage("product.confirm.delete", null, locale));
        messages.put("product.delete.fail", messageSource.getMessage("product.delete.fail", null, locale));

        // ✅ 新增商品表單錯誤
        messages.put("form.name.invalid", messageSource.getMessage("form.name.invalid", null, locale));
        messages.put("form.description.tooLong", messageSource.getMessage("form.description.tooLong", null, locale));
        messages.put("form.price.required", messageSource.getMessage("form.price.required", null, locale));
        messages.put("form.stock.required", messageSource.getMessage("form.stock.required", null, locale));
        messages.put("form.create.fail", messageSource.getMessage("form.create.fail", null, locale));

        // ✅ 結帳資訊
        messages.put("checkout.items", messageSource.getMessage("checkout.items", null, locale));
        messages.put("checkout.total", messageSource.getMessage("checkout.total", null, locale));
        messages.put("checkout.close", messageSource.getMessage("checkout.close", null, locale));

        // ✅ 表單驗證：新增票價用
        messages.put("form.start.required", messageSource.getMessage("form.start.required", null, locale));
        messages.put("form.end.required", messageSource.getMessage("form.end.required", null, locale));
        messages.put("form.fullPrice.positive", messageSource.getMessage("form.fullPrice.positive", null, locale));
        messages.put("form.discount.ntpc.positive", messageSource.getMessage("form.discount.ntpc.positive", null, locale));
        messages.put("form.discount.taipei.positive", messageSource.getMessage("form.discount.taipei.positive", null, locale));
        messages.put("form.distance.positive", messageSource.getMessage("form.distance.positive", null, locale));

        return messages;
    }
}
