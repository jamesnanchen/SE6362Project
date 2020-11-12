package com.jnc350.vo;


import java.util.*;

public class AlphabeticShift{
    private String[] ASList;

    public void sortLines(List<String> lines){
        ASList=lines.toArray(new String[0]);
        if(lines.size()>1){
            mergeSort(ASList);
        }
    }
    public void mergeSort(String[] names) {
        if (names.length >= 2) {
            String[] left = new String[names.length / 2];
            String[] right = new String[names.length - names.length / 2];

            System.arraycopy(names, 0, left, 0, left.length);

            if (right.length >= 0) System.arraycopy(names, names.length / 2, right, 0, right.length);

            mergeSort(left);
            mergeSort(right);
            merge(names, left, right);
        }
    }

    public void merge(String[] names, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }

    public List<String> getASList() {
        return Arrays.asList(ASList.clone());
    }
}