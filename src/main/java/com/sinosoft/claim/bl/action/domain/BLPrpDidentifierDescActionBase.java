package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDidentifierDescDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDidentifierDesc;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdidentifierdesc检验人文本描述表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDidentifierDescActionBase{
    private static Log log = LogFactory.getLog(BLPrpDidentifierDescActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDidentifierDescActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDidentifierDescDto prpDidentifierDescDto) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //插入记录
        dbPrpDidentifierDesc.insert(prpDidentifierDescDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param identifierCode 检验人代码
     * @param lineNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String identifierCode,int lineNo) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //删除记录
        dbPrpDidentifierDesc.delete(identifierCode, lineNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //按条件删除记录
        dbPrpDidentifierDesc.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDidentifierDescDto prpDidentifierDescDto) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //更新记录
        dbPrpDidentifierDesc.update(prpDidentifierDescDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param identifierCode 检验人代码
     * @param lineNo 序号
     * @return prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public PrpDidentifierDescDto findByPrimaryKey(DBManager dbManager,String identifierCode,int lineNo) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //声明DTO
        PrpDidentifierDescDto prpDidentifierDescDto = null;
        //查询数据,赋值给DTO
        prpDidentifierDescDto = dbPrpDidentifierDesc.findByPrimaryKey(identifierCode, lineNo);
        return prpDidentifierDescDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDidentifierDescDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDidentifierDesc.getCount(conditions);
        collection = dbPrpDidentifierDesc.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDidentifierDesc.getCount(conditions);
        return count;
    }
}
