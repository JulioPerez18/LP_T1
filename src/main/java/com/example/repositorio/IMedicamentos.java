package com.example.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelo.Medicamentos;

public interface IMedicamentos extends JpaRepository<Medicamentos, Integer>{
}
