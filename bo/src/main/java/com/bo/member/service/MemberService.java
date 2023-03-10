package com.bo.member.service;

import com.bo.base.config.jwt.provider.JwtProvider;
import com.bo.member.dto.JoinDto;
import com.bo.member.dto.MemberDto;
import com.bo.member.dto.ModifyPwDto;
import com.bo.member.entity.Member;
import com.bo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.Null;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public MemberDto create(JoinDto joinDto) {
        if(!joinDto.getPassword1().equals(joinDto.getPassword2())) {
            throw new InvalidParameterException("두 개의 비밀번호가 일치하지 않습니다");
        }
        Member member = Member.from(joinDto);
        try {
            member.setPassword(passwordEncoder.encode(joinDto.getPassword1()));
            memberRepository.save(member);
        } catch(DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("중복되는 회원이 존재합니다.");
        } catch (Exception e) {
        }
        return member.toDto();
    }
    public MemberDto login(String username, String password) {
        MemberDto member = getByUsername(username);

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new AccessDeniedException("비밀번호가 일치하지 않습니다.");
        }
        return member;
    }

    public MemberDto getByUsername(String username) {
        Optional<Member> optionalMember = memberRepository.findByUsername(username);
        if(optionalMember.isPresent()) {
            return optionalMember.get().toDto();
        } else {
            throw new NullPointerException("회원이 존재하지 않습니다.");
        }
    }

    public String genAccessToken(Member member) {
        return jwtProvider.generateAccessToken(member.getAccessTokenClaims(), 60 * 60 * 24 * 90);
    }

    public List<MemberDto> getByDeptIdx(Long deptIdx) {
        return memberRepository.findByDeptIdx(deptIdx).stream().map(Member::toDto).toList();
    }

    public List<MemberDto> getAll() {
        return memberRepository.findAll().stream().map(Member::toDto).toList();
    }

    public MemberDto getByMemberIdx(Long memberIdx) {
        return memberRepository.findById(memberIdx).orElse(null).toDto();
    }

    public void modifyMemInfo(Long memberIdx, MemberDto memberDto) {
        if(memberIdx != memberDto.getMemberIdx()) {
            throw new AccessDeniedException("변경할 권한이 없습니다.");
        }
        Member member = memberRepository.findById(memberIdx).orElse(null);
        if(member == null) {
            throw new NullPointerException("회원 정보가 존재하지 않습니다.");
        }
        member.modifyMemInfo(memberDto);

        memberRepository.save(member);
    }

    public void modifyMemPw(Long memberIdx, ModifyPwDto modifyPwDto) {
        Member member = memberRepository.findById(memberIdx).orElse(null);
        if(member == null) {
            throw new NullPointerException("회원 정보가 존재하지 않습니다.");
        }
        if(!passwordEncoder.matches(modifyPwDto.getOldPassword(), member.getPassword())) {
            throw new AccessDeniedException("기존 비밀번호가 틀렸습니다.");
        }
        if(!modifyPwDto.getPassword1().equals(modifyPwDto.getPassword2())) {
            throw new AccessDeniedException("비밀번호가 일치하지 않습니다.");
        }
        member.setPassword(passwordEncoder.encode(modifyPwDto.getPassword1()));

        memberRepository.save(member);
    }
}
