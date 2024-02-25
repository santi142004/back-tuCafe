package com.backtucafe.controller;

import com.backtucafe.model.request.ReservationRequest;
import com.backtucafe.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tuCafe/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(value = "creation_reservation")
    public ResponseEntity<String>reservation(@RequestBody ReservationRequest request){
            return ResponseEntity.ok(reservationService.reservation(request));
    }
}
