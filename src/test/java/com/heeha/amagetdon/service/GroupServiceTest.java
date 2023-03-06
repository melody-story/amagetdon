package com.heeha.amagetdon.service;
import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;
import com.heeha.amagetdon.repository.MemoryGroupRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class GroupServiceTest {
    MemoryGroupRepository memoryGroupRepository;
    GroupService groupService;

    @BeforeEach
    public void beforeEach() {
        memoryGroupRepository = new MemoryGroupRepository();
        groupService = new GroupService(memoryGroupRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryGroupRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
        //given
        Budget budget = new Budget();
        budget.setName("밴드동아리예산");
        budget.setBudgetAmount(5000);
        Long groupId = groupService.save(budget);
        //when
        Optional<Group> one = groupService.findOneById(groupId);
        //then
        assertThat(one.get().getId()).isEqualTo(groupId);
    }

    @Test
    public void findAll() throws Exception {
        //given
        Budget budget_1 = createBudget("한문동아리예산", 3000);
        Budget budget_2 = createBudget("과학동아리예산", 4000);
        Budget budget_3 = createBudget("논술동아리예산", 5000);
        groupService.save(budget_1);
        groupService.save(budget_2);
        groupService.save(budget_3);
        //when
        List<Group> allGroup = groupService.findAll();
        //then
        assertThat(allGroup.size()).isEqualTo(3);
    }

    public Long id = 0L;
    public Budget createBudget(String name, int amount) {
        Budget budget = new Budget();
        budget.setId(id++);
        budget.setName(name);
        budget.setBudgetAmount(amount);
        return budget;
    }

    @Test
    public void findOneById() throws Exception {
        //given
        Budget budget = new Budget();
        budget.setName("밴드동아리예산");
        budget.setBudgetAmount(5000);
        Long groupId = groupService.save(budget);
        //when
        Optional<Group> group = groupService.findOneById(groupId);
        //then
        assertThat(budget.getName()).isEqualTo(group.get().getName());
    }

    @Test
    public void updateBudget() throws Exception {
        //given
        Budget budget = new Budget();
        budget.setName("밴드동아리예산");
        budget.setBudgetAmount(5000);
        Long groupId = groupService.save(budget);
        //when
        groupService.update(groupId, budget.getName(),
                budget.getDescription(), budget.getImage(), 6000);
        Budget findOne = (Budget) groupService.findOneById(groupId).get();
        //then
        assertThat(findOne).isSameAs(budget);
        assertThat(findOne.getBudgetAmount()).isEqualTo(6000);
    }

}