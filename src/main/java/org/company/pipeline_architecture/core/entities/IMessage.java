package org.company.pipeline_architecture.core.entities;
import org.company.pipeline_architecture.core.InvoiceInfo;


public interface IMessage {
    InvoiceInfo getInvoiceInfo();
    void setInvoiceInfo(InvoiceInfo invoiceInfo);
    String getFileContent();
    void setFileContent(String content);
}


