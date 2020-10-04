package com.mynt.ShippingFee;

public class ShippingFee {

    final private String code;
    final private float weight;
    final private float height;
    final private float width;
    final private float length;
    final private boolean check_expiry;

    public ShippingFee(String code, float weight, float height, float width, float length) {
        this.code = code;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.check_expiry = false;
    }

    public String getShippingFee() {
        Parcel parcel = new Parcel(this.weight, this.height, this.width, this.length);
        String cost = parcel.getCost();

        Voucher voucher = new Voucher(this.code);
        float discount = voucher.getDiscount();

        if (this.check_expiry) {
            if (voucher.isExpired()) {
                return cost;
            }
        }

        return computeDiscountedPrice(cost, discount);
    }

    private String computeDiscountedPrice(String cost, float discount) {
        try {
            return String.valueOf(Float.parseFloat(cost) * (100 - discount) / 100);
        } catch (Exception e) {
            return cost;
        }
    }
}
