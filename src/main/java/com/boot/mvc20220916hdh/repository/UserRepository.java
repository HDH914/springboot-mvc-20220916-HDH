package com.boot.mvc20220916hdh.repository;

import com.boot.mvc20220916hdh.domain.User;

public interface UserRepository {
    public int save(User user);
    public User findUserByUserId(String userId);
    public User findUserByUserCode(int userCode);
    public int modify(User user);
    public int remove(int userCode);
}
