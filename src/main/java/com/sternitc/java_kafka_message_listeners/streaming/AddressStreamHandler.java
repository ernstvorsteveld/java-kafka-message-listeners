package com.sternitc.java_kafka_message_listeners.streaming;

import com.sternitc.java_kafka_message_listeners.model.Address;
import com.sternitc.java_kafka_message_listeners.model.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Slf4j
public class AddressStreamHandler implements Function<KStream<String, SimpleMessage>, KStream<String, Address>> {

    @Override
    public KStream<String, Address> apply(KStream<String, SimpleMessage> input) {
        return input.map((key, value) -> {
                    log.info(String.format(
                            "About to execute addressSelector for key %s and value %s", key, value));
                    return new KeyValue<>(key, value.payload());
                })
                .map(KeyValue::new);
    }
}
