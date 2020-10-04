package com.mynt.ShippingFee;

public class ParcelCostRuleHeavy extends IParcelCostRule {

    public ParcelCostRuleHeavy(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    @Override
    public String getCost() {
        return String.valueOf(20 * this.weight);
    }

    @Override
    public boolean checkCondition() {
        return this.weight > 10;
    }
}
