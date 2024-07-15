package com.ssu.intercalendar.schedule.repository;

import com.ssu.intercalendar.schedule.domain.Schedule;
import com.ssu.intercalendar.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s WHERE s.user.id = :id AND s.date BETWEEN :startDate AND :endDate ORDER BY s.date ASC")
    List<Schedule> findScheduleByDateRange(@Param("id") Long id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    List<Schedule> findByUser(User user);
}
