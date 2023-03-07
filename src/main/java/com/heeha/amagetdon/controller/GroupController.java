package com.heeha.amagetdon.controller;

import ch.qos.logback.classic.db.names.TableName;
import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;
import com.heeha.amagetdon.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/budgets/new")
    public String createBudgetForm(Model model) {
        model.addAttribute("form", new BudgetForm());
        log.info("===== Group Controller creatForm  =======");
        return "groups/createBudgetForm";
    }

    @PostMapping("/budgets/new")
    public String createBudget(BudgetForm form) {
        groupService.save(form.getName(), form.getDesc(), form.getImage(),form.getAmount());
        log.info("===== Group Controller create  =======");
        return "redirect:/groups";
    }

    @GetMapping("/groups")
    public String list(Model model) {
//        List<Group> groups = groupService.findAll();
        List<Budget> budgets= groupService.findBudgetAll();
        model.addAttribute("budgets", budgets);
        log.info("===== Group Controller listFrom  =======");
        return "groups/groupList";
    }

}
