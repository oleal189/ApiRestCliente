package com.ApiRestCliente.rest;

import java.util.List;



import com.ApiRestCliente.dao.PhoneDAO;
import com.ApiRestCliente.models.Phone;


public class PhoneRest {

	
	private PhoneDAO phoneDao;


	public void registrarPhone(Phone pho) {
		phoneDao.save(pho);
	}


	public List<Phone> listarPhones() {
		return phoneDao.findAll();
	}


	public void actualizarCliente(Phone pho) {
		phoneDao.save(pho);
	}


	public void eliminarPhone(Long id) {
		phoneDao.deleteById(id);
	}

}
