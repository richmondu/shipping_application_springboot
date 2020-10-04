package com.mynt.ShippingFee;

abstract class IParcelCostRule extends IParcel {

    public IParcelCostRule(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    abstract public String getCost();

    abstract public boolean checkCondition();
}
