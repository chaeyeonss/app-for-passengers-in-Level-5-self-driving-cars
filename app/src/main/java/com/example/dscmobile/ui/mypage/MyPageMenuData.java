package com.example.dscmobile.ui.mypage;

public class MyPageMenuData {
    private int menuIconNum;
    private String menuName;

    public int getMenuIconNum() {
        return menuIconNum;
    }

    public void setMenuIconNum(int menuIconNum) {
        this.menuIconNum = menuIconNum;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public MyPageMenuData(int menuIconNum, String menuName) {
        this.menuIconNum = menuIconNum;
        this.menuName = menuName;
    }
}
