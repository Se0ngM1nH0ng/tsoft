package com.example.quick.service;


import com.example.quick.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QuickService {

    public boolean registerItem(ItemDto itemDto){

        log.info("service ..");

        return true;
    }
}
