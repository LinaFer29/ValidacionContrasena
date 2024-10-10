package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;




@Entity
@NamedStoredProcedureQuery(
	    name = "insertar_usuario_si_valido",
	    procedureName = "insertar_usuario_si_valido",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "un_usuario", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "una_contrasena", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "resultado", type = Integer.class)
	    }
	)
@Table(name="Taller_Cuatro")
public class TallerCuatro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Taller_Cuatro;
	@Column(name="contrasena")
	private String contrasena;
	@Column(name="usuario")
	private String usuario;
	
	
	public Long getId_Taller_Cuatro() {
		return Id_Taller_Cuatro;
	}
	public void setId_Taller_Cuatro(Long id_Taller_Cuatro) {
		Id_Taller_Cuatro = id_Taller_Cuatro;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
