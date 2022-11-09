package com.example.informationmangement.service;

import org.junit.jupiter.api.Test;

class DefaultInformationServiceTest {

    @Test
    void getAll() {
        when(informationRepository.findAll()).thenReturn(informations);

        List<TransactionResponseDTO> actualTransactions = transactionService.getAllByUserId(1L);

        assertEquals(transactions.size(), actualTransactions.size());
    }
}