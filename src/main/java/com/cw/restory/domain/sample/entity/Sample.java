package com.cw.restory.domain.sample.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sample {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sample_id")
    private Long id;
    private Integer a;
    private Integer b;
    private Integer sum;

    public void sum(){
        this.sum = this.a + this.b;
    }
    @Builder
    public Sample(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }
}

