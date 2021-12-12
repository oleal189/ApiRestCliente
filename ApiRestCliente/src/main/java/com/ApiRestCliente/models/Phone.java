package com.ApiRestCliente.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "phones")
public class Phone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPhone;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "FK_phones")
    private Cliente cliente;
	
	@Column
	private String numbers;
	
	@Column
	private String citycode;
	
	@Column
	private String contrycode;

	public Long getIdPhone() {
		return idPhone;
	}
   
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setIdPhone(Long idPhone) {
		this.idPhone = idPhone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	

}
