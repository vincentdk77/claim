package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiCodeTransfer;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiCodeTransfer -险种险类代码对照表的业务逻辑对象类<br>
 * 创建于 2005-05-09 09:01:23.421<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLUtiCodeTransferActionBase{
    private static Log logger = LogFactory.getLog(BLUtiCodeTransferActionBase.class);

    /**
     * 构造函数
     */
    public BLUtiCodeTransferActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiCodeTransferDto utiCodeTransferDto) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //插入记录
        dbUtiCodeTransfer.insert(utiCodeTransferDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param configCode 程序中代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String configCode) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //删除记录
        dbUtiCodeTransfer.delete(configCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //按条件删除记录
        dbUtiCodeTransfer.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiCodeTransferDto utiCodeTransferDto) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //更新记录
        dbUtiCodeTransfer.update(utiCodeTransferDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param configCode 程序中代码
     * @return utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public UtiCodeTransferDto findByPrimaryKey(DBManager dbManager,String configCode) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        //声明DTO
        UtiCodeTransferDto utiCodeTransferDto = null;
        //查询数据,赋值给DTO
        utiCodeTransferDto = dbUtiCodeTransfer.findByPrimaryKey(configCode);
        return utiCodeTransferDto;
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
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiCodeTransfer.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiCodeTransfer.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含utiCodeTransferDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbUtiCodeTransfer.findByConditions(conditions);
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
        DBUtiCodeTransfer dbUtiCodeTransfer = new DBUtiCodeTransfer(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiCodeTransfer.getCount(conditions);
        return count;
    }
}
