package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtCodeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPrtCode;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiprtcode打印控制指令代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtCodeActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtCodeActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiPrtCodeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiPrtCodeDto utiPrtCodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPrtCodeDto utiPrtCodeDto) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //插入记录
        dbUtiPrtCode.insert(utiPrtCodeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param instructType 指令类别
     * @param instructCode 指令代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String instructType,String instructCode) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //删除记录
        dbUtiPrtCode.delete(instructType, instructCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //按条件删除记录
        dbUtiPrtCode.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiPrtCodeDto utiPrtCodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPrtCodeDto utiPrtCodeDto) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //更新记录
        dbUtiPrtCode.update(utiPrtCodeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param instructType 指令类别
     * @param instructCode 指令代码
     * @return utiPrtCodeDto utiPrtCodeDto
     * @throws Exception
     */
    public UtiPrtCodeDto findByPrimaryKey(DBManager dbManager,String instructType,String instructCode) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //声明DTO
        UtiPrtCodeDto utiPrtCodeDto = null;
        //查询数据,赋值给DTO
        utiPrtCodeDto = dbUtiPrtCode.findByPrimaryKey(instructType, instructCode);
        return utiPrtCodeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiPrtCodeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPrtCode.getCount(conditions);
        collection = dbUtiPrtCode.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPrtCode.getCount(conditions);
        return count;
    }
}
