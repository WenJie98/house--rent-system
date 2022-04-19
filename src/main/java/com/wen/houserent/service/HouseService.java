package com.wen.houserent.service;

import com.wen.houserent.pojo.House;

/**
 * 1、响应HouseView.java
 * 2、完成CRUD操作
 */

public class HouseService {


    private House[] houses;//保存House对象
    private int houseNums = 1;//记录当前有多少房屋信息
    private int idCounter = 1;//记录id增长到哪个值


    public HouseService(int size) {
        //new house
        houses = new House[size];

        houses[0] = new House(1, "张三", 123, "重庆市", 1000, "未出租");
    }

    //add()方法
    public boolean add(House newHouse) {
        //判断是否可以继续添加
        //优化扩容（暂时不考虑）
        if (houseNums == houses.length) {
            System.out.println("数组已满，添加失败");
            return false;
        }

        //id自增机制
        houses[houseNums++] = newHouse;
        newHouse.setId(++idCounter);
        return true;


    }

    //del()方法
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null;
        return true;
    }

    //查找方法
    public House findById(int findId){
        for (int i = 0; i < houseNums; i++) {
            if(findId == houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }


    public House[] list() {
        return houses;
    }
}
