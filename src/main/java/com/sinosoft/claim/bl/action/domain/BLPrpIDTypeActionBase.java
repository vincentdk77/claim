package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpIDTypeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpIDType;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpidtype接口代码类型表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDTypeActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpIDTypeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpIDTypeDto prpIDTypeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpIDTypeDto prpIDTypeDto) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //插入记录
        dbPrpIDType.insert(prpIDTypeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param codeType 接口代码类型
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //删除记录
        dbPrpIDType.delete(codeType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //按条件删除记录
        dbPrpIDType.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpIDTypeDto prpIDTypeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpIDTypeDto prpIDTypeDto) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //更新记录
        dbPrpIDType.update(prpIDTypeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param codeType 接口代码类型
     * @return prpIDTypeDto prpIDTypeDto
     * @throws Exception
     */
    public PrpIDTypeDto findByPrimaryKey(DBManager dbManager,String codeType) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        //声明DTO
        PrpIDTypeDto prpIDTypeDto = null;
        //查询数据,赋值给DTO
        prpIDTypeDto = dbPrpIDType.findByPrimaryKey(codeType);
        return prpIDTypeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpIDTypeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpIDType.getCount(conditions);
        collection = dbPrpIDType.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpIDType dbPrpIDType = new DBPrpIDType(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpIDType.getCount(conditions);
        return count;
    }
}
