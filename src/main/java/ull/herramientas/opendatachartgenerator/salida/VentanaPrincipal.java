package ull.herramientas.opendatachartgenerator.salida;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import ull.herramientas.opendatachartgenerator.Dataset;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;


/**
 * \class Ventana principal de la aplicación
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class VentanaPrincipal {

	private JFrame frame;
	private final static Logger mlogConsola = Logger.getLogger(VentanaPrincipal.class.getName());
	private JFileChooser ficheroExaminar;
	/**
	 * \brief Lanza la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					mlogConsola.log(Level.INFO,"Error", e);
				}
			}
		});
	}

	/**
	 * \brief Crea la aplicación.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * \brief Inicializa los contenidos del frame.
	 */
	private void initialize() {
		
		//ficheroExaminar = new JFileChooser();
		//ficheroExaminar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		
		//Creación de ventana
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Creación de radio botón de conjunto de datos de población de Barrios de Santa Cruz de Tenerife
		JRadioButton rdbtnCsv = new JRadioButton(".csv");
		rdbtnCsv.setBounds(120, 85, 67, 23);
		frame.getContentPane().add(rdbtnCsv);

		JRadioButton rdbtntxt = new JRadioButton(".txt");
		//rdbtntxt.setBounds(196, 143, 67, 23);
		rdbtntxt.setBounds(200, 85, 63, 23);
		frame.getContentPane().add(rdbtntxt);

		JRadioButton rdbtnxls = new JRadioButton(".xls");
		rdbtnxls.setBounds(270, 85, 63, 23);
		frame.getContentPane().add(rdbtnxls);
		
		JTextField cuadro_texto = new JTextField();
		cuadro_texto.setBounds(100,143,250,30);
		frame.getContentPane().add(cuadro_texto);
		
		rdbtnCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtntxt.isSelected())
				{
					rdbtntxt.setSelected(false);
					rdbtnxls.setSelected(false);
				}
			}
		});

		rdbtntxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnCsv.isSelected())
				{
					rdbtnCsv.setSelected(false);
					rdbtnxls.setSelected(false);
				}
			}
		});

		rdbtnxls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnxls.isSelected())
				{
					rdbtntxt.setSelected(false);
					rdbtnCsv.setSelected(false);
				}
			}
		});

        //Creación de título de aplicación
		JLabel lblOpenDataChart = new JLabel("Open Data Chart Generator");
		lblOpenDataChart.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblOpenDataChart.setBounds(57, 23, 357, 28);
		frame.getContentPane().add(lblOpenDataChart);
		
		JLabel texto1 = new JLabel("Indique el tipo de archivo:");
		texto1.setFont(new Font("Algerian", Font.BOLD, 14));
		texto1.setBounds(120, 55, 357, 28);
		frame.getContentPane().add(texto1);
		
		JLabel texto2 = new JLabel("Introduzcala url del archivo:");
		texto2.setFont(new Font("Algerian", Font.BOLD, 14));
		texto2.setBounds(120, 110, 357, 28);
		frame.getContentPane().add(texto2);
		
		//int t_selecion =ficheroExaminar.showSaveDialog(getContentPane());
		//JComboBox comboBox = new JComboBox();
		//comboBox.setBounds(77, 94, 302, 20);
		//frame.getContentPane().add(comboBox);

		//DefaultComboBoxModel datasets = new DefaultComboBoxModel();
		//datasets.addElement("Población de barrios de Santa Cruz de Tenerife");
		//comboBox.setModel(datasets);


        //Creación de botón para procesar el conjunto de datos seleccionado
		JButton btnProcesarConjuntoDe = new JButton("Procesar conjunto de datos");
		btnProcesarConjuntoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dataset dataset = null;
				try {
					String urlDataset = "";
					urlDataset = cuadro_texto.getText();
					//if (comboBox.getSelectedIndex() == 0)
					if(true)
					{
						if (rdbtnCsv.isSelected())
						{
							//urlDataset = "http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/ee814891-ba52-4e7c-b9e6-017c1bc43b6b/download/barrios.csv";
							dataset = new Dataset(urlDataset,0);
						}
						else if (rdbtntxt.isSelected())
						{
							//urlDataset = "https://rawgit.com/alu0100773408/OpenDataChartGenerator-ODCG/master/barrios.txt";
							dataset = new Dataset(urlDataset,0);
						}

						else if (rdbtnxls.isSelected())
						{
							//urlDataset="http://www.santacruzdetenerife.es/opendata/dataset/8363b662-0bdc-47e1-b9f6-65b536714f29/resource/1f86d613-d406-418e-8757-46bea561d9ed/download/barrios.xls";
							dataset = new Dataset(urlDataset,1);
						}
					}
					//Se crea la ventana de selección de gráficos de la información del conjunto de datos
					SalidaGraficosFrame seleccion_graficos = new SalidaGraficosFrame(dataset);
				} catch (IOException e) {
					mlogConsola.log(Level.INFO,"Error", e);
				}
			}
		});
		btnProcesarConjuntoDe.setBounds(125, 184, 193, 23);
		frame.getContentPane().add(btnProcesarConjuntoDe);
	}
}
