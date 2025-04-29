package com.github.mrchcat.myblog.tag.repository;

import java.util.Set;

public interface TagRepository {

    void saveTagsForPost(Set<String> tagNames, long postId);

    void deleteSingleTagsOfPost(long postId);

    void unlinkTagsFromPost(long postId);

}
