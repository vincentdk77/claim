package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPatchRecDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJrefPatchRec;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefpatchrec批量付费登记表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefPatchRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefPatchRecActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpJrefPatchRecActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJrefPatchRecDto prpJrefPatchRecDto) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //插入记录
        dbPrpJrefPatchRec.insert(prpJrefPatchRecDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param refundGroupNo 批量付费登记号
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String refundGroupNo,String certiNo,int serialNo) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //删除记录
        dbPrpJrefPatchRec.delete(refundGroupNo, certiNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //按条件删除记录
        dbPrpJrefPatchRec.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJrefPatchRecDto prpJrefPatchRecDto) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //更新记录
        dbPrpJrefPatchRec.update(prpJrefPatchRecDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param refundGroupNo 批量付费登记号
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @return prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public PrpJrefPatchRecDto findByPrimaryKey(DBManager dbManager,String refundGroupNo,String certiNo,int serialNo) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //声明DTO
        PrpJrefPatchRecDto prpJrefPatchRecDto = null;
        //查询数据,赋值给DTO
        prpJrefPatchRecDto = dbPrpJrefPatchRec.findByPrimaryKey(refundGroupNo, certiNo, serialNo);
        return prpJrefPatchRecDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpJrefPatchRecDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJrefPatchRec.getCount(conditions);
        collection = dbPrpJrefPatchRec.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJrefPatchRec.getCount(conditions);
        return count;
    }
}
