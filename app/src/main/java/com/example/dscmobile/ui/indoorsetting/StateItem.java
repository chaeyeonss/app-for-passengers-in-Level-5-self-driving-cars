package com.example.dscmobile.ui.indoorsetting;

/* 실내 설정 탭
   차량 상태 상단 모니터링 내용
 */
public class StateItem {
    String title; // 현재 속도, 공기 청정도, 배터리, 운행가능거리
    String unit;  // km/h, ㎛, %, km
    int state;    // 상태값들

    public StateItem(String title, String unit, int state) {
        this.title = title;
        this.unit = unit;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getState() {
        return Integer.toString(state)+unit;
    }

    public void setState(int state) {
        this.state = state;
    }
}
