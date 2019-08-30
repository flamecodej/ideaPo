package com.oracle.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerDemo {

    private static final String BROKER_URL = "tcp://192.168.25.129:61616";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("c1");
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        // 定义一个消息  进行消息生产  生产到中间件上
        Topic topic = session.createTopic("My-Topic");
        // 消息 进行设置一个目的地
        // 订阅一个Topic主题
        //MessageConsumer consumer = session.createConsumer(topic);
        MessageConsumer consumer = session.createDurableSubscriber(topic,"abcd");
        // 这是一个消息的监听 当有消息 时  进行  消息的获取  并不影响 其他的  运行
        // MQ的作用  就是应用解耦 在为  其他的一些服务  做出快速反应
        // 当一个 与系统业务 中不是非核心的操作 时  可以将 一些操作 扔进 MQ中 ，
        // 在MQ进行消息感知  做出处理  不能影响  这个MQ消费犯规的一些其他操作
        /*consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });*/
        TextMessage message = (TextMessage) consumer.receive();
        System.out.println(123);
        System.out.println(message.getText());
    }


}
