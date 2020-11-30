package com.tonyzampogna.podcast.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
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

    public List<Podcast> getBestPodcasts(List<Integer> genres) {
        List<Podcast> podcasts = getPodcasts();

        List<Podcast> filtered = new ArrayList<>();
        for (Podcast podcast : podcasts) {
            if (genres == null) {
                filtered.add(podcast);
            }
            else {
                for (Integer genre : genres) {
                    if (podcast.getGenres() != null && podcast.getGenres().contains(genre)) {
                        filtered.add(podcast);
                    }
                }
            }
        }

        return filtered;
    }

    private List<Podcast> loadResponse() {
        List<Podcast> podcasts = new ArrayList<>();

        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            // convert JSON file to map
            Map<?, ?> map = mapper.readValue(Paths.get("responses/sample-api-response.json").toFile(), Map.class);

            // print map entries
            podcasts = mapper.convertValue(map.get("podcasts"), new TypeReference<List<Podcast>>() {});

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return podcasts;
    }


}
