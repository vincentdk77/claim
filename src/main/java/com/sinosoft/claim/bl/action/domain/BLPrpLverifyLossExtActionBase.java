package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLverifyLossExt的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLverifyLossExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossExtActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLverifyLossExtActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLverifyLossExtDto prpLverifyLossExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLverifyLossExtDto prpLverifyLossExtDto)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //插入记录
        dbPrpLverifyLossExt.insert(prpLverifyLossExtDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo RegistNo
     * @param serialNo SerialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,String lossItemCode)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //删除记录
        dbPrpLverifyLossExt.delete(registNo, serialNo,lossItemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //按条件删除记录
        dbPrpLverifyLossExt.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLverifyLossExtDto prpLverifyLossExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLverifyLossExtDto prpLverifyLossExtDto)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //更新记录
        dbPrpLverifyLossExt.update(prpLverifyLossExtDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo RegistNo
     * @param serialNo SerialNo
     * @return prpLverifyLossExtDto prpLverifyLossExtDto
     * @throws Exception
     */
    public PrpLverifyLossExtDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,String lossItemCode)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //声明DTO
        PrpLverifyLossExtDto prpLverifyLossExtDto = null;
        //查询数据,赋值给DTO
        prpLverifyLossExtDto = dbPrpLverifyLossExt.findByPrimaryKey(registNo, serialNo,lossItemCode);
        return prpLverifyLossExtDto;
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
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLverifyLossExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLverifyLossExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLverifyLossExtDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLverifyLossExt.findByConditions(conditions);
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
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLverifyLossExt.getCount(conditions);
        return count;
    }
}
