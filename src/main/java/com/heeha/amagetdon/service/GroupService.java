package com.heeha.amagetdon.service;

import com.heeha.amagetdon.domain.group.Budget;
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

//    public Long save(String name, String desc, String imageUrl) {
//        return groupRepository.save(name, desc, imageUrl);
//    }
    public Long save(String name, String desc, String imageUrl, int amount) {
        return groupRepository.save(name, desc, imageUrl, amount);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public List<Budget> findBudgetAll() {
        return groupRepository.findBudgetAll();
    }

    public Optional<Group> findOneById(Long id) {
        return groupRepository.findById(id);
    }

    public Budget findBudgetById(Long id) {
        return (Budget) groupRepository.findBudgetById(id);
    }

    public Long update(Long id,String name, String desc, String imageUrl){
        return groupRepository.modify(id, name, desc,imageUrl);
    }

    public Long update(Long id,String name, String desc, String imageUrl, int amount){
        return groupRepository.modify(id, name, desc,imageUrl, amount);
    }
}
