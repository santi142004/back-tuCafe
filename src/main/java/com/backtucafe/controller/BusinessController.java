package com.backtucafe.controller;

import com.backtucafe.controller.response.TokenResponse;
import com.backtucafe.model.request.LoginRequest;
import com.backtucafe.model.request.RegisterRequest;
import com.backtucafe.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tuCafe/v1/business")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping(value = "register")
    public ResponseEntity<String> registerBusiness(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(businessService.registerBusiness(request));
    }

    @PostMapping(value = "login")
    public ResponseEntity<TokenResponse> loginBusiness(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(businessService.loginBusiness(request));
    }



}
