package org.g220804.test;

import java.util.Arrays;

public class test01
{
    public static void main(String[] args)
    {
        //        MyCallable mc=new MyCallable();
        //        FutureTask<String> ft=new FutureTask<>(mc);
        //        Thread t1=new Thread(ft);
        //        String s=ft.get();
        //        t1.start();
        //        System.out.println("hhh");
        //        System.out.println(s);
        //    MyCallable my=new MyCallable();
        //    Thread t1=new Thread(my,"飞机");
        //    Thread t2=new Thread(my,"坦克");
        //    t1.start();
        //    t2.start();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.setName("高铁");
        t2.setName("飞机");
        t3.setName("汽车");
        t1.setPriority(10);
        t3.setPriority(1);
        t1.start();
        try
        {
            t1.join();
        }
        catch(Exception e)
        {
            e.printStackTrace(System.err);
        }
        t2.start();
        try
        {
            t2.join();
        }
        catch(Exception e)
        {
            e.printStackTrace(System.err);
        }
        t3.start();
        int[] a = new int[3];
        Arrays.sort(a);
        for(int i: a)
        {
        }
        //        Properties prop=new Properties();
        //        prop.put("001","zs");
        //        prop.put("002","lisi");
        //        prop.put("003","wu");
        //        Set<Object> keySet= prop.keySet();
        //        for (Object key : keySet) {
        //            Object value=prop.get(key);
        //            System.out.println(key+","+value);
        //        }
    }
}

