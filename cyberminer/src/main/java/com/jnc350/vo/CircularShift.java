package com.jnc350.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CircularShift {
    private final Set<String> CSSet = new HashSet<>();
    private final List<String> outputLines = new ArrayList<>();

    public void shiftLines(String line) {
        String temp = line;
        String[] split = line.split(" ");
        if(split.length<=1){
            outputLines.add(line);
        }
        else{
            for (String sp : split) {
                temp = temp.substring(sp.length() + 1) + " " + temp.substring(0, sp.length());
                CSSet.add(temp);
            }
            outputLines.addAll(CSSet);
        }
    }

    public List<String> getOutputLines() {
        return outputLines;
    }

    public String[] word(int i) {
        return outputLines.get(i).split(" ");
    }
}
