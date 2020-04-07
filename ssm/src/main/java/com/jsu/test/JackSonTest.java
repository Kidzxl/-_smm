package com.jsu.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsu.service.IndexService;
import com.jsu.service.impl.IndexServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JackSonTest {



    @Test
    public void testJson(){
        new IndexServiceImpl().getHistoryProduct("user:001",3);
    }
}
