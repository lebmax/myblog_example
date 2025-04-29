package com.github.mrchcat.myblog.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewCommentDto {
    private String text;
    private long postId;

}
