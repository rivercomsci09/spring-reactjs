package com.river.devicesmanagement.repository;

import com.river.devicesmanagement.model.Poll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    Optional<Poll> findById(Integer pollId);

    Page<Poll> findByCreatedBy(Integer userId, Pageable pageable);

    int countByCreatedBy(Integer userId);

    List<Poll> findByIdIn(List<Integer> pollIds);

    List<Poll> findByIdIn(List<Integer> pollIds, Sort sort);
}
