package com.mynt.ShippingFee;

public class ParcelCostRuleSmall extends IParcelCostRule {

    public ParcelCostRuleSmall(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    @Override
    public String getCost() {
        return String.valueOf(0.03 * this.volume);
    }

    @Override
    public boolean checkCondition() {
        return this.volume < 1500;
    }
}
