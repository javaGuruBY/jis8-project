package com.tutrit.registerservice.config;

import java.nio.file.Path;

public class Storage {
  public static final Path slotStorage = Path.of("data", "slots");
  public static final String extension = ".slot";
}
