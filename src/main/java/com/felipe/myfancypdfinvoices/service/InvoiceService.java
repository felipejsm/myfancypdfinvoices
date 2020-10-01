package com.felipe.myfancypdfinvoices.service;

import com.felipe.myfancypdfinvoices.context.Application;
import com.felipe.myfancypdfinvoices.model.Invoice;
import com.felipe.myfancypdfinvoices.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = Application.userService.findById(userId);
        if(user == null) {
            throw new IllegalStateException();
        }
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }
}
