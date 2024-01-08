package com.tsoft.sched.adm.controller;

import com.tsoft.sched.common.ResponseDTO;
import com.tsoft.sched.quartz.dto.JobManage;
import com.tsoft.sched.quartz.service.JobService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/job")
public class JobManageController {

    private final JobService jobService;

    @PostMapping("/insertJobManage") // job 등록
    @ResponseBody
    public ResponseEntity<ResponseDTO> insertJobManage(@RequestBody HashMap<String,Object> params ) {
        params.put("jobStatus", "준비");
        jobService.insertJobManage(params);

        // jobService.insertJobManage()를 직접 body에 설정
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "등록 성공"));
    }

    @PostMapping("/modal") // job 등록
    @ResponseBody
    public ResponseEntity<ResponseDTO> modal(@RequestBody JobManage jManage ) {
        JobManage selectedJob = jobService.selectOne(jManage);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "성공", selectedJob));
    }


}
