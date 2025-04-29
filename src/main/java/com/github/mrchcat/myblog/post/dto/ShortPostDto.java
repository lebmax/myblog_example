package com.github.mrchcat.myblog.post.dto;

import com.github.mrchcat.myblog.tag.dto.TagDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ShortPostDto {
    private long id;
    private String name;
    private String text;
    private String base64Jpeg;
    private long likes;
    private long commentCounter;
    private List<TagDto> tagsDto;
}
