package com.pindrop.lab.dao;

import com.pindrop.lab.model.ForumTopic;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by santoshdandey on 2/4/17.
 */
@Service
public class CSVPhoneFraudRepository {

    public static final String LIMITER = ",";
    private static final String DATA_FILE = "1800_notes.csv";

    public  HashMap<String, ForumTopic> readCsvFile() {



        String line = "";


        HashMap<String,ForumTopic> forumTopicHashMap = new HashMap<>();
        ForumTopic forumTopic = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/" + DATA_FILE)))) {
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



