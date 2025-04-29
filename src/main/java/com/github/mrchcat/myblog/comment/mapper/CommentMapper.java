package com.github.mrchcat.myblog.comment.mapper;


import com.github.mrchcat.myblog.comment.domain.Comment;
import com.github.mrchcat.myblog.comment.dto.CommentDto;

import java.util.List;

public class CommentMapper {

    public static List<CommentDto> toDto(List<Comment> comments) {
        return comments.stream()
                .map(cm -> new CommentDto(cm.getId(), cm.getText()))
                .toList();
    }
}
