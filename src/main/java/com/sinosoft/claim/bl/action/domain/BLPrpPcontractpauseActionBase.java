package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPcontractpauseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcontractpause;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpPcontractpause中止保险合同信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPcontractpauseActionBase{
    private static Log log = LogFactory.getLog(BLPrpPcontractpauseActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpPcontractpauseActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPcontractpauseDto prpPcontractpauseDto) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //插入记录
        dbPrpPcontractpause.insert(prpPcontractpauseDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param endorseNo 批单号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //删除记录
        dbPrpPcontractpause.delete(endorseNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //按条件删除记录
        dbPrpPcontractpause.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPcontractpauseDto prpPcontractpauseDto) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //更新记录
        dbPrpPcontractpause.update(prpPcontractpauseDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param endorseNo 批单号
     * @return prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public PrpPcontractpauseDto findByPrimaryKey(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //声明DTO
        PrpPcontractpauseDto prpPcontractpauseDto = null;
        //查询数据,赋值给DTO
        prpPcontractpauseDto = dbPrpPcontractpause.findByPrimaryKey(endorseNo);
        return prpPcontractpauseDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpPcontractpauseDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpPcontractpause.getCount(conditions);
        collection = dbPrpPcontractpause.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcontractpause.getCount(conditions);
        return count;
    }
}
