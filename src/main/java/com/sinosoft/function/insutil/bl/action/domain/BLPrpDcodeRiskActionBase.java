package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcodeRiskDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDcodeRisk;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcoderisk的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcodeRiskActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcodeRiskActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDcodeRiskActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDcodeRiskDto prpDcodeRiskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcodeRiskDto prpDcodeRiskDto) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //插入记录
        dbPrpDcodeRisk.insert(prpDcodeRiskDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param codeType codetype
     * @param codeCode codecode
     * @param riskCode riskcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType,String codeCode,String riskCode) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //删除记录
        dbPrpDcodeRisk.delete(codeType, codeCode, riskCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //按条件删除记录
        dbPrpDcodeRisk.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDcodeRiskDto prpDcodeRiskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcodeRiskDto prpDcodeRiskDto) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //更新记录
        dbPrpDcodeRisk.update(prpDcodeRiskDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param codeType codetype
     * @param codeCode codecode
     * @param riskCode riskcode
     * @return prpDcodeRiskDto prpDcodeRiskDto
     * @throws Exception
     */
    public PrpDcodeRiskDto findByPrimaryKey(DBManager dbManager,String codeType,String codeCode,String riskCode) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //声明DTO
        PrpDcodeRiskDto prpDcodeRiskDto = null;
        //查询数据,赋值给DTO
        prpDcodeRiskDto = dbPrpDcodeRisk.findByPrimaryKey(codeType, codeCode, riskCode);
        return prpDcodeRiskDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDcodeRiskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDcodeRisk.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcodeRisk.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDcodeRiskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getCount(){
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcodeRisk.getCount(conditions);
        return count;
    }
}
