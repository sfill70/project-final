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

    /* п.7*/
    @PostMapping("/task/{id}/user/{userId}")
    public String addUserToTask(@PathVariable("id") Long taskId, @PathVariable("userId") Long userId) {
        taskService.addUserToTask(taskId, userId);
        return "redirect:/";
    }

    @PostMapping(path = "/task/{id}/user", produces = {"application/json", MediaType.ALL_VALUE}, consumes = {"application/json", MediaType.ALL_VALUE})
    public String addUserToTask(@PathVariable("id") Long taskId, @RequestBody String userId) {
        long userIdLong = 0;
        try {
            userIdLong = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            return "redirect:/";
        }
        taskService.addUserToTask(taskId, (long) userIdLong);
        return "redirect:/";
    }

}
