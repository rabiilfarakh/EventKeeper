package dao.inter;

import entity.Participant;
import java.util.List;

public interface ParticipantDAO {

    boolean deleteParticipant(Long participantId);
    List<Participant> getAllParticipants();
    void updateParticipant(Long participantId, Participant participant);
    Participant getParticipantById(Long participantId);

}
