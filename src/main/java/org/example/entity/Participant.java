package org.example.entity;

public class Participant extends User{

    private Integer ParticipantId;

    public Participant() {
    }

    public Participant(Integer userId, String username, String password, Integer participantId) {

        super(userId, username, password);
        ParticipantId = participantId;
    }

    @Override
    public Integer getId() {
        return ParticipantId;
    }

    @Override
    public void setId(Integer ParticipantId) {
        this.ParticipantId = ParticipantId;
    }

}
