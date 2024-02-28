package com.example.quick.controller;

import com.example.quick.dto.ItemDto;
import com.example.quick.dto.ResponseDto;
import com.example.quick.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

    @Autowired
    private QuickService quickService;

    @Autowired
    private ResponseDto responseDto;

    @GetMapping("/dummy")
    public String dummy(){
        log.info("dummy");
        return "하이";
    }
    @GetMapping("/dummy2")
    public String dummy2(){
        log.info("dummy");
        return "dummy2";
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo , @RequestParam(" year") int year){ // 파라미터를 넘겨야 될때 사용 // @RequestParam 이 key 역할 , 여기에 value값 넣어줄수 있음
        log.info("empNo : {}", empNo);
        log.info("year : {}", year);

        return "ok";

    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id){
        log.info("id : {}", id);

        return "ok";

    }

    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item){
        log.info("item : {}", item);


        boolean b = quickService.registerItem(item);
        if(b == true){

            responseDto.setMessage("ok");
            return responseDto;
        }


        responseDto.setMessage("fail");
        return responseDto;
    }
}
