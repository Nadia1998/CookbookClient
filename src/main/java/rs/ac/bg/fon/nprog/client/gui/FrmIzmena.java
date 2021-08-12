package rs.ac.bg.fon.nprog.client.gui;

import rs.ac.bg.fon.nprog.library.domen.EnumKategorijaRecepta;
import rs.ac.bg.fon.nprog.library.domen.EnumMera;
import rs.ac.bg.fon.nprog.library.domen.EnumNivoTezine;
import rs.ac.bg.fon.nprog.library.domen.EnumVremePripreme;
import rs.ac.bg.fon.nprog.library.domen.EnumVrsteJela;
import rs.ac.bg.fon.nprog.library.domen.Korisnik;
import rs.ac.bg.fon.nprog.library.domen.Recept;
import rs.ac.bg.fon.nprog.library.domen.Sastojak;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.komunikacija.KomunikacijaSaServerom;
import rs.ac.bg.fon.nprog.library.konstante.Operacije;
import rs.ac.bg.fon.nprog.client.model.TableModelSastojci;
import rs.ac.bg.fon.nprog.library.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.nprog.library.transfer.ServerskiOdgovor;

/**
 *
 * @author Nadia
 */
public class FrmIzmena extends javax.swing.JDialog {

	Recept r;
	Korisnik ulogovan;

