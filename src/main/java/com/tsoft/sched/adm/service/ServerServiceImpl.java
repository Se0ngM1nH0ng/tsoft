package com.tsoft.sched.adm.service;

import com.tsoft.sched.adm.dto.ServerManage;
import com.tsoft.sched.adm.mapper.ServerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerServiceImpl implements ServerService {

    private final ServerMapper serverMapper;

    @Override
    public void serverInsert(HashMap<String, Object> params) {
        try {
            ServerManage sManage = new ServerManage();
            sManage.setServerIp((String) params.get("serverIp"));
            sManage.setServerDesc((String) params.get("serverDesc"));
            sManage.setServerName((String) params.get("serverName"));
            sManage.setServerGroup((String) params.get("serverGroup"));

            serverMapper.serverInsert(sManage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ServerManage> serverSelectAll() {
        return serverMapper.serverSelectAll();
    }

    @Override
    public ServerManage serverSelectOne(ServerManage sManage) {
        return serverMapper.serverSelectOne(sManage);
    }

    @Override
    public void serverUpdate(HashMap<String, Object> params) {
        try{
            ServerManage sManage = new ServerManage();
            sManage.setServerName((String)params.get("serverName"));
            sManage.setServerGroup((String)params.get("serverGroup")); // ajax 에서 넘겨준 key 이름
            sManage.setServerIp((String)params.get("serverIp")); // ajax 에서 넘겨준 key 이름
            sManage.setServerDesc((String) params.get("serverDesc"));
            sManage.setServerId((Integer) params.get("serverId"));

            serverMapper.serverUpdate(sManage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void serverDelete(int hiddenServerId) {
        serverMapper.serverDelete(hiddenServerId);
    }


}
