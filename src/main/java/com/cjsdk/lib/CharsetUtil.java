package com.cjsdk.lib;

/**
 * Created by ${Aven.Gong} on 2019/1/2 0002.
 */
public class CharsetUtil {

    public static final char LRM = '\u200E';

    private static boolean isAscIICode(char cha) {

        if (cha >= 32 && cha <= 126) {
            return true;
        }
        return false;
    }


    /**
     * 说明：除下列ASCII表中字符算作 0.5个字，其他字符都算作1个字
     *
     * @param str
     * @return
     */
    public static int getStringCount(String str) {
        float count = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (isAscIICode(aChar)) {
                count += 0.5f;
            } else {
                count++;
            }
        }
        return (int) Math.floor(count);
    }

    /**
     * 说明：除下列ASCII表中字符算作 0.5个字，其他字符都算作1个字
     *
     * @param str
     * @return
     */
    public static float getRealStringCount(String str) {
        float count = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (isAscIICode(aChar)) {
                count += 0.5f;
            } else {
                count++;
            }
        }
        return count;
    }

    public static String substring(String str, float charCount) {
        float count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isAscIICode(chars[i])) {
                count += 0.5f;
            } else {
                count++;
            }
            if (count > charCount && i <= str.length()) {
                return str.substring(0, i);
            }
        }
        return str;
    }


    public static boolean containsEmoji(String displayName) {
        for (int i = 0; i < displayName.length(); i++) {
            final char hs = displayName.charAt(i);

            if (Character.isHighSurrogate(hs) && i + 1 < displayName.length()) {
                final char ls = displayName.charAt(i + 1);
                final int uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;

                if (0x1d000 <= uc && uc <= 0x1f9c0) {
                    return true;
                }
            } else if (i + 1 < displayName.length()) {
                final char ls = displayName.charAt(i + 1);

                if (ls == 0x20e3 || ls == 0xfe0f || ls == 0xd83c) {
                    return true;
                }
            } else {
                // non surrogate
                if (0x2100 <= hs && hs <= 0x27ff) {
                    return true;
                } else if (0x2B05 <= hs && hs <= 0x2b07) {
                    return true;
                } else if (0x2934 <= hs && hs <= 0x2935) {
                    return true;
                } else if (0x3297 <= hs && hs <= 0x3299) {
                    return true;
                } else if (hs == 0xa9 || hs == 0xae || hs == 0x303d || hs == 0x3030 || hs == 0x2b55 || hs == 0x2b1c || hs == 0x2b1b || hs == 0x2b50) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isEmoji(String displayName) {

        final char hs = displayName.charAt(0);

        if (Character.isHighSurrogate(hs) && 1 < displayName.length()) {
            final char ls = displayName.charAt(1);
            final int uc = ((hs - 0xd800) * 0x400) + (ls - 0xdc00) + 0x10000;

            if (0x1d000 <= uc && uc <= 0x1f9c0) {
                return true;
            }
        } else if (1 < displayName.length()) {

            final char ls = displayName.charAt(1);

            if (ls == 0x20e3 || ls == 0xfe0f || ls == 0xd83c) {
                return true;
            }
        } else {
            // non surrogate
            if (0x2100 <= hs && hs <= 0x27ff) {
                return true;
            } else if (0x2B05 <= hs && hs <= 0x2b07) {
                return true;
            } else if (0x2934 <= hs && hs <= 0x2935) {
                return true;
            } else if (0x3297 <= hs && hs <= 0x3299) {
                return true;
            } else if (hs == 0xa9 || hs == 0xae || hs == 0x303d || hs == 0x3030 || hs == 0x2b55 || hs == 0x2b1c || hs == 0x2b1b || hs == 0x2b50) {
                return true;
            }
        }
        return false;
    }
}
