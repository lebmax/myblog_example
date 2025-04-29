package com.github.mrchcat.myblog.tag.service;

public interface TagService {

    void saveTags(String tagsAsLine, long posId);

    void deleteSingleTagsOfPost(long posId);

    void unlinkTagsFromPost(long postId);

}
