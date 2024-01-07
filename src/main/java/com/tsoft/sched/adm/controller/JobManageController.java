package com.tsoft.sched.adm.controller;

import com.tsoft.sched.common.ResponseDTO;
import com.tsoft.sched.quartz.dto.JobManage;
import com.tsoft.sched.quartz.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/job")
public class JobManageController {

    private final JobService jobService;

    @PostMapping("/insertJobManage")
    @ResponseBody
    public ResponseEntity<?> insertJobManage(@RequestBody HashMap<String, Object> params, @RequestBody JobManage jManage) {
        params.put("jobStatus", "준비");

        // jobService.insertJobManage()를 직접 body에 설정
        return ResponseEntity.ok()
                .body(new ResponseDTO(HttpStatus.CREATED, "등록 성공", jobService.insertJobManage(params)));
    }
}
