package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDpersonPayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDpersonPay;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDpersonPay人员赔付标准金额表的业务逻辑对象类<br>
 * 创建于 2004-09-20 14:11:31.382<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDpersonPayActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonPayActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpDpersonPayActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //插入记录
        dbPrpDpersonPay.insert(prpDpersonPayDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //删除记录
        dbPrpDpersonPay.delete(serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //按条件删除记录
        dbPrpDpersonPay.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //更新记录
        dbPrpDpersonPay.update(prpDpersonPayDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @return prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public PrpDpersonPayDto findByPrimaryKey(DBManager dbManager,int serialNo) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        //声明DTO
        PrpDpersonPayDto prpDpersonPayDto = null;
        //查询数据,赋值给DTO
        prpDpersonPayDto = dbPrpDpersonPay.findByPrimaryKey(serialNo);
        return prpDpersonPayDto;
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
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDpersonPay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDpersonPay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDpersonPayDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDpersonPay.findByConditions(conditions);
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
        DBPrpDpersonPay dbPrpDpersonPay = new DBPrpDpersonPay(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDpersonPay.getCount(conditions);
        return count;
    }
}
