package org.example.plus.domain.post.repository;

import static org.example.plus.common.entity.QComment.comment;
import static org.example.plus.common.entity.QPost.post;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.plus.domain.post.model.dto.PostSummaryDto;

@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<PostSummaryDto> findPostSummary(String username) {
        return queryFactory
            .select(Projections.constructor(
                PostSummaryDto.class,
                post.content,
                comment.countDistinct().intValue()
            ))
            .from(post)
            .leftJoin(post.comments, comment)
            .where(post.user.username.eq(username))
            .groupBy(post.id)
            .fetch();
    }
}
