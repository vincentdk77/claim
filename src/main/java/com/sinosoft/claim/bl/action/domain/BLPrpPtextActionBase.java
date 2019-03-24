package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPtextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPtext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpptext批改文字信息的业务逻辑对象类<br>
 * 创建于 2004-11-22 15:24:31.265<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPtextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPtextActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpPtextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPtextDto prpPtextDto) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //插入记录
        dbPrpPtext.insert(prpPtextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param endorseNo 批单号次
     * @param policyNo 保险单号次
     * @param lineNo 批文的行号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo,String policyNo,int lineNo) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //删除记录
        dbPrpPtext.delete(endorseNo, policyNo, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //按条件删除记录
        dbPrpPtext.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPtextDto prpPtextDto) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //更新记录
        dbPrpPtext.update(prpPtextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param endorseNo 批单号次
     * @param policyNo 保险单号次
     * @param lineNo 批文的行号
     * @return prpPtextDto prpPtextDto
     * @throws Exception
     */
    public PrpPtextDto findByPrimaryKey(DBManager dbManager,String endorseNo,String policyNo,int lineNo) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        //声明DTO
        PrpPtextDto prpPtextDto = null;
        //查询数据,赋值给DTO
        prpPtextDto = dbPrpPtext.findByPrimaryKey(endorseNo, policyNo, lineNo);
        return prpPtextDto;
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
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPtext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPtext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpPtextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPtext.findByConditions(conditions);
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
        DBPrpPtext dbPrpPtext = new DBPrpPtext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPtext.getCount(conditions);
        return count;
    }
}
