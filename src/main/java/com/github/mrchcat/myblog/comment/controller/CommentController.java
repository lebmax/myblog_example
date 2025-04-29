package com.github.mrchcat.myblog.comment.controller;

import com.github.mrchcat.myblog.comment.dto.NewCommentDto;
import com.github.mrchcat.myblog.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping(value = "/post/{postId}/comment/{commentId}", params = "_method=delete")
    public String deleteComment(@PathVariable(value = "postId") long postId,
                                @PathVariable(value = "commentId") long commentId) {
        commentService.deleteComment(commentId,postId);
        return "redirect:/post/" + postId;
    }

    @PostMapping(value = "/post/{postId}/comment", params = "_method=add")
    public String addComment(@PathVariable(value = "postId") long postId,
                             @RequestParam("text") String text) {
        commentService.addComment(new NewCommentDto(text, postId), postId);
        return "redirect:/post/" + postId;
    }

}
