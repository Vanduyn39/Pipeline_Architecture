package org.company.pipeline_architecture.core;

import org.company.pipeline_architecture.core.entities.IMessage;

public class Message implements IMessage {
    private InvoiceInfo invoiceInfo;
    private String fileContent;

    @Override
    public InvoiceInfo getInvoiceInfo() {
        return invoiceInfo;
    }

    @Override
    public void setInvoiceInfo(InvoiceInfo invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    @Override
    public String getFileContent() {
        return fileContent;
    }

    @Override
    public void setFileContent(String content) {
        this.fileContent = content;
    }
}
