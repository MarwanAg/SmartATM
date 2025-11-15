package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionFileManager {

    private static final String FILE_PATH = "database/transactions.json";

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .setPrettyPrinting()
            .create();

    public static void saveTransactionsToFile(List<Transaction> transactions){
        try{
            Files.createDirectories(Paths.get("database"));

            FileWriter writer = new FileWriter(FILE_PATH);
            gson.toJson(transactions, writer);
            writer.close();
        }catch (IOException e){
            System.out.println("Error saving transactions: " + e.getMessage());
        }
    }

}
