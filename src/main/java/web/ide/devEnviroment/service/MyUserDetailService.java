package web.ide.devEnviroment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.ide.devEnviroment.model.MyUserDetails;
import web.ide.devEnviroment.model.db.User;
import web.ide.devEnviroment.repository.UserRepo;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findUserByUsername(s);

        user.orElseThrow(()-> new UsernameNotFoundException(("Not found:" + s)));

        return user.map(MyUserDetails::new).get();
    }


}
