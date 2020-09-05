package com.ilegra.onechoice.service;

import com.ilegra.onechoice.models.*;
import com.ilegra.onechoice.models.enums.FileIdentificationEnum;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Objects;

public class SellDataAnalysisService {
  public void handleStatisticalAnalysis(String sysPath, Path path, String filename) throws Exception {
    Path filePath = Paths.get(String.valueOf(path), filename);
    Files.newBufferedReader(filePath).close();
    Reader reader = Files.newBufferedReader(filePath);
    String line;
    BufferedReader br = new BufferedReader(reader);
    OperationPurchase operationPurchase = new OperationPurchase();
    while (Objects.nonNull(line = br.readLine())) {
      String[] values = line.split("ç");
      String code = values[0];

      if (code.equals(FileIdentificationEnum.CLIENT.getCode())) {
        Client client = new Client();
        client.handleParseLineToObject(values);
        operationPurchase.addClientToOperation(client);
      }
      else if (code.equals(FileIdentificationEnum.SELLER.getCode())) {
        Seller seller = new Seller();
        seller.handleParseLineToObject(values);
        operationPurchase.addSellerToOperation(seller);
      }
      else if (code.equals(FileIdentificationEnum.SELL.getCode())) {
        Sell sell = new Sell();
        sell.handleParseLineToObject(values);
        operationPurchase.addSellsToOperation(sell);
      }
    }

    OperationStatistics operationStatistics = operationPurchase.getSellsRevenueByFile();
    this.writeStatisticsToCSV(operationStatistics, sysPath);
  }

  public void writeStatisticsToCSV(OperationStatistics operationStatistics, String sysPath) throws IOException {
    Path path = Paths.get(String.format("%s/out", sysPath));
    String filename = this.filenameGenerator();
    String filePath = String.format("%s/%s", path, filename);
    FileWriter serializedCsvPath = new FileWriter(filePath);
    CSVWriter csvWriter = new CSVWriter(serializedCsvPath,
        CSVWriter.DEFAULT_SEPARATOR,
        CSVWriter.NO_QUOTE_CHARACTER,
        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
        CSVWriter.DEFAULT_LINE_END
        );
    csvWriter.writeNext(operationStatistics.convertToCSVFormat());
    csvWriter.close();
  }

  public String filenameGenerator() {
    var prefix = "statistical-result";
    var time = Instant.now().getEpochSecond();
    return String.format("%s-%s.csv", prefix, time);
  }
}
