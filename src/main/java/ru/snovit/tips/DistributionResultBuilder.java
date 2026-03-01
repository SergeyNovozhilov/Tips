package ru.snovit.tips;

public class DistributionResultBuilder {
    private String orderId;
    private String courierId;
    private String restaurantId;
    private boolean isHardDelivery;
    private boolean restaurantInProgram;
    private long tipsAmount;
    private int platformPercentage;
    private int restaurantPercentage;

    public DistributionResultBuilder orderId(String id) {
        orderId = id;
        return this;
    }

    public DistributionResultBuilder courierId(String id) {
        courierId = id;
        return this;
    }

    public DistributionResultBuilder restaurantId(String id) {
        restaurantId = id;
        return this;
    }

    public DistributionResultBuilder isHardDelivery(boolean hardDelivery) {
        isHardDelivery = hardDelivery;
        return this;
    }

    public DistributionResultBuilder isRestaurantInProgram(boolean isInProgram) {
        restaurantInProgram = isInProgram;
        return this;
    }

    public DistributionResultBuilder platformPercentage(int percentage) {
        platformPercentage = percentage;
        return this;
    }

    public DistributionResultBuilder restaurantPercentage(int percentage) {
        restaurantPercentage = percentage;
        return this;
    }

    public DistributionResultBuilder tipsAmount(long amount) {
        tipsAmount = amount;
        return this;
    }

    public DistributionResult build() {
        long platformTips = this.isHardDelivery ? 0L : calculate(this.tipsAmount, this.platformPercentage);
        Participant platform = new Participant(ParticipantEnum.PLATFORM, "", platformTips);
        long restaurantTips = this.restaurantInProgram ? calculate(this.tipsAmount,
                this.restaurantPercentage) : 0;
        Participant restaurant = new Participant(ParticipantEnum.RESTAURANT, this.restaurantId, restaurantTips);
        long courierTips = this.tipsAmount - platformTips - restaurantTips;
        Participant courier = new Participant(ParticipantEnum.COURIER, this.courierId, courierTips);
        return new DistributionResult(this.orderId, courier, restaurant, platform);
    }

    private long calculate(long amount, int percentage) {
        return amount * percentage / 100;
    }
}
