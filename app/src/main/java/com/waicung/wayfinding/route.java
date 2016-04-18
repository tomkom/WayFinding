package com.waicung.wayfinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by waicung on 14/04/2016.
 * a route object representing a object with start and end point
 * and a serious of steps
 */
public class Route {
    private Point start_point;
    private Point end_point;
    private ArrayList<Step> steps= new ArrayList<Step>();

    public Route(Point start_point, Point end_point, ArrayList<Step> steps){
        this.start_point = start_point;
        this.end_point = end_point;
        for(Step s: steps){
            this.steps.add(s.clone());
        }
    }

    public String toString(){
        StringBuilder instructions = new StringBuilder();
        for(Step s: steps){
            instructions.append(s.toString());
        }
        return instructions.toString();
    }

    public Point getPoint(String end){
        switch(end) {
            case "start":
                return this.start_point;
            case "end":
                return this.end_point;
            default:
                return this.start_point;
        }
    }

    public List<String> getInstruction(){
        List<String> instructions = new ArrayList<String>();
        for(Step s:this.steps){
            instructions.add(s.toString());
        }
        return instructions;
    }

    //Provided two route have the same start and end point
    //that are the same route
    public boolean equal(Route route){
        if(this.start_point == route.getPoint("start")&&
                this.end_point == route.getPoint("end")){
            return true;
        }
        else return false;
    }

}
