package com.welleplus.server;

import com.welleplus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserServer extends JpaRepository<User,String> {
    /**
     * 添加用户
     * @param user
     */
    User save(User user);

    /**
     * 根据用户名和密码查询用户信息
     * @param userName
     * @param password
     * @return
     */
    User findByUserNameAndPassword(String userName,String password);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 删除用户
     * @param id
     */
    void deleteById(String id);
}
