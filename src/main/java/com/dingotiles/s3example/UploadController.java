package com.dingotiles.s3example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/upload")
    public String importParse(
            //@RequestParam("file") MultipartFile myFile,
            final RedirectAttributes redirectAttributes) {
            redirectAttributes.addFlashAttribute("flash.message", "File was uploaded!");
         return "redirect:/";
    }
}
