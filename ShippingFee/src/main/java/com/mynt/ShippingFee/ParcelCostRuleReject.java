package com.mynt.ShippingFee;

public class ParcelCostRuleReject extends IParcelCostRule {

    public ParcelCostRuleReject(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    @Override
    public String getCost() {
        return "N/A";
    }

    @Override
    public boolean checkCondition() {
        return this.weight > 50;
    }
}
