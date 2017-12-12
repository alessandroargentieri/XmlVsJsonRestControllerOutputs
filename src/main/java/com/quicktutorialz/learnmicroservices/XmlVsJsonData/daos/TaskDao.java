package com.quicktutorialz.learnmicroservices.XmlVsJsonData.daos;

import com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Integer> {
}
