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

    // 8.add task summary (valid - task id=3 )
  /*  JSON
    {
        "ready": "-6 day(s) -2 hour(s) 00 minute(s) 00 second(s)",
        "done": "-2 day(s) -19 hour(s) 00 minute(s) 00 second(s)"
    }*/
    @PostMapping("/summary/{id}")
    @ResponseBody
    public Map<String, String> getSummary(@PathVariable Long id) {
        return taskService.getTaskSummary(id);
    }

}
