/*
 * Copyright © 2014 Typesafe, Inc. All rights reserved.
 */

package com.typesafe.training.coffeehouse;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class Guest extends AbstractLoggingActor{

    public Guest(){

        receive(ReceiveBuilder.
                matchAny(this::unhandled).build()
        );
    }

    public static Props props(){
        return Props.create(Guest.class, Guest::new);
    }
}
