package com.example.quizapp.repository;

import com.example.quizapp.model.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<QuizUser, Long> {
    @Query(value = "SELECT * FROM quiz_user WHERE user_id= :id", nativeQuery = true)
    Optional<QuizUser> findUserById(@Param("id") long id);
}
