package com.example.SpringBasic_Study.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import java.util.List;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // @Table(name = "user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "account")
    private String account;
    private String email;
    private String phoneNumber;
    private String createdBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String updatedBy;
    private LocalDateTime updatedAt;

    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailList;


}
