package com.white_wolf.threeeyedcrows.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_goals")
public class UserGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long weekNumber;

    private boolean completed;

    @ManyToOne(fetch = FetchType.EAGER)
    private Goal goal;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Long getId() {
        return id;
    }

    public Long getWeekNumber() {
        return weekNumber;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Goal getGoal() {
        return goal;
    }

    @JsonIgnore
    public User getUser() {
        return this.user;
    }

    @JsonProperty
    public void setUser(User user) {
        this.user = user;
    }
}
