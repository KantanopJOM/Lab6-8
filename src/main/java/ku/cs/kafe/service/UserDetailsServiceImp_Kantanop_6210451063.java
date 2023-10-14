package ku.cs.kafe.service;


import ku.cs.kafe.entity.Member_Kantanop_6210451063;
import ku.cs.kafe.repository.MemberRepository_Kantanop_6210451063;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetailsServiceImp_Kantanop_6210451063 implements UserDetailsService {


    @Autowired
    private MemberRepository_Kantanop_6210451063 userRepository;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {


        Member_Kantanop_6210451063 user = userRepository.findByUsername(username);


        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }


        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }
}
