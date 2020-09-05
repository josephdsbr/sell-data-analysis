package com.ilegra.onechoice;

import com.ilegra.onechoice.service.SellDataAnalysisService;

import java.nio.file.*;
import java.util.Objects;

public class DirectoryWatcher {

  public static void main(String[] args) throws Exception {
    SellDataAnalysisService sellDataAnalysisService = new SellDataAnalysisService();
    WatchService watchService = FileSystems.getDefault().newWatchService();
    String sysPath = System.getProperty("user.home");
    Path path = Paths.get(String.format("%s/in", sysPath));
    path.register(
        watchService,
        StandardWatchEventKinds.ENTRY_CREATE
    );

    WatchKey key;

    while (Objects.nonNull(key = watchService.take())) {
      for (WatchEvent<?> event: key.pollEvents()) {
        if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
          try {
            Thread.sleep(3000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        sellDataAnalysisService.handleStatisticalAnalysis(sysPath, path, event.context().toString());
      }
      key.reset();
    }
  }
}
