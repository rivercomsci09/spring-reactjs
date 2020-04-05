package com.river.devicesmanagement.payload;

public class UserSummary {
    private Integer id;
    private String username;

    public UserSummary() {
    }

    public UserSummary(Integer id, String username) {
        this.id = id;
        this.username = username;
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
}
