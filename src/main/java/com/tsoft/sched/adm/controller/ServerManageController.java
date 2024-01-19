package com.tsoft.sched.adm.controller;

import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.dto.ServerManage;
import com.tsoft.sched.adm.service.JobService;
import com.tsoft.sched.adm.service.ServerService;
import com.tsoft.sched.common.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/server")
public class ServerManageController {

    private final ServerService serverService;

    @PostMapping("/serverInsert") // job 등록
    @ResponseBody
    public ResponseEntity<ResponseDTO> serverInsert(@RequestBody HashMap<String,Object> params ) {
        serverService.serverInsert(params);

        // jobService.insertJobManage()를 직접 body에 설정
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "등록 성공"));
    }

    @PostMapping("/serverModal") // 모달창
    @ResponseBody
    public ResponseEntity<ResponseDTO> serverModal(@RequestBody ServerManage sManage ) {
        sManage = serverService.serverSelectOne(sManage);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "성공", sManage));
    }

    @PostMapping("/serverUpdate") // 수정
    @ResponseBody
    public ResponseEntity<ResponseDTO> serverUpdate(@RequestBody HashMap<String, Object> params ) {
        System.out.println("값 확인 : " + params);
        serverService.serverUpdate(params);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "변경성공"));
    }

    @PostMapping("/serverDelete") // 삭제
    @ResponseBody
    public ResponseEntity<ResponseDTO> serverDelete(@RequestParam("serverId") int hiddenServerId ) {
        System.out.println("값 확인 : " + hiddenServerId);
        serverService.serverDelete(hiddenServerId);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "삭제성공"));
    }





}
