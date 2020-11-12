package com.wozu.todoApp.Repo;

import com.wozu.todoApp.Model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepo extends CrudRepository<Task, UUID> {}
