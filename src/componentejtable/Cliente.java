package componentejtable;

import java.util.ArrayList;

public class Cliente {
    private int _codigo;
    private String _nombre;
    private String _apellido;
    private String _email;
    private boolean _estado;

    public Cliente(int _codigo, String _nombre, String _apellido, String _email, boolean _estado) {
        this._codigo = _codigo;
        this._nombre = _nombre;
        this._apellido = _apellido;
        this._email = _email;
        this._estado = _estado;
    }

    
    public int getCodigo() {
        return _codigo;
    }

    public void setCodigo(int _codigo) {
        this._codigo = _codigo;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getApellido() {
        return _apellido;
    }

    public void setApellido(String _apellido) {
        this._apellido = _apellido;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public boolean isEstado() {
        return _estado;
    }

    public void setEstado(boolean _estado) {
        this._estado = _estado;
    }

    @Override
    public String toString() {
        return getNombre()+" "+getApellido();
    }
    public static ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> clientes=new ArrayList<Cliente>();
        Cliente cl1=new Cliente(1, "Henry", "Guzman", "hguzman10@gmail.com", false);
        Cliente cl2=new Cliente(2, "Carlos", "Guzman", "hguzman10@gmail.com", true);
        Cliente cl3=new Cliente(3, "Luis", "Guzman", "hguzman10@gmail.com", false);
        Cliente cl4=new Cliente(4, "Gustavo", "Guzman", "hguzman10@gmail.com", false);
        clientes.add(cl1);
        clientes.add(cl2);
        clientes.add(cl3);
        clientes.add(cl4);
        return clientes;
    }
    
}
