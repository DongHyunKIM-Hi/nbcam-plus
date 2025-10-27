package org.example.plus.domain.post.repository;

import static org.example.plus.common.entity.QComment.comment;
import static org.example.plus.common.entity.QPost.post;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.example.plus.domain.post.model.dto.PostSummaryDto;

public class PostQuerydslRepositoryImpl implements PostQuerydslRepository {

    private final JPAQueryFactory queryFactory;

    public PostQuerydslRepositoryImpl(EntityManager em) { queryFactory = new JPAQueryFactory(em); }



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
