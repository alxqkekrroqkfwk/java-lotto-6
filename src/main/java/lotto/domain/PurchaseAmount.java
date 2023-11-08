package lotto.domain;

import lotto.exception.ErrorCode;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public PurchaseAmount(String amount) {
        verification(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    private void verification(String amount) {
        isNullPurchaseAmount(amount);
        isPurchaseAmount(amount);
        isValidPurchaseAmount(amount);
    }

    private void isNullPurchaseAmount(String amount) {
        if (amount.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.MISSING_PURCHASE_AMOUNT.getMessage());
        }
    }

    private void isPurchaseAmount(String amount) {
        if (amount.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }

    private void isValidPurchaseAmount(String amount) {
        if (Integer.parseInt(amount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }
}