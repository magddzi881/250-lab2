package com.lab2;

import com.lab2.component.PollManager;
import com.lab2.model.Poll;
import com.lab2.model.User;
import com.lab2.model.Vote;
import com.lab2.model.VoteOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PollManagerTests {

	@Autowired
	private PollManager pollManager;

	private User user;
	private Poll poll;
	private VoteOption voteOption;

	@BeforeEach
	public void setUp() {
		pollManager = new PollManager();
		// Create and add sample entities
		user = new User();
		user.setId(1);
		user.setVotes(new HashSet<>());
		pollManager.createUser(user);

		poll = new Poll();
		poll.setId(1);
		pollManager.createPoll(poll);

		voteOption = new VoteOption();
		voteOption.setId(1);
		pollManager.createVoteOption(voteOption);
	}

	@Test
	public void testCreateUser() {
		User newUser = new User();
		newUser.setId(2);
		User createdUser = pollManager.createUser(newUser);
		assertNotNull(createdUser);
		assertEquals(2, createdUser.getId());
	}

	@Test
	public void testCreatePoll() {
		Poll newPoll = new Poll();
		newPoll.setId(2);
		Poll createdPoll = pollManager.createPoll(newPoll);
		assertNotNull(createdPoll);
		assertEquals(2, createdPoll.getId());
	}

	@Test
	public void testCreateVoteOption() {
		VoteOption newOption = new VoteOption();
		newOption.setId(2);
		VoteOption createdOption = pollManager.createVoteOption(newOption);
		assertNotNull(createdOption);
		assertEquals(2, createdOption.getId());
	}

	@Test
	public void testCastVote() {
		Vote vote = new Vote();
		vote.setId(1);
		vote.setUser(user);
		vote.setVoteOption(voteOption);
		Vote createdVote = pollManager.castVote(vote);

		assertNotNull(createdVote);
		assertEquals(1, createdVote.getId());
		assertEquals(user, createdVote.getUser());
		assertEquals(voteOption, createdVote.getVoteOption());
		assertTrue(user.getVotes().contains(createdVote.getId()));
	}

	@Test
	public void testGetUserById() {
		User retrievedUser = pollManager.getUserById(1);
		assertNotNull(retrievedUser);
		assertEquals(1, retrievedUser.getId());
	}

	@Test
	public void testGetPollById() {
		Poll retrievedPoll = pollManager.getPollById(1);
		assertNotNull(retrievedPoll);
		assertEquals(1, retrievedPoll.getId());
	}

	@Test
	public void testGetVoteOptionById() {
		VoteOption retrievedOption = pollManager.getVoteOptionById(1);
		assertNotNull(retrievedOption);
		assertEquals(1, retrievedOption.getId());
	}

	@Test
	public void testGetVoteById() {
		Vote vote = new Vote();
		vote.setId(1);
		vote.setUser(user);
		vote.setVoteOption(voteOption);
		pollManager.castVote(vote);

		Vote retrievedVote = pollManager.getVoteById(1);
		assertNotNull(retrievedVote);
		assertEquals(1, retrievedVote.getId());
	}

	@Test
	public void testDeletePoll() {
		Poll newPoll = new Poll();
		newPoll.setId(2);
		pollManager.createPoll(newPoll);

		pollManager.deletePoll(2);
		assertThrows(NoSuchElementException.class, () -> pollManager.getPollById(2));
	}

	@Test
	public void testVoteOptionNotFound() {
		assertThrows(NoSuchElementException.class, () -> pollManager.getVoteOptionById(999));
	}
}
