package com.jsu.test;

import com.jsu.util.CheckAccountUtil;
import org.junit.Test;

public class TestCheckAccountUtil {

    @Test
    public void testSendEmail(){
        String toEmail = "1440244289@qq.com";
        CheckAccountUtil.sendEmail(toEmail);
    }
}
