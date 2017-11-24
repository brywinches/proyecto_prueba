package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.jdbc.pool.DataSource;
import entities.Producto;
import modelo.ModeloProductos;
import repositorios.ConexionPool;

@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ModeloProductos mp;
	private DataSource dataSource = null;

	@Override
	public void init() throws ServletException {
		super.init();
		dataSource = ConexionPool.getDataSource();
		mp = new ModeloProductos(dataSource);

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorProductos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Leer el parametro del formulario
		String comando=request.getParameter("instruccion");
		
		//Si no se envia el parametro, listar productos
		if(comando==null) comando="listar";
		
		//Redirijir el flujo de ejecucion al metodo adecuado
		
		switch(comando) {
		case "listar":
			obtenerProductos(request, response);
			break;
		case "insertarBBDD":
			insertarProducto(request, response);
			break;
		case "cargar":
			
			try {
				cargaProductos(request,response);
			} catch (Exception e) {
				
				System.out.println(e);
			}
			
			break;
			
		case "actualizarBBDD":
			try {
				actualizaProducto(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "eliminar":
			try {
				eliminarProducto(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		default:
			
			obtenerProductos(request, response);
			
		}
		
		
		

	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String codigo=request.getParameter("codigoArticulo");
		mp.eliminarProducto(codigo);
		obtenerProductos(request, response);
		
	}

	private void actualizaProducto(HttpServletRequest request, HttpServletResponse response)throws Exception  {
		//leer los datos que vienen del formulario
		String codigo=request.getParameter("codigo");
		String seccion=request.getParameter("seccion");
		String nomArticulo=request.getParameter("nomArticulo");
		double precio=Double.parseDouble(request.getParameter("precio"));
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		String fecha=request.getParameter("fecha");
		Date date = null;
		try {date = formatoFecha.parse(fecha);} 
		catch (ParseException ex) {ex.printStackTrace();}
		String importado=request.getParameter("importado");
		String pOrigen=request.getParameter("pOrigen");
		//crear nuevo producto		
		Producto producto=new Producto(codigo,seccion,nomArticulo,precio,
				date,Boolean.parseBoolean(importado),pOrigen);
		//actualizar el producto en la bbdd pasandole el producto		
		
		mp.actualizaProducto(producto);
		
		obtenerProductos(request, response);
	}

	private void cargaProductos(HttpServletRequest request, HttpServletResponse response)throws Exception {
		//leer el codigo del articulo que viene en el request
		String codigo=request.getParameter("codigoArticulo");
		//Comunicar codigo art al modelo para obtener la info del producto
		Producto producto=mp.consultaProducto(codigo);
		//Colocar atributo correspondiente al codigo art
		request.setAttribute("productoActualizar", producto);
		//Envia la info al formulario de actualizar(jsp)
		RequestDispatcher rd=request.getRequestDispatcher("/actualizarProducto.jsp");
		rd.forward(request, response);
	}

	private void insertarProducto(HttpServletRequest request, HttpServletResponse response) {
		String codigo=request.getParameter("codigo");
		String seccion=request.getParameter("seccion");
		String nomArticulo=request.getParameter("nomArticulo");
		double precio=Double.parseDouble(request.getParameter("precio"));
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		String fecha=request.getParameter("fecha");
		Date date = null;
		try {date = formatoFecha.parse(fecha);} 
		catch (ParseException ex) {ex.printStackTrace();}
		String importado=request.getParameter("importado");
		String pOrigen=request.getParameter("pOrigen");
				
		Producto producto=new Producto(codigo,
				seccion,
				nomArticulo,
				precio,
				date,
				Boolean.parseBoolean(importado),
				pOrigen);
		mp.insertarProducto(producto);
		obtenerProductos(request, response);
		
		
	}

	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// obtener la lista de productos
		List<Producto> productos = new ArrayList();
		try {
			productos = mp.getProductos();

			// agregar la lista de productos al request
			request.setAttribute("listaProductos", productos);
			// redireccionar la lista al jsp
			RequestDispatcher rd = request.getRequestDispatcher("/listaproductos.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
