package com.heeha.amagetdon.repository;

import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryGroupRepository implements GroupRepository{

    private static Map<Long, Group> store = new HashMap<>();
    private static long sequence = 1L;

    @Override
    public Long save(Group group) {
        group.setId(sequence++);
        store.put(group.getId(), group);
        return group.getId();
    }
//    public Long save(String name, String desc, String imageUrl) {
//        new Group()
//        group.setId(sequence++);
//        store.put(group.getId(), group);
//        return group.getId();
//    }
    @Override
    public Long save(String name, String desc, String imageUrl, int amount) {
        Budget budget = new Budget();
        budget.setId(sequence++);
        budget.setName(name);
        budget.setDescription(desc);
        budget.setImage(imageUrl);
        budget.setBudgetAmount(amount);
        store.put(budget.getId(), budget);
        return budget.getId();
    }

    @Override
    public Optional<Group> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Group> findAll(){
        return new ArrayList<>(store.values());
    }

    @Override
    public Long modify(Long id, String name, String desc, String imageUrl){
        Optional<Group> findGroup = this.findById(id);
        if (findGroup.isPresent()) {
//            Gyetdon getdon = (Gyetdon) group.get();
            Group group = findGroup.get();
            group.setName(name);
            group.setDescription(desc);
            group.setImage(imageUrl);
            this.save(group);
            return group.getId();
        } else {
            throw new IllegalStateException("곗돈그룹이 존재하지 않습니다.");
        }
    }
    @Override
    public Long modify(Long id,String name, String desc,String imageUrl, int amount){
        Optional<Group> groupOfBudget = this.findById(id);
        if (groupOfBudget.isPresent()) {
            Budget budget = (Budget) groupOfBudget.get();
            budget.setName(name);
            budget.setDescription(desc);
            budget.setBudgetAmount(amount);
            budget.setImage(imageUrl);
            this.save(budget);
            return budget.getId();
        } else {
            throw new IllegalStateException("예산그룹이 존재하지 않습니다.");
        }
    }

    public void clearStore() {
        store.clear();
    }
}
