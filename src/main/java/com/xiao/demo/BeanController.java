package com.xiao.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class BeanController {

    @GetMapping("/bean")
    public Map<String, String> getBean() {
        return Map.of("bean", "demoApplication");
    }
}
