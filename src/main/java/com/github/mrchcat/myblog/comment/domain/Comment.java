package com.github.mrchcat.myblog.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Comment {
    private long id;
    private String text;
    private long posId;
}
