package com.itesm.financial;
// Implementing the SimpleFactory Design Pattern
public class ReportFactory {
    public static Report createReport(String type) {
        switch(type) {
            case "WebReport":
                return new WebReport();
            case "PrintReport":
                return new PrintReport();
            default:
                throw new IllegalArgumentException("Report type unknown");

        }
    }
}
