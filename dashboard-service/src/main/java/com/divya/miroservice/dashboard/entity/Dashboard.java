package com.divya.miroservice.dashboard.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Immutable
@Table(name="dashboard")
public class Dashboard implements Serializable {
@Id
@Column(name="name",updatable = false,nullable = false)
    private String studentName;
@Column(name="total",updatable = false,nullable = false)
    private int total;

}
