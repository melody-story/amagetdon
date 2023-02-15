package com.heeha.amagetdon.repository;

import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryGroupRepositoryTest {
    MemoryGroupRepository repository;
    @BeforeEach
    public void beforeEach() {
        this.repository = new MemoryGroupRepository();
    }

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Budget budget = createBudget("어부들",200);
        Long budgetId = repository.save(budget);
        Optional<Group> result = repository.findById(budgetId);
        assertThat(budget.getName()).isSameAs(result.get().getName());
    }

    @Test
    public void findById() throws Exception{
        Budget budget = createBudget("증인들", 200);
        Long budgetId = repository.save(budget);
        System.out.println("budgetId = " + budgetId);
        System.out.println("budget.getId() = " + budget.getId());
        assertThat(budget.getId()).isSameAs(budgetId);
    }
    @Test
    public void findAll() throws Exception {
        Budget budget = createBudget("초등부", 400);
        repository.save(budget);
        Budget budget2 = createBudget("어부들", 500);
        repository.save(budget2);
        int result = repository.findAll().size();
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void modify() throws Exception {
        //given
        Budget budget = createBudget("어부들", 400);
        repository.save(budget);

        //when
        Long result = repository.modify(budget.getId(), "증인들", "","", 500);

        //then
        assertThat(budget.getName()).isEqualTo("증인들");
        assertThat(budget.getBudgetAmount()).isEqualTo(500);
    }

    public Budget createBudget(String name, int amount) {
        Budget budget = new Budget();
        budget.setName(name);
        budget.setBudgetAmount(amount);
        return budget;
    }
}