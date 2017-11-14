package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import modelo.ModeloProductos;

/**
 * Servlet implementation class ServletPrueba
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Crear el printwriter
		PrintWriter salida=response.getWriter();
		//Crear conexion
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		PoolProperties p = new PoolProperties();
		p.setName("jdbc/Productos");
		p.setUrl("jdbc:mysql://localhost:3306/pruebas?useSSL=false");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setMaxIdle(3);
        p.setUsername("root");
        p.setPassword("bry857857");
        p.setMaxActive(15);
        p.setMaxWait(5000);
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);
		/*try {
			con=datasource.getConnection();
			String sql="select * from productos";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				String datos=rs.getString("nombrearticulo");
				salida.write(datos+"<br>");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}*/
        ModeloProductos mp=new ModeloProductos(datasource);
        try {
			mp.getProductos().forEach(System.out::println);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
