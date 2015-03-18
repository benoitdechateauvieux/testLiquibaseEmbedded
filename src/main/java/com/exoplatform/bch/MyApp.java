package com.exoplatform.bch;

import com.exoplatform.bch.db.MyService;
import org.jboss.resteasy.core.Dispatcher;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bdechateauvieux on 3/18/15.
 */
public class MyApp extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public MyApp(@Context Dispatcher dispatcher) {
        singletons.add(new MyService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
