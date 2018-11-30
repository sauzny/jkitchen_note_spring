package com.sauzny.springbootweb.utils.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class MultipleStatus {

    // 0 1
    // private int hide;
    // 0 2
    // private int del;
    // 0 4
    // private int read;
    // 0 8
    // private int publish;
    
    // 实际数据库存储的数值 0-15
    private int status;
    
    public MultipleStatus(){}

}

interface MultipleStatusCon{
    
    int N_ALL = 0;
    
    int Y_HIDE = 1;
    
    int Y_DEL = 2;
    
    int Y_READ = 4;
    
    int Y_PUBLISH = 8;
}

public class MultipleStatusDemo{
    
    // 对比状态值
    // 使用|可以表示出所有状态的组合，可以实现判断数据库中的值是否自己所需要的
    // 也可以使用+号 连接状态值，建议使用位运算，原因见修改状态值
    public void foo01(){
        System.out.println("使用|即可标识所有状态的组合，可以实现判断数据库中的值是否自己所需要的");

        System.out.println(MultipleStatusCon.N_ALL);
        
        System.out.println(MultipleStatusCon.Y_HIDE);
        System.out.println(MultipleStatusCon.Y_DEL);
        System.out.println(MultipleStatusCon.Y_HIDE|MultipleStatusCon.Y_DEL);
        System.out.println(MultipleStatusCon.Y_READ);
        System.out.println(MultipleStatusCon.Y_HIDE|MultipleStatusCon.Y_READ);
        System.out.println(MultipleStatusCon.Y_DEL|MultipleStatusCon.Y_READ);
        System.out.println(MultipleStatusCon.Y_HIDE|MultipleStatusCon.Y_DEL|MultipleStatusCon.Y_READ);
        System.out.println(MultipleStatusCon.Y_PUBLISH);
        System.out.println(MultipleStatusCon.Y_HIDE|MultipleStatusCon.Y_PUBLISH);
        System.out.println(MultipleStatusCon.Y_DEL|MultipleStatusCon.Y_PUBLISH);
        System.out.println(MultipleStatusCon.Y_HIDE|MultipleStatusCon.Y_DEL|MultipleStatusCon.Y_PUBLISH);
        System.out.println(MultipleStatusCon.Y_READ|MultipleStatusCon.Y_PUBLISH);
        System.out.println(MultipleStatusCon.Y_HIDE|MultipleStatusCon.Y_READ|MultipleStatusCon.Y_PUBLISH);
        System.out.println(MultipleStatusCon.Y_DEL|MultipleStatusCon.Y_READ|MultipleStatusCon.Y_PUBLISH);
        System.out.println(MultipleStatusCon.Y_HIDE|MultipleStatusCon.Y_DEL|MultipleStatusCon.Y_READ|MultipleStatusCon.Y_PUBLISH);
    }
    
    // 修改 状态值
    // 这里注意：如果使用+-号来修改状态值，要注意出现 8+8（状态值重复增加或减少）这样的情况
    public void foo02(){

        System.out.println("修改 状态值");
        
        MultipleStatus ms1 = new MultipleStatus(8);
        int r11 = ms1.getStatus() | MultipleStatusCon.Y_READ;
        System.out.println("原状态是8，增加 可READ后变为：" + r11);
        
        int r12 = ms1.getStatus() & ~MultipleStatusCon.Y_READ;
        System.out.println("原状态是8（本身不包含可read），去掉 可READ后变为：" + r12);
        
        MultipleStatus ms2 = new MultipleStatus(15);
        
        int r21 = ms2.getStatus() & MultipleStatusCon.Y_READ;
        System.out.println("原状态是15，只保留可READ后变为：" + r21);
        
        int r22 = ms2.getStatus() & (MultipleStatusCon.Y_READ | MultipleStatusCon.Y_DEL);
        System.out.println("原状态是15，保留可READ,保留已删除后变为：" + r22);

        int r23 = ms2.getStatus() & ~MultipleStatusCon.Y_READ;
        System.out.println("原状态是15，去掉可READ后变为：" + r23);

        int r24 = ms2.getStatus() & ~(MultipleStatusCon.Y_READ | MultipleStatusCon.Y_DEL);
        System.out.println("原状态是15，去掉可READ，去掉已删除后变为：" + r24);

    }

    public void foo03(){

        System.out.println("已知状态值，测试当前状态值包含哪些状态，结果为0，则不包含，反之则包含");

        MultipleStatus ms1 = new MultipleStatus(12);
        System.out.println("当前状态是12，测试是否包含Y_HIDE：" + (ms1.getStatus() & MultipleStatusCon.Y_HIDE));
        System.out.println("当前状态是12，测试是否包含Y_DEL：" + (ms1.getStatus() & MultipleStatusCon.Y_DEL));
        System.out.println("当前状态是12，测试是否包含Y_READ：" + (ms1.getStatus() & MultipleStatusCon.Y_READ));
        System.out.println("当前状态是12，测试是否包含Y_PUBLISH：" + (ms1.getStatus() & MultipleStatusCon.Y_PUBLISH));

        System.out.println();

        MultipleStatus ms2 = new MultipleStatus(15);
        System.out.println("当前状态是15，测试是否包含Y_HIDE：" + (ms2.getStatus() & MultipleStatusCon.Y_HIDE));
        System.out.println("当前状态是15，测试是否包含Y_DEL：" + (ms2.getStatus() & MultipleStatusCon.Y_DEL));
        System.out.println("当前状态是15，测试是否包含Y_READ：" + (ms2.getStatus() & MultipleStatusCon.Y_READ));
        System.out.println("当前状态是15，测试是否包含Y_PUBLISH：" + (ms2.getStatus() & MultipleStatusCon.Y_PUBLISH));
    }

    public static void main(String[] args) {
        MultipleStatusDemo msd = new MultipleStatusDemo();
        msd.foo01();
        System.out.println("===================================================================");
        msd.foo02();
        System.out.println("===================================================================");
        msd.foo03();
    }
}
