package com.mynt.ShippingFee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Parcel extends IParcel {

    public Parcel(float weight, float height, float width, float length) {
        super(weight, height, width, length);
    }

    public String getCost() {
        ArrayList<IParcelCostRule> rules = new ArrayList<IParcelCostRule>();
        rules.add(new ParcelCostRuleReject(weight, height, width, length));
        rules.add(new ParcelCostRuleHeavy(weight, height, width, length));
        rules.add(new ParcelCostRuleSmall(weight, height, width, length));
        rules.add(new ParcelCostRuleMedium(weight, height, width, length));
        rules.add(new ParcelCostRuleLarge(weight, height, width, length));

        Iterator<IParcelCostRule> it = rules.iterator();
        while (it.hasNext()) {
            IParcelCostRule rule = it.next();
            if (rule.checkCondition()) {
                return rule.getCost();
            }
        }
        return "N/A";
    }
}
