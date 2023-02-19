package com.heeha.amagetdon.controller;

import com.heeha.amagetdon.domain.group.Budget;
import com.heeha.amagetdon.domain.group.Group;
import com.heeha.amagetdon.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

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
        List<Group> groups = groupService.findAll();
        model.addAttribute("groups", groups);
        return "groups/groupList";
    }
}
