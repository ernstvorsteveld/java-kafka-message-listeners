package com.sternitc.java_kafka_message_listeners.model;

import lombok.Data;

@Data
public class Address {
    private String street;
    private int number;
    private String postalCode;
    private String city;
}
