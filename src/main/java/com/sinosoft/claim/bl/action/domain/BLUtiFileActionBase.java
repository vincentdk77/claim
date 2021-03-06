package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiFileDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiFile;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utifile打印文件表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiFileActionBase{
    private static Log log = LogFactory.getLog(BLUtiFileActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiFileActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiFileDto utiFileDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiFileDto utiFileDto) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //插入记录
        dbUtiFile.insert(utiFileDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param fileName 文件名称
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,int lineNo) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //删除记录
        dbUtiFile.delete(fileName, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //按条件删除记录
        dbUtiFile.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiFileDto utiFileDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiFileDto utiFileDto) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //更新记录
        dbUtiFile.update(utiFileDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param fileName 文件名称
     * @param lineNo 行号
     * @return utiFileDto utiFileDto
     * @throws Exception
     */
    public UtiFileDto findByPrimaryKey(DBManager dbManager,String fileName,int lineNo) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //声明DTO
        UtiFileDto utiFileDto = null;
        //查询数据,赋值给DTO
        utiFileDto = dbUtiFile.findByPrimaryKey(fileName, lineNo);
        return utiFileDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiFileDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiFile.getCount(conditions);
        collection = dbUtiFile.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiFile.getCount(conditions);
        return count;
    }
}
