package com.tsoft.sched.adm.controller;

import com.tsoft.sched.common.ResponseDTO;
import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.service.JobService;
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

    @PostMapping("/jobUpdate") // job 등록
    @ResponseBody
    public ResponseEntity<ResponseDTO> jobUpdate(@RequestBody HashMap<String, Object> params ) {
        System.out.println("값 확인 : " + params);
        jobService.update(params);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "변경성공"));
    }

    @PostMapping("/jobDelete") // job 등록
    @ResponseBody
    public ResponseEntity<ResponseDTO> jobDelete(@RequestParam("jobId") int hiddenJobId ) {
        System.out.println("값 확인 : " + hiddenJobId);
        jobService.delete(hiddenJobId);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "삭제성공"));
    }


}
