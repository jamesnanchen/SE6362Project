package com.jnc350.vo;

public class LineStorage {
    private String line = "";

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

//    public static void main(String[] args){
//        LineStorage ls= new LineStorage();
//        ls.setLine("This is a good day");
//        System.out.println(ls.getLine());
//        CircularShift cs = new CircularShift();
//        cs.shiftLines(ls.getLine());
//        System.out.println(cs.getOutputLines());
//
//        AlphabeticShift as = new AlphabeticShift();
//        as.sortLines(cs.getOutputLines());
//    }
}
