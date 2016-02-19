package com.dingotiles.s3example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jcarter on 19/02/16.
 */
@Controller
@RequestMapping("/")
public class UploadController {

    @RequestMapping(method = RequestMethod.GET)
    String home() {
        return "home";
    }
}
