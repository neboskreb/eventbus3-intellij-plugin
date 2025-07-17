package org.example;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private EventBus bus;
    private EventBusSubclass subclass;
    private MyBus myBus;

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public void pst1() {
        EventBus.getDefault().post(new Message1());
    }

    public void pst5() {
        subclass
                .post(new Message1());
    }

    public void pst2() {
        bus.post(new Message1());
    }

    public void pst3() {
        myBus.post(new Message1());
    }

    public void pst4() {
        OtherBusImplBase otherBusImplBase = new OtherBusImplBase();
        otherBusImplBase.send(new Message1());
        otherBusImplBase.fake(new Message1(), 42);
    }

    public void pst4_1() {
        Message1 message = new Message1();
        new OtherBusImplBase().send(message);
    }

    public void pst6() {
        OtherBusSubclass otherBusSubclass = new OtherBusSubclass();
        otherBusSubclass.send(new Message1());
        otherBusSubclass.fake(new Message1(), 42);

        otherBusSubclass.send(new Message2(null));
    }

    public void pst7() {
        OtherBusSubclass otherBusSubclass = new OtherBusSubclass();
        Stream.of(new Message1())
                .map(Message2::new)
                .forEach(myBus::post);
    }
}

class ValidReceivers {
    @Subscribe
    public void sub1(Message1 message) {

    }

    @Subscribe
    public void sub2(Message2 message) {

    }

    @Subscribe
    public void sub3(IMessage message) {

    }
}

class InvalidReceivers {
    @Subscribe
    public void inv1() {

    }

    @Subscribe
    public int inv1(Message1 message1) {
        return 42;
    }

    @Subscribe
    private void inv2(Message1 message1) {
    }

    @Subscribe
    public static void inv3(Message1 message1) {
    }
}
