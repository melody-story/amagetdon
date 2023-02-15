package com.heeha.amagetdon.repository;

import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
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

    @Override
    public Optional<Group> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Group> findAll(){
        return new ArrayList<>(store.values());
    }

    @Override
    public Long modifyBudget(Long id,String name, String desc, int amount, String imageUrl){
        Optional<Group> group = this.findById(id);
        if (group.isPresent()) {
            Budget budget = (Budget) group.get();
            budget.setName(name);
            budget.setDescription(desc);
            budget.setBudgetAmount(amount);
            budget.setImageUrl(imageUrl);
            this.save(budget);
            return budget.getId();
        } else {
            throw new IllegalStateException("그룹이 존재하지 않습니다.");
        }
    }

    public void clearStore() {
        store.clear();
    }
}
