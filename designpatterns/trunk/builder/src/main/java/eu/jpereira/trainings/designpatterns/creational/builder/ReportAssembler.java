/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.builder;

import java.util.Iterator;

import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.*;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

/**
 * @author jpereira
 * 
 */
public class ReportAssembler {

	private SaleEntry saleEntry;

	/**
	 * @param reportDate
	 */
	public void setSaleEntry(SaleEntry saleEntry) {
		this.saleEntry = saleEntry;

	}

	/**
	 * @param type
	 * @return
	 */
	public Report getReport(String type) {
		Report report = new Report();

		switch (type){
			case "JSON": {
				ReportBody reportBody = new JSONReportBody(saleEntry);
				FormatDirector formatDirector = new FormatDirector(reportBody);
				formatDirector.makeReport();

				report.setReportBody(formatDirector.getReport());
			}
			break;
			case "XML": {
				ReportBody reportBody = new XMLReportBody(saleEntry);
				FormatDirector formatDirector = new FormatDirector(reportBody);
				formatDirector.makeReport();

				report.setReportBody(formatDirector.getReport());
			}
				break;
			case "HTML":{
				ReportBody reportBody = new HTMLReportBody(saleEntry);
				FormatDirector formatDirector = new FormatDirector(reportBody);
				formatDirector.makeReport();

				report.setReportBody(formatDirector.getReport());
			}
		}

		return report;
	}

}
