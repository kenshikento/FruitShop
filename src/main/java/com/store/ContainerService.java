package com.store;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ContainerService extends Application
{
    private Set<Class> classes = new HashSet<Class>();

    public ContainerService() {
        classes.add(ShopService.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
}
