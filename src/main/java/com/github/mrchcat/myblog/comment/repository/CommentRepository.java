package com.github.mrchcat.myblog.comment.repository;

import com.github.mrchcat.myblog.comment.domain.Comment;
import com.github.mrchcat.myblog.comment.dto.NewCommentDto;

import java.util.List;

public interface CommentRepository {
    List<Comment> getCommentsByPost(long postId);

    void deleteComment(long commentId);

    void addComment(NewCommentDto newCommentDto);

    void incrementCommentCounter(long postId);

    void decrementCommentCounter(long postId);
}
