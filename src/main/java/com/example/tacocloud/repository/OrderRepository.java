package com.example.tacocloud.repository;

import com.example.tacocloud.domain.Taco;
import com.example.tacocloud.domain.TacoOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

//    @Query
//    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
