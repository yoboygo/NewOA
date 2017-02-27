package tk.codecube.base;

import java.util.List;

public interface IBaseDao<T> {

	String save(T entity);
	
	void saveOrUpdate(T entity);
	
	void delete(T entity);
	
	void update(T entity);
	
	T get(String id);
	
	List<T> findByHql(String hql);
	
	List<T> findBySql(String sql);
	
}
