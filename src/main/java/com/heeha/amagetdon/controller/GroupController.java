package com.heeha.amagetdon.controller;

import com.heeha.amagetdon.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
