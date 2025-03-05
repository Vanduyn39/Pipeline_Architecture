package org.company.pipeline_architecture.controller;

import org.company.pipeline_architecture.core.CreditNote;
import org.company.pipeline_architecture.core.Payment;
import org.company.pipeline_architecture.core.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        
        return "Customer"; // Trả về file index.html trong thư mục templates
    }
    @GetMapping("/order")
    public String order(Model model) {
        
        return "Order"; // Trả về file index.html trong thư mục templates
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
