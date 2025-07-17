package org.example;

import com.github.neboskreb.ideaplugin.eventbus3.Posting;

public interface IMyOtherBus {
    @Posting
    void send(Object message);
}
