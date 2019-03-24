package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtParDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiPrtPar;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiprtpar的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtParActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtParActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiPrtParActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiPrtParDto utiPrtParDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPrtParDto utiPrtParDto) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //插入记录
        dbUtiPrtPar.insert(utiPrtParDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param fileName filename
     * @param labelNo labelno
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //删除记录
        dbUtiPrtPar.delete(fileName, labelNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //按条件删除记录
        dbUtiPrtPar.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiPrtParDto utiPrtParDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPrtParDto utiPrtParDto) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //更新记录
        dbUtiPrtPar.update(utiPrtParDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param fileName filename
     * @param labelNo labelno
     * @return utiPrtParDto utiPrtParDto
     * @throws Exception
     */
    public UtiPrtParDto findByPrimaryKey(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //声明DTO
        UtiPrtParDto utiPrtParDto = null;
        //查询数据,赋值给DTO
        utiPrtParDto = dbUtiPrtPar.findByPrimaryKey(fileName, labelNo);
        return utiPrtParDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiPrtParDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiPrtPar.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiPrtPar.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含utiPrtParDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getCount(){
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPrtPar.getCount(conditions);
        return count;
    }
}
