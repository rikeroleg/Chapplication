package com.chapplication.example.servicerepo;

import com.chapplication.example.objects.UserObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService extends JpaRepository<UserObject, Long>{
    List<UserObject> findAllUsers();
}
