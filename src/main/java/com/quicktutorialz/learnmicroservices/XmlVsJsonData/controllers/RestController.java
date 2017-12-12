package com.quicktutorialz.learnmicroservices.XmlVsJsonData.controllers;

import com.quicktutorialz.learnmicroservices.XmlVsJsonData.daos.TaskDao;
import com.quicktutorialz.learnmicroservices.XmlVsJsonData.daos.UserDao;
import com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities.ResponseWrapper;
import com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities.Task;
import com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired TaskDao taskDao;
    @Autowired UserDao userDao;


    @RequestMapping(value="/tasks")//, produces={"application/json", "application/xml"})
    public List<Task> getAllTasksDefault(){
        return taskDao.findAll();
    }


    @RequestMapping(value="tasks.xml", produces= "application/xml")
    public ResponseWrapper getAllTasksInXml(){
        return new ResponseWrapper(taskDao.findAll());
    }




    @RequestMapping(value="/tasks/{id}", produces="application/json")
    public Task getATask(@PathVariable(name = "id") Integer idTask){
        return taskDao.getOne(idTask);
    }

    @RequestMapping(value="/tasks/{id}.xml", produces="application/xml")
    public Task getATaskInXml(@PathVariable(name = "id") Integer idTask){
        return taskDao.getOne(idTask);
    }

    //doppione in xml e con query string
    @RequestMapping(value="/task", produces="application/xml")  // ../task?id=5
    public Task getOneTask(@RequestParam(value = "id") Integer idTask){
        return taskDao.getOne(idTask);
    }


    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @RequestMapping(value="/users.xml",produces = "application/xml")
    public ResponseWrapper getAllUsersInXml(){
        return new ResponseWrapper(userDao.findAll());
    }

    @RequestMapping(value="/users/{id}", produces="application/json")
    public User getAUser(@PathVariable(value = "id") Integer userId){
        return userDao.getOne(userId);
    }

    @RequestMapping(value="/users/{id}.xml", produces="application/xml")
    public User getAUserInXml(@PathVariable(value = "id") Integer userId){
        return userDao.getOne(userId);
    }

    //doppione in xml e con query string
    @RequestMapping(value="/user", produces="application/xml")  // ../user?id=5
    public User getOneUser(@RequestParam(value = "id") Integer userId){
        return userDao.getOne(userId);
    }


}
