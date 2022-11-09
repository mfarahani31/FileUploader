package com.example.informationmangement.service;

import com.example.informationmangement.helper.CSVHelper;
import com.example.informationmangement.model.Information;
import com.example.informationmangement.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class InformationService {

    private final InformationRepository informationRepository;

    @Autowired
    public InformationService(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    public List<Information> save(MultipartFile file) {
        try {
            List<Information> informationList = CSVHelper.csvToInformations(file.getInputStream());
            return informationRepository.saveAll(informationList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Information> getAll() {
        return this.informationRepository.findAll();
    }
}
