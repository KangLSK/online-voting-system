package org.example.votesystembackend.model;

import java.util.List;

public class VoteRequest {
    private String voter;
    private List<Integer> itemIds;

    public VoteRequest() {}

    public VoteRequest(String voter, List<Integer> itemIds) {
        this.voter = voter;
        this.itemIds = itemIds;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public List<Integer> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
