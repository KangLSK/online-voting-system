package org.example.votesystembackend.service;

import org.example.votesystembackend.model.VoteItem;
import org.example.votesystembackend.model.VoteRequest;
import org.example.votesystembackend.repository.VoteJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteJdbcRepository voteRepository;

    public List<VoteItem> getAllItems() {
        return voteRepository.getAllVoteItems();
    }

    @Transactional
    public void vote(VoteRequest request) {
        for (Integer itemId : request.getItemIds()) {
            voteRepository.insertVote(request.getVoter(), itemId);
        }
    }

    public void addItem(String name) {
        voteRepository.insertVoteItem(name);
    }

    public void deleteItem(int itemId) {
        voteRepository.deleteVoteItem(itemId);
    }
}