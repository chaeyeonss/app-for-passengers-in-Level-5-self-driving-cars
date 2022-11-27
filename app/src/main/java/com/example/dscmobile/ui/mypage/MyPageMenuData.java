package com.example.dscmobile.ui.mypage;

public class MyPageMenuData {
    public int num_img;
    public String menuName;

    public int getNum_img() {
        return num_img;
    }

    public void setNum_img(int num_img) {
        this.num_img = num_img;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public MyPageMenuData(int num_img, String menuName) {
        this.num_img = num_img;
        this.menuName = menuName;
    }
}
