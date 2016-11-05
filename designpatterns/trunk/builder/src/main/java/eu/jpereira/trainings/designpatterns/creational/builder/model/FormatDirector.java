package eu.jpereira.trainings.designpatterns.creational.builder.model;

/**
 * Created by ubuntu-master on 31.10.16.
 */
public class FormatDirector {
    private ReportBody reportBody;

    public FormatDirector(ReportBody reportBody){
        this.reportBody = reportBody;
    }

    public void makeReport(){
        reportBody.addCustomer();
        reportBody.addItems();
    }

    public ReportBody getReport(){
        return reportBody;
    }
}
