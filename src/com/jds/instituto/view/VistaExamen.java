package com.jds.instituto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jds.instituto.controller.ControladorCentroEducativo;
import com.jds.instituto.controller.ControladorMateria;
import com.jds.instituto.controller.ControladorNivel;
import com.jds.instituto.model.CentroEducativo;
import com.jds.instituto.model.Materia;
import com.jds.instituto.model.Nivel;
import com.jds.instituto.utils.NoInicioCorrectoException;
import com.jds.instituto.utils.Utils;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaExamen extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;
	private JTextField jtfUrl;
	private JTextField jtfFecha;
	private JComboBox<CentroEducativo> jcbCentro;
	private List<CentroEducativo> centroEducativo;
	private JComboBox<Nivel> jcbNivel;
	private List<Nivel> nivel;
	private JComboBox<Materia> jcbMateria;
	private List<Materia> materia;
	private JCheckBox cbMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaExamen frame = new VistaExamen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaExamen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0 };
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Gestión de materias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Centro");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbCentro = new JComboBox<CentroEducativo>();
		GridBagConstraints gbc_jcbCentro = new GridBagConstraints();
		gbc_jcbCentro.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCentro.gridx = 1;
		gbc_jcbCentro.gridy = 1;
		contentPane.add(jcbCentro, gbc_jcbCentro);

		try {
			centroEducativo = new ArrayList<CentroEducativo>();
			centroEducativo = ControladorCentroEducativo.allRegisters();
			for (int i = 0; i < centroEducativo.size(); i++) {
				jcbCentro.addItem(centroEducativo.get(i));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JButton jbtNiveles = new JButton("Cargar Niveles");
		jbtNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcbNivel.removeAllItems();
				CentroEducativo ce = new CentroEducativo();
				ce = (CentroEducativo) jcbCentro.getSelectedItem();
				try {
					nivel = new ArrayList<Nivel>();
					nivel = ControladorNivel.allRegistersFromCe(ce);
					for (int i = 0; i < nivel.size(); i++) {
						jcbNivel.addItem(nivel.get(i));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_jbtNiveles = new GridBagConstraints();
		gbc_jbtNiveles.insets = new Insets(0, 0, 5, 0);
		gbc_jbtNiveles.gridx = 2;
		gbc_jbtNiveles.gridy = 1;
		contentPane.add(jbtNiveles, gbc_jbtNiveles);

		JLabel lblNewLabel_2 = new JLabel("Nivel");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbNivel = new JComboBox<Nivel>();
		GridBagConstraints gbc_jcbNivel = new GridBagConstraints();
		gbc_jcbNivel.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNivel.gridx = 1;
		gbc_jcbNivel.gridy = 2;
		contentPane.add(jcbNivel, gbc_jcbNivel);

		JButton jbtMaterias = new JButton("Cargar materias");
		jbtMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcbMateria.removeAllItems();
				Nivel n = new Nivel();
				n = (Nivel) jcbNivel.getSelectedItem();

				try {
					materia = new ArrayList<Materia>();
					materia = ControladorMateria.allRegistersFromNivel(n);
					for (int i = 0; i < materia.size(); i++) {
						jcbMateria.addItem(materia.get(i));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_jbtMaterias = new GridBagConstraints();
		gbc_jbtMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_jbtMaterias.gridx = 2;
		gbc_jbtMaterias.gridy = 2;
		contentPane.add(jbtMaterias, gbc_jbtMaterias);

		JLabel lblNewLabel_3 = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		contentPane.add(jcbMateria, gbc_jcbMateria);

		JButton jbtDatos = new JButton("Ver materia");
		jbtDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Materia m = new Materia();
				m = (Materia) jcbMateria.getSelectedItem();
				
				
				jtfId.setText("" + m.getId());
				jtfNombre.setText(m.getNombre());
				jtfCodigo.setText(m.getCodigo());
				jtfUrl.setText(m.getUrlClassroom());
				jtfFecha.setText("" + m.getFechaInicio());
				cbMatricula.setSelected(m.isAdmiteMatricula());
			}
		});
		GridBagConstraints gbc_jbtDatos = new GridBagConstraints();
		gbc_jbtDatos.insets = new Insets(0, 0, 5, 0);
		gbc_jbtDatos.gridx = 2;
		gbc_jbtDatos.gridy = 3;
		contentPane.add(jbtDatos, gbc_jbtDatos);

		JLabel lblNewLabel_4 = new JLabel("Datos de la materia");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 5;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Código");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.gridwidth = 2;
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 7;
		contentPane.add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("URL");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfUrl = new JTextField();
		GridBagConstraints gbc_jtfUrl = new GridBagConstraints();
		gbc_jtfUrl.gridwidth = 2;
		gbc_jtfUrl.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUrl.gridx = 1;
		gbc_jtfUrl.gridy = 8;
		contentPane.add(jtfUrl, gbc_jtfUrl);
		jtfUrl.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Fecha Inicio");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 9;
		contentPane.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		cbMatricula = new JCheckBox("Admite matrícula");
		GridBagConstraints gbc_jcbMatricula = new GridBagConstraints();
		gbc_jcbMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMatricula.gridx = 1;
		gbc_jcbMatricula.gridy = 10;
		contentPane.add(cbMatricula, gbc_jcbMatricula);

		JButton jbtGuardar = new JButton("Guardar");
		jbtGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Materia m = new Materia();

				Materia nivelId = (Materia) jcbMateria.getSelectedItem();
				Date fecha = Utils.parseoFechaEspañol(jtfFecha.getText());
				java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());

				m.setIdNivel(nivelId.getIdNivel());
				m.setId(Integer.parseInt(jtfId.getText()));
				m.setNombre(jtfNombre.getText());
				m.setCodigo(jtfCodigo.getText());
				m.setUrlClassroom(jtfUrl.getText());
				m.setFechaInicio(fechaSql);
				if (cbMatricula.isEnabled() == true) {
					m.setAdmiteMatricula(true);
				} else {
					m.setAdmiteMatricula(false);

				}
				try {
					actualizarRegistro(m);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoInicioCorrectoException e2) {
					JOptionPane.showConfirmDialog(null, "La URL tiene que empezar por https:// o http://");
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(null, "Tienes que introducir 3 letras.");
					e1.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_jbtGuardar = new GridBagConstraints();
		gbc_jbtGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_jbtGuardar.gridx = 1;
		gbc_jbtGuardar.gridy = 11;
		contentPane.add(jbtGuardar, gbc_jbtGuardar);
	}

	public void actualizarRegistro(Materia materia) throws SQLException, Exception, NoInicioCorrectoException {

		String codigo = jtfCodigo.getText();
		String url = jtfUrl.getText();
		int letras = 0;
		for (int i = 0; i < codigo.length(); i++) {

			if (Character.isLetter(codigo.charAt(i)) == true) {
				letras++;
			}
		}
		if (url.startsWith("http:/") == true | url.startsWith("https:/") == true ) {

		}
		else {
			throw new NoInicioCorrectoException();
		}

		if (letras < 3) {
			throw new Exception();
		}

		if (ControladorMateria.updateRegister(materia) != 1) {
			JOptionPane.showConfirmDialog(null, "Algo ha salido mal.");
		} else {
			JOptionPane.showConfirmDialog(null, "Guardado correctamente.");

		}

	}

}
