package Crud;

import java.sql.SQLException;

import com.conexion.*;

public class PrincipalCrud {
	public static void main(String[] args)throws SQLException {
		
		Conexion c =new Conexion();
		c.getConnection();
		
		
		
		
		
		ProductosCrud pc = new ProductosCrud();
		Productos produc1 = new Productos(1,"Nutrex Outlift",10,35.99);
		Productos produc2 = new Productos(2,"Dymatize ISO100",10,34.99);
		Productos produc3 =new Productos(3,"MHP Probolic-SR",10,34.99);
		Productos produc4 =new Productos(4,"Cellucor C4",10,29.99);
		Productos produc5 =new Productos(5,"NOW Foods Whey Protein Isolate",10,65.99);
		//Productos listaProductos = new Productos();
		
		
		
		//boolean cone = pc.crear(produc);
		boolean cone = pc.crear(produc1);
		//boolean cone = pc.crear(produc2);
		//boolean cone = pc.crear(produc1);
		//produc =pc.leerProductos(1);
		//System.out.println(produc1);
		//System.out.println(pc.crear(produc2));
		
		//boolean cone =pc.eliminar(7);
		System.out.println(cone);
		
		//System.out.println(listaProductos);
		
		
		
		
		//pc.actualizar(produc1,10);
		
		
	}

}
