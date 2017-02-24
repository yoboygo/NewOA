package tk.codecube.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
	private SqlSessionFactory sqlSessionFactory;
	
	public BaseDao() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getClass();
	}
	
	/** 保存
	 * @param entity
	 * @return 返回主键
	 */
	public void save(T entity){
		getSession().getMapper(IBaseDao.class).save(entity);
		entity.getId();
	}
	
	/**
	 * 保存或更新
	 * @param entity
	 * @return
	 */
	public void saveOrUpdate(T entity){
		getSession().getMapper(IBaseDao.class).saveOrUpdate(entity);
		entity.getId();
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(T entity){
		getSession().getMapper(IBaseDao.class).delete(entity);
	}
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity){
		getSession().getMapper(IBaseDao.class).update(entity);
	}

	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public T get(String id)
	{
		return (T) getSession().getMapper(IBaseDao.class).get(id);
	}
	
	/**
	 * 根据HQL查询
	 * @param queryString
	 * @param values
	 * @return
	 */
	public List<T> findByHql(String queryString){
		return (List<T>) getSession().getMapper(IBaseDao.class).findByHql(queryString);
	}
	

	/**
	 * 根据SQL查询
	 * @param sql
	 * @return
	 */
	public List<T> findBySql(String sql){
		return (List<T>) getSession().getMapper(IBaseDao.class).findBySql(sql);
	}
	
	/**
	 * 将Hibernate的SessionFactory注入进来
	 * @param sessionFactory
	 */
	public void setSessionFactoryBySpring(SqlSessionFactory sqlSessionFactory){
		System.out.println("BaseDao.setSessionFactoryBySpring() 注入 Hibernate SessionFactory.."+sqlSessionFactory);
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	protected SqlSession getSession(){
		return this.sqlSessionFactory.openSession();
	}
	
}
