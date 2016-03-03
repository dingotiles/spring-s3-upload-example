package com.dingotiles.s3example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * Created by jcarter on 19/02/16.
 */
@Controller
@RequestMapping("/")
public class UploadController {

    final private UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @RequestMapping(method = RequestMethod.GET)
    String home() {
        return "home";
    }

    @RequestMapping(value = "/upload")
    public String upload(
            @RequestParam("file") MultipartFile myFile,
            final RedirectAttributes redirectAttributes) throws IOException {
            redirectAttributes.addFlashAttribute("flash.message", "File was uploaded!");
            uploadService.uploadFile(myFile.getOriginalFilename(), myFile.getInputStream());
        return "redirect:/";
    }
}
