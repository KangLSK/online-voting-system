package org.example.votesystembackend.repository;



import org.example.votesystembackend.model.VoteItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoteJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<VoteItem> getAllVoteItems() {
        return jdbcTemplate.query("CALL get_all_vote_items()",
                new BeanPropertyRowMapper<>(VoteItem.class));
    }

    public void insertVote(String voter, int itemId) {
        jdbcTemplate.update("CALL insert_vote(?, ?)", voter, itemId);
    }

    public void insertVoteItem(String name) {
        jdbcTemplate.update("CALL insert_vote_item(?)", name);
    }

    public void deleteVoteItem(int itemId) {
        jdbcTemplate.update("CALL delete_vote_item(?)", itemId);
    }
}