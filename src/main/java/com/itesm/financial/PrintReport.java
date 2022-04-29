package com.itesm.financial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// PrintReport follows Single Responsiblity Principle as its only focus is to create print format reports
public class PrintReport extends Report {
    @Override
    public void createFile(String content) throws IOException {
        FileWriter fileWriter = new FileWriter("financial-report.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    @Override
    String createHeaders(String title){
        return title + '\n';
    }

    @Override
    String createTableHeaders() {
        return      "TaxiID" +
                    String.format("%" + 30 + "s", "Pickup time") +
                    String.format("%" + 40 + "s", "Dropoff time") +
                    String.format("%" + 30 + "s", "Passenger count") +
                    String.format("%" + 20 + "s", "Trip Distance") +
                    String.format("%" + 20 + "s", "Total amount\n");
    }

    @Override
    String closeTableHeaders() {
        return "";
    }

    @Override
    String addRide(Ride ride) {
        return  String.format("%-" + 15 + "s", ride.getTaxiId()) +
                String.format("%" + 30 + "s", ride.getPickUpTime()) +
                String.format("%" + 40 + "s", ride.getDropOffTime()) +
                String.format("%" + 20 + "s", ride.getPassengerCount()) +
                String.format("%" + 20 + "s", ride.getTripDistance()) +
                String.format("%" + 20 + "s", formatAmount(ride.getTollsAmount())) +
                "\n\n";
    }

    @Override
    String formatAmount(double amount) {
        if(amount < 0) {
            return "(" + amount + ")";
        }
        return Double.toString(amount);
    }
}
