package com.pindrop.lab.model;



/**
 * Created by santoshdandey on 2/4/17.
 */
public class ForumTopic {

    private String topicName;
    private String topicLink;
    private String totalComments;
    private String latestCommentDate;
    private String category;


    public ForumTopic(String csvLine) {

        String[] tokens = csvLine.split(",");

        if(tokens.length == 5) {

            topicName = tokens[0].trim();
            topicLink = tokens[1].trim();
            totalComments = tokens[2].trim();
            latestCommentDate = tokens[3].trim();
            category = tokens[4].trim();
        }
    }
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicLink() {
        return topicLink;
    }

    public void setTopicLink(String topicLink) {
        this.topicLink = topicLink;
    }

    public String getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(String totalComments) {
        this.totalComments = totalComments;
    }

    public String getLatestCommentDate() {
        return latestCommentDate;
    }

    public void setLatestCommentDate(String latestCommentDate) {
        this.latestCommentDate = latestCommentDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ForumTopic{" +
                "topicName='" + topicName + '\'' +
                ", topicLink='" + topicLink + '\'' +
                ", totalComments=" + totalComments +
                ", latestCommentDate='" + latestCommentDate + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
