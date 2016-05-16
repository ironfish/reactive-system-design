/**
 * Copyright © 2014, 2015 Typesafe, Inc. All rights reserved. [http://www.typesafe.com]
 */

package com.typesafe.training.coffeehouse;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class CoffeeHouse extends AbstractLoggingActor{

    public CoffeeHouse(){
        log().debug("CoffeeHouse Open");

        receive(ReceiveBuilder.
                match(CreateGuest.class, createGuest ->
                        createGuest()
                ).
                matchAny(this::unhandled).build()
        );
    }

    public static Props props(){
        return Props.create(CoffeeHouse.class, CoffeeHouse::new);
    }

    protected void createGuest(){
        context().actorOf(Guest.props());
    }

    public static final class CreateGuest{

        public static final CreateGuest Instance =
            new CreateGuest();

        private CreateGuest(){
        }
    }
}
