package org.company.pipeline_architecture.controller;

import org.company.pipeline_architecture.core.CreditNote;
import org.company.pipeline_architecture.core.Payment;
import org.company.pipeline_architecture.core.PaymentService;
import org.company.pipeline_architecture.core.Product;
import org.company.pipeline_architecture.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductServices productService;


    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "Customer";
    }
    @GetMapping("/order")
    public String order(Model model) {
        
        return "Order";
    }
    private PaymentService paymentService = new PaymentService();

    public String makePayment(CreditNote creditNote, Payment payment) {
        if (paymentService.checkPaymentCapacity(creditNote, payment)) {
            return paymentService.processPayment(payment);
        } else {
            return "Insufficient credit capacity for this payment.";
        }
    }

}
