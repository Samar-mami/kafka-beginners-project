//package io.conduktor.demos.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class KafkaProducerDemo {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducerDemo.class.getSimpleName());

    public static void main(String[] args) {
        log.info("Hello");

        // create producer properties
        Properties properties = new Properties();

        // connect to conduktor playground
        properties.setProperty("bootstrap.servers","localhost:9092");
        //properties.setProperty("security.protocol", "SASL_SSL");
        //properties.setProperty("sasl.mechanism", "PLAIN");
        //properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required " +
        //         "username=\"6y2HjFiKZn2y0vnIZqUOlF\" password=\"" +
        //        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY29uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjpudWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiI2eTJIakZpS1puMnkwdm5JWnFVT2xGIiwib3JnYW5pemF0aW9uSWQiOjc1MjE3LCJ1c2VySWQiOjg3NTE3LCJmb3JFeHBpcmF0aW9uQ2hlY2siOiJjMzg2ZWM1My1mYjBhLTQyMjktOWMwMy1hODc0ZGQ3OGUxMWUifX0.T52rrnst9LMWm3UwjlS6Yg1Sto0xTGP8mN55xI2-pIk\";");


        // set producer properties
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // create the Producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // create a Producer Record
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("demo_java", "helloooo world I am a Kafka producer ");

        // send data
        producer.send(producerRecord);

        // tell the producer to send all data and block until done -- synchronous
        producer.flush();

        // flush and close the producer
        producer.close();
    }
}