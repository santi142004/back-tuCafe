package com.backtucafe.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    private String name;
    private String country;
    private String city;
    private String email;
    private String phone;
    private String password;
    private List<Byte> photo;

    @ManyToMany(mappedBy = "clients")
    private Set<Business> businesess = new HashSet<>();

}
