package com.example.SpringBasic_Study.repository;

import com.example.SpringBasic_Study.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
