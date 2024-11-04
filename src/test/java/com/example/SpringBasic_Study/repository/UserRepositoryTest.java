package com.example.SpringBasic_Study.repository;


import com.example.SpringBasic_Study.SpringBasicStudyApplicationTests;
import com.example.SpringBasic_Study.model.entity.Item;
import com.example.SpringBasic_Study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


public class UserRepositoryTest extends SpringBasicStudyApplicationTests {

    // Dependency Injection Spring에서 관리 하는 객체
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){       // 객체 타입으로 선언하고 JPA Repository를 상속 받음으로 객체를 setter / getter의 설정만으로 CRUD 설정 가능하다.
        User user = new User();

        user.setAccount("TestUser04");
        user.setEmail("TestUser04@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser =  userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    @Test
    @Transactional
    public void read(){

        //select * from user where id = ?
        Optional<User> user = userRepository.findByAccount("TestUser01");

        user.ifPresent(selectUser ->{
            selectUser.getOrderDetailList().stream().forEach(detail -> {
                Item item = detail.getItem();
                System.out.println(item);
            });
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(4L);

        Assertions.assertTrue(user.isPresent());    //false
        
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(4L);

        Assertions.assertFalse(deleteUser.isPresent()); //true

//        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재 : "+ deleteUser.get());
//        }else{
//            System.out.println("데이터 삭제 데이터 없음");
//        }

    }

}
