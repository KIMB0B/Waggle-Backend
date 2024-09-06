package com.waggle.waggle.auth;

import com.waggle.waggle.auth.dto.KakaoTokenResponseDto;
import com.waggle.waggle.auth.service.KakaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/oauth2")
public class OAuth2Controller {

    @Autowired
    private KakaoService kakaoService;

    @GetMapping("/kakao/code")
    public ResponseEntity<?> loginKakao(@RequestParam("code") String code) {
        KakaoTokenResponseDto response = kakaoService.getAccessToken(code);
        String userInfo = kakaoService.getUserInfo(response.accessToken);
        log.info("사용자 정보: {}", userInfo);
        return ResponseEntity.ok(response);
    }
}
