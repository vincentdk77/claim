package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDclauseKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDclauseKind;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdclausekind条款险别关系表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:46<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDclauseKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpDclauseKindActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDclauseKindActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDclauseKindDto prpDclauseKindDto) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //插入记录
        dbPrpDclauseKind.insert(prpDclauseKindDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param clauseType 条款类别
     * @param kindCode 险别代码
     * @param relateKindCode 关联险别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String clauseType,String kindCode,String relateKindCode) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //删除记录
        dbPrpDclauseKind.delete(riskCode, clauseType, kindCode, relateKindCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //按条件删除记录
        dbPrpDclauseKind.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDclauseKindDto prpDclauseKindDto) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //更新记录
        dbPrpDclauseKind.update(prpDclauseKindDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param clauseType 条款类别
     * @param kindCode 险别代码
     * @param relateKindCode 关联险别代码
     * @return prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public PrpDclauseKindDto findByPrimaryKey(DBManager dbManager,String riskCode,String clauseType,String kindCode,String relateKindCode) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        //声明DTO
        PrpDclauseKindDto prpDclauseKindDto = null;
        //查询数据,赋值给DTO
        prpDclauseKindDto = dbPrpDclauseKind.findByPrimaryKey(riskCode, clauseType, kindCode, relateKindCode);
        return prpDclauseKindDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDclauseKindDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDclauseKind.getCount(conditions);
        collection = dbPrpDclauseKind.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDclauseKind dbPrpDclauseKind = new DBPrpDclauseKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDclauseKind.getCount(conditions);
        return count;
    }
}
