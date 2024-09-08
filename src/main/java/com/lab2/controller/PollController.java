package com.lab2.controller;

import com.lab2.component.PollManager;
import com.lab2.model.Poll;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/polls")
public class PollController {
    private final PollManager pollManager;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollManager.createPoll(poll);
    }

    @GetMapping
    public Collection<Poll> listPolls() {
        return pollManager.listPolls();
    }

    @GetMapping("/{id}")
    public Poll getPollById(@PathVariable Integer id) {
        return pollManager.getPollById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable Integer id) {
        pollManager.deletePoll(id);
    }
}
