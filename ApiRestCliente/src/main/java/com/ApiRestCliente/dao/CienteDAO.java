package com.ApiRestCliente.dao;

import com.ApiRestCliente.models.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CienteDAO extends JpaRepository<Cliente,Long> {
	 @Query(value = "SELECT c FROM Cliente c where c.email = ?1")
		Cliente existByEmail(@Param("email")String email);
}
