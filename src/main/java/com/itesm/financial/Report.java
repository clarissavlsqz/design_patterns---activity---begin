package com.itesm.financial;

import java.io.IOException;
import java.util.List;
// Report follows OOP "Program to interfaces, not implementations"; we depend on the abstraction of Report to create types of reports
// Report follows Open Closed Principle, as it can be used to extend to other types of reports, but we don't modify our main Report and the other types
// Report follows the Liskov Substitue Principle, both types of report are fully substitutable from the Report interface
// Implementing Template Method Design Pattern
public abstract class Report {
    // createContent will be the same for every object; our template method
    // createContent uses methods that will be different per report
    public String createContent(List<Ride> rides){
        StringBuilder builder = new StringBuilder();
        builder.append(createHeaders("Taxi Report"));
        builder.append(createTableHeaders());
        rides.forEach( ride -> {
            builder.append(addRide(ride));
        });
        builder.append(closeTableHeaders());    

        return builder.toString();
    }
    abstract void createFile(String content) throws IOException;
    abstract String createHeaders(String title);
    abstract String createTableHeaders();
    abstract String closeTableHeaders();
    abstract String addRide(Ride ride);
    abstract String formatAmount(double amount);
}
