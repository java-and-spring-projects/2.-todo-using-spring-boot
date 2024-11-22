package com.hitesh.todo.todo_manager.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger= LoggerFactory.getLogger(FileController.class);

    @PostMapping("/single")
    public String uploadSingleFile(@RequestParam("image")MultipartFile file) {
        logger.info("Name {}", file.getName());
        logger.info("Size {}", file.getSize());
        logger.info("Content Type: {}", file.getContentType());
        logger.info("Original File name: {}", file.getOriginalFilename());

        return "File uploaded successfully";
    }

    @PostMapping("/multiple")
    public String uploadMultipleFiles(@RequestParam("images") MultipartFile[] files) {
        for (MultipartFile file : files) {
            logger.info("Name {}", file.getName());
            logger.info("Size {}", file.getSize());
            logger.info("Content Type: {}", file.getContentType());
            logger.info("Original File name: {}", file.getOriginalFilename());
        }

        return "Files uploaded successfully";
    }

    //serving image file in response
    @GetMapping("/serve-image")
    public void serveImage(HttpServletResponse response) {
        try{
            InputStream fileInputStream = new FileInputStream("images/hitesh.jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream, response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
