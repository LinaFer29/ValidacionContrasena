package com.example.demo.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TallerCuatro;

import oracle.jdbc.OracleTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TallerCuatroRepositoryImpl implements TallerCuatroRepositoryCustom {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Override
	    public List<TallerCuatro> mostrarTallerCuatro() {
	        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
	            .withProcedureName("mostrar_taller_cuatro")
	            .declareParameters(new SqlOutParameter("cur_out", OracleTypes.CURSOR, (rs, rowNum) -> {
	                TallerCuatro taller = new TallerCuatro();
	                taller.setId_Taller_Cuatro(rs.getLong("id_taller_cuatro"));
	                taller.setUsuario(rs.getString("usuario"));
	                taller.setContrasena(rs.getString("contrasena"));
	                return taller;
	            }));

	        Map<String, Object> result = jdbcCall.execute();
	        List<TallerCuatro> talleres = (List<TallerCuatro>) result.get("cur_out");

	        return talleres != null ? talleres : new ArrayList<>();
	    }
}
