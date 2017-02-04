package com.pindrop.lab.dao;

import com.pindrop.lab.model.ForumTopic;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by santoshdandey on 2/4/17.
 */
@Service
public class CSVPhoneFraudRepository {

    public static final String LIMITER = ",";

    public  HashMap<String, ForumTopic> readCsvFile() {


        String csvFile = "/Users/santoshdandey/Documents/data/PhoneFraudApi/src/main/resources/1800_notes.csv";
        String line = "";


        HashMap<String,ForumTopic> forumTopicHashMap = new HashMap<>();
        ForumTopic forumTopic = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                forumTopic = new ForumTopic(line);
                forumTopicHashMap.put(forumTopic.getTopicName(), forumTopic);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return forumTopicHashMap;
        }

        return forumTopicHashMap;
    }


    public ForumTopic getForumTopicByName(String name) {
        return readCsvFile().get(name);
    }

    public List<ForumTopic> getAllTopics() {
        return new ArrayList<>(readCsvFile().values());
    }


}



