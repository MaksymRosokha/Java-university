package com.rosokha;

import java.util.List;

public class Swapper {
    public static <T> void swap(List<T> list, int i, int j) {
        try {
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Your index out of bounds");
        }
    }
}
