package com.github.mrchcat.myblog.post.domain;


import com.github.mrchcat.myblog.tag.domain.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString(exclude = {"base64Jpeg"})
public class Post {
    private long id;
    private String name;
    private String text;
    private String base64Jpeg;
    private long likes;
    private long commentCounter;
    private Set<Tag> tags;
}
