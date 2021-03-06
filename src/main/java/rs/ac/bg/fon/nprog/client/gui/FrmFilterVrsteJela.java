package rs.ac.bg.fon.nprog.client.gui;

import rs.ac.bg.fon.nprog.library.domen.EnumVrsteJela;
import rs.ac.bg.fon.nprog.library.domen.Recept;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.komunikacija.KomunikacijaSaServerom;
import rs.ac.bg.fon.nprog.library.konstante.Operacije;
import rs.ac.bg.fon.nprog.client.model.TableModelRecepti;
import rs.ac.bg.fon.nprog.library.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.nprog.library.transfer.ServerskiOdgovor;

/**
 *
 * @author Nadia
 */
public class FrmFilterVrsteJela extends javax.swing.JDialog {

	JFrame parent;

	/**
	 * Creates new form FrmFilterVrsteJela
	 */
	public FrmFilterVrsteJela(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		this.parent = (JFrame) parent;
		sredi();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblRecept = new javax.swing.JTable();
		btnPretrazi = new javax.swing.JButton();
		cbVrstaJela = new javax.swing.JComboBox<>();
		btnVise = new javax.swing.JButton();
		lblVrstaJela = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Rezultat pretrage"));

		tblRecept
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tblRecept);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout
						.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(30, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(29, Short.MAX_VALUE).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		btnPretrazi.setText("Pretra??i");
		btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPretraziActionPerformed(evt);
			}
		});

		// cbVrstaJela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
		// "Item 1", "Item 2", "Item 3", "Item 4" }));

		btnVise.setText("Vi??e");
		btnVise.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnViseActionPerformed(evt);
			}
		});

		lblVrstaJela.setText("Vrsta jela:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(lblVrstaJela).addGap(57, 57, 57)
										.addComponent(cbVrstaJela, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(62, 62, 62).addComponent(btnPretrazi))
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(23, 23, 23))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addComponent(btnVise, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(37, 37, 37)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(59, 59, 59)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblVrstaJela).addComponent(btnPretrazi)
								.addComponent(cbVrstaJela, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(45, 45, 45)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVise, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
	}// </editor-fold>

	private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {
		List<Recept> recepti = new ArrayList<Recept>();
		boolean uspesno = false;
		EnumVrsteJela vrstaJela = (EnumVrsteJela) cbVrstaJela.getSelectedItem();
		KlijentskiZahtev kz = new KlijentskiZahtev();
		kz.setOperacija(Operacije.NADJI_RECEPT_PREMA_VRSTI_JELA);
		kz.setParametar(vrstaJela);
		KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
		ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
		recepti = (List<Recept>) so.getOdgovor();
		if (so.isUspesno()) {
			uspesno = true;
			System.out.println("Uspeli smo da nadjemo recepte koji spadaju u ovu vrstu jela!");
		} else {
			uspesno = false;
			JOptionPane.showMessageDialog(this, "Nismo uspeli da nadjemo recepte koji spadaju u ovu vrstu jela!");
			this.dispose();
		}
		TableModelRecepti model = new TableModelRecepti(recepti);
		tblRecept.setModel(model);
	}

	private void btnViseActionPerformed(java.awt.event.ActionEvent evt) {
		TableModelRecepti model = (TableModelRecepti) tblRecept.getModel();
		int row = tblRecept.getSelectedRow();
		if (row != -1) {
			Recept r = model.getReceptAtRow(row);
			new FrmReceptDetaljno(parent, true, r).setVisible(true);
		}
	}

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton btnPretrazi;
	private javax.swing.JButton btnVise;
	private javax.swing.JComboBox<Object> cbVrstaJela;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblVrstaJela;
	private javax.swing.JTable tblRecept;
	// End of variables declaration

	private void sredi() {
		this.setTitle("Pretra??ivanje recepta prema vrsti jela");
		setLocationRelativeTo(null);
		TableModelRecepti model = new TableModelRecepti();
		tblRecept.setModel(model);
		cbVrstaJela.removeAllItems();
		for (EnumVrsteJela vp : EnumVrsteJela.values()) {
			cbVrstaJela.addItem(vp);
		}
	}
}
