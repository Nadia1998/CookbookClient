package rs.ac.bg.fon.nprog.client.gui;

import rs.ac.bg.fon.nprog.library.domen.Korisnik;
import rs.ac.bg.fon.nprog.library.domen.Recept;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
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
public class FrmPrikaz extends JDialog {

    Korisnik korisnik;
    JFrame parent;

    /**
     * Creates new form FrmPrikaz
     */
    public FrmPrikaz(java.awt.Frame parent, boolean modal, Korisnik ulogovan) {
        super(parent, modal);
        this.parent = (JFrame) parent;
        initComponents();
        this.setTitle("Prikaz svih recepata");
        korisnik = ulogovan;
        napuniTabelu();
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
        tblRecepti = new javax.swing.JTable();
        btnVise = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recepti");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Recepti"));

        tblRecepti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRecepti);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        btnVise.setText("Više");
        btnVise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViseActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVise, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVise, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnViseActionPerformed(java.awt.event.ActionEvent evt) {                                        
        TableModelRecepti model = (TableModelRecepti) tblRecepti.getModel();
        int row = tblRecepti.getSelectedRow();
        if (row != -1) {
            Recept r = model.getReceptAtRow(row);
            new FrmReceptDetaljno(parent, true, r).setVisible(true);
        }
    }                                       

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int row = tblRecepti.getSelectedRow();
        TableModelRecepti model = (TableModelRecepti) tblRecepti.getModel();
        if (row != -1) {
            Recept r = model.getReceptAtRow(row);
            System.out.println(r.getNaziv());
            System.out.println(r.getKorisnik().getKorisnikId());
            System.out.println(korisnik.getKorisnikId());
            if (r.getKorisnik().getKorisnikId() == korisnik.getKorisnikId()) {
                KlijentskiZahtev kz = new KlijentskiZahtev();
                kz.setOperacija(Operacije.OBRISI_RECEPT);
                kz.setParametar(r);
                KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
                ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
                napuniTabelu();
                if (so.isUspesno()) {
                    JOptionPane.showMessageDialog(this, "Uspešno ste obrisali recept!");

                } else {
                    JOptionPane.showMessageDialog(this, "Brisanje nije uspelo!");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Brisanje tuđih recepata nije dozvoljeno!");
            }
        }
    }                                         

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int row = tblRecepti.getSelectedRow();
        TableModelRecepti model = (TableModelRecepti) tblRecepti.getModel();
        if (row != -1) {
            Recept r = model.getReceptAtRow(row);
            if (r.getKorisnik().getKorisnikId() == korisnik.getKorisnikId()) {
            new FrmIzmena(parent, rootPaneCheckingEnabled, r, korisnik).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Recept može promeniti samo autor recepta!");
            }
        }
    }                                         

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnVise;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRecepti;
    // End of variables declaration                   

    private void napuniTabelu() {
        setLocationRelativeTo(null);
        tblRecepti.setModel(new TableModelRecepti(vratiRecepte()));
    }

    private List<Recept> vratiRecepte() {
        ArrayList<Recept> recepti;
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_RECEPTE);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor odgovor = KomunikacijaSaServerom.getInstance().primiOdgovor();
        recepti = (ArrayList<Recept>) odgovor.getOdgovor();
        if (odgovor.isUspesno()) {
            System.out.println("Uspesno ucitavanje recepata!");
        } else {
            JOptionPane.showMessageDialog(this, "Doslo je do greske pri ucitavanju!");
            return null;
        }
        return recepti;

    }
}
