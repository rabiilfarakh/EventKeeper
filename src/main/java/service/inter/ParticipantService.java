package service.inter;

import entity.Participant;
import java.util.List;
import java.util.Optional;

public interface ParticipantService {

    boolean deleteParticipant(Long participantId);
    List<Participant> getAllParticipants();
    void updateParticipant(Long participantId, Participant participant);
}
