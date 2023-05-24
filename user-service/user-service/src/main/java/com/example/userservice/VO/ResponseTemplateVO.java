package com.example.userservice.VO;


import com.example.userservice.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {


    private Users user;
    private Department department;


}
