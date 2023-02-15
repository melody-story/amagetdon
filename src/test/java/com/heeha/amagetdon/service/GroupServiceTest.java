package com.heeha.amagetdon.service;
import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;
import com.heeha.amagetdon.repository.MemoryGroupRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.Optional;


public class GroupServiceTest {
    MemoryGroupRepository memoryGroupRepository;
    GroupService groupService;

    @Before
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
        Optional<Group> one = groupService.findOne(groupId);
        //then
        Assertions.assertThat(one.get().getId()).isEqualTo(groupId);
    }
}