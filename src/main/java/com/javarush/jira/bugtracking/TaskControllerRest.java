package com.javarush.jira.bugtracking;


import com.javarush.jira.bugtracking.internal.model.Task;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@Slf4j
@Controller
@AllArgsConstructor
@RestController
public class TaskControllerRest {
    private TaskService taskService;

    @PutMapping("/tasks/{id}")
    public ResponseEntity<?> addTagsTask(@Valid @PathVariable("id") Long id, @RequestBody String[] tags) {
        Task task = taskService.addTagsToTask(id, Set.copyOf(Arrays.asList(tags)));
        return ResponseEntity.ok(task);
    }

}
