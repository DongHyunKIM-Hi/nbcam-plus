package org.example.plus.domain.user.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.plus.common.enums.UserRoleEnum;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchResponse {

    private String username;
    private String email;
    private UserRoleEnum role;
}
