package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.json.JSONReportHeader;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.abstractfactory.xml.XMLReportHeader;

/**
 * Created by ubuntu-master on 15.11.16.
 */
public class ReportHeaderFactory extends AbstractFactory{

    @Override
    ReportElement getReportBody(String reportBody) {
        return null;
    }

    @Override
    ReportElement getReportFooter(String reportFooter) {
        return null;
    }

    @Override
    ReportElement getReportHeader(String reportHeader) {
        switch (reportHeader){
            case "XML": return new XMLReportHeader();
            case "JSON": return new JSONReportHeader();
            default: return null;
        }
    }
}
