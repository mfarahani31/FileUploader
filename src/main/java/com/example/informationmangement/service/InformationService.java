package com.example.informationmangement.service;

import com.example.informationmangement.model.Information;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InformationService {

    List<Information> save(MultipartFile file);

    List<Information> getAll();
}
