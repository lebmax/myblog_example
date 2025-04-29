package com.github.mrchcat.myblog.tag.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = {"id"})
public class Tag {
    private long id;
    private String name;
}
