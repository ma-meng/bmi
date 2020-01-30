package com.ma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by <a href="mailto:18045142590@163.com" > mameng </a>
 */
@Controller
public class BMIController {

    @GetMapping("/index")
    public String index() {
        return "./calculate.html";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public String calculate(String name, String height, String weight) {

        System.out.println(name + ":" + height + "cm" + ":" + weight + "kg");

        float h = convertString2Float(height) / 100;
        float w = convertString2Float(weight);
        float ret = w / (h * h);
        String tips;

        if(ret < 19) {
            tips = "多吃点，太瘦了！注意加强营养~";
        } else if(ret < 25) {
            tips = "体重正常，注意保持~";
        } else {
            tips = "该减肥了！注意加强锻炼~";
        }
        return tips;
    }

    private Float convertString2Float(String source) {
        return Float.valueOf(source);
    }
}
