package com.heeha.amagetdon.domain.group;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@DiscriminatorValue("Budget")
public class Budget extends Group {
    private int budgetAmount;
}
