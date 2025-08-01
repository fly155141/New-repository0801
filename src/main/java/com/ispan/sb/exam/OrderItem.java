package com.ispan.sb.exam;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")  // FK 對應 orders.id
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id") // FK 對應 products.id
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price; // 下單當下的單價

    // Getter / Setter
    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
