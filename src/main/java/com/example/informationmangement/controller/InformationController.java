package com.example.informationmangement.controller;

import com.example.informationmangement.constants.Messages;
import com.example.informationmangement.helper.CSVHelper;
import com.example.informationmangement.model.Information;
import com.example.informationmangement.service.InformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
public class InformationController {
    private static final Logger logger =
            LoggerFactory.getLogger(InformationController.class);

    private final InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @Operation(summary = "Upload a new CSV file")
    @ApiResponse(responseCode = "201", description = "Uploaded the file successfully")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                List<Information> informationList = informationService.save(file);
                message = Messages.UPLOAD_SUCCESSFUL + file.getOriginalFilename();
                logger.info(Messages.NEW_FILE_UPLOAD_LOG, informationList);
                return ResponseEntity.status(HttpStatus.CREATED).body(message);
            } catch (Exception e) {
                message = Messages.UPLOAD_UNSUCCESSFUL + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }
        message = Messages.PLEASE_UPLOAD_CSV;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

}
