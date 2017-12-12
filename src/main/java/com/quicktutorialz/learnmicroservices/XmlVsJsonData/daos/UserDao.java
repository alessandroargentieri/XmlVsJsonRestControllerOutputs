package com.quicktutorialz.learnmicroservices.XmlVsJsonData.daos;

import com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{
}
