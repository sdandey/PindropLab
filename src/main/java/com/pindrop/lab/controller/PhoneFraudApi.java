package com.pindrop.lab.controller;

import com.pindrop.lab.dao.CSVPhoneFraudRepository;
import com.pindrop.lab.model.ForumTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by santoshdandey on 2/4/17.
 */
@RestController
public class PhoneFraudApi {


    @Autowired
    CSVPhoneFraudRepository phoneFraudRepository;


    @RequestMapping("topics/{topicName}")
    public ForumTopic getForumTopicsByForumTopicName(@PathVariable("topicName") String topicName) {
        return phoneFraudRepository.getForumTopicByName(topicName);
    }

    @RequestMapping("topics")
    public List<ForumTopic> getAllTopics() {
        return phoneFraudRepository.getAllTopics();
    }
}
