package com.heeha.amagetdon.repository;

import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.DiscriminatorValue;
import java.util.*;

@Repository
public class MemoryGroupRepository implements GroupRepository{

    private static Map<Long, Group> groupStore = new HashMap<>();
    private static Map<Long, Budget> budgetStore = new HashMap<>();
    private static long sequence = 1L;

    @Override
    public Long save(Group group) {
        String dType = group.getClass().getAnnotation(DiscriminatorValue.class).value();
        group.setTableName(dType);
        groupStore.put(group.getId(), group);
        if (Objects.equals(dType, "Budget")) {
            budgetStore.put(group.getId(), (Budget) group);
        }
        return group.getId();
    }

    @Override
    public Long save(String name, String desc, String imageUrl, int amount) {
        Budget budget = new Budget();
        budget.setId(sequence++);
        budget.setName(name);
        budget.setDescription(desc);
        budget.setImage(imageUrl);
        budget.setBudgetAmount(amount);
        this.save(budget);
        return budget.getId();
    }

    @Override
    public Optional<Group> findById(Long id) {
        Optional<Group> findGroup = Optional.ofNullable(groupStore.get(id));
        if (findGroup.isPresent()) {
            return findGroup;
        } else {
            throw new IllegalStateException("그룹이 존재하지 않습니다.");
        }
    }

    @Override
    public Budget findBudgetById(Long id) {
        Optional<Group> findGroup = Optional.ofNullable(groupStore.get(id));
        Group group = findGroup.get();
        String dType = group.getClass().getAnnotation(DiscriminatorValue.class).value();
        if (Objects.equals(dType, "Budget")) {
            return (Budget) group;
        } else {
            throw new IllegalStateException("그룹이 존재하지 않습니다.");
        }
    }

    @Override
    public List<Group> findAll(){
        return new ArrayList<>(groupStore.values());
    }

    @Override
    public List<Budget> findBudgetAll() {
        return new ArrayList<>(budgetStore.values());
    }

    @Override
    public Long modify(Long id, String name, String desc, String imageUrl){
        Optional<Group> findGroup = this.findById(id);
        if (findGroup.isPresent()) {
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
        groupStore.clear();
    }
}
