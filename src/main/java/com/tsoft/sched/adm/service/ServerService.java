package com.tsoft.sched.adm.service;

import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.dto.ServerManage;

import java.util.HashMap;
import java.util.List;

public interface ServerService {
    void serverInsert(HashMap<String, Object> params);
    List<ServerManage> serverSelectAll();
    ServerManage serverSelectOne(ServerManage sManage);
    void serverUpdate(HashMap<String, Object> params);
    void serverDelete(int hiddenServerId);
}
