package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TallerCuatro;
import com.example.demo.services.TallerCuatroService;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class TallerCuatroController {
	@Autowired
	private TallerCuatroService services;
	
	@PostMapping("/tc/ingresar")
	private ResponseEntity<String> gestionIngresoDatosController(@RequestBody TallerCuatro datosIngreso){
		return services.gestionIngresoDatosService(datosIngreso);
	}
	
	@GetMapping("/mostrar")
    public ResponseEntity<List<TallerCuatro>> mostrarTallerCuatro() {
        List<TallerCuatro> talleres = services.obtenerTallerCuatro();
        System.out.print(talleres.isEmpty());
        return new ResponseEntity<>(talleres, HttpStatus.OK);
    }
	
}
