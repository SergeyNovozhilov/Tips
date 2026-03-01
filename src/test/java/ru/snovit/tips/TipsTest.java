package ru.snovit.tips;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TipsTest {
    private final TipDistributionService service = new TipDistributionService();

    @Test
    public void tipsTest() {
        long tipsAmount = 12743L;
        Delivery delivery = new Delivery("123", "123", "123", false, false);
        var result = service.distribute(tipsAmount, delivery);
        assertNotNull(result);
        assertEquals(tipsAmount, result.total());
    }
}
