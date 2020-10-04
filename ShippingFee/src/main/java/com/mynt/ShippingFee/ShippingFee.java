package com.mynt.ShippingFee;

public class ShippingFee {

    private String code;
    private float weight;
    private float height;
    private float width;
    private float length;

    public ShippingFee(String code, float weight, float height, float width, float length) {
        this.code = code;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public String getShippingFee() {
        Parcel parcel = new Parcel(this.weight, this.height, this.width, this.length);
        String cost = parcel.getCost();

        Voucher voucher = new Voucher(this.code);
        float discount = voucher.getDiscount();

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
