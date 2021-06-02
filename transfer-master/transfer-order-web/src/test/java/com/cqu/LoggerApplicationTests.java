package com.cqu;



import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
@Slf4j
public class LoggerApplicationTests {

    @Test
    void contextLoads() {
       log.info("info测试日志");
       log.debug("debug测试日志");
       log.error("error测试日志");
       log.warn("warn测试日志");
    }
}
