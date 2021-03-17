package base.algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] array = new Integer[100];
        for(int i=0; i<array.length; i++){
            array[i] = (int)(Math.random()*100);
        }
        System.out.println("排序前：" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    public static <E extends Comparable<E>> void quickSort(E[] array, int start, int end) {
        if (start >= end) return;
        int index = getIndex(array, start, end);
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    public static <E extends Comparable<E>> int getIndex(E[] array, int start, int end) {
        E temp = array[start];
        while (start < end) {
            while (start < end && array[end].compareTo(temp) >= 0) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start].compareTo(temp) <= 0) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }
}
