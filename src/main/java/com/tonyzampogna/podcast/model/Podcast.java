package com.tonyzampogna.podcast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Podcast {

    private String id;

    private String title;

    private String description;

    private String type;

    private Boolean claimed;

    @JsonProperty("explicit_content")
    private Boolean explicit;

    private String publisher;

    private String imageUrl;

    private String thumbnailUrl;

    @JsonProperty("listennotes_url")
    private String listenNotesUrl;

    @JsonProperty("total_episodes")
    private Integer totalEpisodes;

    private String website;

    private String email;

    private String rss;

    private String language;

    private String country;

    @JsonProperty("genre_ids")
    private List<Integer> genres;

}
