import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class mainWindow extends JFrame {

	private JPanel contentPane;
	private JTable tablaPuntos;
	private DefaultTableModel modeloTablaPuntos;
	private JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow frame = new mainWindow();
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
	public mainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 566);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 289, 329, 217);
		contentPane.add(scrollPane);
		tablaPuntos = new JTable();
		tablaPuntos.setBounds(12, 289, 329, 217);
		modeloTablaPuntos = new DefaultTableModel();
		tablaPuntos.setModel(modeloTablaPuntos);
		modeloTablaPuntos.addColumn("Id punto");
		modeloTablaPuntos.addColumn("Coord X");
		modeloTablaPuntos.addColumn("Coord Y");
		scrollPane.setViewportView(tablaPuntos);

		
		Punto pun = new Punto(1.0,1.0);
		this.addPunto(pun);
		Rectangle re = new Rectangle(50,50,50,50);
		contentPane.paintImmediately(re);
		
	}
	
	public void addPunto(Punto p) {
		Object[] P = {p.getId(), p.getCoordx(), p.getCoordy()};
		modeloTablaPuntos.addRow(P);
		
	}
}
