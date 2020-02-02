package com.deigon.lanpartypicker;

import com.deigon.lanpartypicker.domain.LanPartyUser;
import com.deigon.lanpartypicker.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LanPartyUser byUsername = userRepository.getByUsername(s);
        if (byUsername == null){
            throw new UsernameNotFoundException("User not found in system");
        }
        return byUsername;
    }
}
