package com.jds.instituto.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jds.instituto.model.CentroEducativo;
import com.jds.instituto.model.Nivel;
import com.jds.instituto.utils.ConnectionManager;

public class ControladorNivel {

	public static List<Nivel> allRegistersFromCe(CentroEducativo ce) throws SQLException {

		int idCentro = ce.getId();
		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from nivelesymaterias.nivel where idCentro = " + idCentro);

		List<Nivel> nivel = new ArrayList<Nivel>();

		while (rs.next()) {
			Nivel n = new Nivel();
			n.setId(rs.getInt(1));
			n.setDescripcion(rs.getString(2));
			nivel.add(n);
		}

		conn.close();
		rs.close();
		s.close();
		return nivel;
	}

}
