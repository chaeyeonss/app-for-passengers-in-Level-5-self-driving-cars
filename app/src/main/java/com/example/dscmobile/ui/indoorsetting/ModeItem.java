package com.example.dscmobile.ui.indoorsetting;

public class ModeItem {
    private int modeIcon;
    private String mode;

    public ModeItem(int modeIcon, String mode) {
        this.modeIcon = modeIcon;
        this.mode = mode;
    }

    public int getModeIcon() {
        return modeIcon;
    }

    public void setModeIcon(int modeIcon) {
        this.modeIcon = modeIcon;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
