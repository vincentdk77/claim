package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcode;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcode通用代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcodeActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDcodeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDcodeDto prpDcodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcodeDto prpDcodeDto) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //插入记录
        dbPrpDcode.insert(prpDcodeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param codeType 代码类型
     * @param codeCode 业务代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType,String codeCode) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //删除记录
        dbPrpDcode.delete(codeType, codeCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //按条件删除记录
        dbPrpDcode.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDcodeDto prpDcodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcodeDto prpDcodeDto) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //更新记录
        dbPrpDcode.update(prpDcodeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param codeType 代码类型
     * @param codeCode 业务代码
     * @return prpDcodeDto prpDcodeDto
     * @throws Exception
     */
    public PrpDcodeDto findByPrimaryKey(DBManager dbManager,String codeType,String codeCode) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        //声明DTO
        PrpDcodeDto prpDcodeDto = null;
        //查询数据,赋值给DTO
        prpDcodeDto = dbPrpDcode.findByPrimaryKey(codeType, codeCode);
        return prpDcodeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDcodeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcode.getCount(conditions);
        collection = dbPrpDcode.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcode.getCount(conditions);
        return count;
    }
}
