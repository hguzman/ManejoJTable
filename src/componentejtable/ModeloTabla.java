package componentejtable;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel{
    private List<Cliente> clientes= new ArrayList<Cliente>();
    private String[] columnas={"Codigo","Nombre","Apellido","Email","Estado"};
    private Class[] tipoDato= new Class[]{java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class};
    private boolean[] editables={false,true,false,false,true};
    
    public ModeloTabla() {
        // Simplemente cuando se instanacia la clase se cargan los clientes
        clientes=Cliente.getClientes();
    }        
    
    public void agregarCliente(Cliente clien){
        clientes.add(clien);
        //Notifica a los listener sobre la insercion
        this.fireTableRowsInserted(clientes.size(), clientes.size());
    }
    
    public void borrarFila(int indice){
        clientes.remove(indice);
        // Notifica a los listener sobre el borrado
        this.fireTableRowsDeleted(indice, indice);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipoDato[columnIndex];
    }

    
    // Obtiene el numero de filas del modelo
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    // Obtiene el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    // Este metodo no es obligación Implementarlo, pero es para obtener el titulo de la columna
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    public Cliente getFila(int rowIndex){
        return clientes.get(rowIndex);
    }
    
    // Obtiene el objeto actual
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return clientes.get(rowIndex).getCodigo();
            case 1: return clientes.get(rowIndex).getNombre();
            case 2: return clientes.get(rowIndex).getApellido();
            case 3: return clientes.get(rowIndex).getEmail();
            case 4: return clientes.get(rowIndex).isEstado();
            default:return null;
        }
    }

    // Verifica cual columna es editable y cual no
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editables[columnIndex];
    }
    
    
}
