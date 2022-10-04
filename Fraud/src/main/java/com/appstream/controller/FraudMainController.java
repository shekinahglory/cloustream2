package com.appstream.controller;

import com.appstream.domain.FraudCheckResponse;
import com.appstream.service.FrauCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudMainController {


    FrauCheckService checkService;

    @GetMapping(path = "{customerId")
    public ResponseEntity<FraudCheckResponse> fraudCheck(@PathVariable("customerId") Integer customerId){

        boolean result = checkService.isFraudulentCustomer(customerId);
        FraudCheckResponse response = new FraudCheckResponse(result);
        log.info("fraud check request for customer {}", customerId);
        return ResponseEntity.ok(response);

    }
}
