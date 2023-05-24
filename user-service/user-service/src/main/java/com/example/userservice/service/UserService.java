package com.example.userservice.service;

import com.example.userservice.VO.Department;
import com.example.userservice.VO.ResponseTemplateVO;
import com.example.userservice.entity.Users;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService
{

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RestTemplate restTemplate;
    public Users saveUser(Users user) {
        log.info("inside user service to post");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Get user data with department info");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Users user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDeptId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
