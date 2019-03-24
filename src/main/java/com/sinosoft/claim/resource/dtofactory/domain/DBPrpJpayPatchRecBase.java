package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayPatchRecDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpaypatchrec批量收费登记表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpayPatchRecBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJpayPatchRecBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJpayPatchRecBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public void insert(PrpJpayPatchRecDto prpJpayPatchRecDto) throws Exception{
        String statement = " Insert Into PrpJpayPatchRec(" + 
                           " PayGroupNo," + 
                           " CertiNo," + 
                           " SerialNo) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJpayPatchRecDto.getPayGroupNo());
        dbManager.setString(2,prpJpayPatchRecDto.getCertiNo());
        dbManager.setInt(3,prpJpayPatchRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayPatchRecBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJpayPatchRecDto prpJpayPatchRecDto = (PrpJpayPatchRecDto)i.next();
            insert(prpJpayPatchRecDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param payGroupNo 批量收费登记号
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次收费序号
     * @throws Exception
     */
    public void delete(String payGroupNo,String certiNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJpayPatchRec Where " +
                           " PayGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,payGroupNo);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJpayPatchRecBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public void update(PrpJpayPatchRecDto prpJpayPatchRecDto) throws Exception{
        String statement = " Update PrpJpayPatchRec Set  Where " +
                           " PayGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        //设置条件字段;
        dbManager.setString(1,prpJpayPatchRecDto.getPayGroupNo());
        dbManager.setString(2,prpJpayPatchRecDto.getCertiNo());
        dbManager.setInt(3,prpJpayPatchRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayPatchRecBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param payGroupNo 批量收费登记号
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次收费序号
     * @return PrpJpayPatchRecDto
     * @throws Exception
     */
    public PrpJpayPatchRecDto findByPrimaryKey(String payGroupNo,String certiNo,int serialNo) throws Exception{
        String statement = " Select PayGroupNo," + 
                           " CertiNo," + 
                           " SerialNo From PrpJpayPatchRec Where " +
                           " PayGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        PrpJpayPatchRecDto prpJpayPatchRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,payGroupNo);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJpayPatchRecDto = new PrpJpayPatchRecDto();
            prpJpayPatchRecDto.setPayGroupNo(dbManager.getString(resultSet,1));
            prpJpayPatchRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJpayPatchRecDto.setSerialNo(dbManager.getInt(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpJpayPatchRecBase.findByPrimaryKey() success!");
        return prpJpayPatchRecDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select PayGroupNo," + 
                           " CertiNo," + 
                           " SerialNo From PrpJpayPatchRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJpayPatchRecDto prpJpayPatchRecDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpJpayPatchRecDto = new PrpJpayPatchRecDto();
            prpJpayPatchRecDto.setPayGroupNo(dbManager.getString(resultSet,1));
            prpJpayPatchRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJpayPatchRecDto.setSerialNo(dbManager.getInt(resultSet,3));
            collection.add(prpJpayPatchRecDto);
        }
        resultSet.close();
        log.info("DBPrpJpayPatchRecBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpJpayPatchRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJpayPatchRecBase.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from PrpJpayPatchRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJpayPatchRecBase.getCount() success!");
        return count;
    }
}
