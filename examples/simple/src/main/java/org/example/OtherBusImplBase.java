package org.example;

import com.likfe.ideaplugin.eventbus3.Posting;

public class OtherBusImplBase implements IMyOtherBus {

//    @Posting
    @Override
    public void send(Object message) {

    }

//    @Posting
    public void fake(Object message, Integer ignored) {

    }
}
