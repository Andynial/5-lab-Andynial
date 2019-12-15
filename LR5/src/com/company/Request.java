package com.company;

import java.util.ArrayList;

public class Request {
    ArrayList<Part> parts = new ArrayList<Part>();
    void AddPart(Part part){
        parts.add(part);
    }

    String PrintRequest(){
        String text = "";
        for (int i = 0; i < parts.size(); i++) {
            Part part = parts.get(i);
           text += part.GetInstrument() + ", " + part.GetTime() + "; ";
        }
        return text;
    }
}
