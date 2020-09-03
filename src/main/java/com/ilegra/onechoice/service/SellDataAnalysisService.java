package com.ilegra.onechoice.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SellDataAnalysisService {
  public void csvToClass(Path path) throws IOException {
    List<List<String>> records = new ArrayList<>();

  }

  public void AnalyseFileUploadToBusinessLogicIntoFolder(String folder) throws IOException {
    WatchService watchService = FileSystems.getDefault().newWatchService();
    Path path = Paths.get("in");
    WatchKey watchKey = path.register(
        watchService, StandardWatchEventKinds.ENTRY_CREATE
    );
  }
}
