package com.dingotiles.s3example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jcarter on 19/02/16.
 */
@RestController
public class UploadController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
