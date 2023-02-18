package com.heeha.amagetdon.domain.permission;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "user_group")
public class UserPermission {
    @Id
    @GeneratedValue
    @Column(name="user_group_id")
    private Long id;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "permission_type")
    @Enumerated(EnumType.STRING)
    private Permisson permissionType;

    @Column(name = "user_id")
    private Long userId;

    private Long email;

    @Column(name = "permission_assigner")
    private Long permissionAssigner;

    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @Column(name = "unassigned_date")
    private LocalDateTime unassignedDate;
}
