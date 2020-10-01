package com.felipe.myfancypdfinvoices.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.myfancypdfinvoices.model.Invoice;
import com.felipe.myfancypdfinvoices.service.InvoiceService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyFancyPdfInvoicesServlet extends HttpServlet {
	private InvoiceService invoiceService = new InvoiceService();
	private ObjectMapper objectMapper = new ObjectMapper();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (request.getRequestURI().equalsIgnoreCase("/")) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(
					"<html>\n" +
							"<body>\n" +
							"<h1>Hello World</h1>\n" +
							"<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
							"</body>\n" +
							"</html>");
		}
		else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
			response.setContentType("application/json; charset=UTF-8");
			List<Invoice> invoices = this.invoiceService.findAll();
			response.getWriter().print(this.objectMapper.writeValueAsString(invoices));
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(request.getRequestURI().equalsIgnoreCase("/invoices")) {
			String userId = request.getParameter("user_id");
			Integer amount = Integer.valueOf(request.getParameter("amount"));

			Invoice invoice = this.invoiceService.create(userId, amount);

			response.setContentType("application/json; charset=UTF-8");
			String json = this.objectMapper.writeValueAsString(invoice);

			response.getWriter().print(json);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
