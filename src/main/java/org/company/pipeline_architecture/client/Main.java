package org.company.pipeline_architecture.client;

import org.company.pipeline_architecture.controller.HomeController;
import org.company.pipeline_architecture.core.CreditNote;
import org.company.pipeline_architecture.core.Message;
import org.company.pipeline_architecture.core.Payment;
import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;
import org.company.pipeline_architecture.pipes.Pipeline;
import org.company.pipeline_architecture.process.read.CheckDeliveryRatesProcess;
import org.company.pipeline_architecture.process.read.CheckInventoryProcess;
import org.company.pipeline_architecture.process.read.CheckPaymentCapacity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        HomeController controller = new HomeController();

        CreditNote creditNote = new CreditNote();
        creditNote.setAvailableCredit(500.0);

        Payment payment = new Payment();
        payment.setAmount(200.0);

        String result = controller.makePayment(creditNote, payment);
        System.out.println(result); // In ra kết quả thanh toán
    }
}