package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDidentifierDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDidentifier;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdidentifier检验人代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDidentifierActionBase{
    private static Log log = LogFactory.getLog(BLPrpDidentifierActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDidentifierActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDidentifierDto prpDidentifierDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDidentifierDto prpDidentifierDto) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //插入记录
        dbPrpDidentifier.insert(prpDidentifierDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param identifierCode 检验人代码
     * @param portCode 港口代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String identifierCode,String portCode) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //删除记录
        dbPrpDidentifier.delete(identifierCode, portCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //按条件删除记录
        dbPrpDidentifier.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDidentifierDto prpDidentifierDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDidentifierDto prpDidentifierDto) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //更新记录
        dbPrpDidentifier.update(prpDidentifierDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param identifierCode 检验人代码
     * @param portCode 港口代码
     * @return prpDidentifierDto prpDidentifierDto
     * @throws Exception
     */
    public PrpDidentifierDto findByPrimaryKey(DBManager dbManager,String identifierCode,String portCode) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        //声明DTO
        PrpDidentifierDto prpDidentifierDto = null;
        //查询数据,赋值给DTO
        prpDidentifierDto = dbPrpDidentifier.findByPrimaryKey(identifierCode, portCode);
        return prpDidentifierDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDidentifierDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDidentifier.getCount(conditions);
        collection = dbPrpDidentifier.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDidentifier dbPrpDidentifier = new DBPrpDidentifier(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDidentifier.getCount(conditions);
        return count;
    }
}
