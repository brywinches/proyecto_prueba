package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;

import entities.Producto;

public class ModeloProductos {

	private DataSource origenDatos;
	private Connection con=null;

	public ModeloProductos(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	public List<Producto> getProductos() throws Exception{
		List<Producto>productos=new ArrayList();
		try {
			con=origenDatos.getConnection();
			String sql="select * from productos";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				productos.add(new Producto(rs.getString("codigoarticulo")
						, rs.getString("seccion")
						, rs.getString("nombrearticulo")
						, rs.getDouble("precio")
						, rs.getDate("fecha"),
						rs.getBoolean("importado")
						, rs.getString("paisdeorigen")));
							
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return productos;
	}
	
	public void insertarProducto(Producto producto) {
		try {
			con=origenDatos.getConnection();
			if(con!=null) {
				System.out.println("conexion correcta");
			}
			String sql="insert into productos values (?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, producto.getCodArticulo());
			ps.setString(2, producto.getSeccion());
			ps.setString(3, producto.getNomArticulo());
			ps.setDouble(4, producto.getPrecio());
			java.util.Date utilDate=producto.getFecha();
			java.sql.Date fechaSql=new java.sql.Date(utilDate.getTime()); 
			ps.setDate(5, fechaSql);
			ps.setBoolean(6, producto.isImportado());
			ps.setString(7, producto.getPaisOrigen());
			ps.execute();
			System.out.println("insercion correcta");
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Producto consultaProducto(String codigo) {
		Producto producto=null;
		String codigoArt=codigo;
		try {
			con=origenDatos.getConnection();
			String sql="select * from productos where codigoarticulo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, codigoArt);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				producto=new Producto(rs.getString("codigoarticulo")
						, rs.getString("seccion")
						, rs.getString("nombrearticulo")
						, rs.getDouble("precio")
						, rs.getDate("fecha"),
						rs.getBoolean("importado")
						, rs.getString("paisdeorigen"));
			}else {
				throw new Exception("Articulo no encontrado codigo articulo: "+codigoArt);
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return producto;
		
		
	}

	public void actualizaProducto(Producto producto) {
		try {
			con=origenDatos.getConnection();
			if(con!=null) {
				System.out.println("conexion correcta");
			}
			String sql="update productos set seccion=?, nombrearticulo=?, precio=?, fecha=?, "
					+ "importado=?, paisdeorigen=? where codigoarticulo=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, producto.getSeccion());
			ps.setString(2, producto.getNomArticulo());
			ps.setDouble(3, producto.getPrecio());
			java.util.Date utilDate=producto.getFecha();
			java.sql.Date fechaSql=new java.sql.Date(utilDate.getTime()); 
			ps.setDate(4, fechaSql);
			ps.setBoolean(5, producto.isImportado());
			ps.setString(6, producto.getPaisOrigen());
			ps.setString(7, producto.getCodArticulo());
			ps.execute();
			System.out.println("actualizacion correcta");
		
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

	public void eliminarProducto(String codigo) {
		String codigoArt=codigo;
		try {
			con=origenDatos.getConnection();
			String sql="delete from productos where codigoarticulo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, codigoArt);
			ps.executeUpdate();
			System.out.println("Articulo eliminado");			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
