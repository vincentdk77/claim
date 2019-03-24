package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPseleDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPsele;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utipsele单证打印的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPseleActionBase{
    private static Log log = LogFactory.getLog(BLUtiPseleActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiPseleActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiPseleDto utiPseleDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPseleDto utiPseleDto) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //插入记录
        dbUtiPsele.insert(utiPseleDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param fileName 文件名
     * @param orderNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,String orderNo) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //删除记录
        dbUtiPsele.delete(fileName, orderNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //按条件删除记录
        dbUtiPsele.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiPseleDto utiPseleDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPseleDto utiPseleDto) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //更新记录
        dbUtiPsele.update(utiPseleDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param fileName 文件名
     * @param orderNo 序号
     * @return utiPseleDto utiPseleDto
     * @throws Exception
     */
    public UtiPseleDto findByPrimaryKey(DBManager dbManager,String fileName,String orderNo) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //声明DTO
        UtiPseleDto utiPseleDto = null;
        //查询数据,赋值给DTO
        utiPseleDto = dbUtiPsele.findByPrimaryKey(fileName, orderNo);
        return utiPseleDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiPseleDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPsele.getCount(conditions);
        collection = dbUtiPsele.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPsele.getCount(conditions);
        return count;
    }
}
