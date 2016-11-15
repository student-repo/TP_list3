package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.*;

/**
 * Created by ubuntu-master on 15.11.16.
 */
public class DefaultBookstoreFacade implements BookstoreFacade {

    CustomerDBService customerService;
 	BookDBService bookService;
 	OrderingService orderingService;
 	WharehouseService warehouseService;
    CustomerNotificationService customerNotificationService;

    @Override
    public void placeOrder(String customerId, String isbn) {

        Book book = bookService.findBookByISBN(isbn);
        Customer customer = customerService.findCustomerById(customerId);
        Order order = orderingService.createOrder(customer, book);
        customerNotificationService.notifyClient(order);
        DispatchReceipt dispatchReceipt = warehouseService.dispatch(order);
        customerNotificationService.notifyClient(dispatchReceipt);
    }

    @Override
    public void setCustomerService(CustomerDBService customerService) {

        this.customerService = customerService;
    }

    @Override
    public void setWarehouseService(WharehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Override
    public void setBookService(BookDBService bookDBService) {

        this.bookService = bookDBService;
    }

    @Override
    public void setBookService(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    @Override
    public void setNotificationService(CustomerNotificationService customerNotificationService) {
        this.customerNotificationService = customerNotificationService;
    }
}
