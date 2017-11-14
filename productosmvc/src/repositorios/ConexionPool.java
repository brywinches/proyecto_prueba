package repositorios;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class ConexionPool {

	private static String resource="jdbc/Productos";
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/pruebas?useSSL=false";
	private static String user="root";
	private static String password="bry857857";
	private static int minimoEnCola=3;
	private static int maximoEnCola=10;
	private static int maximoActivo=15;
	private static int tiempoMaxEspera=5000;
	private static DataSource dataSource=null;
	
	public static DataSource getDataSource() {
		PoolProperties propiedades = new PoolProperties();
		propiedades.setName(resource);
		propiedades.setUrl(url);
        propiedades.setDriverClassName(driver);
        propiedades.setUsername(user);
        propiedades.setPassword(password);
        propiedades.setMinIdle(minimoEnCola);
        propiedades.setMaxIdle(maximoEnCola);
        propiedades.setMaxActive(maximoActivo);
        propiedades.setMaxWait(tiempoMaxEspera);
        dataSource = new DataSource();
        dataSource.setPoolProperties(propiedades);
		
		return dataSource;
	}
}
