package ru.job4j.ood.solid.lsp;

public class Bankomat3 {
    /**
     * Нарушение инварианта - поле amount не валидируется
     */
    private double amount;
    private String currency;

    public Bankomat3() {
    }

    public Bankomat3(double amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Наличие денег не может быть меньше нуля!");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public class newATM extends Bankomat3 {

        private double amount;
        private String currency;

        public newATM(double amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public void setAmount(double amount) {
            this.amount = amount;
        }

        @Override
        public String getCurrency() {
            return currency;
        }

        @Override
        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
