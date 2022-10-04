package com.appstream.service;


import com.appstream.domain.FraudCheckHistory;
import com.appstream.repository.FraudCheckHistoryRepo;
import org.springframework.stereotype.Service;

@Service
public record FrauCheckService(FraudCheckHistoryRepo repo) {


    public boolean isFraudulentCustomer(Integer customerId){
        FraudCheckHistory history = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .build();
        repo.save(history);
        return  false;

    }
}
