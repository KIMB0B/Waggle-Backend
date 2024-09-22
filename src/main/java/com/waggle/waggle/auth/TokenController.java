package com.waggle.waggle.auth;

import com.waggle.waggle.auth.dto.*;
import com.waggle.waggle.auth.service.TokenService;
import com.waggle.waggle.global.ApiResponse;
import com.waggle.waggle.global.constant.ErrorStatus;
import com.waggle.waggle.global.constant.SuccessStatus;
import com.waggle.waggle.user.entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService authService;

    @GetMapping("/reissue/access-token")
    public ResponseEntity<ApiResponse<Object>> reissueAccessToken(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        String refreshToken = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refresh_token")) {
                refreshToken = cookie.getValue();
                break;
            }
        }

        if (refreshToken == null) {
            return ApiResponse.onFailure(ErrorStatus._UNAUTHORIZED);
        }

        TokenResponse accessToken = authService.reissueAccessToken(refreshToken);
        return ApiResponse.onSuccess(SuccessStatus._CREATED_ACCESS_TOKEN, accessToken);
    }

    @GetMapping("/current-user")
    public User fetchCurrentUser() {
        return authService.getCurrentUser();
    }
}
