package com.cheer.huangou.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "tb_specification")
public class Specification {
    @Id
    private Long categoryId;
    private String specifications;
}
