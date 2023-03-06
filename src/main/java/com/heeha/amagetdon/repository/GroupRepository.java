package com.heeha.amagetdon.repository;

import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {
    public Long save(Group group);

//    public Long save(String name, String desc, String imageUrl);

    public Long save(String name, String desc, String imageUrl, int amount);

    public Optional<Group> findById(Long id);

    public Group findBudgetById(Long id);

    public List<Group> findAll();

    public List<Budget> findBudgetAll();

    public Long modify(Long id, String name, String desc, String imageUrl);

    public Long modify(Long id, String name, String desc, String imageUrl, int amount);

}
