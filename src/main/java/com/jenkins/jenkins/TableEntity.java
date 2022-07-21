package com.jenkins.jenkins;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class TableEntity {

    @Id
    private Long id;
    private String name;
    private String color;
}
