package com.ilegra.onechoice.service;

import com.ilegra.onechoice.models.Client;
import com.ilegra.onechoice.models.Sell;
import com.ilegra.onechoice.models.Seller;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.util.Objects;

@Service
public class SellDataAnalysisService {
  public void csvToClass(Reader reader) throws IOException {
    String line;
    BufferedReader br = new BufferedReader(reader);
    while (Objects.nonNull(line = br.readLine())) {
      System.out.println(line);
      String[] values = line.split("ç");
      switch (values[0]) {
        case "001" -> {
          Seller seller = new Seller();
          seller.handleParseLineToObject(values);
        }
        case "002" -> {
          Client client = new Client();
          client.handleParseLineToObject(values);
        }
        case "003" -> {
          Sell sell = new Sell();
          sell.handleParseLineToObject(values);
        }
      }
    }
  }

  public void AnalyseFileUploadToBusinessLogicIntoFolder(String folder) throws IOException {
    WatchService watchService = FileSystems.getDefault().newWatchService();
    Path path = Paths.get("in");
    WatchKey watchKey = path.register(
        watchService, StandardWatchEventKinds.ENTRY_CREATE
    );
  }
}
