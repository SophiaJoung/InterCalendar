package com.ssu.intercalendar.group.repository;

import com.ssu.intercalendar.group.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByGroupName(String groupName);
}
