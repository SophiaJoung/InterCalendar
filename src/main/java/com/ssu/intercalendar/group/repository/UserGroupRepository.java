package com.ssu.intercalendar.group.repository;

import com.ssu.intercalendar.group.domain.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
}
