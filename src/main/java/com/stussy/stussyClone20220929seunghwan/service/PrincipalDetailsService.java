package com.stussy.stussyClone20220929seunghwan.service;

import com.stussy.stussyClone20220929seunghwan.domain.User;
import com.stussy.stussyClone20220929seunghwan.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = accountRepository.findUserByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("존재하지 않는 아이디 입니다.");
        }

        log.info("email >> {}", email);


        return null;
    }
}
