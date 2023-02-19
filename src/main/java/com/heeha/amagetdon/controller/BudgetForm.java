package com.heeha.amagetdon.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
@Getter @Setter
public class BudgetForm {

    private Long id;

    @NotEmpty(message = "그룹명은 필수입니다.")
    private String name;

    private String desc;

    private int amount;

    private String image;
}
