package ru.snovit.tips;

/**
 * Сервис распределения чаевых.
 *
 * Правила округления: в копейках, округление вниз для платформы и ресторана,
 * остаток — курьеру (сумма долей должна равняться исходным чаевым).
 */
class TipDistributionService {
    private final PropertyConfiguration configuration = new PropertyConfiguration();

    /**
     * Распределить чаевые между участниками.
     *
     * @param tipAmount сумма чаевых в копейках
     * @param delivery информация о доставке
     * @return результат распределения
     */
    public DistributionResult distribute(long tipAmount, Delivery delivery) {
        DistributionResultBuilder builder = new DistributionResultBuilder();
        return builder.courierId(delivery.courierId())
                .orderId(delivery.orderId())
                .restaurantId(delivery.restaurantId())
                .tipsAmount(tipAmount)
                .isRestaurantInProgram(delivery.restaurantInProgram())
                .isHardDelivery(delivery.isHardDelivery())
                .restaurantPercentage(configuration.getRestaurantPercentage())
                .platformPercentage(configuration.getPlatformPercentage())
                .build();
    }
}
