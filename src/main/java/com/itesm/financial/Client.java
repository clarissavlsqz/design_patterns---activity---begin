package com.itesm.financial;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final String CSV_FILENAME = "taxi-data.csv";

    public static void main(String[] args) throws Exception {
        System.out.println("Financial Report Generation");

        List<Ride> result = new ArrayList<>();

        ParserFacade parserFacade = new ParserFacade();
        result = parserFacade.generateResult(result, CSV_FILENAME);

        // WebReport webReport = new WebReport();
        // String htmlReport = webReport.createContent(result);
        // // System.out.println(htmlReport);
        // webReport.createFile(htmlReport);

        Report report = ReportFactory.createReport("PrintReport");
        String textReport = report.createContent(result);
        report.createFile(textReport);
        

    }
}
