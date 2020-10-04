package com.mynt.ShippingFee;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


public class Voucher {
    private final String host = "https://mynt-exam.mocklab.io";
    private String code;

    public Voucher(String code){
        this.code = code;
    }

    public float getDiscount() {
        if (this.code == null) {
            return 0;
        }
        String response = callVoucherApi(this.code);
        if (response == null) {
            return 0;
        }
        return parseDiscount(response);
    }

    public String getCode() {
        return this.code;
    }

    private String callVoucherApi(String code) {
        final String api = "/voucher/" + code + "?key=apikey";
        final String baseUrl = host + api;
        try {
            ResponseEntity<String> response = new RestTemplate().getForEntity(new URI(baseUrl), String.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private float parseDiscount(String response) {
        try {
            JsonNode jsonNode = new ObjectMapper().readTree(response);
            return jsonNode.get("discount").floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
