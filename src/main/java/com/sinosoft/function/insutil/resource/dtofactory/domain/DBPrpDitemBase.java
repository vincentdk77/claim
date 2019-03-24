package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDitemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpditem的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDitemBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDitemBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDitemBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDitemDto prpDitemDto
     * @throws Exception
     */
    public void insert(PrpDitemDto prpDitemDto) throws Exception{
        String statement = " Insert Into PrpDitem(" + 
                           " RiskCode," + 
                           " ItemCode," + 
                           " ItemCName," + 
                           " ItemEName," + 
                           " ItemFlag," + 
                           " NewItemCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDitemDto.getRiskCode());
        dbManager.setString(2,prpDitemDto.getItemCode());
        dbManager.setString(3,prpDitemDto.getItemCName());
        dbManager.setString(4,prpDitemDto.getItemEName());
        dbManager.setString(5,prpDitemDto.getItemFlag());
        dbManager.setString(6,prpDitemDto.getNewItemCode());
        dbManager.setString(7,prpDitemDto.getValidStatus());
        dbManager.setString(8,prpDitemDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDitemBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDitemDto prpDitemDto = (PrpDitemDto)i.next();
            insert(prpDitemDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode riskcode
     * @param itemCode itemcode
     * @throws Exception
     */
    public void delete(String riskCode,String itemCode) throws Exception{
        String statement = " Delete From PrpDitem Where " +
                           " RiskCode = ? And " + 
                           " ItemCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,itemCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDitemBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDitemDto prpDitemDto
     * @throws Exception
     */
    public void update(PrpDitemDto prpDitemDto) throws Exception{
        String statement = " Update PrpDitem Set ItemCName = ?," + 
                           " ItemEName = ?," + 
                           " ItemFlag = ?," + 
                           " NewItemCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " ItemCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDitemDto.getItemCName());
        dbManager.setString(2,prpDitemDto.getItemEName());
        dbManager.setString(3,prpDitemDto.getItemFlag());
        dbManager.setString(4,prpDitemDto.getNewItemCode());
        dbManager.setString(5,prpDitemDto.getValidStatus());
        dbManager.setString(6,prpDitemDto.getFlag());
        //设置条件字段;
        dbManager.setString(7,prpDitemDto.getRiskCode());
        dbManager.setString(8,prpDitemDto.getItemCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDitemBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode riskcode
     * @param itemCode itemcode
     * @return PrpDitemDto
     * @throws Exception
     */
    public PrpDitemDto findByPrimaryKey(String riskCode,String itemCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ItemCode," + 
                           " ItemCName," + 
                           " ItemEName," + 
                           " ItemFlag," + 
                           " NewItemCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDitem Where " +
                           " RiskCode = ? And " + 
                           " ItemCode = ?";
        PrpDitemDto prpDitemDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,itemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDitemDto = new PrpDitemDto();
            prpDitemDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDitemDto.setItemCode(dbManager.getString(resultSet,2));
            prpDitemDto.setItemCName(dbManager.getString(resultSet,3));
            prpDitemDto.setItemEName(dbManager.getString(resultSet,4));
            prpDitemDto.setItemFlag(dbManager.getString(resultSet,5));
            prpDitemDto.setNewItemCode(dbManager.getString(resultSet,6));
            prpDitemDto.setValidStatus(dbManager.getString(resultSet,7));
            prpDitemDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBPrpDitemBase.findByPrimaryKey() success!");
        return prpDitemDto;
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
        String statement = "Select RiskCode," + 
                           " ItemCode," + 
                           " ItemCName," + 
                           " ItemEName," + 
                           " ItemFlag," + 
                           " NewItemCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDitem Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDitemDto prpDitemDto = null;
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

            prpDitemDto = new PrpDitemDto();
            prpDitemDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDitemDto.setItemCode(dbManager.getString(resultSet,2));
            prpDitemDto.setItemCName(dbManager.getString(resultSet,3));
            prpDitemDto.setItemEName(dbManager.getString(resultSet,4));
            prpDitemDto.setItemFlag(dbManager.getString(resultSet,5));
            prpDitemDto.setNewItemCode(dbManager.getString(resultSet,6));
            prpDitemDto.setValidStatus(dbManager.getString(resultSet,7));
            prpDitemDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpDitemDto);
        }
        resultSet.close();
        log.info("DBPrpDitemBase.findByConditions() success!");
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
        String statement = "Delete From PrpDitem Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDitemBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDitem Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDitemBase.getCount() success!");
        return count;
    }
}
