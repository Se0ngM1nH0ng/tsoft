package com.tsoft.sched.adm.mapper;

import com.tsoft.sched.adm.dto.JobManage;
import com.tsoft.sched.adm.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface JobMapper {

   void insertJobManage(JobManage jManage);
   List<JobManage> selectAll();
   JobManage selectOne(JobManage jManage);
   void update(JobManage jManage);
   void delete(int hiddenJobId);

   // 게시글 리스트 조회
   List<JobManage> findAll(SearchDto params);

   // 게시글 수 카운팅
   int count(SearchDto params);



}