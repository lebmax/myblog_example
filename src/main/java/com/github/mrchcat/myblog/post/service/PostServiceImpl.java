package com.github.mrchcat.myblog.post.service;

import com.github.mrchcat.myblog.comment.dto.CommentDto;
import com.github.mrchcat.myblog.comment.service.CommentService;
import com.github.mrchcat.myblog.post.domain.Post;
import com.github.mrchcat.myblog.post.dto.NewPostDto;
import com.github.mrchcat.myblog.post.dto.PostDto;
import com.github.mrchcat.myblog.post.dto.ShortPostDto;
import com.github.mrchcat.myblog.post.mapper.PostMapper;
import com.github.mrchcat.myblog.post.repository.PostRepository;
import com.github.mrchcat.myblog.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentService commentService;
    private final TagService tagService;

    @Override
    public PostDto getPostDto(long postId) {
        Post post = postRepository.getPost(postId).orElseThrow(() -> new NoSuchElementException("Post not found"));
        List<CommentDto> commentDtos = commentService.getCommentsByPost(post.getId());
        return PostMapper.toDto(post, commentDtos);
    }

    @Override
    public void addLike(long postId) {
        postRepository.addLike(postId);
    }

    @Override
    public void deletePost(long postId) {
        tagService.unlinkTagsFromPost(postId);
        tagService.deleteSingleTagsOfPost(postId);
        postRepository.deletePost(postId);
    }

    @Override
    public PostDto editPost(long postId, NewPostDto newPostDto) {
        Post post = PostMapper.toPost(newPostDto);
        post.setId(postId);

        tagService.unlinkTagsFromPost(postId);
        tagService.deleteSingleTagsOfPost(postId);
        tagService.saveTags(newPostDto.getTags(), postId);

        long updatedPostId = postRepository.updatePost(post);
        Post updatedPost = postRepository.getPost(updatedPostId)
                .orElseThrow(() -> new NoSuchElementException("Post not found"));
        List<CommentDto> commentDtos = commentService.getCommentsByPost(updatedPostId);
        return PostMapper.toDto(updatedPost, commentDtos);
    }

    @Override
    public void addNewPost(NewPostDto newPostDto) {
        Post post = PostMapper.toPost(newPostDto);
        long savedPostId = postRepository.addNewPost(post);
        tagService.saveTags(newPostDto.getTags(), savedPostId);
    }

    @Override
    public Page<ShortPostDto> getFeed(Pageable pageable) {
        Collection<Post> postList = postRepository.getFeed(pageable);
        List<ShortPostDto> listDto = PostMapper.toShortDto(postList);
        long totalPosts = postRepository.getTotal();
        return new PageImpl<>(listDto, pageable, totalPosts);
    }

    @Override
    public Page<ShortPostDto> getFeedByTag(long tagId, Pageable pageable) {
        Collection<Post> postList = postRepository.getFeedByTag(tagId, pageable);
        List<ShortPostDto> listDto = PostMapper.toShortDto(postList);
        long totalPosts = postRepository.getTotalByTag(tagId);
        return new PageImpl<>(listDto, pageable, totalPosts);
    }
}
