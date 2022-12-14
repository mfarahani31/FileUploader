package com.example.informationmangement.controller;

import com.example.informationmangement.constants.Messages;
import com.example.informationmangement.helper.CSVHelper;
import com.example.informationmangement.model.Information;
import com.example.informationmangement.service.InformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/information")
public class InformationController {
    private static final Logger logger =
            LoggerFactory.getLogger(InformationController.class);

    private final InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @Operation(summary = "Upload a new CSV file")
    @ApiResponse(responseCode = "201", description = "Uploaded the file successfully",
            content = {@Content(schema = @Schema(implementation = String.class))})
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

    @Operation(summary = "Fetch all data")
    @ApiResponse(responseCode = "200", description = "Found the information", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Information.class))})
    @GetMapping(value = "/getAll", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Information>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.informationService.getAll());
    }
}
