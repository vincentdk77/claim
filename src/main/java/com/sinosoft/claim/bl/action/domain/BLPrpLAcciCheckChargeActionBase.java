package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLAcciCheckCharge;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是调查费用表-PrpLAcciCheckCharge的业务逻辑对象类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciCheckChargeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLAcciCheckChargeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLAcciCheckChargeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //插入记录
        dbPrpLAcciCheckCharge.insert(prpLAcciCheckChargeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param checkNo 调查号-CheckNo
     * @param serialNo 序号-SerialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String checkNo,int serialNo)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //删除记录
        dbPrpLAcciCheckCharge.delete(checkNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //按条件删除记录
        dbPrpLAcciCheckCharge.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //更新记录
        dbPrpLAcciCheckCharge.update(prpLAcciCheckChargeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param checkNo 调查号-CheckNo
     * @param serialNo 序号-SerialNo
     * @return prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public PrpLAcciCheckChargeDto findByPrimaryKey(DBManager dbManager,String checkNo,int serialNo)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        //声明DTO
        PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = null;
        //查询数据,赋值给DTO
        prpLAcciCheckChargeDto = dbPrpLAcciCheckCharge.findByPrimaryKey(checkNo, serialNo);
        return prpLAcciCheckChargeDto;
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
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLAcciCheckCharge.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLAcciCheckCharge.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLAcciCheckChargeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLAcciCheckCharge.findByConditions(conditions);
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
        DBPrpLAcciCheckCharge dbPrpLAcciCheckCharge = new DBPrpLAcciCheckCharge(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLAcciCheckCharge.getCount(conditions);
        return count;
    }
}
