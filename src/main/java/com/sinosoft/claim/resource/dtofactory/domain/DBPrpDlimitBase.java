package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDlimitDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdlimit限额免赔代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDlimitBase{
    protected  DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDlimitBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDlimitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public void insert(PrpDlimitDto prpDlimitDto) throws Exception{
        String statement = " Insert Into PrpDlimit(" + 
                           " RiskCode," + 
                           " LimitCode," + 
                           " LimitCName," + 
                           " LimitEName," + 
                           " LimitPriority," + 
                           " ItemCode," + 
                           " ModeCode," + 
                           " LimitFee," + 
                           " KindCode," + 
                           " LimitRelation," + 
                           " LimitRelationDesc," + 
                           " NewLimitCode," + 
                           " ValidStatus," + 
                           " LimitFlag," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDlimitDto.getRiskCode());
        dbManager.setString(2,prpDlimitDto.getLimitCode());
        dbManager.setString(3,prpDlimitDto.getLimitCName());
        dbManager.setString(4,prpDlimitDto.getLimitEName());
        dbManager.setString(5,prpDlimitDto.getLimitPriority());
        dbManager.setString(6,prpDlimitDto.getItemCode());
        dbManager.setString(7,prpDlimitDto.getModeCode());
        dbManager.setDouble(8,prpDlimitDto.getLimitFee());
        dbManager.setString(9,prpDlimitDto.getKindCode());
        dbManager.setString(10,prpDlimitDto.getLimitRelation());
        dbManager.setString(11,prpDlimitDto.getLimitRelationDesc());
        dbManager.setString(12,prpDlimitDto.getNewLimitCode());
        dbManager.setString(13,prpDlimitDto.getValidStatus());
        dbManager.setString(14,prpDlimitDto.getLimitFlag());
        dbManager.setString(15,prpDlimitDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDlimitBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDlimitDto prpDlimitDto = (PrpDlimitDto)i.next();
            insert(prpDlimitDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param limitCode 限额/免赔类别代码
     * @throws Exception
     */
    public void delete(String riskCode,String limitCode) throws Exception{
        String statement = " Delete From PrpDlimit Where " +
                           " RiskCode = ? And " + 
                           " LimitCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,limitCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDlimitBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public void update(PrpDlimitDto prpDlimitDto) throws Exception{
        String statement = " Update PrpDlimit Set LimitCName = ?," + 
                           " LimitEName = ?," + 
                           " LimitPriority = ?," + 
                           " ItemCode = ?," + 
                           " ModeCode = ?," + 
                           " LimitFee = ?," + 
                           " KindCode = ?," + 
                           " LimitRelation = ?," + 
                           " LimitRelationDesc = ?," + 
                           " NewLimitCode = ?," + 
                           " ValidStatus = ?," + 
                           " LimitFlag = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " LimitCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDlimitDto.getLimitCName());
        dbManager.setString(2,prpDlimitDto.getLimitEName());
        dbManager.setString(3,prpDlimitDto.getLimitPriority());
        dbManager.setString(4,prpDlimitDto.getItemCode());
        dbManager.setString(5,prpDlimitDto.getModeCode());
        dbManager.setDouble(6,prpDlimitDto.getLimitFee());
        dbManager.setString(7,prpDlimitDto.getKindCode());
        dbManager.setString(8,prpDlimitDto.getLimitRelation());
        dbManager.setString(9,prpDlimitDto.getLimitRelationDesc());
        dbManager.setString(10,prpDlimitDto.getNewLimitCode());
        dbManager.setString(11,prpDlimitDto.getValidStatus());
        dbManager.setString(12,prpDlimitDto.getLimitFlag());
        dbManager.setString(13,prpDlimitDto.getFlag());
        //设置条件字段;
        dbManager.setString(14,prpDlimitDto.getRiskCode());
        dbManager.setString(15,prpDlimitDto.getLimitCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDlimitBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param limitCode 限额/免赔类别代码
     * @return PrpDlimitDto
     * @throws Exception
     */
    public PrpDlimitDto findByPrimaryKey(String riskCode,String limitCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " LimitCode," + 
                           " LimitCName," + 
                           " LimitEName," + 
                           " LimitPriority," + 
                           " ItemCode," + 
                           " ModeCode," + 
                           " LimitFee," + 
                           " KindCode," + 
                           " LimitRelation," + 
                           " LimitRelationDesc," + 
                           " NewLimitCode," + 
                           " ValidStatus," + 
                           " LimitFlag," + 
                           " Flag From PrpDlimit Where " +
                           " RiskCode = ? And " + 
                           " LimitCode = ?";
        PrpDlimitDto prpDlimitDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,limitCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDlimitDto = new PrpDlimitDto();
            prpDlimitDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDlimitDto.setLimitCode(dbManager.getString(resultSet,2));
            prpDlimitDto.setLimitCName(dbManager.getString(resultSet,3));
            prpDlimitDto.setLimitEName(dbManager.getString(resultSet,4));
            prpDlimitDto.setLimitPriority(dbManager.getString(resultSet,5));
            prpDlimitDto.setItemCode(dbManager.getString(resultSet,6));
            prpDlimitDto.setModeCode(dbManager.getString(resultSet,7));
            prpDlimitDto.setLimitFee(dbManager.getDouble(resultSet,8));
            prpDlimitDto.setKindCode(dbManager.getString(resultSet,9));
            prpDlimitDto.setLimitRelation(dbManager.getString(resultSet,10));
            prpDlimitDto.setLimitRelationDesc(dbManager.getString(resultSet,11));
            prpDlimitDto.setNewLimitCode(dbManager.getString(resultSet,12));
            prpDlimitDto.setValidStatus(dbManager.getString(resultSet,13));
            prpDlimitDto.setLimitFlag(dbManager.getString(resultSet,14));
            prpDlimitDto.setFlag(dbManager.getString(resultSet,15));
        }
        resultSet.close();
        log.info("DBPrpDlimitBase.findByPrimaryKey() success!");
        return prpDlimitDto;
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
                           " LimitCode," + 
                           " LimitCName," + 
                           " LimitEName," + 
                           " LimitPriority," + 
                           " ItemCode," + 
                           " ModeCode," + 
                           " LimitFee," + 
                           " KindCode," + 
                           " LimitRelation," + 
                           " LimitRelationDesc," + 
                           " NewLimitCode," + 
                           " ValidStatus," + 
                           " LimitFlag," + 
                           " Flag From PrpDlimit Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDlimitDto prpDlimitDto = null;
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

            prpDlimitDto = new PrpDlimitDto();
            prpDlimitDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDlimitDto.setLimitCode(dbManager.getString(resultSet,2));
            prpDlimitDto.setLimitCName(dbManager.getString(resultSet,3));
            prpDlimitDto.setLimitEName(dbManager.getString(resultSet,4));
            prpDlimitDto.setLimitPriority(dbManager.getString(resultSet,5));
            prpDlimitDto.setItemCode(dbManager.getString(resultSet,6));
            prpDlimitDto.setModeCode(dbManager.getString(resultSet,7));
            prpDlimitDto.setLimitFee(dbManager.getDouble(resultSet,8));
            prpDlimitDto.setKindCode(dbManager.getString(resultSet,9));
            prpDlimitDto.setLimitRelation(dbManager.getString(resultSet,10));
            prpDlimitDto.setLimitRelationDesc(dbManager.getString(resultSet,11));
            prpDlimitDto.setNewLimitCode(dbManager.getString(resultSet,12));
            prpDlimitDto.setValidStatus(dbManager.getString(resultSet,13));
            prpDlimitDto.setLimitFlag(dbManager.getString(resultSet,14));
            prpDlimitDto.setFlag(dbManager.getString(resultSet,15));
            collection.add(prpDlimitDto);
        }
        resultSet.close();
        log.info("DBPrpDlimitBase.findByConditions() success!");
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
        String statement = "Delete From PrpDlimit Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDlimitBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDlimit Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDlimitBase.getCount() success!");
        return count;
    }
}
