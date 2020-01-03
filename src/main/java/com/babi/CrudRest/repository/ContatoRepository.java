package com.babi.CrudRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babi.CrudRest.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {} 
