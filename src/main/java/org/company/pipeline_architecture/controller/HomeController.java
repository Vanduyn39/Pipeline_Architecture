package org.company.pipeline_architecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.company.pipeline_architecture.core.Payment;
import org.company.pipeline_architecture.core.CreditNote;
import org.company.pipeline_architecture.core.PaymentService;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Chào mừng đến với Spring Boot JSP!");
        return "home"; // Điều hướng đến home.jsp
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
