package io.java_core.models;

import java.util.Objects;
import java.util.UUID;

public class Order {
    private final Long id;
    private final Long userId;
    private final Cart cart;
    private OrderStatus orderStatus;

    public Order(Long userId, Cart cart, OrderStatus orderStatus)  {
        this.id = UUID.randomUUID().timestamp();
        this.userId = userId;
        this.cart = cart;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Cart getCart() {
        return cart;
    }

    public Long getUserId() {
        return userId;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", cart=" + cart +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
