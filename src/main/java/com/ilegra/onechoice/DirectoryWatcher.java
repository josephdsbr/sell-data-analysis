package com.ilegra.onechoice;

import com.ilegra.onechoice.service.SellDataAnalysisService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.util.Objects;

@Async
@Component
public class DirectoryWatcher {

  public static void main(String[] args) throws InterruptedException, IOException {
    SellDataAnalysisService sellDataAnalysisService = new SellDataAnalysisService();
    WatchService watchService = FileSystems.getDefault().newWatchService();

    Path path = Paths.get(String.format("%s/in", System.getProperty("user.home")));

    path.register(
        watchService,
        StandardWatchEventKinds.ENTRY_CREATE
    );

    WatchKey key;

    while (Objects.nonNull(key = watchService.take())) {
      for (WatchEvent<?> event: key.pollEvents()) {
        System.out.printf("Event kind: %s. File effected %s%n", event.kind(), event.context());
        Path filePath = Paths.get(String.valueOf(path), event.context().toString());
        Reader reader = Files.newBufferedReader(filePath);
        sellDataAnalysisService.csvToClass(reader);
      }
      key.reset();
    }
  }
}
