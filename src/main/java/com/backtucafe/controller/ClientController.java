package com.backtucafe.controller;

import com.backtucafe.controller.response.TokenResponse;
import com.backtucafe.model.request.LoginRequest;
import com.backtucafe.model.request.RegisterRequest;
import com.backtucafe.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tuCafe/v1/client")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {

    private final ClientService clientService;

    @PostMapping(value = "register")
    public ResponseEntity<String> registerClient(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(clientService.registerCliente(request));
    }

    @PostMapping(value = "login")
    public ResponseEntity<TokenResponse> loginUser(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(clientService.loginCliente(request));
    }




}
