package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCengage;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcengage特别约定表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCengageActionBase{
    private static Log log = LogFactory.getLog(BLPrpCengageActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCengageActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCengageDto prpCengageDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCengageDto prpCengageDto) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //插入记录
        dbPrpCengage.insert(prpCengageDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @param lineNo 行序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo,int lineNo) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //删除记录
        dbPrpCengage.delete(policyNo, serialNo, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //按条件删除记录
        dbPrpCengage.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCengageDto prpCengageDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCengageDto prpCengageDto) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //更新记录
        dbPrpCengage.update(prpCengageDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @param lineNo 行序号
     * @return prpCengageDto prpCengageDto
     * @throws Exception
     */
    public PrpCengageDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo,int lineNo) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        //声明DTO
        PrpCengageDto prpCengageDto = null;
        //查询数据,赋值给DTO
        prpCengageDto = dbPrpCengage.findByPrimaryKey(policyNo, serialNo, lineNo);
        return prpCengageDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCengageDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCengage.getCount(conditions);
        collection = dbPrpCengage.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCengage dbPrpCengage = new DBPrpCengage(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCengage.getCount(conditions);
        return count;
    }
}
