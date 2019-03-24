package com.sinosoft.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLnodutyLoss;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLNODUTYLOSS的业务逻辑对象类<br>
 */
public class BLPrplnodutylossActionBase{
    private static Logger logger = Logger.getLogger(BLPrplnodutylossActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplnodutylossActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplnodutylossDto prplnodutylossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLnodutyLossDto prplnodutylossDto)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //插入记录
        dbPrplnodutyloss.insert(prplnodutylossDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateno COMPENSATENO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateno,int serialno)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //删除记录
        dbPrplnodutyloss.delete(compensateno, serialno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //按条件删除记录
        dbPrplnodutyloss.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplnodutylossDto prplnodutylossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLnodutyLossDto prplnodutylossDto)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //更新记录
        dbPrplnodutyloss.update(prplnodutylossDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateno COMPENSATENO
     * @param serialno SERIALNO
     * @return prplnodutylossDto prplnodutylossDto
     * @throws Exception
     */
    public PrpLnodutyLossDto findByPrimaryKey(DBManager dbManager,String compensateno,int serialno)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //声明DTO
    	PrpLnodutyLossDto prplnodutylossDto = null;
        //查询数据,赋值给DTO
        prplnodutylossDto = dbPrplnodutyloss.findByPrimaryKey(compensateno, serialno);
        return prplnodutylossDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplnodutyloss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplnodutyloss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplnodutylossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplnodutyloss.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplnodutyloss.getCount(conditions);
        return count;
    }
}
