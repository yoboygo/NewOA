package tk.codecube.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


public class BaseDao<T extends BaseModel> extends HibernateDaoSupport{
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDao() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getClass();
	}
	
	/** 保存
	 * @param entity
	 * @return 返回主键
	 */
	public String save(T entity){
		super.getHibernateTemplate().save(entity);
		return entity.getId();
	}
	
	/**
	 * 保存或更新
	 * @param entity
	 * @return
	 */
	public String saveOrUpdate(T entity){
		super.getHibernateTemplate().saveOrUpdate(entity);
		return entity.getId();
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(T entity){
		super.getHibernateTemplate().delete(entity);
	}
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity){
		super.getHibernateTemplate().update(entity);
	}

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public T get(String id)
	{
		return super.getHibernateTemplate().get(clazz, id);
	}
	
	/**
	 * 根据HQL查询
	 * @param queryString
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByHql(String queryString,Object... values){
		return (List<T>) super.getHibernateTemplate().find(queryString, values);
	}
	

	/**
	 * 根据SQL查询
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findBySql(String sql){
		return (List<T>) super.getSessionFactory().getCurrentSession().createSQLQuery(sql);
	}
	
	/**
	 * 将Hibernate的SessionFactory注入进来
	 * @param sessionFactory
	 */
	@Autowired
	public void setSessonFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
}
