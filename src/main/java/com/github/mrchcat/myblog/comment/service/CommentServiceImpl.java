package com.github.mrchcat.myblog.comment.service;

import com.github.mrchcat.myblog.comment.domain.Comment;
import com.github.mrchcat.myblog.comment.dto.CommentDto;
import com.github.mrchcat.myblog.comment.dto.NewCommentDto;
import com.github.mrchcat.myblog.comment.mapper.CommentMapper;
import com.github.mrchcat.myblog.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<CommentDto> getCommentsByPost(long postId) {
        List<Comment> comments = commentRepository.getCommentsByPost(postId);
        return CommentMapper.toDto(comments);
    }

    @Override
    public void deleteComment(long commentId, long postId) {
        commentRepository.deleteComment(commentId);
        commentRepository.decrementCommentCounter(postId);
    }

    @Override
    public void addComment(NewCommentDto newCommentDto, long postId) {
        commentRepository.addComment(newCommentDto);
        commentRepository.incrementCommentCounter(postId);
    }
}
