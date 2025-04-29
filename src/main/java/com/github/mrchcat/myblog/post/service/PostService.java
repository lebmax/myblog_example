package com.github.mrchcat.myblog.post.service;

import com.github.mrchcat.myblog.post.dto.NewPostDto;
import com.github.mrchcat.myblog.post.dto.PostDto;
import com.github.mrchcat.myblog.post.dto.ShortPostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto getPostDto(long postId);

    Page<ShortPostDto> getFeed(Pageable pageable);

    Page<ShortPostDto> getFeedByTag(long tagId, Pageable pageable);

    PostDto editPost(long postId, NewPostDto newPostDto);

    void addLike(long postId);

    void deletePost(long postId);

    void addNewPost(NewPostDto newPostDto);
}
