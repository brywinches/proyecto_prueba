package testing;

import java.util.Date;

import org.apache.tomcat.jdbc.pool.DataSource;

import entities.Producto;
import modelo.ModeloProductos;
import repositorios.ConexionPool;

public class Testing {

	public static void main(String[] args) {
		DataSource dataSource=ConexionPool.getDataSource();
		ModeloProductos mp=new ModeloProductos(dataSource);
		mp.insertarProducto(new Producto(
				"sh1005","Ferreteria","Pileta baño",600.50,new Date(2007/10/04),false,"Argentina"));

	}

}
