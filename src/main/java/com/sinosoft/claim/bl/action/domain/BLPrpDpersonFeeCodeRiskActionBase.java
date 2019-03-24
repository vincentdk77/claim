package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDpersonFeeCodeRisk;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDpersonFeeCodeRisk-人伤费用险种对照表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDpersonFeeCodeRiskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonFeeCodeRiskActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpDpersonFeeCodeRiskActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //插入记录
        dbPrpDpersonFeeCodeRisk.insert(prpDpersonFeeCodeRiskDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param feeCode 费用代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String feeCode)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //删除记录
        dbPrpDpersonFeeCodeRisk.delete(riskCode, feeCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //按条件删除记录
        dbPrpDpersonFeeCodeRisk.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //更新记录
        dbPrpDpersonFeeCodeRisk.update(prpDpersonFeeCodeRiskDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param feeCode 费用代码
     * @return prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public PrpDpersonFeeCodeRiskDto findByPrimaryKey(DBManager dbManager,String riskCode,String feeCode)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        //声明DTO
        PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = null;
        //查询数据,赋值给DTO
        prpDpersonFeeCodeRiskDto = dbPrpDpersonFeeCodeRisk.findByPrimaryKey(riskCode, feeCode);
        return prpDpersonFeeCodeRiskDto;
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
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDpersonFeeCodeRisk.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDpersonFeeCodeRisk.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDpersonFeeCodeRiskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDpersonFeeCodeRisk.findByConditions(conditions);
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
        DBPrpDpersonFeeCodeRisk dbPrpDpersonFeeCodeRisk = new DBPrpDpersonFeeCodeRisk(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDpersonFeeCodeRisk.getCount(conditions);
        return count;
    }
}
