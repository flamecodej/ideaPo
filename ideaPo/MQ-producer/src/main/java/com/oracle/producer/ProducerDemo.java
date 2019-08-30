package com.oracle.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ProducerDemo {

    // 定义一个中间件的服务地址
    // tcp安全可靠的 连接协议 udp
    private static final String BROKER_URL = "tcp://192.168.25.129:61616";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        // 定义一个消息  进行消息生产  生产到中间件上
        Topic topic = session.createTopic("My-Topic");
        // 消息 进行设置一个目的地
        MessageProducer messageProducer = session.createProducer(topic);
        // 发布订阅时 消息默认是持久化的   当服务宕机时  消息存储在磁盘上   服务重启时  消息回写到盘内
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);// 不持久化消息
        messageProducer.send(session.createTextMessage("这是一条消息2"));
        messageProducer.close();
        session.close();
        connection.close();
    }
}
