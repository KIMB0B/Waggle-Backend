package com.waggle.waggle.auth.service;

import com.waggle.waggle.auth.dto.TokenResponse;
import com.waggle.waggle.user.entity.User;

public interface TokenService {
    TokenResponse reissueAccessToken(String refreshToken);
    User getCurrentUser();
}
