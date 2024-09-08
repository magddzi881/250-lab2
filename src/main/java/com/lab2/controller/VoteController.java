package com.lab2.controller;

import com.lab2.component.PollManager;
import com.lab2.model.Vote;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final PollManager pollManager;

    public VoteController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public Vote castVote(@RequestBody Vote vote) {

        return pollManager.castVote(vote);

    }

    @GetMapping
    public Collection<Vote> listVotes() {
        return pollManager.listVotes();
    }

    @GetMapping("/{id}")
    public Vote getVoteById(@PathVariable Integer id) {
        return pollManager.getVoteById(id);
    }
}
