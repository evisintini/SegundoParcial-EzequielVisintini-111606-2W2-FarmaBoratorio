/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorBD;

import Modelo.DetalleFactura;
import Modelo.Empleado;
import Modelo.Factura;
import Modelo.Producto;
import Modelo.Sucursal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2w2 111606 Ezequiel Favio Visintini
 */
public class GestorBD {

    private Connection con;
    int r;

    private void abrirConexion() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Farmaboratorio", "sa", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public Empleado Validar(String usuario, String contraseña) {

        Empleado e = new Empleado();

        try {
            abrirConexion();

            String consulta = "SELECT * FROM empleados WHERE usuario =  ? AND  contraseña =  ? ";

            PreparedStatement ps = con.prepareStatement(consulta);

            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String puesto = rs.getString("puesto");
                String user = rs.getString("usuario");
                String pass = rs.getString("contraseña");

                e = new Empleado(id, nombre, puesto, user, pass);
            }

            ps.close();
            cerrarConexion();

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return e;
    }

    public ArrayList getEmpleados() {
        String consulta = "select * from empleados";
        ArrayList<Empleado> lista = new ArrayList<>();

        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String puesto = rs.getString("puesto");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");

                Empleado e = new Empleado(id, nombre, puesto, usuario, contraseña);
                lista.add(e);
            }

            ps.close();
            cerrarConexion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void agregarEmpleado(Empleado e) {

        String sql = "insert into Empleados (Nombre, Puesto, Usuario, Contraseña) values (?, ?, ?, ?)";
        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPuesto());
            ps.setString(3, e.getUsuario());
            ps.setString(4, e.getContraseña());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Empleado getEmpleadoPorId(int idEmpleado) {
        Empleado e = new Empleado();
        
        try {
            abrirConexion();
            String sql = "SELECT * FROM Empleados WHERE idEmpleado = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String puesto = rs.getString("puesto");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                
                e = new Empleado(id, nombre, puesto, usuario, contraseña);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return e;
    }

    public int actualizarEmpleado(Empleado e) {

        try {
            abrirConexion();

            String sql = "UPDATE Empleados SET nombre=?, puesto=?, usuario=?, contraseña=? WHERE idEmpleado=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPuesto());
            ps.setString(3, e.getUsuario());
            ps.setString(4, e.getContraseña());
            ps.setInt(5, e.getIdEmpleado());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return r;
    }

    public void eliminarEmpleado(int idEmpleado) {
        try {
            abrirConexion();
            String sql = "DELETE FROM Empleados WHERE id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idEmpleado);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
    
    //Metodos para productos
    public ArrayList getProductos() {
        String consulta = "select * from productos";
        ArrayList<Producto> lista = new ArrayList<>();

        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                boolean isVentaLibre = rs.getBoolean("isVentaLibre");

                Producto p = new Producto(id, nombre, precio, isVentaLibre);
                lista.add(p);
            }

            ps.close();
            cerrarConexion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void agregarProducto(Producto p) {

        String sql = "insert into Productos (Nombre, precio, isVentaLibre) values (?, ?, ?)";
        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setFloat(2, p.getPrecio());
            ps.setBoolean(3, p.isIsVentaLibre());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Producto getProductoPorId(int idProducto) {
        Producto p = null;
        try {
            abrirConexion();
            String sql = "SELECT * FROM Productos WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                int id = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                boolean isVentalibre = rs.getBoolean("isVentaLibre");
                
                p = new Producto(id, nombre, precio, isVentalibre);
            }
            
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {            
            cerrarConexion();
        }
        return p;
    }

    public int actualizarProducto(Producto p) {

        try {
            abrirConexion();

            String sql = "UPDATE Productos SET nombre=?, precio=?, isVentaLibre=? WHERE idProducto=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setFloat(2, p.getPrecio());
            ps.setBoolean(3, p.isIsVentaLibre());
            ps.setInt(5, p.getIdProducto());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return r;
    }

    public void eliminarProducto(int idProducto) {
        try {
            abrirConexion();
            String sql = "DELETE FROM Productos WHERE id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idProducto);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
    
    public Producto ConsultaPorCodigo(int idProducto) {
        Producto p = null;
        
        String consulta = "SELECT * FROM productos WHERE idProducto = ? ";

        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                int id = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                float precio = rs.getFloat("precio");
                boolean isVentalibre = rs.getBoolean("isVentaLibre");
                
                p = new Producto(id, nombre, precio, isVentalibre);  
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    /*public void agregarProducto(Producto p) {

        String sql = "insert into Productos (Nombre, precio, isVentaLibre) values (?, ?, ?)";
        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setFloat(2, p.getPrecio());
            ps.setBoolean(3, p.isIsVentaLibre());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
    
    public ArrayList getSucursales() {
        String consulta = "select * from sucursales";
        ArrayList<Sucursal> lista = new ArrayList<>();

        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idSucursal");
                String direccion = rs.getString("direccion");
                String ciudad = rs.getString("ciudad");
                String provincia = rs.getString("provincia");
                float telefono = rs.getFloat("telefono");

                Sucursal s = new Sucursal(id, direccion, ciudad, provincia, telefono);
                lista.add(s);
            }

            ps.close();
            cerrarConexion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public void agregarFactura(Factura f){

        String sql = "insert into Facturas (idSucursal, fecha, nombreCliente, idEmpleado, numeroReceta) values (?, ?, ?, ?, ?)";
        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, f.getS().getIdSucursal());
            //ps.setDate(2, f.getFecha());
            ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ps.setString(3, f.getNombreCliente());
            ps.setInt(4, f.getE().getIdEmpleado());
            ps.setInt(5, f.getNumeroReceta());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList getFacturas() {
        String consulta = "select * from Facturas";
        ArrayList<Factura> lista = new ArrayList<>();

        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idFactura");
                int idSucursal = Integer.parseInt(rs.getString("idSucursal"));
                LocalDate fecha = LocalDate.parse(rs.getString("fecha"));
                String nombreCliente = rs.getString("nombreCliente");
                int idEmpleado = Integer.parseInt(rs.getString("idEmpleado"));
                int numeroReceta = Integer.parseInt(rs.getString("numeroReceta"));
                
                Sucursal s = new Sucursal(idSucursal);
                Empleado e = new Empleado(idEmpleado);

                Factura f = new Factura(idSucursal, s, fecha, nombreCliente, e, numeroReceta);
                lista.add(f);
            }

            ps.close();
            cerrarConexion();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    public void agregarDetalleFactura(DetalleFactura d){

        String sql = "insert into DetalleFacturas (idFactura, idProducto, cantidad, precio) values (?, ?, ?, ?)";
        try {
            abrirConexion();

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, d.getF().getIdFactura());
            ps.setInt(2, d.getP().getIdProducto());
            ps.setInt(3, d.getCantidad());
            ps.setFloat(4, d.getPrecio());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
