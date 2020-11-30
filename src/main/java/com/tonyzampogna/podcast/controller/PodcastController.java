package com.tonyzampogna.podcast.controller;

import com.tonyzampogna.podcast.model.Podcast;
import com.tonyzampogna.podcast.service.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PodcastController {

    @Autowired
    private PodcastService podcastService;

    @GetMapping("best_podcasts")
    public List<Podcast> getBestPodcasts(@RequestParam(name="genres", required=false) List<Integer> genres) {
        return podcastService.getBestPodcasts(genres);
    }
}
