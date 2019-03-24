package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGroupDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGroup;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgroup单证分组的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGroupActionBase{
    private static Log log = LogFactory.getLog(BLPrpGroupActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpGroupActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpGroupDto prpGroupDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGroupDto prpGroupDto) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //插入记录
        dbPrpGroup.insert(prpGroupDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param groupNo 合编组
     * @param subGroupNo 分编组
     * @throws Exception
     */
    public void delete(DBManager dbManager,String groupNo,String subGroupNo) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //删除记录
        dbPrpGroup.delete(groupNo, subGroupNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //按条件删除记录
        dbPrpGroup.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpGroupDto prpGroupDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGroupDto prpGroupDto) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //更新记录
        dbPrpGroup.update(prpGroupDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param groupNo 合编组
     * @param subGroupNo 分编组
     * @return prpGroupDto prpGroupDto
     * @throws Exception
     */
    public PrpGroupDto findByPrimaryKey(DBManager dbManager,String groupNo,String subGroupNo) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        //声明DTO
        PrpGroupDto prpGroupDto = null;
        //查询数据,赋值给DTO
        prpGroupDto = dbPrpGroup.findByPrimaryKey(groupNo, subGroupNo);
        return prpGroupDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpGroupDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGroup.getCount(conditions);
        collection = dbPrpGroup.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGroup dbPrpGroup = new DBPrpGroup(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGroup.getCount(conditions);
        return count;
    }
}
