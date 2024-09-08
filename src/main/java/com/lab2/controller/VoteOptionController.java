package com.lab2.controller;

import com.lab2.component.PollManager;
import com.lab2.model.VoteOption;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/voteOptions")
public class VoteOptionController {
    private final PollManager pollManager;

    public VoteOptionController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public VoteOption createVoteOption(@RequestBody VoteOption voteOption) {
        return pollManager.createVoteOption(voteOption);
    }

    @GetMapping
    public Collection<VoteOption> listVoteOptions() {
        return pollManager.listVoteOptions();
    }

    @GetMapping("/{id}")
    public VoteOption getVoteOptionById(@PathVariable Integer id) {
        return pollManager.getVoteOptionById(id);
    }
}
