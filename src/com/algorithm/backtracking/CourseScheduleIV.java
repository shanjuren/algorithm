package com.algorithm.backtracking;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ght
 * @date 2022.04.26 3:18 PM
 * @description 1462. 课程表 IV
 */
public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        Map<Integer,List<Integer>> coursesMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if(!coursesMap.containsKey(prerequisites[i][0])){
                coursesMap.put(prerequisites[i][0],new ArrayList<>());
            }
            coursesMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            result.add(find(coursesMap,0,queries[i][1],queries[i][0]));
        }
        return result;
    }


    public boolean find(Map<Integer,List<Integer>> coursesMap,int curr,int start,int end){
        if(curr>coursesMap.size()) return false;


        if(coursesMap.containsKey(end)){
            List<Integer> newEndList = coursesMap.get(end);
            if(newEndList.contains(start)){
                return true;
            }else {
                for (Integer newEnd : newEndList) {
                    if(find(coursesMap,++curr,start,newEnd)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();
        int[][] test = new int[][]{{1,2},{1,0},{2,0}};
        int[][] quest = new int[][]{{1,0},{1,2}};
        courseScheduleIV.checkIfPrerequisite(3,test,quest);
    }

}
