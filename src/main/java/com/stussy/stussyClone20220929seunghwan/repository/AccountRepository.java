package com.stussy.stussyClone20220929seunghwan.repository;

import com.stussy.stussyClone20220929seunghwan.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public int save(User user);
    public User findUserByEmail(String Email);
}
