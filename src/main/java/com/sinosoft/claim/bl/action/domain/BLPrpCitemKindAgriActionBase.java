package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemKindAgri;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpCitemKindAgri的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCitemKindAgriActionBase{
    private static Log logger = LogFactory.getLog(BLPrpCitemKindAgriActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpCitemKindAgriActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCitemKindAgriDto prpCitemKindAgriDto)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //插入记录
        dbPrpCitemKindAgri.insert(prpCitemKindAgriDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo PolicyNo
     * @param itemKindNo ItemKindNo
     * @param kindCode KindCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,long itemKindNo,String kindCode)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //删除记录
        dbPrpCitemKindAgri.delete(policyNo, itemKindNo, kindCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //按条件删除记录
        dbPrpCitemKindAgri.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCitemKindAgriDto prpCitemKindAgriDto)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //更新记录
        dbPrpCitemKindAgri.update(prpCitemKindAgriDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo PolicyNo
     * @param itemKindNo ItemKindNo
     * @param kindCode KindCode
     * @return prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public PrpCitemKindAgriDto findByPrimaryKey(DBManager dbManager,String policyNo,long itemKindNo,String kindCode)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        //声明DTO
        PrpCitemKindAgriDto prpCitemKindAgriDto = null;
        //查询数据,赋值给DTO
        prpCitemKindAgriDto = dbPrpCitemKindAgri.findByPrimaryKey(policyNo, itemKindNo, kindCode);
        return prpCitemKindAgriDto;
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
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCitemKindAgri.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpCitemKindAgri.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpCitemKindAgriDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpCitemKindAgri.findByConditions(conditions);
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
        DBPrpCitemKindAgri dbPrpCitemKindAgri = new DBPrpCitemKindAgri(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCitemKindAgri.getCount(conditions);
        return count;
    }
}
