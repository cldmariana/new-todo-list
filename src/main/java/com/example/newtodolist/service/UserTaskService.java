package com.example.newtodolist.service;

import com.example.newtodolist.model.UserTask;
import com.example.newtodolist.repository.UserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaskService {
    @Autowired
    private UserTaskRepository userTaskRepository;

    public List<UserTask> findAll() {
        return userTaskRepository.findAll();
    }

    public UserTask findUserTaskById(Long id) {
        return userTaskRepository.findById(id).orElseThrow(() -> new RuntimeException("User Task Not Found"));
    }

    public UserTask createUserTask(UserTask userTask) {
        return userTaskRepository.save(userTask);
    }

    public UserTask updateUserTask(Long id, UserTask userTaskDetails) {
        UserTask userTask = findUserTaskById(id);
        userTask.setName(userTaskDetails.getName());
        userTask.setDescription(userTaskDetails.getDescription());
        userTask.setDone(userTaskDetails.isDone());
        return userTaskRepository.save(userTask);
    }

    public void deleteUserTaskById(Long id) {
        userTaskRepository.deleteById(id);
    }
}
