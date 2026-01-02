package com.smhrd.carepose.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.carepose.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {

	// 회원가입
	public MemberEntity findByUsernameAndPassword(String username, String password);

	// 로그인
	Optional<MemberEntity> findByUsername(String username);
}
