package com.github.mrchcat.myblog.comment.repository;

import com.github.mrchcat.myblog.comment.domain.Comment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Comment.builder()
                .id(rs.getLong("id"))
                .text(rs.getString("text"))
                .build();
    }
}
