package org.example.votesystembackend.controller;

import org.example.votesystembackend.model.VoteItem;
import org.example.votesystembackend.model.VoteRequest;
import org.example.votesystembackend.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin(origins = "*")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/items")
    public List<VoteItem> getItems() {
        return voteService.getAllItems();
    }

    @PostMapping("/vote")
    public void vote(@RequestBody VoteRequest request) {
        voteService.vote(request);
    }

    @PostMapping("/items")
    public void addItem(@RequestParam String name) {
        voteService.addItem(name);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable int id) {
        voteService.deleteItem(id);
    }
}
