package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPayRecDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefpayrec付费和收费联系记录表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJrefPayRecBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJrefPayRecBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJrefPayRecBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJrefPayRecDto prpJrefPayRecDto
     * @throws Exception
     */
    public void insert(PrpJrefPayRecDto prpJrefPayRecDto) throws Exception{
        String statement = " Insert Into PrpJrefPayRec(" + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " PayFlag," + 
                           " Order02No," + 
                           " PayTimes) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJrefPayRecDto.getCertiNo());
        dbManager.setInt(2,prpJrefPayRecDto.getSerialNo());
        dbManager.setString(3,prpJrefPayRecDto.getPayFlag());
        dbManager.setInt(4,prpJrefPayRecDto.getOrder02No());
        dbManager.setInt(5,prpJrefPayRecDto.getPayTimes());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefPayRecBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJrefPayRecDto prpJrefPayRecDto = (PrpJrefPayRecDto)i.next();
            insert(prpJrefPayRecDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @throws Exception
     */
    public void delete(String certiNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJrefPayRec Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJrefPayRecBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJrefPayRecDto prpJrefPayRecDto
     * @throws Exception
     */
    public void update(PrpJrefPayRecDto prpJrefPayRecDto) throws Exception{
        String statement = " Update PrpJrefPayRec Set PayFlag = ?," + 
                           " Order02No = ?," + 
                           " PayTimes = ? Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpJrefPayRecDto.getPayFlag());
        dbManager.setInt(2,prpJrefPayRecDto.getOrder02No());
        dbManager.setInt(3,prpJrefPayRecDto.getPayTimes());
        //设置条件字段;
        dbManager.setString(4,prpJrefPayRecDto.getCertiNo());
        dbManager.setInt(5,prpJrefPayRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefPayRecBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @return PrpJrefPayRecDto
     * @throws Exception
     */
    public PrpJrefPayRecDto findByPrimaryKey(String certiNo,int serialNo) throws Exception{
        String statement = " Select CertiNo," + 
                           " SerialNo," + 
                           " PayFlag," + 
                           " Order02No," + 
                           " PayTimes From PrpJrefPayRec Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        PrpJrefPayRecDto prpJrefPayRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJrefPayRecDto = new PrpJrefPayRecDto();
            prpJrefPayRecDto.setCertiNo(dbManager.getString(resultSet,1));
            prpJrefPayRecDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpJrefPayRecDto.setPayFlag(dbManager.getString(resultSet,3));
            prpJrefPayRecDto.setOrder02No(dbManager.getInt(resultSet,4));
            prpJrefPayRecDto.setPayTimes(dbManager.getInt(resultSet,5));
        }
        resultSet.close();
        log.info("DBPrpJrefPayRecBase.findByPrimaryKey() success!");
        return prpJrefPayRecDto;
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
        String statement = "Select CertiNo," + 
                           " SerialNo," + 
                           " PayFlag," + 
                           " Order02No," + 
                           " PayTimes From PrpJrefPayRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJrefPayRecDto prpJrefPayRecDto = null;
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

            prpJrefPayRecDto = new PrpJrefPayRecDto();
            prpJrefPayRecDto.setCertiNo(dbManager.getString(resultSet,1));
            prpJrefPayRecDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpJrefPayRecDto.setPayFlag(dbManager.getString(resultSet,3));
            prpJrefPayRecDto.setOrder02No(dbManager.getInt(resultSet,4));
            prpJrefPayRecDto.setPayTimes(dbManager.getInt(resultSet,5));
            collection.add(prpJrefPayRecDto);
        }
        resultSet.close();
        log.info("DBPrpJrefPayRecBase.findByConditions() success!");
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
        String statement = "Delete From PrpJrefPayRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJrefPayRecBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJrefPayRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJrefPayRecBase.getCount() success!");
        return count;
    }
}
