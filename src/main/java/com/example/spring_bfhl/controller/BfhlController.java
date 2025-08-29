package com.example.spring_bfhl.controller;

import com.example.spring_bfhl.dto.BfhlRequest;
import com.example.spring_bfhl.dto.BfhlResponse;
import com.example.spring_bfhl.service.BfhlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BfhlController {

    private final BfhlService service;

    // TODO: Replace these constants with your real values before submission
    private static final String SUBMIT_USER_ID = "agneepradeep_verma_19062002";
    private static final String SUBMIT_EMAIL = "agnipradeep19@gmail.com";
    private static final String SUBMIT_ROLL = "22BCI0198";

    public BfhlController(BfhlService service) {
        this.service = service;
    }

    @PostMapping("/bfhl")
    public ResponseEntity<BfhlResponse> process(@RequestBody BfhlRequest request) {
        try {
            var res = service.process(request != null ? request.getData() : null);

            BfhlResponse response = new BfhlResponse();
            response.setSuccess(true);
            response.setUserId(SUBMIT_USER_ID);   // change to real "full_name_ddmmyyyy"
            response.setEmail(SUBMIT_EMAIL);      // change to your email
            response.setRollNumber(SUBMIT_ROLL);  // change to your roll number
            response.setOddNumbers(res.oddNumbers);
            response.setEvenNumbers(res.evenNumbers);
            response.setAlphabets(res.alphabets);
            response.setSpecialCharacters(res.specialCharacters);
            response.setSum(res.sum);
            response.setConcatString(res.concatString);

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            // graceful failure - return is_success = false and safe defaults
            BfhlResponse errorResp = new BfhlResponse();
            errorResp.setSuccess(false);
            errorResp.setUserId(SUBMIT_USER_ID);
            errorResp.setEmail(SUBMIT_EMAIL);
            errorResp.setRollNumber(SUBMIT_ROLL);
            errorResp.setOddNumbers(java.util.Collections.emptyList());
            errorResp.setEvenNumbers(java.util.Collections.emptyList());
            errorResp.setAlphabets(java.util.Collections.emptyList());
            errorResp.setSpecialCharacters(java.util.Collections.emptyList());
            errorResp.setSum("0");
            errorResp.setConcatString("");
            return ResponseEntity.ok(errorResp);
        }
    }
}
