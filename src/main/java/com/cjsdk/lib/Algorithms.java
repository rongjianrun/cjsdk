package com.cjsdk.lib;

import android.util.Log;

import java.security.MessageDigest;

public class Algorithms {

    public static String md5(byte[] data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(data);
            byte[] d = md5.digest();

            return bytesToHexString(d);
        } catch (Exception e) {
            Log.w("Algorithms.java getMD5", Log.getStackTraceString(e));
            return null;
        }
    }

    public static String bytesToHexString(byte[] data) {
        final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        StringBuilder buf = new StringBuilder(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            buf.append(hexDigits[(data[i] & 0xf0) >>> 4]);
            buf.append(hexDigits[data[i] & 0x0f]);
        }

        return buf.toString();
    }
}
