package com.shsxctf.admin.controllers;

import com.shsxctf.admin.message.ResponseMessage;
import com.shsxctf.admin.services.FileStorageService;
import com.shsxctf.admin.services.ScheduleTextProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FilesController {

    @Autowired
    FileStorageService storageService;

    @Autowired
    JdbcTemplate template;

    @PostMapping("/upload/schedule")
    @CrossOrigin
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        ScheduleTextProcessor scheduleTextProcessor = new ScheduleTextProcessor();
        //scheduleTextProcessor.inputSchedule(template);
        try {
            storageService.deleteAll();
            storageService.save(file);
            scheduleTextProcessor.formatResults(template, storageService);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}
