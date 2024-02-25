package com.backtucafe.service;

import com.backtucafe.controller.response.TokenResponse;
import com.backtucafe.model.Client;
import com.backtucafe.model.request.LoginRequest;
import com.backtucafe.model.request.RegisterRequest;
import com.backtucafe.repository.ClientRepository;
import com.backtucafe.security.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class ClientService{

    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;

    public String registerCliente(RegisterRequest request){
        Client client = Client.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        clientRepository.save(client);
        return "Te has registrado con exito";
    }

    public TokenResponse loginCliente(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        Client client = clientRepository.findByEmail(request.getEmail());
        String token = tokenUtils.getTokenClient(client);
        return TokenResponse.builder()
                .token(token)
                .build();
    }



}
