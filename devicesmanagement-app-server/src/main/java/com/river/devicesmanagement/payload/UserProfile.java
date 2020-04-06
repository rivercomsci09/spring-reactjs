package com.river.devicesmanagement.payload;

import java.time.Instant;

public class UserProfile {
    private Integer id;
    private String username;
    private Instant joinedAt;
    private Integer pollCount;
    private Integer voteCount;

    public UserProfile(Integer id, String username, Instant joinedAt, Integer pollCount, Integer voteCount) {
        this.id = id;
        this.username = username;
        this.joinedAt = joinedAt;
        this.pollCount = pollCount;
        this.voteCount = voteCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Instant joinedAt) {
        this.joinedAt = joinedAt;
    }

    public Integer getPollCount() {
        return pollCount;
    }

    public void setPollCount(Integer pollCount) {
        this.pollCount = pollCount;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
