package com.kitkat.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello(){
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "피싱사이트아닙니다";
    }

    @GetMapping("/mypage")
    @ResponseBody
    String mypage(){
        return "마이페이지에요";
    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        return LocalDateTime.now().format(formatter);
    }
}

