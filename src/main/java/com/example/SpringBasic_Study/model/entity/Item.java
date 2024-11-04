package com.example.SpringBasic_Study.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String content;

    //LAZY = 지연 로딩, EAGER = 즉시 로딩 -> 관계는 나중에 선언
    //LAZY = SELECT * FROM item WHERE ID = ?;

    //EAGER =                        -> 관계 있는 애들 즉시 조인해서 다 불러
    //item_id = order_detail.item_id
    //user_id = order_detail.user_id
    //where item.id = ?;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
