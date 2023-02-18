package com.heeha.amagetdon.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Sepending {
    @Id
    @GeneratedValue
    @Column(name = "spending_id")
    private Long id;

    @Column(name = "user_permission_id")
    private Long uerPermissionId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "user_id")
    private Long userId;

    private String email;

    @Column(name = "receipt_id")
    private Long receiptId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "currency_id")
    private Long currencyId;

    private LocalDateTime enrolledDate;

    @Column(name = "spending_description")
    private String description;

    @Column(name = "spending_location")
    private String location;

    private boolean isTransfered;
}
