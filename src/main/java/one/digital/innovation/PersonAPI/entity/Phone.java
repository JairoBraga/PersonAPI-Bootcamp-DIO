package one.digital.innovation.PersonAPI.entity;

import one.digital.innovation.PersonAPI.enums.PhoneType;

import javax.persistence.*;

public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}

