package com.felipe.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.myfancypdfinvoices.service.InvoiceService;
import com.felipe.myfancypdfinvoices.service.UserService;

public class Application {

    public static final InvoiceService invoiceService = new InvoiceService();
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final UserService userService = new UserService();
}
