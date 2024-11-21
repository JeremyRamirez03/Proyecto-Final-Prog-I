package Interfaces;

public interface Crud {
	public boolean añadir(Object o);
	public Object buscarPuntual(String dato1,String dato2);
	public boolean eliminar (String dato1,String dato2);
	public boolean buscar(String dato1,String dato2, String dato3);
}
