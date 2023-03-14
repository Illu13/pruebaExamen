package com.jds.instituto.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jds.instituto.model.Materia;
import com.jds.instituto.model.Nivel;
import com.jds.instituto.utils.ConnectionManager;

public class ControladorMateria {

	public static List<Materia> allRegistersFromNivel(Nivel n) throws SQLException {

		int idNivel = n.getId();
		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from nivelesymaterias.materia where idNivel = " + idNivel);

		List<Materia> materia = new ArrayList<Materia>();

		while (rs.next()) {
			Materia m = new Materia();
			m.setId(rs.getInt(1));
			m.setNombre(rs.getString(2));
			m.setIdNivel(rs.getInt(3));
			m.setCodigo(rs.getString(4));
			m.setUrlClassroom(rs.getString(5));
			m.setAdmiteMatricula(rs.getBoolean(6));
			m.setFechaInicio(rs.getDate(7));
			materia.add(m);
		}

		conn.close();
		rs.close();
		s.close();
		return materia;
	}
	
	public static int updateRegister(Materia m) throws SQLException {

		Connection conn = ConnectionManager.getConexion();

		int idActual = m.getId();

		PreparedStatement ps = conn
				.prepareStatement("update nivelesymaterias.materia set nombre = ?, idNivel = ?, "
						+ "codigo = ?, urlClassroom = ?, fechaInicio = ? where id = " + idActual);
		ps.setString(1, m.getNombre());
		ps.setInt(2, m.getIdNivel());
		ps.setString(3, m.getCodigo());
		ps.setString(4, m.getUrlClassroom());
		ps.setDate(5, m.getFechaInicio());

		int filasAlteradas = ps.executeUpdate();

		conn.close();
		ps.close();
		return filasAlteradas;
	}
	

	
	

}
