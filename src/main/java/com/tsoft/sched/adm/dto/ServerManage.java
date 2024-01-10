package com.tsoft.sched.adm.dto;

import lombok.Data;

@Data
public class ServerManage {

    private int serverId;
    private String serverGroup;
    private String serverName;
    private String serverIp;
    private String serverDesc;

    private String useYn;

}
