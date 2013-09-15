package componentejtable;

import java.awt.Component;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class CeldaComboBoxEditor extends AbstractCellEditor implements TableCellEditor{
    JComboBox jcb= new JComboBox(new String[]{"uno","dos","tres"});
    Object valorActual;
    Cliente cl=null;

    public CeldaComboBoxEditor() {
        ItemListener il= new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    ItemSelectable is=e.getItemSelectable();
                    String bjt=(String) is.getSelectedObjects()[0];
                    valorActual = bjt;
                    cl.setNombre(bjt);
                }
            }
        };
        jcb.addItemListener(il);
    }
    
    @Override
    public Object getCellEditorValue() {
        return valorActual;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ModeloTabla mdl=(ModeloTabla) table.getModel();
        cl= mdl.getFila(row);
        return jcb;
    }
    
}
