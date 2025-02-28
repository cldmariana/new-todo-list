package com.example.newtodolist.controller;

import com.example.newtodolist.model.UserTask;
import com.example.newtodolist.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usertasks")
public class UserTaskController {
    @Autowired
    private UserTaskService userTaskService;

    @GetMapping
    public List<UserTask> getAllUserTasks() {
        return userTaskService.findAll();
    }

    @GetMapping("{id}")
    public UserTask getUserTaskById(@PathVariable Long id) {
        return userTaskService.findUserTaskById(id);
    }

    @PostMapping
    public ResponseEntity<UserTask> createUserTask(@RequestBody UserTask userTask) {
        return ResponseEntity.ok(userTaskService.createUserTask(userTask));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserTask> updateUserTask(@PathVariable Long id, @RequestBody UserTask userTask) {
        return ResponseEntity.ok(userTaskService.updateUserTask(id, userTask));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUserTaskById(@PathVariable Long id) {
        userTaskService.deleteUserTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
