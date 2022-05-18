package com.cjsdk.lib;

import android.content.res.AssetManager;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;


public class AssetsUtils {
    private static int bufferSzie = 4096;

    public static String getStringFromFile(AssetManager assetManager, String fileName, String encodeing) {
        try {
            InputStream is = assetManager.open(fileName);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] data = new byte[bufferSzie];
            int count = -1;
            while ((count = is.read(data, 0, bufferSzie)) != -1)
                outStream.write(data, 0, count);

            data = null;
            return new String(outStream.toByteArray(), encodeing);
        } catch (Exception e) {
            return null;
        }
    }

}
