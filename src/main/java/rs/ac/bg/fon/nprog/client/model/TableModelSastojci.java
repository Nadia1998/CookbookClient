package rs.ac.bg.fon.nprog.client.model;


import rs.ac.bg.fon.nprog.library.domen.Sastojak;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nadia
 */
public class TableModelSastojci extends AbstractTableModel {

    List<Sastojak> sastojci;
    String[] kolone = new String[]{"naziv", "količina", "mera"};

    public TableModelSastojci() {
        sastojci = new ArrayList<>();
    }
     public TableModelSastojci(List<Sastojak> sastojci) {
        this.sastojci=sastojci;
    }

    @Override
    public int getRowCount() {
        return sastojci.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return sastojci.get(rowIndex).getNaziv();
            case 1: return sastojci.get(rowIndex).getKolicina();
            case 2: return sastojci.get(rowIndex).getMera();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajSastojak(Sastojak s) {
        sastojci.add(s);
    }

    public List<Sastojak> getSastojci() {
        return sastojci;
    }

    public void obrisiSastojak(int red) {
        sastojci.remove(red);
    }

    public List<Sastojak> getListaSastojaka() {
        return sastojci;
    } 

}

