package com.tutrit.registerservice.config;

import com.tutrit.registerservice.bean.Entity;

import java.nio.file.Path;

public class Storage {
  //TODO куда сохранять? переписать Path
  public static final Path pathStorage = Path.of("data");

  public static String getExtension(Entity entity) {
    return "." + entity.getClass().getSimpleName().toLowerCase();
  }
}
