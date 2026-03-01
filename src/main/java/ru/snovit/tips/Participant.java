package ru.snovit.tips;

public record Participant(
        ParticipantEnum participant,
        String participantId,
        long amount
) {}
