package com.exone.ex_one.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CustomerData {
    String customerId;
    String name;
    String email;
}
