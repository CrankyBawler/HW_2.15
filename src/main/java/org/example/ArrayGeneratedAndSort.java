package org.example;

import java.util.Arrays;
import java.util.Random;


public class ArrayGeneratedAndSort {
    private Integer[] array;
    private int size;

    public ArrayGeneratedAndSort(Integer[] array, int size) {
        this.array = array;
        this.size = 100000;
    }

    public static Integer[] generateArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();

        }
        return array;
    }





//
//    public static void sortBubble(Integer[] arrayBubble) {
//        boolean swapped;
//        for (int i = 0; i < arrayBubble.length - 1; i++) {
//            swapped = false;
//            for (int j = 0; j < arrayBubble.length - 1 - i; j++) {
//                if (arrayBubble[j] > arrayBubble[j + 1]) {
//                    int temp = arrayBubble[j];
//                    arrayBubble[j] = arrayBubble[j + 1];
//                    arrayBubble[j + 1] = temp;
//                    swapped = true;
//                }
//
//            }
//            if (!swapped) {
//                break;
//            }
//        }
//
//    }
//
//    public void timer() {
//
//        long start = System.currentTimeMillis();
//        sortBubble(array);
//        System.out.println(System.currentTimeMillis() - start);
//    }
//
};
