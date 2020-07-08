package com.cscb025.logistic.company.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uid;

    @Column(nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(nullable = false)
    @NonNull
    private String address;

    @Column(nullable = false, unique = true)
    @NonNull
    private String phone;

    //Relations

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @NonNull
    private Company company;

    @OneToMany(mappedBy = "office")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "office")
    private List<Shipment> shipments = new ArrayList<>();
}
