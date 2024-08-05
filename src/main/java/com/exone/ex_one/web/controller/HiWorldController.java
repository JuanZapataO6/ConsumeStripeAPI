package com.exone.ex_one.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayhi")
public class HiWorldController {
    @Value("${stripe.apikey}")
    String apiPrivateKey;
    @GetMapping("/hi")
    public String saidHi() {
        return "Never Stop of learning ";
    }
    @GetMapping("/apikey")
    public String publishedKey (){
        return apiPrivateKey;
    }

}
