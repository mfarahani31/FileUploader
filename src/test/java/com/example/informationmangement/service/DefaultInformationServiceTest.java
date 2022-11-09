package com.example.informationmangement.service;

import com.example.informationmangement.repository.InformationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultInformationServiceTest {

    @InjectMocks
    DefaultInformationService informationService;

    @Mock
    InformationRepository informationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testContext() {
        assertNotNull(informationService);
        assertNotNull(informationRepository);
    }
}