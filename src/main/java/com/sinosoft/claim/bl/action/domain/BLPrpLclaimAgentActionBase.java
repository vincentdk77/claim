package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimAgentDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimAgent;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimAgent-代理赔保单信息表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimAgentActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimAgentActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimAgentActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimAgentDto prpLclaimAgentDto) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //插入记录
        dbPrpLclaimAgent.insert(prpLclaimAgentDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //删除记录
        dbPrpLclaimAgent.delete(claimNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //按条件删除记录
        dbPrpLclaimAgent.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimAgentDto prpLclaimAgentDto) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //更新记录
        dbPrpLclaimAgent.update(prpLclaimAgentDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @return prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public PrpLclaimAgentDto findByPrimaryKey(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //声明DTO
        PrpLclaimAgentDto prpLclaimAgentDto = null;
        //查询数据,赋值给DTO
        prpLclaimAgentDto = dbPrpLclaimAgent.findByPrimaryKey(claimNo);
        return prpLclaimAgentDto;
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
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimAgent.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimAgent.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimAgentDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimAgent.findByConditions(conditions);
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
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimAgent.getCount(conditions);
        return count;
    }
}
