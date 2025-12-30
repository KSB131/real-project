package com.carepose.service;

import com.carepose.domain.Member;
import com.carepose.dto.RegisterRequest;
import com.carepose.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long register(RegisterRequest req) {
        // 로그인 보류니까 일단 pw는 "그대로 저장" (나중에 Security 붙일 때 BCrypt로 변경)
        Member saved = memberRepository.save(
                Member.builder()
                        .pw(req.getPw())
                        .roomAuthority(req.getRoomAuthority())
                        .build()
        );
        return saved.getId();
    }

    private class MemberRepository {
    }
}
