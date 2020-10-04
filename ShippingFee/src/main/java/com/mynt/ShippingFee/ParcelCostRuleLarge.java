package com.mynt.ShippingFee;

public class ParcelCostRuleLarge extends IParcelCostRule {

    public ParcelCostRuleLarge(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    @Override
    public String getCost() {
        return String.valueOf(0.05 * this.volume);
    }

    @Override
    public boolean checkCondition() {
        return true;
    }
}
