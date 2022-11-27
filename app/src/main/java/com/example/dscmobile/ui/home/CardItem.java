package com.example.dscmobile.ui.home;

public class CardItem {
    private String sectionPhrase;
    private String[] cardContents;

    public String getSectionPhrase() {
        return sectionPhrase;
    }

    public void setSectionPhrase(String sectionPhrase) {
        this.sectionPhrase = sectionPhrase;
    }

    public String[] getCardContents() {
        return cardContents;
    }

    public void setCardContents(String[] cardContents) {
        this.cardContents = cardContents;
    }

    public CardItem(String sectionPhrase, String[] cardContents) {
        this.sectionPhrase = sectionPhrase;
        this.cardContents = cardContents;
    }
}
