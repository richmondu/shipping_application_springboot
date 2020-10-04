package com.mynt.ShippingFee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.net.URI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;


@SpringBootApplication
@RestController
public class RestApi {

    public static void main(String[] args) {
        SpringApplication.run(RestApi.class, args);
    }

    @GetMapping("/api/v1/shipping/fee")
    public String shippingFee(@RequestParam Map<String,String> requestParams) {

        float weight = Float.parseFloat(requestParams.get("weight"));
        float height = Float.parseFloat(requestParams.get("height"));
        float width = Float.parseFloat(requestParams.get("width"));
        float length = Float.parseFloat(requestParams.get("length"));
        String code = requestParams.get("code");

        ShippingFee shippingFee = new ShippingFee(code, weight, height, width, length);
        String cost = shippingFee.getShippingFee();
        System.out.println(cost);

        return String.format("cost=%s", cost);
    }
}
