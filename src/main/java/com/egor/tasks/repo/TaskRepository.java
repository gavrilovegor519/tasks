package com.egor.tasks.repo;

import com.egor.tasks.entity.Task;
import com.egor.tasks.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends
        JpaRepository<Task, Long> {
    // findById is default

    Page<Task> findAllByAuthor(User author,
                               Pageable pageable);

}