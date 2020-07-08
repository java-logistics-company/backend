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
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uid;

    @Column(nullable = false, unique = true)
    @NonNull
    private String name;

    //Relations

    @OneToMany(mappedBy = "company")
    private List<Office> offices = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    private List<Client> clients = new ArrayList<>();
}
