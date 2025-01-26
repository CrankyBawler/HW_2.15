package org.example;

import java.util.Arrays;
import java.util.Random;

import org.example.ArrayGeneratedAndSort;

public class Main {

    public static void main(String[] args) {
        ArrayGeneratedAndSort array = new ArrayGeneratedAndSort(100000);

        Integer[] arr = array.getArray();


        Integer[] arrBubble = Arrays.copyOf(arr, 100000);
        array.sortBubble(arrBubble);
        array.timerSortBubble();


        Integer[] arrSelection = Arrays.copyOf(arr, 100000);
        array.sortSelection(arrSelection);
        array.timerSortSelection();


        Integer[] arrInsertion = Arrays.copyOf(arr, 100000);
        array.sortInsertion(arrInsertion);
        array.timersortInsertion();


    }
}