package com.heeha.amagetdon.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Receipt {
    @Id
    @GeneratedValue
    @Column(name = "receipt_id")
    private Long id;

    @Column(name = "spending_id")
    private Long spendingId;
}
