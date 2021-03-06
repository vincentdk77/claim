package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPvalueDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPvalue;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utipvalue单证打印数据的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPvalueActionBase{
    private static Log log = LogFactory.getLog(BLUtiPvalueActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiPvalueActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiPvalueDto utiPvalueDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPvalueDto utiPvalueDto) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //插入记录
        dbUtiPvalue.insert(utiPvalueDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param ttyName 终端号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String ttyName) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //删除记录
        dbUtiPvalue.delete(ttyName);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //按条件删除记录
        dbUtiPvalue.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiPvalueDto utiPvalueDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPvalueDto utiPvalueDto) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //更新记录
        dbUtiPvalue.update(utiPvalueDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param ttyName 终端号
     * @return utiPvalueDto utiPvalueDto
     * @throws Exception
     */
    public UtiPvalueDto findByPrimaryKey(DBManager dbManager,String ttyName) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        //声明DTO
        UtiPvalueDto utiPvalueDto = null;
        //查询数据,赋值给DTO
        utiPvalueDto = dbUtiPvalue.findByPrimaryKey(ttyName);
        return utiPvalueDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiPvalueDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPvalue.getCount(conditions);
        collection = dbUtiPvalue.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiPvalue dbUtiPvalue = new DBUtiPvalue(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPvalue.getCount(conditions);
        return count;
    }
}
