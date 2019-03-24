package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdriverDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDdriver;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpddriver机动车险司机代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdriverActionBase{
    private static Log log = LogFactory.getLog(BLPrpDdriverActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDdriverActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDdriverDto prpDdriverDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDdriverDto prpDdriverDto) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //插入记录
        dbPrpDdriver.insert(prpDdriverDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param drivingLicenseNo 驾驶员驾驶证号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String drivingLicenseNo) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //删除记录
        dbPrpDdriver.delete(drivingLicenseNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //按条件删除记录
        dbPrpDdriver.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDdriverDto prpDdriverDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDdriverDto prpDdriverDto) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //更新记录
        dbPrpDdriver.update(prpDdriverDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param drivingLicenseNo 驾驶员驾驶证号码
     * @return prpDdriverDto prpDdriverDto
     * @throws Exception
     */
    public PrpDdriverDto findByPrimaryKey(DBManager dbManager,String drivingLicenseNo) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        //声明DTO
        PrpDdriverDto prpDdriverDto = null;
        //查询数据,赋值给DTO
        prpDdriverDto = dbPrpDdriver.findByPrimaryKey(drivingLicenseNo);
        return prpDdriverDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDdriverDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDdriver.getCount(conditions);
        collection = dbPrpDdriver.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDdriver dbPrpDdriver = new DBPrpDdriver(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDdriver.getCount(conditions);
        return count;
    }
}
