package com.heeha.amagetdon.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Currency {
    @Id
    @GeneratedValue
    @Column(name = "currnecy_id")
    private Long id;

    @Column(name = "currency_name")
    private String name;

    @Column(name = "currency_unit")
    private String unit;
}
