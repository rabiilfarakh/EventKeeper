package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evenement {
    private Long id;
    private String title;
    private String type;
    private Date date;
    private List<Participant> participants;

    // Constructor, getters and setters

    public Evenement(Long id, String title, String type, Date date) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.date = date;
        this.participants = new ArrayList<>();
    }

    public Evenement() {
        this.participants = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }
}
