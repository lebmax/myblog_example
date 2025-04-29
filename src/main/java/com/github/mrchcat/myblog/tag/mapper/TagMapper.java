package com.github.mrchcat.myblog.tag.mapper;

import com.github.mrchcat.myblog.tag.domain.Tag;
import com.github.mrchcat.myblog.tag.dto.TagDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TagMapper {
    public static List<TagDto> toDto(Set<Tag> tags) {
        return tags.stream()
                .map(t -> new TagDto(t.getId(), t.getName()))
                .toList();
    }

    public static Set<String> toTagList(String tags) {
        if (tags.isEmpty()) {
            return Collections.emptySet();
        }
        return Arrays.stream(tags.split("\\s*;\\s*"))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toSet());
    }

}
