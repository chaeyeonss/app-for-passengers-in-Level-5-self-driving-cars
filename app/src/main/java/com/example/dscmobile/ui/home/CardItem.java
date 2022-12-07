package com.example.dscmobile.ui.home;
/* 홈 페이지
   테마별 추천 리스트 카드 내용
 */
public class CardItem {
    private String[] cardContents;

    public String[] getCardContents() {
        return cardContents;
    }

    public void setCardContents(String[] cardContents) {
        this.cardContents = cardContents;
    }

    public CardItem(String[] cardContents) {
        this.cardContents = cardContents;
    }
}
