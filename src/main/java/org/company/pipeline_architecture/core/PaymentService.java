// services/PaymentService.java
package org.company.pipeline_architecture.core;

import org.company.pipeline_architecture.core.Payment;
import org.company.pipeline_architecture.core.CreditNote;

public class PaymentService {

    public boolean checkPaymentCapacity(CreditNote creditNote, Payment payment) {
        // Kiểm tra nếu số tiền thanh toán không vượt quá số tiền tín dụng khả dụng
        return payment.getAmount() <= creditNote.getAvailableCredit();
    }

    public String processPayment(Payment payment) {
        // Giả sử thanh toán diễn ra thành công
        // Trong thực tế, bạn sẽ cần thực hiện các bước khác như cập nhật trạng thái thanh toán
        return "Payment of " + payment.getAmount() + " processed successfully.";
    }
}