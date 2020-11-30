package com.tonyzampogna.podcast.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonyzampogna.podcast.model.Podcast;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PodcastService {

    public List<Podcast> podcasts;

    public List<Podcast> getPodcasts() {
        if (this.podcasts == null) {
            this.podcasts = loadResponse();
        }

        return this.podcasts;
    }

    private List<Podcast> loadResponse() {
        List<Podcast> podcasts = new ArrayList<>();

        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON file to map
            Map<?, ?> map = mapper.readValue(Paths.get("responses/sample-api-response.json").toFile(), Map.class);

            // print map entries
            podcasts = (List<Podcast>) map.get("podcasts");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return podcasts;
    }


}
