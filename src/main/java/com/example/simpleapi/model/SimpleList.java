package com.example.simpleapi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@AllArgsConstructor

public class SimpleList {
    List<Simple> simpleList = new ArrayList<Simple>();

    public SimpleList(){
        for(int i=1; i<11; i++){
            Simple simple = new Simple();
            simple.setNum(i);
            simple.setTitle("Test Title" + i);
            simple.setContent("Test Content" + i);
            simpleList.add(simple);
        }
    }

    public void getSimpleList(){
        log.info("========================================================");
        for(int i=0; i <simpleList.size(); i++){
            String num = Integer.toString(simpleList.get(i).getNum());
            log.info("num =" + num);
            log.info("title = " + simpleList.get(i).getTitle());
            log.info("content =" + simpleList.get(i).getContent());
        }
        log.info("========================================================");
    }

    public void addSimpleList(Simple simple){
        simpleList.add(simple);
    }

    public void updateSimpleList(int i, Simple simple){
        simpleList.get(i).setNum(simple.getNum());
        simpleList.get(i).setTitle(simple.getTitle());
        simpleList.get(i).setContent(simple.getContent());
    }

    public void deleteSimpleList(int i){
        simpleList.remove(i);
    }

    public int getSize(){
        return simpleList.size();
    }
}
