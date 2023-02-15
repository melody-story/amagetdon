package com.heeha.amagetdon.repository;

import com.heeha.amagetdon.domain.group.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {
    public Long save(Group group);

    public Optional<Group> findById(Long id);

    public List<Group> findAll();

    public Long modify(Long id, String name, String desc, String imageUrl);

    public Long modify(Long id, String name, String desc, String imageUrl, int amount);
}
