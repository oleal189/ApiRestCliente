package com.ApiRestCliente.rest;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ApiRestCliente.dao.CienteDAO;
import com.ApiRestCliente.dao.PhoneDAO;
import com.ApiRestCliente.models.Cliente;
import com.ApiRestCliente.models.Phone;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping("clientes")
public class ClienteRest {

	@Autowired
	private CienteDAO clienteDao;

	@PostMapping("/registrarCliente")
	public ResponseEntity<?> registrarCliente(@RequestBody Cliente cli) {
		Cliente cl = new Cliente();
		if (!correoRegistrado(cli.getEmail())) {
			if (validarCorreo(cli.getEmail())) {
				cl = clienteDao.save(cli);
				return ResponseEntity.status(HttpStatus.OK).body(cl);
			} else {
				return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(("{\"error\":\""+"El correo no tiene el formato correcto"+"\"}"));
			}

		} else {
			return  ResponseEntity.status(HttpStatus.FOUND).body(("{\"error\":\""+"El correo ya se encuentra registrado"+"\"}"));
		}
	}

	@GetMapping("/listarCliente")
	public List<Cliente> listarCliente() {
		return clienteDao.findAll();
	}

	@PutMapping("/actualizarCliente")
	public ResponseEntity<?>actualizarCliente(@RequestBody Cliente cli) {
		Cliente cl = new Cliente();

		if (validarCorreo(cli.getEmail())) {
			cl = clienteDao.save(cli);
		} else {
			return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(("{\"error\":\""+"El correo no tiene el formato correcto"+ "\"}"));
		}
		return ResponseEntity.status(HttpStatus.OK).body(cl);

	}

	@DeleteMapping("/eliminarCliente/{id}")
	public void eliminarCliente(@PathVariable("id") Long id) {
		clienteDao.deleteById(id);
	}

	public boolean validarCorreo(String email) {
		Pattern patron = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = patron.matcher(email);
		return matcher.find();
	}

	public boolean correoRegistrado(String email) {
		if (clienteDao.existByEmail(email)!=null ) {
			return true;
		}

		return false;
	}

}
