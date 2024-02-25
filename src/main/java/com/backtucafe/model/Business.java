package com.backtucafe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_business;
    private String name;
    private String email;
    private String password;
    private String address;
    private String description;
    private List<Byte> image;
    private String city;
    private String phone;
    private LocalDate start_hour;
    private LocalDate finish_hour;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_admin", referencedColumnName = "id_admin")
//    private Admin idAdmin;

    @ManyToMany
    @JoinTable(name = "reservation",
            joinColumns = @JoinColumn(name = "id_business"),
            inverseJoinColumns = @JoinColumn(name = "id_client"))
    private Set<Client> clients = new HashSet<>();



}
