package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;

/**
 * Created by ubuntu-master on 15.11.16.
 */
public class ReportBodyFactory extends AbstractFactory {
    @Override
    ReportElement getReportBody(String reportBody) {
        switch (reportBody){
            case "XML": return new XMLReportBody();
            case "JSON": return new JSONReportBody();
            default: return null;
        }
    }

    @Override
    ReportElement getReportFooter(String reportFooter) {
        return null;
    }

    @Override
    ReportElement getReportHeader(String reporHeader) {
        return null;
    }
}
