package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLCMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLCMain-代赔保单主表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.171<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCMainActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLCMainActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLCMainActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLCMainDto prpLCMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLCMainDto prpLCMainDto) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //插入记录
        dbPrpLCMain.insert(prpLCMainDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //删除记录
        dbPrpLCMain.delete(registNo, policyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //按条件删除记录
        dbPrpLCMain.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLCMainDto prpLCMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLCMainDto prpLCMainDto) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //更新记录
        dbPrpLCMain.update(prpLCMainDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @return prpLCMainDto prpLCMainDto
     * @throws Exception
     */
    public PrpLCMainDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        //声明DTO
        PrpLCMainDto prpLCMainDto = null;
        //查询数据,赋值给DTO
        prpLCMainDto = dbPrpLCMain.findByPrimaryKey(registNo, policyNo);
        return prpLCMainDto;
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
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLCMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLCMainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLCMain.findByConditions(conditions);
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
        DBPrpLCMain dbPrpLCMain = new DBPrpLCMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLCMain.getCount(conditions);
        return count;
    }
}
