package org.example.plus.domain.user.repository;

import java.util.List;
import org.example.plus.domain.user.model.request.UserSearchRequest;
import org.example.plus.domain.user.model.response.UserSearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserCustomRepository {

    List<UserSearchResponse> searchUserByMultiCondition(UserSearchRequest request);

    List<UserSearchResponse> searchUserByMultiConditionV2(UserSearchRequest request);

    Page<UserSearchResponse> searchUserByMultiConditionPage(UserSearchRequest request, Pageable pageable);
}
