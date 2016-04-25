package com.work.mapper;

import java.util.List;

public interface BasicDao <T>{

	/**添加一条记录
	 * @param obj
	 * @return
	 */
	public int insert(T obj);
	
	/**删除一条记录
	 * @param pks map对象
	 * @return
	 */
	public int delete(Object params);
	
	/**查询一条记录
	 * @param params
	 * @return
	 */
	public T load(Object params);
	
	/**查询记录的数量
	 * @param params
	 * @return
	 */
	public int count(Object params);
	
	/**不带分页的查询
	 * @param params
	 * @return
	 */
	public List<T> list(Object params);
	
	/**带分页的查询
	 * @param params
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<T> listByPage(Object params);
	
	/**数据更新
	 * @param params
	 * @return
	 */
	public int update(Object params);
}
