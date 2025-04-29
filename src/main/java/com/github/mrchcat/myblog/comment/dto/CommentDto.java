package com.github.mrchcat.myblog.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentDto {
    private long id;
    private String text;
}
