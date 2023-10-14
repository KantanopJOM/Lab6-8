package ku.cs.kafe.service;


import ku.cs.kafe.entity.Member_Kantanop_6210451063;
import ku.cs.kafe.model.SignupRequest_Kantanop_6210451063;
import ku.cs.kafe.repository.MemberRepository_Kantanop_6210451063;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SignupService_Kantanop_6210451063 {


    @Autowired
    private MemberRepository_Kantanop_6210451063 repository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private ModelMapper modelMapper;


    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }


    public void createUser(SignupRequest_Kantanop_6210451063 user) {
        Member_Kantanop_6210451063 record = modelMapper.map(user, Member_Kantanop_6210451063.class);
        record.setRole("ROLE_USER");


        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);


        repository.save(record);
    }


    public Member_Kantanop_6210451063 getUser(String username) {
        return repository.findByUsername(username);
    }
}
