package net.biancheng.c.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLog4j {
    private static final Logger log = LoggerFactory.getLogger(HelloLog4j.class);
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        log.info("消息为：" + message);
    }
}