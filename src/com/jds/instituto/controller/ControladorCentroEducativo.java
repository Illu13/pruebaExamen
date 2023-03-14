package com.jds.instituto.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jds.instituto.model.CentroEducativo;
import com.jds.instituto.utils.ConnectionManager;

public class ControladorCentroEducativo {

	public static List<CentroEducativo> allRegisters() throws SQLException {

		Connection conn = ConnectionManager.getConexion();
		Statement s = (Statement) conn.createStatement();
		ResultSet rs = s.executeQuery("select * from nivelesymaterias.centroeducativo");

		List<CentroEducativo> centrosEducativos = new ArrayList<CentroEducativo>();

		while (rs.next()) {
			CentroEducativo ce = new CentroEducativo();
			ce.setId(rs.getInt(1));
			ce.setDescripcion(rs.getString(2));
			centrosEducativos.add(ce);
		}

		conn.close();
		rs.close();
		s.close();
		return centrosEducativos;
	}

}
