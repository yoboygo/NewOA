package tk.codecube.base;

import java.util.ArrayList;

/**
 * 动态生成List列表
 * @author bpqqo
 *
 * @param <E>
 */
public class DynamicList<E> extends ArrayList<E>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7707010216264224545L;
	private Class<E> clazz;
	
	public DynamicList(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public E get(int index) {
		
		if(index > super.size())
		{
			try {
				super.add(clazz.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return super.get(index);
	}

}
