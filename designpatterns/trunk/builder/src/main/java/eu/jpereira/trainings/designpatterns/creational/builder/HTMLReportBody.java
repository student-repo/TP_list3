package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.Iterator;

public class HTMLReportBody implements ReportBody {

	public HTMLReportBody(SaleEntry saleEntry){
		this.saleEntry = saleEntry;
	}

	private StringBuilder stringBuilder = new StringBuilder();
	private SaleEntry saleEntry = new SaleEntry();


//	@Override
//	public Object getAsString() {
//		return this.stringBuilder.toString();
//	}

	@Override
	public void addCustomer() {
		stringBuilder.append("<span class=\"customerName\">");
		stringBuilder.append(this.saleEntry.getCustomer().getName());
		stringBuilder.append("</span><span class=\"customerPhone\">");
		stringBuilder.append(this.saleEntry.getCustomer().getPhone());
		stringBuilder.append("</span>");

		stringBuilder.append("<items>");
	}

	@Override
	public void addItems() {
		Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
		while ( it.hasNext() ) {
			SoldItem soldEntry= it.next();
			stringBuilder.append("<item><name>");
			stringBuilder.append(soldEntry.getName());
			stringBuilder.append("</name><quantity>");
			stringBuilder.append(soldEntry.getQuantity());
			stringBuilder.append("</quantity><price>");
			stringBuilder.append(soldEntry.getUnitPrice());
			stringBuilder.append("</price></item>");
		}
		stringBuilder.append("</items>");
	}

	@Override
	public String getReport() {
		return this.stringBuilder.toString();
	}

}
