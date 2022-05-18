package com.cjsdk.lib;

/**
 * Created by zxs on 2017/9/5.
 */

public enum BooleanEnumUtil {
    TRUE(1),
    FALSE(0);

    private int mValue;

    BooleanEnumUtil(int value) {
        mValue = value;
    }

    public boolean equalBool(int val) {
        return mValue == val;
    }
}
