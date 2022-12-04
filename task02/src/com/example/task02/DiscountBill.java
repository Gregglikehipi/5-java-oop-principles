package com.example.task02;

public class DiscountBill extends Bill {
    private long discount;
    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (price * 100 - (price * discount)) / 100;
    }
    public void setDiscount(long discount) {
        this.discount = discount;
    }
    public long getDiscount() {
        return discount;
    }
    public long discountPrice() {
        long price = super.getPrice();
        return price * discount / 100;
    }
}
