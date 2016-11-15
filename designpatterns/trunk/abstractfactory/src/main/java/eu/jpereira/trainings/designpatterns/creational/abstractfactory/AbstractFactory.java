package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

/**
 * Created by ubuntu-master on 15.11.16.
 */
public abstract class AbstractFactory {
    abstract ReportElement getReportBody(String reportBody);
    abstract ReportElement getReportFooter(String reportFooter);
    abstract ReportElement getReportHeader(String reporHeader);
}
