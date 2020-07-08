package com.cscb025.logistic.company.entity;

import com.cscb025.logistic.company.enums.ShipmentStatus;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table()
public class Shipment {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String uid;

    @Column(nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private ShipmentStatus status;

    //Relations
    @ManyToOne
    @JoinColumn(name = "office_id", nullable = false)
    @NonNull
    private Office office; //Where shipment was registered

    @ManyToOne
    @JoinColumn(name = "office_worker_id", nullable = false)
    @NonNull
    private Employee office_worker; //Who registered shipment

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    @NonNull
    private Client receiver;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    @NonNull
    private Client sender;
}
