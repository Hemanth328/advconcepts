package com.org.multipledbconnections.repository.user;

import com.org.multipledbconnections.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
