package models;

import java.time.LocalDate;

public class Card {
    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    private Long cardNo;
    private LocalDate expDate;

    public Card(long cardNo, int securityCode, LocalDate expDate) {
        this.cardNo = cardNo;
        this.expDate = expDate;
        this.securityCode = securityCode;
    }

    private int securityCode;

}
