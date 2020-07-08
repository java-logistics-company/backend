package com.cscb025.logistic.company.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uid;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
