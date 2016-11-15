package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportFooter;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportFooter;

/**
 * Created by ubuntu-master on 15.11.16.
 */
public class ReportFooterFactory extends AbstractFactory {
    @Override
    ReportElement getReportBody(String reportBody) {
        return null;
    }

    @Override
    ReportElement getReportFooter(String reportFooter) {
        switch (reportFooter){
            case "XML": return new XMLReportFooter();
            case "JSON": return new JSONReportFooter();
            default: return null;
        }
    }

    @Override
    ReportElement getReportHeader(String reporHeader) {
        return null;
    }
}
