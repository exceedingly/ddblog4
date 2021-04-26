package com.example.markdown.bean;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Product{
    private int number =1;//1 A 2 B C 3
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try{
            // 判断

            while(number!=1){
                condition1.await();
            }

            // 做事情
            for(int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }

            // 唤醒\
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            // 判断

            while(number!=2){
                condition2.await();
            }

            // 做事情
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }

            // 唤醒\
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            // 判断

            while(number!=3){
                condition3.await();
            }

            // 做事情
            for(int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"   "+i);
            }

            // 唤醒\
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}

public class Test {

    public static void main(String[] args) {
        Product product = new Product();

        new Thread(()->{
            for(int i =0;i<10;i++){
                product.print5();
            }
        },"A").start();

        new Thread(()->{
            System.out.println("B 开始");
            for(int i =0;i<10;i++){
                product.print10();
            }
            System.out.println("B 结束");
        },"B").start();

        new Thread(()->{
            for(int i =0;i<10;i++){
                product.print15();
            }
        },"C").start();


    }
}
