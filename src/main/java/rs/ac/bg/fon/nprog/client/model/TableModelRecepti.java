package rs.ac.bg.fon.nprog.client.model;


import rs.ac.bg.fon.nprog.library.domen.Recept;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nadia
 */
public class TableModelRecepti extends AbstractTableModel {

    List<Recept> recepti;
    String[] kolone = new String[]{"naziv", "kategorija recepta", "dodat od strane:"};

    public TableModelRecepti() {
        recepti = new ArrayList<>();
    }
    public TableModelRecepti(List<Recept> recepti) {
        this.recepti=recepti;
    }

    @Override
    public int getRowCount() {
        return recepti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return recepti.get(rowIndex).getNaziv();
            case 1:
                return recepti.get(rowIndex).getKategorijaRecepta().toString();
            case 2:
                return recepti.get(rowIndex).getKorisnik().getIme();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajRecept(Recept r) {
        recepti.add(r);
    }

    public List<Recept> getRecepti() {
        return recepti;
    }

    public void obrisiRecept(int red) {
        recepti.remove(red);
    }

    public List<Recept> getListaRecepata() {
        return recepti;
    }
    public Recept getReceptAtRow(int row){
        return recepti.get(row);
    }

    public void setRecepti(List<Recept> recepti) {
        this.recepti = recepti;
        fireTableDataChanged();
    }
    

    public void ocistiTabelu() {
        recepti = new ArrayList<>();
        fireTableDataChanged();
    }

}
