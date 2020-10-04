package com.mynt.ShippingFee;

public class ParcelCostRuleMedium extends IParcelCostRule {

    public ParcelCostRuleMedium(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    @Override
    public String getCost() {
        return String.valueOf(0.04 * this.volume);
    }

    @Override
    public boolean checkCondition() {
        return this.volume < 2500;
    }
}
