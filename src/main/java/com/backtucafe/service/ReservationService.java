package com.backtucafe.service;

import com.backtucafe.model.Business;
import com.backtucafe.model.Client;
import com.backtucafe.model.Reservation;
import com.backtucafe.model.request.ReservationRequest;
import com.backtucafe.repository.BusinessRepository;
import com.backtucafe.repository.ClientRepository;
import com.backtucafe.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final BusinessRepository businessRepository;

    public String reservation(ReservationRequest request){
        // Buscar cliente por ID
        Client client = clientRepository.findById(request.getId_client())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Buscar negocio por ID
        Business business = businessRepository.findById(request.getId_business())
                .orElseThrow(() -> new RuntimeException("Establecimiento no encontrado"));

        // Crear la reserva
        Reservation reservation = Reservation.builder()
                .id_client(client)
                .id_business(business)
                .date(request.getHour_reservation())
                .description(request.getDescription())
                .build();

        // Guardar la reserva en la base de datos
        reservationRepository.save(reservation);

        return "Reserva realizada con éxito";
    }
}
