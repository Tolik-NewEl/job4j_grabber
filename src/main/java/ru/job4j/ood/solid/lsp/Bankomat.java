package ru.job4j.ood.solid.lsp;

public class Bankomat {
    /**
     * Подкласс усиливает предусловие
     */
    private int cardBalance;

    public boolean withdraw(int amount) {
        if (amount > cardBalance) {
            throw new IllegalArgumentException("Недостаточно средств на карте!");
        }
        return true;
    }

    private class SomeElseATM extends Bankomat {

        @Override
        public boolean withdraw(int amount) {
            if (amount > cardBalance) {
                throw new IllegalArgumentException("Недостаточно средств на карте!");
            }
            if (amount > 50000) {
                throw new IllegalArgumentException("Сумма вывода превышает допустимую (50000)!");
            }
            return true;
        }
    }
}

