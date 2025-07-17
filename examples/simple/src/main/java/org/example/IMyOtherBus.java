package org.example;

import com.likfe.ideaplugin.eventbus3.Posting;

public interface IMyOtherBus {
    @Posting
    void send(Object message);
}
