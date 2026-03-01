package ru.snovit.tips;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public record DistributionResult(String orderId,
                                 Participant courier,
                                 Participant restaurant,
                                 Participant platform) {
    public long total() {
        AtomicLong total = new AtomicLong();
        Optional.ofNullable(courier).ifPresent(p -> total.addAndGet(p.amount()));
        Optional.ofNullable(restaurant).ifPresent(p -> total.addAndGet(p.amount()));
        Optional.ofNullable(platform).ifPresent(p -> total.addAndGet(p.amount()));
        return total.get();
    }
}
