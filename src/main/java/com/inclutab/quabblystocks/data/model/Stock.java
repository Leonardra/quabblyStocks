package com.inclutab.quabblystocks.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Stock {
    @Id
    private Long id;
    private String name;
    private Double price;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