	/**
	 * Creates new form FrmIzmena
	 */
	public FrmIzmena(java.awt.Frame parent, boolean modal, Recept recept, Korisnik korisnik) {
		super(parent, modal);
		this.r = recept;
		this.ulogovan = korisnik;
		initComponents();
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

		jScrollPane1 = new javax.swing.JScrollPane();
		txtOpisRecepta = new javax.swing.JTextArea();
		btnIzmeni = new javax.swing.JButton();
		cbVremePripreme = new javax.swing.JComboBox<>();
		jLabel1 = new javax.swing.JLabel();
		cbNivoTezine = new javax.swing.JComboBox<>();
		jLabel2 = new javax.swing.JLabel();
		cbVrsteJela = new javax.swing.JComboBox<>();
		jLabel3 = new javax.swing.JLabel();
		cbKategorijaRecepta = new javax.swing.JComboBox<>();
		jLabel4 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblSastojci = new javax.swing.JTable();
		txtNazivSastojka = new javax.swing.JTextField();
		txtKolicina = new javax.swing.JTextField();
		cbMernaJedinica = new javax.swing.JComboBox<>();
		btnObrisiSastojak = new javax.swing.JButton();
		btnDodajSastojak = new javax.swing.JButton();
		lblNaziv = new javax.swing.JLabel();
		lblKolicina = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtNaziv = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		txtOpisRecepta.setColumns(20);
		txtOpisRecepta.setRows(5);
		jScrollPane1.setViewportView(txtOpisRecepta);

		btnIzmeni.setText("Izmeni");
		btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnIzmeniActionPerformed(evt);
			}
		});

		// cbVremePripreme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
		// { "Item 1", "Item 2", "Item 3", "Item 4" }));
		cbVremePripreme.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbVremePripremeActionPerformed(evt);
			}
		});

		jLabel1.setText("Naziv");

		// cbNivoTezine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
		// "Item 1", "Item 2", "Item 3", "Item 4" }));

		jLabel2.setText("Vreme pripreme");

		//cbVrsteJela.setModel(
		//		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		jLabel3.setText("Nivo težine");

		//cbKategorijaRecepta.setModel(
		//		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		jLabel4.setText("Vrsta jela");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sastojak"));

		tblSastojci
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(tblSastojci);

		//cbMernaJedinica.setModel(
		//		new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		btnObrisiSastojak.setText("Obriši sastojak");
		btnObrisiSastojak.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnObrisiSastojakActionPerformed(evt);
			}
		});

		btnDodajSastojak.setText("Dodaj sastojak");
		btnDodajSastojak.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDodajSastojakActionPerformed(evt);
			}
		});

		lblNaziv.setText("Naziv");

		lblKolicina.setText("Količina");

		jLabel7.setText("Merna jedinica");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 537,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
										.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblKolicina).addComponent(lblNaziv))
										.addGap(70, 70, 70)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(btnDodajSastojak)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addComponent(txtKolicina,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 151,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(44, 44, 44).addComponent(jLabel7)))
														.addGap(34, 34, 34)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(btnObrisiSastojak)
																.addComponent(cbMernaJedinica,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 116,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addComponent(txtNazivSastojka, javax.swing.GroupLayout.PREFERRED_SIZE,
														151, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(87, 87, 87)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout
										.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtNazivSastojka, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNaziv))
										.addGap(40, 40, 40).addComponent(lblKolicina))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(cbMernaJedinica, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel7))))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(btnDodajSastojak).addComponent(btnObrisiSastojak))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(42, 42, 42)));

		jLabel5.setText("Kategorija recepta");

		jLabel6.setText("Opis recepta");

		txtNaziv.setEditable(false);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup().addGap(64, 64, 64)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel3).addComponent(jLabel4).addComponent(jLabel5)
										.addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel6))
								.addGap(84, 84, 84)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(cbVrsteJela, javax.swing.GroupLayout.PREFERRED_SIZE, 236,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cbKategorijaRecepta,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 236,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cbNivoTezine, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 236,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 236,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cbVremePripreme,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 236,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addGap(222, 222, 222).addComponent(btnIzmeni,
										javax.swing.GroupLayout.PREFERRED_SIZE, 151,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(38, 38, 38).addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(44, 44, 44)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(cbVremePripreme, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(cbNivoTezine, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(41, 41, 41)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(cbVrsteJela, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(41, 41, 41)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(cbKategorijaRecepta, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(99, 99, 99)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addGap(18, 18, 18).addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(29, 29, 29)));

		pack();
	}// </editor-fold>

	private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {
		izmeniRecept();
	}

	private void cbVremePripremeActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnObrisiSastojakActionPerformed(java.awt.event.ActionEvent evt) {
		int red = tblSastojci.getSelectedRow();
		if (red != -1) {
			TableModelSastojci model = (TableModelSastojci) tblSastojci.getModel();
			model.obrisiSastojak(red);
			model.fireTableDataChanged();
		}

	}

	private void btnDodajSastojakActionPerformed(java.awt.event.ActionEvent evt) {
		String naziv = txtNazivSastojka.getText().trim();
		int kolicina = 0;
		try {
			kolicina = Integer.parseInt(txtKolicina.getText().trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Količina mora biti broj");
		}
		EnumMera mera = (EnumMera) cbMernaJedinica.getSelectedItem();
		if (mera == null || naziv == null || kolicina <= 0) {
			JOptionPane.showMessageDialog(this, "Sva polja su obavezna!");
			return;
		}

		Sastojak s = new Sastojak(-1, naziv, kolicina, mera, r);

		TableModelSastojci model = (TableModelSastojci) tblSastojci.getModel();
		model.dodajSastojak(s);
		model.fireTableDataChanged();
	}

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton btnDodajSastojak;
	private javax.swing.JButton btnIzmeni;
	private javax.swing.JButton btnObrisiSastojak;
	private javax.swing.JComboBox<Object> cbKategorijaRecepta;
	private javax.swing.JComboBox<Object> cbMernaJedinica;
	private javax.swing.JComboBox<Object> cbNivoTezine;
	private javax.swing.JComboBox<Object> cbVremePripreme;
	private javax.swing.JComboBox<Object> cbVrsteJela;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lblKolicina;
	private javax.swing.JLabel lblNaziv;
	private javax.swing.JTable tblSastojci;
	private javax.swing.JTextField txtKolicina;
	private javax.swing.JTextField txtNaziv;
	private javax.swing.JTextField txtNazivSastojka;
	private javax.swing.JTextArea txtOpisRecepta;
	// End of variables declaration

	private void sredi() {
		setLocationRelativeTo(null);
		this.setTitle("Izmeni recept");
		popuniCB();
		popuniPolja();
		popuniTabeluSastojaka();
	}

	private void popuniCB() {

		cbKategorijaRecepta.removeAllItems();
		cbNivoTezine.removeAllItems();
		cbVremePripreme.removeAllItems();
		cbVrsteJela.removeAllItems();

		for (EnumKategorijaRecepta k : EnumKategorijaRecepta.values()) {
			cbKategorijaRecepta.addItem(k);
		}

		for (EnumNivoTezine n : EnumNivoTezine.values()) {
			cbNivoTezine.addItem(n);
		}
		for (EnumVremePripreme vp : EnumVremePripreme.values()) {
			cbVremePripreme.addItem(vp);
		}
		for (EnumVrsteJela v : EnumVrsteJela.values()) {
			cbVrsteJela.addItem(v);
		}

		cbMernaJedinica.removeAllItems();
		for (EnumMera mera : EnumMera.values()) {
			cbMernaJedinica.addItem(mera);
		}

	}

	private void popuniPolja() {
		cbKategorijaRecepta.setSelectedItem(r.getKategorijaRecepta());
		cbNivoTezine.setSelectedItem(r.getNivoTezine());
		cbVremePripreme.setSelectedItem(r.getVremePripreme());
		cbVrsteJela.setSelectedItem(r.getVrstaJela());

		txtNaziv.setText(r.getNaziv());
		txtOpisRecepta.setText(r.getOpisRecepta());

	}

	private void popuniTabeluSastojaka() {

		KlijentskiZahtev kz = new KlijentskiZahtev();
		kz.setOperacija(Operacije.VRATI_SASTOJKE_RECEPTA);
		kz.setParametar(r);
		KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
		ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
		List<Sastojak> lista = (List<Sastojak>) so.getOdgovor();
		TableModelSastojci model = new TableModelSastojci(lista);
		tblSastojci.setModel(model);
	}

	private void izmeniRecept() {
		TableModelSastojci model = (TableModelSastojci) tblSastojci.getModel();
		EnumVremePripreme vremePripreme = (EnumVremePripreme) cbVremePripreme.getSelectedItem();
		EnumNivoTezine nivoTezine = (EnumNivoTezine) cbNivoTezine.getSelectedItem();
		EnumVrsteJela vrsteJela = (EnumVrsteJela) cbVrsteJela.getSelectedItem();
		EnumKategorijaRecepta kategorija = (EnumKategorijaRecepta) cbKategorijaRecepta.getSelectedItem();
		String opis = txtOpisRecepta.getText().trim();
		List<Sastojak> sastojci = new ArrayList<>();
		sastojci = model.getListaSastojaka();

		if (sastojci.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Unesite sastojke!");
		}

		r.setKorisnik(ulogovan);
		System.out.println(ulogovan);
		r.setNaziv(r.getNaziv());
		r.setVremePripreme(vremePripreme);
		r.setNivoTezine(nivoTezine);
		r.setVrstaJela(vrsteJela);
		r.setKategorijaRecepta(kategorija);
		r.setOpisRecepta(opis);
		r.setSastojci(sastojci);

		try {

			KlijentskiZahtev kz = new KlijentskiZahtev();
			kz.setParametar(r);
			kz.setOperacija(Operacije.IZMENI_RECEPT);

			KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
			ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
			Recept izmenjen = (Recept) so.getOdgovor();
			if (izmenjen != null) {
				JOptionPane.showMessageDialog(this, "Recept je izmenjen");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Recept nije izmenjen");
			}
		} catch (Exception ex) {
			Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
}
