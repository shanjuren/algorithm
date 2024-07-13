package com.algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: 187. 重复的DNA序列
 * https://leetcode.cn/problems/repeated-dna-sequences/description/
 *
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 *
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 *
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * @Author: ght
 * @Date: 2024/7/13 14:09
 */
public class FindRepeatedDnaSequences {

    Set<String> result = new HashSet<>();

    public List<String> findRepeatedDnaSequences(String s) {

        if(s.length()<=10){
            return new ArrayList<>(result);
        }
        Set<String> tmpSearchSet = new HashSet<>();
        char[] chars = s.toCharArray();

        tmpSearchSet.add(s.substring(0,10));
        for (int start=0,end = 10; end < chars.length; end++) {
            String tmpString = s.substring(++start,end+1);
            if(tmpSearchSet.contains(tmpString)){
                result.add(tmpString);
            }else {
                tmpSearchSet.add(tmpString);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequences sequences = new FindRepeatedDnaSequences();
        System.out.println(sequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
