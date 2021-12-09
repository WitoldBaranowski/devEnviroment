package web.ide.devEnviroment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.ide.devEnviroment.model.MyUserDetails;
import web.ide.devEnviroment.model.Student;
import web.ide.devEnviroment.repository.StudentRepo;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Student> student = studentRepo.findStudentByUsername(s);

        student.orElseThrow(()-> new UsernameNotFoundException(("Not found:" + s)));

        return student.map(MyUserDetails::new).get();
    }
}
