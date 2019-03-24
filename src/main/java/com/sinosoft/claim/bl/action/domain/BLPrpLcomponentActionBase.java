package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomponent;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcomponent-换件项目清单(修改)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.000<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcomponentActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcomponentActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcomponentActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcomponentDto prpLcomponentDto) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //插入记录
        dbPrpLcomponent.insert(prpLcomponentDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,int serialNo,String lossItemCode) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //删除记录
        dbPrpLcomponent.delete(riskCode, serialNo, lossItemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //按条件删除记录
        dbPrpLcomponent.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcomponentDto prpLcomponentDto) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //更新记录
        dbPrpLcomponent.update(prpLcomponentDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @return prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public PrpLcomponentDto findByPrimaryKey(DBManager dbManager,String riskCode,int serialNo,String lossItemCode) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //声明DTO
        PrpLcomponentDto prpLcomponentDto = null;
        //查询数据,赋值给DTO
        prpLcomponentDto = dbPrpLcomponent.findByPrimaryKey(riskCode, serialNo, lossItemCode);
        return prpLcomponentDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcomponent.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcomponent.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcomponentDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcomponent.findByConditions(conditions);
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
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcomponent.getCount(conditions);
        return count;
    }
}
