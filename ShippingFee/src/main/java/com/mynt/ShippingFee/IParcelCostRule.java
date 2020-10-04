package com.mynt.ShippingFee;

public class IParcelCostRule extends IParcel {

    public IParcelCostRule(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    public String getCost() {
        return "N/A";
    }

    public boolean checkCondition() {
        return true;
    }
}
