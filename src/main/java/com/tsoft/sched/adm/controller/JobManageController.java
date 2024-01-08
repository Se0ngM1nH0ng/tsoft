package com.tsoft.sched.adm.controller;

import com.tsoft.sched.common.ResponseDTO;
import com.tsoft.sched.quartz.dto.JobManage;
import com.tsoft.sched.quartz.service.JobService;
import lombok.RequiredArgsConstructor;
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

//    @PostMapping("/scheduleManage") // job 관리 페이지 목록 조회
//    public String scheduleManage(Model model , JobManage jManage) {
//
//        List<JobManage> jobList = jobService.selectAll(jManage);
//        model.addAttribute("jobList", jobList);
//
//        return "scheduleManage";
//    }

}
