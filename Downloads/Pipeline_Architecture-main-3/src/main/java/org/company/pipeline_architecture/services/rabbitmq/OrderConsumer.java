package org.company.pipeline_architecture.services.rabbitmq;

import org.company.pipeline_architecture.core.Message;
import org.company.pipeline_architecture.core.entities.IFilter;
import org.company.pipeline_architecture.core.entities.IMessage;
import org.company.pipeline_architecture.pipes.Pipeline;
import org.company.pipeline_architecture.process.read.CheckDeliveryRatesProcess;
import org.company.pipeline_architecture.process.read.CheckInventoryProcess;
import org.company.pipeline_architecture.process.read.CheckPaymentCapacity;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderConsumer {
//    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    @RabbitListener(queues = "Pipeline_Architecture")
    public void receiveMessage(String orderInfo) {

        //Xử lý đơn hàng ở đây (Chạy pipeline)
        Message message = new Message();
        message.setFileContent(orderInfo);

        List<IFilter<IMessage>> filters = new ArrayList<>();
        filters.add(new CheckInventoryProcess());
        filters.add(new CheckDeliveryRatesProcess());
        filters.add(new CheckPaymentCapacity());
        Pipeline pipeline = new Pipeline(filters);

        pipeline.processFilters(message);

    }


}
