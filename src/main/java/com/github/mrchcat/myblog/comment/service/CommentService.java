package com.github.mrchcat.myblog.comment.service;

import com.github.mrchcat.myblog.comment.dto.CommentDto;
import com.github.mrchcat.myblog.comment.dto.NewCommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getCommentsByPost(long postId);

    void deleteComment(long commentId, long postId);

    void addComment(NewCommentDto newCommentDto, long postId);

}
