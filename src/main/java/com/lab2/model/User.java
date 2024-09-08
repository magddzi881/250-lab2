package com.lab2.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Integer id;
    private String username;
    private String email;
    private Set<Poll> createdPolls = new HashSet<>();
    private Set<Vote> votes = new HashSet<>();

    public User() {}

    public User(Integer id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Set<Poll> getCreatedPolls() { return createdPolls; }
    public void setCreatedPolls(Set<Poll> createdPolls) { this.createdPolls = createdPolls; }

    public Set<Vote> getVotes() { return votes; }
    public void setVotes(Set<Vote> votes) { this.votes = votes; }
}
