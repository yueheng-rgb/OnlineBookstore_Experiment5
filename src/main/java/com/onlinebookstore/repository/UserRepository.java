package com.onlinebookstore.repository;

import com.onlinebookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * 用户数据访问层。
 * <p>提供用户实体的基础 CRUD 及按用户名、邮箱查询的能力。</p>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名查找用户。
     * @param username 用户名
     * @return Optional 包装的用户
     */
    Optional<User> findByUsername(String username);

    /**
     * 根据邮箱查找用户。
     * @param email 电子邮箱
     * @return Optional 包装的用户
     */
    Optional<User> findByEmail(String email);

    /**
     * 判断用户名是否已存在。
     * @param username 用户名
     * @return 存在返回 true
     */
    boolean existsByUsername(String username);

    /**
     * 判断邮箱是否已存在。
     * @param email 电子邮箱
     * @return 存在返回 true
     */
    boolean existsByEmail(String email);
}
