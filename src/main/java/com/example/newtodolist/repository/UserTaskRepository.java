package com.example.newtodolist.repository;

import com.example.newtodolist.model.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTaskRepository extends JpaRepository<UserTask, Long> {
}
