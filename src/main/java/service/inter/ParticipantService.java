package service.inter;

import entity.Participant;
import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    Participant addParticipant(Participant participant);
    Participant updateParticipant(int participantId, Participant participant);
    void deleteParticipant(int participantId);
    Optional<Participant> getParticipantById(int participantId);
    List<Participant> getAllParticipants();
}
