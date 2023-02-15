package com.heeha.amagetdon.service;

import com.heeha.amagetdon.domain.group.Group;
import com.heeha.amagetdon.repository.GroupRepository;
import com.heeha.amagetdon.repository.MemoryGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Long save(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Optional<Group> findOneById(Long id) {
        return groupRepository.findById(id);
    }

    public Long updateBudget(Long id,String name, String desc, int amount, String imageUrl){
        return groupRepository.modifyBudget(id, name, desc, amount, imageUrl);
    }
}
