package com.ssu.intercalendar.group.domain;


import com.ssu.intercalendar.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Builder
    public UserGroup(User user, Group group) {
        this.user = user;
        this.group = group;
    }

    public void addGroup(Group group) {
        this.group = group;
        if (!group.getUserGroups().contains(this)) {
            group.getUserGroups().add(this);
        }
    }

}
