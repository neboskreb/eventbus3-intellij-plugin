package org.example;

import com.likfe.ideaplugin.eventbus3.Posting;

@Posting
public interface IMyBus {
    void post(Object message);
}
