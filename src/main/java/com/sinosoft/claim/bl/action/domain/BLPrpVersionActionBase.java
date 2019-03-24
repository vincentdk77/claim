package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpVersionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpVersion;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpversion数据库版本信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpVersionActionBase{
    private static Log log = LogFactory.getLog(BLPrpVersionActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpVersionActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpVersionDto prpVersionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpVersionDto prpVersionDto) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //插入记录
        dbPrpVersion.insert(prpVersionDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param projectVersion 项目版本号
     * @param productID 产品标识
     * @param times 变更次数
     * @throws Exception
     */
    public void delete(DBManager dbManager,String projectVersion,String productID,int times) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //删除记录
        dbPrpVersion.delete(projectVersion, productID, times);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //按条件删除记录
        dbPrpVersion.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpVersionDto prpVersionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpVersionDto prpVersionDto) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //更新记录
        dbPrpVersion.update(prpVersionDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param projectVersion 项目版本号
     * @param productID 产品标识
     * @param times 变更次数
     * @return prpVersionDto prpVersionDto
     * @throws Exception
     */
    public PrpVersionDto findByPrimaryKey(DBManager dbManager,String projectVersion,String productID,int times) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //声明DTO
        PrpVersionDto prpVersionDto = null;
        //查询数据,赋值给DTO
        prpVersionDto = dbPrpVersion.findByPrimaryKey(projectVersion, productID, times);
        return prpVersionDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpVersionDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpVersion.getCount(conditions);
        collection = dbPrpVersion.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpVersion.getCount(conditions);
        return count;
    }
}
