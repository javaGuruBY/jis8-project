package com.tutrit.registerservice.config;

import com.tutrit.register.gateway.GateWayEntity;

import java.nio.file.Path;

public class Storage {
    //TODO куда сохранять? переписать Path
    public static final Path pathStorage = Path.of("data");

    public static String getExtension(GateWayEntity entity) {
        return "." + entity.getClass().getSimpleName().toLowerCase();
    }
}
