package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLloss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLlossFG;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLloss-赔付标的信息表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLlossActionBaseFG{
    private static Log logger = LogFactory.getLog(BLPrpLlossActionBaseFG.class);

    /**
     * 构造函数
     */
    public BLPrpLlossActionBaseFG(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLlossDto prpLlossDto) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //插入记录
        dbPrpLloss.insert(prpLlossDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //删除记录
        dbPrpLloss.delete(compensateNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //按条件删除记录
        dbPrpLloss.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLlossDto prpLlossDto) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //更新记录
        dbPrpLloss.update(prpLlossDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @return prpLlossDto prpLlossDto
     * @throws Exception
     */
    public PrpLlossDto findByPrimaryKey(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        //声明DTO
        PrpLlossDto prpLlossDto = null;
        //查询数据,赋值给DTO
        prpLlossDto = dbPrpLloss.findByPrimaryKey(compensateNo, serialNo);
        return prpLlossDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLloss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLloss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLlossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLlossFG dbPrpLloss = new DBPrpLlossFG(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLloss.findByConditions(conditions);
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
        DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLloss.getCount(conditions);
        return count;
    }
}
