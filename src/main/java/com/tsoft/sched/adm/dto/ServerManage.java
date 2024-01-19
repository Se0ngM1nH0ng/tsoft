package com.tsoft.sched.adm.dto;

import lombok.Data;

@Data
public class ServerManage {

    private int serverId; // 번호
    private String serverGroup; // 서버그룹 
    private String serverName; // 서버명
    private String serverIp; // 서버ip
    private String serverDesc; // 서버 내용

    private String useYn; // 노출여부

}
