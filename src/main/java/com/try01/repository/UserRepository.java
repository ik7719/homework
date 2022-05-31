package com.try01.repository;

import com.try01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    List<User> findAllByOrderByModifiedAtDesc();
    // 다 찾아줘 / 정렬해줘 / 수정된 날짜 기준으로 / 최신순으로
}