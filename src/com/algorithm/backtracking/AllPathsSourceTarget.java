package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 797. 所有可能的路径
 * <p>
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 * @Author: ght
 * @Date: 2024/6/8 15:31
 */
public class AllPathsSourceTarget {

    List<Integer> tmp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        tmp.add(0);
        dfs(graph, 0);
        return result;
    }

    private void dfs(int[][] graph, int curIndex) {
        if (graph[curIndex].length == 0) {
            return;
        }


        int[] nextNodes = graph[curIndex];
        for (int i = 0; i < nextNodes.length; i++) {
            if (nextNodes[i] == (graph.length - 1)) {
                tmp.add(nextNodes[i]);
                result.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
            } else {
                tmp.add(nextNodes[i]);
                dfs(graph, nextNodes[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2}, {3}, {3}, {}};
        AllPathsSourceTarget target = new AllPathsSourceTarget();
        List<List<Integer>> result = target.allPathsSourceTarget(test);
        System.out.println(result);
    }
}
