package org.example;

import org.greenrobot.eventbus.Subscribe;

public class OtherBusSubclass extends OtherBusImplBase {

//    @Override
//    public void send(Object message) {
//        super.send(message);
//    }


    @Subscribe
    public void sub(Object message) {

    }
}
