package com.mynt.ShippingFee;
import java.util.ArrayList;


public class Parcel extends IParcel {

    public Parcel(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    public String getCost() {
        ArrayList<IParcelCostRule> rules = new ArrayList<>();
        rules.add(new ParcelCostRuleReject(weight, height, width, length));
        rules.add(new ParcelCostRuleHeavy(weight, height, width, length));
        rules.add(new ParcelCostRuleSmall(weight, height, width, length));
        rules.add(new ParcelCostRuleMedium(weight, height, width, length));
        rules.add(new ParcelCostRuleLarge(weight, height, width, length));

        for (IParcelCostRule rule : rules) {
            if (rule.checkCondition()) {
                return rule.getCost();
            }
        }
        return "N/A";
    }
}
