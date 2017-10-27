package com.cookie.framework.base;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseService<T> {
    @Autowired
    public MyMapper<T> mapper;

    /*插入一条数据 null的属性也会保存

	*支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)

	*优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长

	*

	**/
    public T insert(T entity) {
        mapper.insert(entity);
        return entity;
    }
    /**

     * 根据主键进行查询,必须保证结果唯一

     * 单个字段做主键时,可以直接写主键的值

     * 联合主键时,key可以是实体类,也可以是Map

     * @param key

     * @return

     */
    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }
    /**

     * 返回单个对象

     * @param entity

     * @return

     */
    public T selectOne(T entity){
        return mapper.selectOne(entity);
    }
    /**

     * 根据对象中不为空的属性查询列表

     */
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }
    /**

     * 根据实体类不为null的字段进行查询,条件全部使用=号and条件

     * @param record

     * @return

     */
    public List<T> select(T entity){
        return mapper.select(entity);
    }
    /**

     * 查询所有记录

     * @return

     */
    public List<T> selectAll(){
        return mapper.selectAll();
    }
    /**

     * 根据实体类不为null的字段查询总数,条件全部使用=号and条件

     * @param record

     * @return

     */
    public int selectCount(T entity){
        return mapper.selectCount(entity);
    }
    /**

     *

     * @param pageNum   当前页

     * @param pageSize  每页显示的记录数

     * @param example

     * @return

     */
    public PageBean<T> getPageBeanByExample(int pageNum, int pageSize, Object example){
        PageHelper.startPage(pageNum, pageSize, true);
        List<T> list=selectByExample(example);
        return new PageBean<T>(list);
    }
    /**

     * 查询所有记录

     * @param pageNum

     * @param pageSize

     * @return

     */
    public PageBean<T> getPageBeanBySelectAll(int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize, true);
        List<T> list=selectAll();
        return new PageBean<T>(list);
    }
    /**

     * 根据主键进行更新,这里最多只会更新一条数据

     * 参数为实体类

     */
    public int updateByPrimaryKey(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }
    /**

     * 根据主键进行更新

     * 只会更新不是null的数据

     */
    public int updateNotNullByPrimaryKey(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }
    /**

     *通过主键进行删除,这里最多只会删除一条数据

     *单个字段做主键时,可以直接写主键的值

     *联合主键时,key可以是实体类,也可以是Map

     *

     */
    public int deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }
    /**

     * 根据实体类中字段不为null的条件进行删除,条件全部使用=号and条件

     * @param key

     * @return

     */
    public int delete(T entity){
        return mapper.delete(entity);
    }
}
