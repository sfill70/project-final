package com.javarush.jira.bugtracking;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping
public class TaskController {

    private TaskService taskService;

    /*п. 6  */
    @PostMapping(path = "/{id}/tag", consumes = {"application/json", "application/x-www-form-urlencoded"})
    public String addTagToTask(@PathVariable("id") Long taskId, @RequestBody String tag) {
        taskService.addTagToTask(taskId, tag);
        return "redirect:/";
    }


}
