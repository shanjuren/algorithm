package com.algorithm.other;

/**
 * @author ght
 * @date 2022.04.22 3:03 PM
 * @description
 */
public class RobotBoundedInCircle {

    public static boolean isRobotBounded(String instructions) {

        char[] roads = instructions.toCharArray();
        int up = 0;
        int left = 0;
        int right = 0;
        int down = 0;

        int direction = 0;

        int i=0;

        // 只有差值变小才结束
        while(i<4){
            for (char road : roads) {
                if(road!='G'){
                    direction = direction+ (road=='L'?-1:1);
                    continue;
                }

                int tmp = direction%4;
                if(tmp==0){
                    up++;
                }else if(tmp==1 || tmp==-3){
                    right++;
                }else if(tmp==3 || tmp==-1){
                    left++;
                }else if(tmp==2 || tmp==-2){
                    down++;
                }
            }
            if(right==left && up==down){
                return true;
            }
            i++;
        }

        // 还需要处理
        return false;
    }


    public static void main(String[] args) {
        String instructions = "GG";
        System.out.print(isRobotBounded(instructions)+"\n");
    }
}
