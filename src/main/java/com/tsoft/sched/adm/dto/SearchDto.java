package com.tsoft.sched.adm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private int page; // 현재 페이지 번호
    private int recordSize; // 페이지 당 출력할 데이터 개수
    private int pageSize; // 화면 하단에 출력할 페이지 사이즈

    public SearchDto(){
        this.page = 1;
        this.recordSize = 5;
        this.pageSize = 10;
    }

    public int getOffset(){
        return (page -1) * recordSize;
    }

}