package com.ispan.sb.exam.services;

import com.ispan.sb.exam.*;
import com.ispan.sb.exam.repository.OrderItemRepository;
import com.ispan.sb.exam.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    
   


    // ✅ 檢查商品是否可以刪除
    public boolean canDeleteProduct(Long productId) {
        List<OrderItem> items = orderItemRepository.findByProductId(productId);
        for (OrderItem item : items) {
            OrderStatus status = item.getOrder().getStatus();
            if (status == OrderStatus.PENDING || status == OrderStatus.SHIPPED || status == OrderStatus.RETURNING) {
                return false;
            }
        }
        return true;
    }

    // ✅ 執行商品刪除（如果允許）
    public boolean deleteProductById(Long id) {
        if (!canDeleteProduct(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
}
