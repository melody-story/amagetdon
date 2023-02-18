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
public class Income {
    @Id
    @GeneratedValue
    @Column(name = "income_id")
    private Long incomeId;

    @Column(name = "user_permission_id")
    private Long userPermissionId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "user_id")
    private Long userId;

    private String email;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "currency_id")
    private Long currencyId;

    @Column(name = "enrolled_date")
    private LocalDateTime enrolledDate;

    private String description;

    @Column(name = "income_amount")
    private Long amount;
}
