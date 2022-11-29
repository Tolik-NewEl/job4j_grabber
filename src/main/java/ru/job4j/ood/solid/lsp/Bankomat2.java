package ru.job4j.ood.solid.lsp;

public class Bankomat2 {
    /**
     * Ослабление постусловия в подклассе
     */
    private double cardBalance;
    private boolean active;

    public Bankomat2(double cardBalance, boolean active) {
        this.cardBalance = cardBalance;
        this.active = active;
    }

    public double withdraw(double amount) {
        double rsl;
        if (active || cardBalance > amount) {
            rsl = (cardBalance - amount) * 0.95;
        } else {
            throw new IllegalArgumentException("Карта заблокирована или недостаточно средств!");
        }
        return rsl;
    }

    private class AnotherATM extends Bankomat2 {

        public AnotherATM(double cardBalance, boolean active) {
            super(cardBalance, active);
        }

        @Override
        public double withdraw(double amount) {
            return (cardBalance - amount) * 0.95;
        }
    }
}
