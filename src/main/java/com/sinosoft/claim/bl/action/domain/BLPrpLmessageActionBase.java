package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLmessage;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLmessage理赔流转讨论留言表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmessageActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmessageActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLmessageActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLmessageDto prpLmessageDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLmessageDto prpLmessageDto) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //插入记录
        dbPrpLmessage.insert(prpLmessageDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,int lineNo) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //删除记录
        dbPrpLmessage.delete(registNo, serialNo, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //按条件删除记录
        dbPrpLmessage.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLmessageDto prpLmessageDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLmessageDto prpLmessageDto) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //更新记录
        dbPrpLmessage.update(prpLmessageDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param lineNo 行号
     * @return prpLmessageDto prpLmessageDto
     * @throws Exception
     */
    public PrpLmessageDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,int lineNo) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        //声明DTO
        PrpLmessageDto prpLmessageDto = null;
        //查询数据,赋值给DTO
        prpLmessageDto = dbPrpLmessage.findByPrimaryKey(registNo, serialNo, lineNo);
        return prpLmessageDto;
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
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmessage.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLmessage.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLmessageDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLmessage.findByConditions(conditions);
        return collection;
    }
    /**
     * 按条件查询多条数据(呼叫中心接口使用，输入日期类型为(yyyy-mm-dd hh24:mi:ss))
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLmessageDto的集合
     * @throws Exception
     */
    public Collection findByConditions1(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLmessage.findByConditions1(conditions);
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
        DBPrpLmessage dbPrpLmessage = new DBPrpLmessage(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmessage.getCount(conditions);
        return count;
    }
}
