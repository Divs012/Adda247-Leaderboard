package com.divya.miroservice.dashboard.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

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
@Subselect("select * from dashboard")
public class Dashboard implements Serializable {
@Id
@Column(name="email")
    private  String email;
@Column(name="student_name",updatable = false,nullable = false)
    private String studentName;
@Column(name="total",updatable = false,nullable = false)
    private int total;

}
