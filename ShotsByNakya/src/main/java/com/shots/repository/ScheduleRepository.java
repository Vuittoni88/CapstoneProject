package com.shots.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shots.entity.Scheduler;

@Repository
public interface ScheduleRepository extends JpaRepository<Scheduler, Integer> {

}
