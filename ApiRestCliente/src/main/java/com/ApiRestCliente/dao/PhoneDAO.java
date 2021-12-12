package com.ApiRestCliente.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiRestCliente.models.Phone;

public interface PhoneDAO extends JpaRepository<Phone,Long>{

}
