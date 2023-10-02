package co.edu.unbosque.model.persistence;

public interface CRUDOperation {
	
	public void create(Object o);
	public void create(String ... args);
	public String readAll();
	public boolean updateById(int i, Object o);
	public boolean updateBYName(String name, Object o);
	public int deleteById(int i);
	public int deleteByName(String name);

}
