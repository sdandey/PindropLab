package com.pindrop.lab.service;

import com.pindrop.lab.dao.CSVPhoneFraudRepository;
import com.pindrop.lab.model.ForumTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by santoshdandey on 2/4/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CSVPhoneFraudRepositoryTest {

    Logger LOGGER = LoggerFactory.getLogger(CSVPhoneFraudRepositoryTest.class);

    @Autowired
    CSVPhoneFraudRepository phoneFraudRepository;
    @Test
    public void readCsvFile() throws Exception {
        HashMap<String, ForumTopic> forumTopics;
        forumTopics = phoneFraudRepository.readCsvFile();
        LOGGER.info(forumTopics.toString());
        assertNotNull(forumTopics);

    }

    @Test
    public void getForumTopicByName() throws Exception {

    }

}