package com.algorithm.bfs;

import java.util.*;

/**
 * @author ght
 * @date 2022.04.28 1:40 PM
 * @description 210. 课程表 II
 */
public class CourseScheduleII {

    /**
     * BFS解法
     *  入度表
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites){

        int[] inDegree = new int[numCourses];
        Map<Integer,List<Integer>> courseMap = new HashMap<>();

        int[] result = new int[numCourses];
        int resultIndex = 0;

        Queue<Integer> tmpQueue = new LinkedList<>();

        // 这里可以理解为出度表，
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if(!courseMap.containsKey(prerequisites[i][1])){
                courseMap.put(prerequisites[i][1],new ArrayList<>());
            }
            courseMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i]==0){
                // 如果为0则认为这可以是个起点
                tmpQueue.offer(i);
            }
        }

        while (!tmpQueue.isEmpty()){
            int cur = tmpQueue.poll();
            result[resultIndex++] = cur;
            numCourses--;

            if(courseMap.containsKey(cur)){
                for (Integer preCourse : courseMap.get(cur)) {
                    if(--inDegree[preCourse]==0){
                        tmpQueue.offer(preCourse);
                    }
                }
            }
        }
        return numCourses==0?result:new int[0];
    }


//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        // 深度遍历
//        int[] coursesStatus = new int[numCourses];
//        List<Integer> result = new ArrayList<>();
//
//        Map<Integer,List<Integer>> preRequireMap = new HashMap<>();
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            if(!preRequireMap.containsKey(prerequisites[i][0])){
//                preRequireMap.put(prerequisites[i][0],new ArrayList<>());
//            }
//            preRequireMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
//        }
//
//        // dfs遍历
//        for (int i = 0; i < numCourses; i++) {
//            if(!dfs(preRequireMap,result,coursesStatus,i)){
//               continue;
//            }
//        }
//
//        int[] test = new int[numCourses];
//        for (int i = 0; i < result.size(); i++) {
//            test[i] = result.get(i);
//        }
//        return  result.size()<numCourses?new int[0]:test;
//    }
//
//    /**
//     * 深度优先遍历
//     * @param preRequireMap
//     * @param result
//     * @param coursesStatus
//     * @return
//     */
//    private boolean dfs(Map<Integer, List<Integer>> preRequireMap, List<Integer> result, int[] coursesStatus,int cur) {
//
//        // 等于1是个环
//        if(coursesStatus[cur]==1) return false;
//
//        if(coursesStatus[cur]==-1) return true;
//
//        result.add(cur);
//        coursesStatus[cur] = 1;
//
//        // 挨个遍历上级
//        if(preRequireMap.get(cur)!=null){
//            for (Integer preCourse : preRequireMap.get(cur)) {
//                if(!dfs(preRequireMap,result,coursesStatus,preCourse)) {
//                    result.remove(result.size()-1);
//                    return false;
//                }
//            }
//        }
//
//        coursesStatus[cur] = -1;
//
//        return true;
//    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,0}};
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        courseScheduleII.findOrder(2,test);
    }
}
