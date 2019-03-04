package com.trevorstinson.booklog.models.service;

import com.trevorstinson.booklog.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
