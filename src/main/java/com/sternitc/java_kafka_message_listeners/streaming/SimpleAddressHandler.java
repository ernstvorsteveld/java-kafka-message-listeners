package com.sternitc.java_kafka_message_listeners.streaming;

import com.sternitc.java_kafka_message_listeners.model.Address;
import com.sternitc.java_kafka_message_listeners.model.SimpleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

//@Component
@Slf4j
public class SimpleAddressHandler implements Function<SimpleMessage, Address> {

    @Override
    public Address apply(SimpleMessage input) {
        log.info(String.format("About to handle message %s", input));
        return input.payload();
    }
}

