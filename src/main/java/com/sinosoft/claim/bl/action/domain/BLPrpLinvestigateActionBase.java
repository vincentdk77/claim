package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLinvestigateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinvestigate;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLinvestigate-案情调查信息表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.015<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLinvestigateActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLinvestigateActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinvestigateActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //插入记录
        dbPrpLinvestigate.insert(prpLinvestigateDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param serialNo 序号
     * @param objectType 调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,String objectType) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //删除记录
        dbPrpLinvestigate.delete(registNo, serialNo, objectType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //按条件删除记录
        dbPrpLinvestigate.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //更新记录
        dbPrpLinvestigate.update(prpLinvestigateDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param serialNo 序号
     * @param objectType 调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论
     * @return prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public PrpLinvestigateDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,String objectType) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        //声明DTO
        PrpLinvestigateDto prpLinvestigateDto = null;
        //查询数据,赋值给DTO
        prpLinvestigateDto = dbPrpLinvestigate.findByPrimaryKey(registNo, serialNo, objectType);
        return prpLinvestigateDto;
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
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinvestigate.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinvestigate.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinvestigateDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinvestigate.findByConditions(conditions);
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
        DBPrpLinvestigate dbPrpLinvestigate = new DBPrpLinvestigate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinvestigate.getCount(conditions);
        return count;
    }
}
