package org.example.entity;

import io.micrometer.core.instrument.Tags;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MyMeter {

    private String name;
    private Tags tags;
    private double value;

}
