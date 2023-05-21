package com.algorithm.bfs;

import java.util.*;

/**
 * @author ght
 * @date 2022.04.28 10:44 AM
 * @description 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 *
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
public class CourseSchedule {

    /**
     * 拓扑排序中的入度表标识是否当前还有依赖，如果还有证明后面无论怎么转都会再转到这个点。
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 入度表
        int[] inDegree = new int[numCourses];

        // 各个节点依赖关系
        List<List<Integer>> dependList = new ArrayList<>(numCourses);

        // 当前队列
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            dependList.add(new ArrayList<>());
        }

        // 生成入度表
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]] +=1;
            dependList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        // bfs遍历
        while (!queue.isEmpty()){

            int curCourse = queue.poll();
            // 当前这个节点已经遍历，退出一个课程
            numCourses--;
            // 入度表相邻节点-1,如果出现0继续往下走
            for (Integer preCourse : dependList.get(curCourse)) {
                if(--inDegree[preCourse] == 0){
                    queue.offer(preCourse);
                }
            }
        }
        return numCourses>0?false:true;
    }

    /**
     * 还存在一种DFS的解法
     * @param args
     */








    public static void main(String[] args) {
        int[][] test = new int[][]{{0,1},{1,5},{1,4},{4,3},{5,2},{2,1}};
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.print(courseSchedule.canFinish(6,test));
    }


}
