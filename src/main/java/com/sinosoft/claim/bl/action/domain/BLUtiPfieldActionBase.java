package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPfieldDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPfield;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utipfield单证打印的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPfieldActionBase{
    private static Log log = LogFactory.getLog(BLUtiPfieldActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiPfieldActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPfieldDto utiPfieldDto) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //插入记录
        dbUtiPfield.insert(utiPfieldDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param fileName 文件名称
     * @param labelNo 标号(格式标号)
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //删除记录
        dbUtiPfield.delete(fileName, labelNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //按条件删除记录
        dbUtiPfield.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPfieldDto utiPfieldDto) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //更新记录
        dbUtiPfield.update(utiPfieldDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param fileName 文件名称
     * @param labelNo 标号(格式标号)
     * @return utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public UtiPfieldDto findByPrimaryKey(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        //声明DTO
        UtiPfieldDto utiPfieldDto = null;
        //查询数据,赋值给DTO
        utiPfieldDto = dbUtiPfield.findByPrimaryKey(fileName, labelNo);
        return utiPfieldDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiPfieldDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPfield.getCount(conditions);
        collection = dbUtiPfield.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPfield dbUtiPfield = new DBUtiPfield(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPfield.getCount(conditions);
        return count;
    }
}
