package lk.sliit.mtit.micro.user.service;

import lk.sliit.mtit.micro.user.entity.User;
import lk.sliit.mtit.micro.user.repository.UserRepository;
import lk.sliit.mtit.micro.user.valueObjects.Department;
import lk.sliit.mtit.micro.user.valueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findByUserId(id);
    }

    public ResponseTemplateVO gerUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://localhost:8092/departments/" +
                user.getDepartmentId(), Department.class);

        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
