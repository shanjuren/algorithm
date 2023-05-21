package com.algorithm.base;



/**
 * @author ght
 * @date 2022.04.08 5:50 PM
 * @description 单例模式
 */
public class SingleModel {

    /** 极简版单例模式
    private static volatile SingleModel record =null;

    // 破坏默认构造函数
    private SingleModel(){};

    public static SingleModel getRecord(){
       synchronized (SingleModel.class){
           if(record!=null){
                record = new SingleModel();
           }
           return record;
       }
    }

     **/

    // double chcek
    private static SingleModel record = null;

    private SingleModel(){};

    public static SingleModel getRecord(){
        if(record==null){
            synchronized (SingleModel.class){
                if(record==null){
                    record = new SingleModel();
                }
            }
        }
        return record;
    }



}
