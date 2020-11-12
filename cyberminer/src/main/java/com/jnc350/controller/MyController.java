package com.jnc350.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jnc350.vo.AlphabeticShift;
import com.jnc350.vo.CircularShift;
import com.jnc350.vo.LineStorage;
import com.jnc350.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","Test page");
        mv.addObject("function","something else");

        mv.setViewName("show");

        return mv;
    }

    @RequestMapping(value = "/other.do")
    public ModelAndView doOther(String inputText){


        ModelAndView mv = new ModelAndView();


        mv.addObject("output","ss");


        mv.setViewName("show");

        return mv;
    }

    //returnVoid-ajx.do
    @RequestMapping(value = "/returnVoid-ajx.do")
    public void doAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("Name is "+ name +" Age is  "+ age);
        Student student = new Student();
        student.setName(name);
        student.setAge(27);

        String json = "";
        if(student!=null) {
            ObjectMapper om = new ObjectMapper();
            json=om.writeValueAsString(student);
            System.out.println(json);

        }

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.close();
    }

    @RequestMapping(value = "/returnStudent_JSON.do")
    @ResponseBody
    public Student doObject(String name, Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        System.out.println(student);
        return student;
    }

    @RequestMapping(value = "/returnS_JSON.do")
    @ResponseBody
    public String doS(String s) {
        return s;
    }

    @RequestMapping(value = "/returnCS_JSON.do")
    @ResponseBody
    public List<String> doCS(String s) {
        LineStorage ls= new LineStorage();
        ls.setLine(s);
        CircularShift cs = new CircularShift();
        cs.shiftLines(ls.getLine());
        return cs.getOutputLines();
    }

    @RequestMapping(value = "/returnAS_JSON.do")
    @ResponseBody
    public List<String> doAS(String s) {
        LineStorage ls= new LineStorage();
        ls.setLine(s);
        CircularShift cs = new CircularShift();
        cs.shiftLines(ls.getLine());
        AlphabeticShift as = new AlphabeticShift();
        as.sortLines(cs.getOutputLines());
        return as.getASList();
    }

}
