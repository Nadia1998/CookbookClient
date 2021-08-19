package rs.ac.bg.fon.nprog.client.gui;

import rs.ac.bg.fon.nprog.library.domen.Korisnik;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.komunikacija.KomunikacijaSaServerom;
import rs.ac.bg.fon.nprog.library.konstante.Operacije;
import rs.ac.bg.fon.nprog.library.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.nprog.library.transfer.ServerskiOdgovor;

/**
 *
 * @author Nadia
 */
public class FrmLogin extends JFrame {

	/**
	 * Creates new form FrmLogin
	 */
	public FrmLogin() {
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

		lblKorisnickoIme = new javax.swing.JLabel();
		lblLozinka = new javax.swing.JLabel();
		txtLozinka = new javax.swing.JPasswordField();
		txtKorisnickoIme = new javax.swing.JTextField();
		btnLogin = new javax.swing.JButton();
		lblErrorLozinka = new javax.swing.JLabel();
		lblErrorKorisnickoIme = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblKorisnickoIme.setText("Korisničko ime");

		lblLozinka.setText("Lozinka");

		btnLogin.setText("Uloguj se");
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
					btnLoginActionPerformed(evt);
				
			}
		});

		lblErrorLozinka.setForeground(new java.awt.Color(255, 0, 0));

		lblErrorKorisnickoIme.setForeground(new java.awt.Color(255, 0, 0));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(384, 384, 384).addComponent(btnLogin)
												.addGap(26, 26, 26))
								.addGroup(layout.createSequentialGroup().addGap(54, 54, 54)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblKorisnickoIme).addComponent(lblLozinka))
										.addGap(41, 41, 41)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblErrorLozinka, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txtLozinka).addComponent(txtKorisnickoIme).addComponent(
														lblErrorKorisnickoIme, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGap(79, 79, 79)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(70, 70, 70)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblKorisnickoIme)
								.addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblErrorKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLozinka))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(lblErrorLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
						.addComponent(btnLogin).addGap(68, 68, 68)));

		pack();
	}// </editor-fold>

	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
		String korisnickoIme = txtKorisnickoIme.getText().trim();
		String lozinka = new String(txtLozinka.getPassword());
		if (korisnickoIme.isEmpty()) {
			lblErrorLozinka.setText("Korisnicko ime ne može da bude prazno!");
		}
		if (lozinka.isEmpty()) {
			lblErrorLozinka.setText("Lozinka ne može da bude prazna!");
		}
		lblErrorKorisnickoIme.setText("");

		Korisnik korisnik = new Korisnik(-1, null, null, korisnickoIme, lozinka);

		KlijentskiZahtev kz = new KlijentskiZahtev();
		kz.setParametar(korisnik);
		kz.setOperacija(Operacije.PRIJAVI_KORISNIKA);

		KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);

		ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();

		if (so != null && so.isUspesno()) {
			Korisnik ulogovan = (Korisnik) so.getOdgovor();
			new FrmMain(ulogovan).setVisible(true);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Netačna kombinacija lozinke i username-a.Pokušaj ponovo.");

		}

	}

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.JButton btnLogin;
	private javax.swing.JLabel lblErrorKorisnickoIme;
	private javax.swing.JLabel lblErrorLozinka;
	private javax.swing.JLabel lblKorisnickoIme;
	private javax.swing.JLabel lblLozinka;
	private javax.swing.JTextField txtKorisnickoIme;
	private javax.swing.JPasswordField txtLozinka;
	// End of variables declaration

	private void sredi() {
		this.setLocationRelativeTo(null);
		setTitle("Login forma");
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				handleClose();
				System.exit(0);

			}

		});

		this.setVisible(true);
	}

	public void handleClose() {
		KlijentskiZahtev kz = new KlijentskiZahtev();
		kz.setOperacija(Operacije.IZBACI_KLIJENTA);
		KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
		ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
	}
}
