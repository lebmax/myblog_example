package com.github.mrchcat.myblog.post.repository;

import com.github.mrchcat.myblog.post.domain.Post;
import com.github.mrchcat.myblog.tag.domain.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

@Component
public class PostResultSetExtractor implements ResultSetExtractor<Collection<Post>> {

    @Override
    public Collection<Post> extractData(ResultSet rs) throws SQLException, DataAccessException {
        HashMap<Long, Post> map = new HashMap<>();
        while (rs.next()) {
            long postId = rs.getLong("id");
            if (!map.containsKey(postId)) {
                HashSet<Tag> tags = new HashSet<>();
                tags.add(getTagFromRow(rs));
                Post post = Post.builder()
                        .id(postId)
                        .name(rs.getString("name"))
                        .text(rs.getString("text"))
                        .base64Jpeg(rs.getString("picture"))
                        .likes(rs.getLong("likes"))
                        .commentCounter(rs.getLong("comment_counter"))
                        .tags(tags)
                        .build();
                map.put(postId, post);
            } else {
                map.get(postId).getTags().add(getTagFromRow(rs));
            }
        }
        return map.values();
    }

    private Tag getTagFromRow(ResultSet rs) throws SQLException {
        return Tag.builder()
                .id(rs.getLong("tag_id"))
                .name(rs.getString("tag_name"))
                .build();
    }

}
