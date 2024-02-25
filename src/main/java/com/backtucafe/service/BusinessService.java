package com.backtucafe.service;

import com.backtucafe.controller.response.TokenResponse;
import com.backtucafe.model.Business;
import com.backtucafe.model.request.LoginRequest;
import com.backtucafe.model.request.RegisterRequest;
import com.backtucafe.repository.BusinessRepository;
import com.backtucafe.security.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;

    public String registerBusiness(RegisterRequest request){
        Business business = Business.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        businessRepository.save(business);
        return "Te has registrado con exito";
    }

    public TokenResponse loginBusiness(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        Business business = businessRepository.findByEmail(request.getEmail());
        String token = tokenUtils.getTokenBusiness(business);
        return TokenResponse.builder()
                .token(token)
                .build();
    }



}
