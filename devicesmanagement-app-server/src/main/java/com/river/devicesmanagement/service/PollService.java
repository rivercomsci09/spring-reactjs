package com.river.devicesmanagement.service;

import com.river.devicesmanagement.model.Account;
import com.river.devicesmanagement.model.Poll;
import com.river.devicesmanagement.payload.PagedResponse;
import com.river.devicesmanagement.payload.PollRequest;
import com.river.devicesmanagement.payload.PollResponse;
import com.river.devicesmanagement.payload.VoteRequest;
import com.river.devicesmanagement.security.UserPrincipal;

import java.util.List;
import java.util.Map;

public interface PollService {
    public PagedResponse<PollResponse> getAllPolls(UserPrincipal currentUser, int page, int size);
    public PagedResponse<PollResponse> getPollsCreatedBy(String username, UserPrincipal currentUser, int page, int size);
    public PagedResponse<PollResponse> getPollsVotedBy(String username, UserPrincipal currentUser, int page, int size);
    public Poll createPoll(PollRequest pollRequest);
    public PollResponse getPollById(Integer pollId, UserPrincipal currentUser);
    public PollResponse castVoteAndGetUpdatedPoll(Integer pollId, VoteRequest voteRequest, UserPrincipal currentUser);
    void validatePageNumberAndSize(int page, int size);
    Map<Integer, Integer> getChoiceVoteCountMap(List<Integer> pollIds);
    Map<Integer, Integer> getPollUserVoteMap(UserPrincipal currentUser, List<Integer> pollIds);
    Map<Integer, Account> getPollCreatorMap(List<Poll> polls);
}
