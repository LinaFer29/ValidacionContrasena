package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TallerCuatro;

@Repository
public interface TallerCuatroRepository extends JpaRepository<TallerCuatro, Long>, TallerCuatroRepositoryCustom{
	
	 @Procedure(name = "insertar_usuario_si_valido")
	 int insertarUsuarioSiValido(@Param("un_usuario") String usuario, @Param("una_contrasena") String contrasena);

}