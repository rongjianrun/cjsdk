package com.cjsdk.lib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by legend on 15/5/20.
 */
public class ArrayUtils {

    public static final int INDEX_NOT_FOUND = -1;

    public static <T> boolean contains(T[] array, T value) {
        return indexOf(array, value) != -1;
    }

    public static boolean contains(final int[] array, final int valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static <T> int indexOf(T[] array, T value) {
        if (array == null) return -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) return i;
        }
        return -1;
    }

    public static int indexOf(final int[] array, final int valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final int[] array, final int valueToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(long[] array, long valueToFind) {
        return indexOf(array, valueToFind) != -1;
    }

    public static int indexOf(long[] array, long valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(long[] array, long valueToFind, int startIndex) {
        if (array == null) {
            return -1;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static int[] toIntArray(Integer[] array) {
        if (array == null) {
            return new int[0];
        }
        int[] ret = new int[array.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = array[i];
        }
        return ret;
    }

    public static long[] toLongArray(List<Long> list) {
        long[] ret = new long[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static <T> List<T> subList(List<T> src, int start, int count) {
        List<T> list = new ArrayList<>();
        int maxIndex = Math.min(start + count, src.size());
        for (int i = start; i < maxIndex; ++i) {
            list.add(src.get(i));
        }
        return list;
    }

    public static <T> boolean union(T[] dst, T[]... src) {
        int dstLength = dst.length;

        int current = 0;
        for (T[] item : src) {
            int end = current + item.length;
            if (end > dstLength) {
                return false;
            }
            System.arraycopy(item, 0, dst, current, end);
            current += item.length;
        }
        return true;
    }

    public static <T> boolean add(T[] src, T[] dst, int index, T element) {
        if (dst.length - src.length != 1) {
            return false;
        }
        System.arraycopy(src, 0, dst, 0, index);
        dst[index] = element;
        System.arraycopy(src, index, dst, index + 1, src.length - index);
        return true;
    }

    public static <T> boolean remove(T[] src, T[] dst, int index) {
        if (src.length - dst.length != 1) {
            return false;
        }
        System.arraycopy(src, 0, dst, 0, index);
        System.arraycopy(src, index + 1, dst, index, src.length - index - 1);
        return true;
    }

    public static <T> T[] removeElement(Class<T> kind, T[] array, T element) {
        if (array != null) {
            if (!contains(array, element)) return array;
            final int length = array.length;
            for (int i = 0; i < length; i++) {
                if (array[i].equals(element)) {
                    if (length == 1) {
                        return null;
                    }
                    T[] result = (T[]) Array.newInstance(kind, length - 1);
                    System.arraycopy(array, 0, result, 0, i);
                    System.arraycopy(array, i + 1, result, i, length - i - 1);
                    return result;
                }
            }
        }
        return array;
    }

    public static <T> T[] appendElement(Class<T> kind, T[] array, T element) {
        final T[] result;
        final int end;
        if (array != null) {
            if (contains(array, element)) return array;
            end = array.length;
            result = (T[]) Array.newInstance(kind, end + 1);
            System.arraycopy(array, 0, result, 0, end);
        } else {
            end = 0;
            result = (T[]) Array.newInstance(kind, 1);
        }
        result[end] = element;
        return result;
    }


    public static Integer[] toObject(int[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Integer[0];
        }
        final Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
