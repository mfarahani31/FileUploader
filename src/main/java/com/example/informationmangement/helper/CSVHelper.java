package com.example.informationmangement.helper;

import com.example.informationmangement.model.Information;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"code", "source", "codeListCode", "displayValue", "longDescription", "fromDate",
            "toDate", "sortingPriority"};

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType())
                || Objects.requireNonNull(file.getContentType()).equals("application/vnd.ms-excel");
    }

    public static List<Information> csvToInformations(InputStream is) {
        // Todo; refactor deprecated codes
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Information> informationList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            // Todo; refactor set date for fromDate and to Date
            for (CSVRecord csvRecord : csvRecords) {
                Information information = new Information(
                        csvRecord.get("code"),
                        csvRecord.get("source"),
                        csvRecord.get("codeListCode"),
                        csvRecord.get("displayValue"),
                        csvRecord.get("longDescription"),
                        csvRecord.get("fromDate"),
                        csvRecord.get("toDate"),
                        csvRecord.get("sortingPriority"));

                informationList.add(information);
            }

            return informationList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
