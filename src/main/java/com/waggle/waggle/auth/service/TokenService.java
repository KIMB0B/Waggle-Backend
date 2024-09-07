package com.waggle.waggle.auth.service;

import com.waggle.waggle.auth.dto.TokenResponse;

public interface TokenService {
    TokenResponse reissueAccessToken(String authorizationHeader);
}
