package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.TallerCuatro;
import com.example.demo.repository.TallerCuatroRepository;

@Service
@Transactional
public class TallerCuatroService {

	@Autowired
	private TallerCuatroRepository repository;
	
	public ResponseEntity<String> gestionIngresoDatosService(TallerCuatro datosIngreso) {
		String mensaje = "";
		String usuario = datosIngreso.getUsuario();
		String contrasena = datosIngreso.getContrasena();
		System.out.print("Usuario: " + usuario + " Contrasena: " + contrasena);
		Integer resultado = repository.insertarUsuarioSiValido(usuario,contrasena);
		System.out.println(" resultado - " + resultado);
		if (resultado != null && resultado == 1) {
			mensaje = "Inserción exitosa";
		} else {
			mensaje = "Inserción fallida: la contraseña no cumple con los requisitos";
			return new ResponseEntity<>(mensaje,HttpStatus.BAD_REQUEST);

		}
		
		return new ResponseEntity<>(mensaje,HttpStatus.CREATED);
	}
	
	public List<TallerCuatro> obtenerTallerCuatro() {
        return repository.mostrarTallerCuatro();
    }
	
}
