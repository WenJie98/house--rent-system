package com.wen.houserent.view;


import com.wen.houserent.pojo.House;
import com.wen.houserent.service.HouseService;
import com.wen.houserent.utility.Utility;

/**
 * 1、显示界面
 * 2、接受用户输入
 * 3、调用其他类完成相关操作
 */
public class HouseView {

    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接受用户选择
    private HouseService houseService = new HouseService(2);


    //编写addHouse()方法
    public void addHouse() {
        System.out.println("\n=============添加房屋=============");
        System.out.println("房主：");
        String name = Utility.readString(8);
        System.out.println("电话：");
        int tel = Utility.readInt();
        System.out.println("地址：");
        String address = Utility.readString(8);
        System.out.println("月租：");
        int price = Utility.readInt();
        System.out.println("状态：");
        String rent = Utility.readString(3);

        House house = new House();
        house.setName(name);
        house.setTel(tel);
        house.setAddress(address);
        house.setPrice(price);
        house.setRent(rent);
        if (houseService.add(house)) {
            System.out.println("==============添加房屋成功==============");
        }
    }

    //删除房屋delHouse
    public void delHouse() {
        System.out.println("\n==============删除房屋信息==============");
        System.out.println("请输入您要删除的房屋id(-1退出)");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("==============您放弃了删除==============");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            boolean del = houseService.del(delId);
            if (del) {
                System.out.println("==============删除成功==============");
            } else {
                System.out.println("==============房屋不存在，删除失败==============");
            }
        } else {
            System.out.println("==============您放弃了删除==============");
        }
    }

    //查找房屋
    public void findHouse() {
        System.out.println("\n==============查找房屋信息==============");
        System.out.println("请输入您要查找的房屋id");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("==============查找的房屋信息不存在==============");
        }
    }

    //修改房屋信息
    public void updateHouse() {
        System.out.println("\n==============修改房屋信息==============");

        System.out.println("请选择待修改房屋id(-1退出)");
        int upDateId = Utility.readInt();
        House house = houseService.findById(upDateId);
        if (house == null) {
            System.out.println("您要修改的房屋信息不存在");
            return;
        }

        System.out.println("姓名(" + house.getName() + "):");
        String name = Utility.readString(8, "");
        if (name != "") {
            house.setName(name);
        }

        System.out.println("电话(" + house.getTel() + "):");
        int tel = Utility.readInt(-1);
        if (tel != -1) {
            house.setTel(tel);
        }

        System.out.println("地址(" + house.getAddress() + "):");
        String address = Utility.readString(8, "");
        if (address != "") {
            house.setAddress(address);
        }

        System.out.println("月租(" + house.getPrice() + "):");
        int price = Utility.readInt(-1);
        if (tel != -1) {
            house.setPrice(price);

            System.out.println("状态(未出租/已出租)" + house.getRent() + "):");
            String rent = Utility.readString(8, "");
            if (rent != "") {
                house.setRent(rent);
            }

        }
    }


    //退出系统
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    //显示房屋列表
    public void listHouse() {
        System.out.println("\n=============房屋列表=============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] list = houseService.list();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                break;
            }
            System.out.println(list[i]);
        }
    }


    //1、显示界面
    public void mainMenu() {
        do {
            System.out.println("=============房屋出租系统=============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退       出");
            System.out.println("请输入你的选择");

            key = Utility.readChar();

            switch (key) {
                case '1' -> addHouse();
                case '2' -> findHouse();
                case '3' -> delHouse();
                case '4' -> updateHouse();
                case '5' -> listHouse();
                case '6' -> exit();
            }
        } while (loop);
    }
}

