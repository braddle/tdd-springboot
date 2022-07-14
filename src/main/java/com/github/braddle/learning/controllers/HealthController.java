package com.github.braddle.learning.controllers;

import com.github.braddle.learning.HealthReport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public HealthReport Check(){
        return new HealthReport("1.2.3");
    }
}
