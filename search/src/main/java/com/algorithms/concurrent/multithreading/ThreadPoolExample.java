package com.algorithms.concurrent.multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    This is a basic example of thread pool executor- FixedThreadPool.
    This code illustrates a situation in which five people prepare drinks at a vending machine. 
    There are three machines available, in which only 3 people can prepare their drink simultaneously. 
    The rest must wait in a queue until a machine is available.
    It's up to you to exercise, refactor, improve and test this code 
*/
public class ThreadPoolExample {
    // Maximum number of threads in thread pool, in this case each thread represent a beverage vending machine.
    static final int MAX_BEVERAGE_VENDING_MACHINES = 3;

    public static void main(String[] args) {
        // creates Five persons
        Runnable r1 = new Person("Peter");
        Runnable r2 = new Person("Mark");
        Runnable r3 = new Person("Julia");
        Runnable r4 = new Person("Lisa");
        Runnable r5 = new Person("Anna");

        //Creates a pool with fixed threads, each one representing a vending Beverage machine.
        ExecutorService beverageRoom = Executors.newFixedThreadPool(MAX_BEVERAGE_VENDING_MACHINES);// Executor helper class

        // Passes the tasks to the pool, in this case each task represents different persons preparing his own beverages
        // Only 3 persons are allowed to prepare the beverage simultaneously.
        // If exists more than 3 persons for beverage preparing, they must wait until beverage machines becomes available. 
        beverageRoom.execute(r1);
        beverageRoom.execute(r2);
        beverageRoom.execute(r3);
        
        // Unfortunately they must wait until machines get available.
        beverageRoom.execute(r4);
        beverageRoom.execute(r5);

        // Pool shutdown. Beverage room closed.
        beverageRoom.shutdown();
    }
}

class Person implements Runnable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // Every person need to perform 5 steps in order to get beverage ready.
    // Every operation represents this 5 tasks.
    public void run() {
        try {
            pickMachine();
            Thread.sleep(1000);
            makePayment();
            Thread.sleep(3000);
            selectBeverage();
            Thread.sleep(5000);
            getBeverage();
            Thread.sleep(2000);
            leaveMachine();
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void pickMachine() {
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        System.out.println(name + " pick machine: " + Thread.currentThread().getId() + " at: " + ft.format(d));
    }

    private void makePayment() {
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        System.out.println(name + " is paying beverage at " + ft.format(d) + " on machine: " + Thread.currentThread().getId());
    }

    private void selectBeverage() {
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        System.out.println(name + " is selecting beverage at " + ft.format(d) + " on machine: " + Thread.currentThread().getId());
    }

    private void getBeverage() {
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        System.out.println(name + " is getting beverage at " + ft.format(d) + " on machine: " + Thread.currentThread().getId());
    }

    private void leaveMachine() {
        System.out.println(name + " left the room! Machine: " + Thread.currentThread().getId() + " available now!");
    }
}
