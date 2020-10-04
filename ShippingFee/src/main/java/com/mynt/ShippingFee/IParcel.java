package com.mynt.ShippingFee;

public class IParcel {

    protected float weight;
    protected float height;
    protected float width;
    protected float length;
    protected float volume;

    public IParcel(float weight, float height, float width, float length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.volume = height * width * length;
    };
}
