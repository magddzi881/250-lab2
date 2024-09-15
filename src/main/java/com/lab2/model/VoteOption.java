package com.lab2.model;

public class VoteOption {
    private Integer id;
    private Integer pollId;
    private String caption;
    private int presentationOrder;

    public VoteOption() {}

    public VoteOption(Integer id, Integer pollId, String caption, int presentationOrder) {
        this.id = id;
        this.pollId = pollId;
        this.caption = caption;
        this.presentationOrder = presentationOrder;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getPollId() {
        return pollId;
    }

    public void setPollId(Integer pollId) {
        this.pollId = pollId;
    }

    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }

    public int getPresentationOrder() { return presentationOrder; }
    public void setPresentationOrder(int presentationOrder) { this.presentationOrder = presentationOrder; }
}
