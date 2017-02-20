package tk.codecube.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3751587306646856021L;
	
	/**
	 * 默认每页大小
	 */
	public static final int DEFAULT_PAGE_SIZE = 20;
	
	/**
	 * 自定义页面条数
	 */
	private int pageSize;
	
	/**
	 * 数据
	 */
	private List<T> data;
	
	/**
	 * 页的开始位置
	 */
	private long start;
	
	/**
	 * 总条数
	 */
	private long totalSize;
	
	
	public Page(int pageSize,int start,int totalSize,List<T> data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalSize = totalSize;
		this.data = data;
	}
	
	public Page(){
		this(DEFAULT_PAGE_SIZE, 0, 0, new ArrayList<T>());
	}
	
	
	/**
	 * 获取总页数
	 * @return
	 */
	public long getPageCount(){
		if (totalSize % pageSize == 0)
		{
			return totalSize / pageSize;
		}else{
			return totalSize / pageSize + 1;
		}
	}

	/**
	 * 获取当前页码
	 * @return
	 */
	public long getCurrentPageNo(){
		if (start % pageSize == 0){
			return start / pageSize;
		}else{
			return start / pageSize + 1;
		}
	}
	
	/**
	 * 是否有下一页
	 * @return
	 */
	public boolean hasNextPage(){
		return this.getCurrentPageNo() <= this.getPageCount() ? true : false ;
	}
	
	/**
	 * 是否有上一页
	 * @return
	 */
	public boolean hasPrePage(){
		return this.getCurrentPageNo() > 0 ? true : false ;
	}
	/**
	 *  返回任意一页在List中的位置
	 * @author Aimy
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * 2015年3月3日 上午9:35:52
	 */
	public static long getStartOfPage(long pageNo,int pageSize)
	{
		return (pageNo-1) * pageSize + 1;
	}
	
	public long getStartOfPage(long pageNo){
		return getStartOfPage(pageNo,this.pageSize);
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
}
