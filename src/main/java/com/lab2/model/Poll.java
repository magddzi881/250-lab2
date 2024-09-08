package com.lab2.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class Poll {
    private Integer id;
    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private Set<VoteOption> options = new HashSet<>();
    private Set<Vote> votes = new HashSet<>();
    private Set<User> invitedUsers = new HashSet<>();

    public Poll() {}

    public Poll(Integer id, String question, Instant publishedAt, Instant validUntil) {
        this.id = id;
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public Instant getPublishedAt() { return publishedAt; }
    public void setPublishedAt(Instant publishedAt) { this.publishedAt = publishedAt; }

    public Instant getValidUntil() { return validUntil; }
    public void setValidUntil(Instant validUntil) { this.validUntil = validUntil; }

    public Set<VoteOption> getOptions() { return options; }
    public void setOptions(Set<VoteOption> options) { this.options = options; }

    public Set<Vote> getVotes() { return votes; }
    public void setVotes(Set<Vote> votes) { this.votes = votes; }

    public Set<User> getInvitedUsers() { return invitedUsers; }
    public void setInvitedUsers(Set<User> invitedUsers) { this.invitedUsers = invitedUsers; }
}
