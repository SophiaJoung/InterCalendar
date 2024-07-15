package com.ssu.intercalendar.group.domain;

import com.ssu.intercalendar.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class GroupParticipantWaiting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Builder
    public GroupParticipantWaiting(User user, Group group) {
        this.user = user;
        this.group = group;
    }
    //Builder: 생성자 순서 외우기 싫어서 쓰는 것
}
