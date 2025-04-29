package com.github.mrchcat.myblog.post.repository;

import com.github.mrchcat.myblog.post.domain.Post;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface PostRepository {
    Optional<Post> getPost(long postId);

    Collection<Post> getFeed(Pageable pageable);

    Collection<Post> getFeedByTag(long tagId, Pageable pageable);

    long getTotal();

    long getTotalByTag(long tagId);

    long addNewPost(Post post);

    long updatePost(Post post);

    void deletePost(long postId);

    void addLike(long postId);
}
