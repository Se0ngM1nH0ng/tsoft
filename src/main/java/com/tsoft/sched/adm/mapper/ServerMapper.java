package com.tsoft.sched.adm.mapper;

import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.dto.ServerManage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServerMapper {
    void serverInsert(ServerManage sManage);
    List<ServerManage> serverSelectAll();
    ServerManage serverSelectOne(ServerManage sManage);
    void serverUpdate(ServerManage sManage);
    void serverDelete(int hiddenJobId);
}
