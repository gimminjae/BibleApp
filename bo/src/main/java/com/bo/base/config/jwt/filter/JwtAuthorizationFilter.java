package com.bo.base.config.jwt.filter;



import com.bo.base.config.jwt.provider.JwtProvider;
import com.bo.member.entity.Member;
import com.bo.member.entity.MemberContext;
import com.bo.member.service.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final MemberService memberService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader("Authorization");
        Cookie[] cookies = request.getCookies();
        //jwt를 헤더에 보내면 보안 강화
        //jwt를 쿠키에 담아서 보내면 보안은 비교적 약화되지만, 유연성 확보 가능


        if (bearerToken != null) {
            String token = bearerToken;

            // 1차 체크(정보가 변조되지 않았는지 체크)
            if (jwtProvider.verify(token)) {
                Map<String, Object> claims = jwtProvider.getClaims(token);
                String userId = (String) claims.get("username");
                Member member = memberService.getByUsername(userId).toEntity();
                forceAuthentication(member);
            }
        }
        filterChain.doFilter(request, response); //다음 필터를 실행시켜 주어야 한다
    }

    private void forceAuthentication(Member member) {
        MemberContext memberContext = new MemberContext(member);

        UsernamePasswordAuthenticationToken authentication =
                UsernamePasswordAuthenticationToken.authenticated(
                        memberContext,
                        null,
                        member.getAuthorities()
                );

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
    }
}
