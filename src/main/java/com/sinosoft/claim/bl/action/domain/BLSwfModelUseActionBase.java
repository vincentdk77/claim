package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfModelUse;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfModelUse模板使用设置（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.296<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfModelUseActionBase{
    private static Log logger = LogFactory.getLog(BLSwfModelUseActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfModelUseActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfModelUseDto swfModelUseDto) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //插入记录
        dbSwfModelUse.insert(swfModelUseDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编号
     * @param riskCode 险种代码
     * @param comCode 部门编码
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,String riskCode,String comCode) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //删除记录
        dbSwfModelUse.delete(modelNo, riskCode, comCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //按条件删除记录
        dbSwfModelUse.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfModelUseDto swfModelUseDto) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //更新记录
        dbSwfModelUse.update(swfModelUseDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编号
     * @param riskCode 险种代码
     * @param comCode 部门编码
     * @return swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public SwfModelUseDto findByPrimaryKey(DBManager dbManager,int modelNo,String riskCode,String comCode) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //声明DTO
        SwfModelUseDto swfModelUseDto = null;
        //查询数据,赋值给DTO
        swfModelUseDto = dbSwfModelUse.findByPrimaryKey(modelNo, riskCode, comCode);
        return swfModelUseDto;
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
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfModelUse.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfModelUse.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfModelUseDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfModelUse.findByConditions(conditions);
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
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfModelUse.getCount(conditions);
        return count;
    }
}
