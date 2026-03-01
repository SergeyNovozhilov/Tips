package ru.snovit.tips;

public record Delivery(
        String orderId,
        String courierId,
        String restaurantId,
        boolean isHardDelivery,
        boolean restaurantInProgram
) {
}
