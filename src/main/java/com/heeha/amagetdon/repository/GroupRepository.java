package com.heeha.amagetdon.repository;

import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface GroupRepository {
    public Long save(Group group);

    public Optional<Group> findById(Long id);

    public List<Group> findAll();

    public Long modifyBudget(Long id,String name, String desc, int amount, String imageUrl);
}