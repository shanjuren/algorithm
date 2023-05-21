package com.algorithm.dynamicProgramming;

/**
 * @author ght
 * @date 2022.04.27 2:50 PM
 * @description 1306. 跳跃游戏 III
 */
public class JumpGameIII {

//    public boolean canReach(int[] arr, int start) {
//
//        if(arr[start]==0) return true;
//        List<List<Integer>> jumpStep = new ArrayList<>();
//        List<Integer> endList =new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            jumpStep.add(new ArrayList<>());
//            if(arr[i]==0) {
//                endList.add(i);
//                continue;
//            }
//            int left = i-arr[i];
//            int right = i+arr[i];
//
//
//
//            if(left>=0){
//                jumpStep.get(i).add(left);
//            }
//            if(right<arr.length ){
//                jumpStep.get(i).add(right);
//            }
//
//
//        }
//        return findEnd(jumpStep,start,endList,0);
//    }
//
//    private boolean findEnd(List<List<Integer>> jumpStep, int start, List<Integer> endList,int hasRun) {
//
//        if(endList.contains(start)) return true;
//        if(hasRun>=jumpStep.size()) return false;
//
//        for (Integer newStart : jumpStep.get(start)) {
//            boolean tmpResult = findEnd(jumpStep,newStart,endList,hasRun+1);
//            if(tmpResult) return true;
//        }
//        return false;
//    }

    boolean flag;
    boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        this.flag = false;
        this.visited = new boolean[n];

        dfs(arr, start);

        return flag;
    }

    private void dfs(int[] arr, int start) {
        if (arr[start] == 0) flag = true;

        if (flag) return;

        if (visited[start]) return;

        visited[start] = true;

        if (start - arr[start] >= 0) {
            dfs(arr, start - arr[start]);
        }

        if (start + arr[start] < arr.length) {
            dfs(arr, start + arr[start]);
        }
    }

    public static void main(String[] args) {
        JumpGameIII jumpGameIII = new JumpGameIII();
        int[] test = new int[]{3,0,2,1,2};
        System.out.print(jumpGameIII.canReach(test,2));

    }

}
