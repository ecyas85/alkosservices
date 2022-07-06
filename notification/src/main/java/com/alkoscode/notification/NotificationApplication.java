package com.alkoscode.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {
        "com.alkoscode.notification",
        "com.alkoscode.amqp"})
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(final RabbitMQMessageProducer producer, final NotificationConfig config) {
//        return args ->
//            producer.publish(
//                    config.getInternalExchange(),
//                    config.getInternalNotificationRoutingKey(),
//                    new Person("Obi-Wan", 33)
//                    );
//    }
//
//    record Person(String name, int age){}
}
