package com.mynt.ShippingFee;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class Voucher {
    private final String host = "https://mynt-exam.mocklab.io";
    private String code;
    private boolean expired;

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
        try {
            JsonNode jsonResponse = new ObjectMapper().readTree(response);
            this.expired = checkExpiry(jsonResponse);
            return parseDiscount(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getCode() {
        return this.code;
    }

    public boolean isExpired() {
        return this.expired;
    }

    private String callVoucherApi(String code) {
        final String api = "/voucher/" + code + "?key=apikey";
        try {
            ResponseEntity<String> response = new RestTemplate().getForEntity(new URI(host + api), String.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private float parseDiscount(JsonNode jsonResponse) {
        return jsonResponse.get("discount").floatValue();
    }

    private String parseExpiry(JsonNode jsonResponse) {
        return jsonResponse.get("expiry").asText();
    }

    private boolean checkExpiry(JsonNode jsonResponse) {
        String dateStr = jsonResponse.get("expiry").asText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = dateFormat.parse(dateStr);
            Date d2 = dateFormat.parse(LocalDate.now().toString());
            if (d1.compareTo(d2) < 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
