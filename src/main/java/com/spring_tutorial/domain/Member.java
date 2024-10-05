package com.spring_tutorial.domain;

import lombok.*;



@Data
@Builder
public class Member {
    private Long id;
    private  String name;
}
