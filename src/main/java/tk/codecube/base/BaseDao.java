package tk.codecube.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * MyBits测试基类
 * @author songjl
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class BaseDao<T extends BaseModel> implements IBaseDao<T>{
	
	private Class<T> clazz;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BaseDao() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getClass();
	}
	
	/** 保存
	 * @param entity
	 * @return 返回主键
	 */
	public String save(T entity){
		getSession().save(entity);
		return entity.getId();
	}
	
	/**
	 * 保存或更新
	 * @param entity
	 * @return
	 */
	public void saveOrUpdate(T entity){
		getSession().saveOrUpdate(entity);
		entity.getId();
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(T entity){
		getSession().delete(entity);
	}
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity){
		getSession().update(entity);
	}

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public T get(String id)
	{
		return (T) getSession().get(clazz,id);
	}
	
	/**
	 * 根据HQL查询
	 * @param hql
	 * @param values
	 * @return
	 */
	public List<T> findByHql(String hql){
		return (List<T>) getSession().createQuery(hql);
	}
	

	/**
	 * 根据SQL查询
	 * @param sql
	 * @return
	 */
	public List<T> findBySql(String sql){
		return (List<T>) getSession().createNativeQuery(sql, clazz);
	}
	
	protected Session getSession(){
		
//		return this.sessionFactory.openSession();
		return this.sessionFactory.getCurrentSession();
	}
	
}
