package org.company.pipeline_architecture.client;

import org.company.pipeline_architecture.core.Message;
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

//        Message message = new Message();
//        message.setFileContent(Files.readString(Path.of("src/main/java/org/company/pipeline_architecture/client/order_data.json")));
//
//        List<IFilter<IMessage>> filters = new ArrayList<>();
//        filters.add(new CheckInventoryProcess());
//        filters.add(new CheckDeliveryRatesProcess());
//        filters.add(new CheckPaymentCapacity());
//        Pipeline pipeline = new Pipeline(filters);
//
//        pipeline.processFilters(message);

    }
}