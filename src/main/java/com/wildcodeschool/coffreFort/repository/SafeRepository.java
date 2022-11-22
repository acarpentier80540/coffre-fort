package com.wildcodeschool.coffreFort.repository;

import org.springframework.stereotype.Repository;

import com.wildcodeschool.coffreFort.entity.Safe;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface SafeRepository extends JpaRepository<Safe, Long> {

}
