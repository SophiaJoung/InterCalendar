package com.ssu.intercalendar.security.service;
import com.ssu.intercalendar.security.domain.SessionUser;
import com.ssu.intercalendar.user.domain.User;
import com.ssu.intercalendar.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override // username으로 우리 디비에서, 객체 뽑아서 리턴
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new SessionUser(user);
    }
}

