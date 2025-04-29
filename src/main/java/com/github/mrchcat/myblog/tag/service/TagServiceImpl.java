package com.github.mrchcat.myblog.tag.service;

import com.github.mrchcat.myblog.tag.mapper.TagMapper;
import com.github.mrchcat.myblog.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public void saveTags(String tagsAsLine, long postId) {
        Set<String> tagNames = TagMapper.toTagList(tagsAsLine);
        tagRepository.saveTagsForPost(tagNames, postId);
    }

    @Override
    public void deleteSingleTagsOfPost(long posId) {
        tagRepository.deleteSingleTagsOfPost(posId);
    }

    @Override
    public void unlinkTagsFromPost(long postId) {
        tagRepository.unlinkTagsFromPost(postId);
    }
}
