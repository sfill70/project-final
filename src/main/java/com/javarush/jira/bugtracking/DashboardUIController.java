package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.to.SprintTo;
import com.javarush.jira.bugtracking.to.TaskTo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping
public class DashboardUIController {

    private TaskService taskService;

    @GetMapping("/") // index page
    public String getAll(Model model) {
        List<TaskTo> tasks = taskService.getAll();
        Map<SprintTo, List<TaskTo>> taskMap = tasks.stream()
                .collect(Collectors.groupingBy(TaskTo::getSprint));
        model.addAttribute("taskMap", taskMap);
        Map<Long,Map<String,String>> mapSummary = new HashMap<>();
        for (TaskTo taskTo:tasks
             ) {
            mapSummary.put(taskTo.id(), taskService.getTaskSummary(taskTo.getId()));
        }
        model.addAttribute("mapSummary", mapSummary);
        return "index";
    }

    //    11.
   /* @GetMapping("/lang")
    public String changeLanguage(@RequestParam String language, HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }*/
}
