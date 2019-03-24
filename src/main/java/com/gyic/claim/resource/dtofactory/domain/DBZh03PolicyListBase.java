package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.custom.EarLabelRegistDto;
import com.gyic.claim.dto.custom.FamilyNoRegistDto;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03PolicyList的数据访问对象基类<br>
 */
public class DBZh03PolicyListBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBZh03PolicyListBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBZh03PolicyListBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void insert(Zh03PolicyListDto zh03PolicyListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Zh03PolicyList (");
        buffer.append("InusreListCode,");
        buffer.append("IndexNo,");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("FamilySex,");
        buffer.append("FamilyFIdCard,");
        buffer.append("Name,");
        buffer.append("Address,");
        buffer.append("Count,");
        buffer.append("UnitAmount,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("HandlerCode,");
        buffer.append("InputDate,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("ItemCode,");
        buffer.append("Rate,");
        buffer.append("FamilyFlag,");
        buffer.append("ExportIndex,");
        buffer.append("PersonNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(zh03PolicyListDto.getInusreListCode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getIndexNo()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getKindCode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getFamilyNo()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getFamilyName()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getFamilySex()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getFamilyFIdCard()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getName()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getAddress()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getCount()).append("',");
            debugBuffer.append("").append(zh03PolicyListDto.getUnitAmount()).append(",");
            debugBuffer.append("").append(zh03PolicyListDto.getSumAmount()).append(",");
            debugBuffer.append("").append(zh03PolicyListDto.getSumPremium()).append(",");
            debugBuffer.append("'").append(zh03PolicyListDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getInputDate()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getStartDate()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getEndDate()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getFlag()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getRemark()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getItemCode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getRate()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getFamilyFlag()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getExportIndex()).append("',");
            debugBuffer.append("'").append(zh03PolicyListDto.getPersonNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,zh03PolicyListDto.getInusreListCode());
        dbManager.setString(2,zh03PolicyListDto.getIndexNo());
        dbManager.setString(3,zh03PolicyListDto.getRiskCode());
        dbManager.setString(4,zh03PolicyListDto.getKindCode());
        dbManager.setString(5,zh03PolicyListDto.getFamilyNo());
        dbManager.setString(6,zh03PolicyListDto.getFamilyName());
        dbManager.setString(7,zh03PolicyListDto.getFamilySex());
        dbManager.setString(8,zh03PolicyListDto.getFamilyFIdCard());
        dbManager.setString(9,zh03PolicyListDto.getName());
        dbManager.setString(10,zh03PolicyListDto.getAddress());
        dbManager.setString(11,zh03PolicyListDto.getCount());
        dbManager.setDouble(12,zh03PolicyListDto.getUnitAmount());
        dbManager.setDouble(13,zh03PolicyListDto.getSumAmount());
        dbManager.setDouble(14,zh03PolicyListDto.getSumPremium());
        dbManager.setString(15,zh03PolicyListDto.getHandlerCode());
        dbManager.setDateTime(16,zh03PolicyListDto.getInputDate());
        dbManager.setDateTime(17,zh03PolicyListDto.getStartDate());
        dbManager.setDateTime(18,zh03PolicyListDto.getEndDate());
        dbManager.setString(19,zh03PolicyListDto.getFlag());
        dbManager.setString(20,zh03PolicyListDto.getRemark());
        dbManager.setString(21,zh03PolicyListDto.getItemCode());
        dbManager.setString(22,zh03PolicyListDto.getRate());
        dbManager.setString(23,zh03PolicyListDto.getFamilyFlag());
        dbManager.setString(24,zh03PolicyListDto.getExportIndex());
        dbManager.setString(25,zh03PolicyListDto.getPersonNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Zh03PolicyList (");
        buffer.append("InusreListCode,");
        buffer.append("IndexNo,");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("FamilySex,");
        buffer.append("FamilyFIdCard,");
        buffer.append("Name,");
        buffer.append("Address,");
        buffer.append("Count,");
        buffer.append("UnitAmount,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("HandlerCode,");
        buffer.append("InputDate,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("ItemCode,");
        buffer.append("Rate,");
        buffer.append("FamilyFlag,");
        buffer.append("ExportIndex,");
        buffer.append("PersonNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            Zh03PolicyListDto zh03PolicyListDto = (Zh03PolicyListDto)i.next();
            dbManager.setString(1,zh03PolicyListDto.getInusreListCode());
            dbManager.setString(2,zh03PolicyListDto.getIndexNo());
            dbManager.setString(3,zh03PolicyListDto.getRiskCode());
            dbManager.setString(4,zh03PolicyListDto.getKindCode());
            dbManager.setString(5,zh03PolicyListDto.getFamilyNo());
            dbManager.setString(6,zh03PolicyListDto.getFamilyName());
            dbManager.setString(7,zh03PolicyListDto.getFamilySex());
            dbManager.setString(8,zh03PolicyListDto.getFamilyFIdCard());
            dbManager.setString(9,zh03PolicyListDto.getName());
            dbManager.setString(10,zh03PolicyListDto.getAddress());
            dbManager.setString(11,zh03PolicyListDto.getCount());
            dbManager.setDouble(12,zh03PolicyListDto.getUnitAmount());
            dbManager.setDouble(13,zh03PolicyListDto.getSumAmount());
            dbManager.setDouble(14,zh03PolicyListDto.getSumPremium());
            dbManager.setString(15,zh03PolicyListDto.getHandlerCode());
            dbManager.setDateTime(16,zh03PolicyListDto.getInputDate());
            dbManager.setDateTime(17,zh03PolicyListDto.getStartDate());
            dbManager.setDateTime(18,zh03PolicyListDto.getEndDate());
            dbManager.setString(19,zh03PolicyListDto.getFlag());
            dbManager.setString(20,zh03PolicyListDto.getRemark());
            dbManager.setString(21,zh03PolicyListDto.getItemCode());
            dbManager.setString(22,zh03PolicyListDto.getRate());
            dbManager.setString(23,zh03PolicyListDto.getFamilyFlag());
            dbManager.setString(24,zh03PolicyListDto.getExportIndex());
            dbManager.setString(25,zh03PolicyListDto.getPersonNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(String inusreListCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Zh03PolicyList ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("InusreListCode=").append("'").append(inusreListCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("InusreListCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusreListCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void update(Zh03PolicyListDto zh03PolicyListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Zh03PolicyList SET ");
        buffer.append("IndexNo = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("FamilyNo = ?, ");
        buffer.append("FamilyName = ?, ");
        buffer.append("FamilySex = ?, ");
        buffer.append("FamilyFIdCard = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("Count = ?, ");
        buffer.append("UnitAmount = ?, ");
        buffer.append("SumAmount = ?, ");
        buffer.append("SumPremium = ?, ");
        buffer.append("HandlerCode = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("StartDate = ?, ");
        buffer.append("EndDate = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("ItemCode = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("FamilyFlag = ?, ");
        buffer.append("ExportIndex = ?, ");
        buffer.append("PersonNo = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Zh03PolicyList SET ");
            debugBuffer.append("IndexNo = '" + zh03PolicyListDto.getIndexNo() + "', ");
            debugBuffer.append("RiskCode = '" + zh03PolicyListDto.getRiskCode() + "', ");
            debugBuffer.append("KindCode = '" + zh03PolicyListDto.getKindCode() + "', ");
            debugBuffer.append("FamilyNo = '" + zh03PolicyListDto.getFamilyNo() + "', ");
            debugBuffer.append("FamilyName = '" + zh03PolicyListDto.getFamilyName() + "', ");
            debugBuffer.append("FamilySex = '" + zh03PolicyListDto.getFamilySex() + "', ");
            debugBuffer.append("FamilyFIdCard = '" + zh03PolicyListDto.getFamilyFIdCard() + "', ");
            debugBuffer.append("Name = '" + zh03PolicyListDto.getName() + "', ");
            debugBuffer.append("Address = '" + zh03PolicyListDto.getAddress() + "', ");
            debugBuffer.append("Count = '" + zh03PolicyListDto.getCount() + "', ");
            debugBuffer.append("UnitAmount = " + zh03PolicyListDto.getUnitAmount() + ", ");
            debugBuffer.append("SumAmount = " + zh03PolicyListDto.getSumAmount() + ", ");
            debugBuffer.append("SumPremium = " + zh03PolicyListDto.getSumPremium() + ", ");
            debugBuffer.append("HandlerCode = '" + zh03PolicyListDto.getHandlerCode() + "', ");
            debugBuffer.append("InputDate = '" + zh03PolicyListDto.getInputDate() + "', ");
            debugBuffer.append("StartDate = '" + zh03PolicyListDto.getStartDate() + "', ");
            debugBuffer.append("EndDate = '" + zh03PolicyListDto.getEndDate() + "', ");
            debugBuffer.append("Flag = '" + zh03PolicyListDto.getFlag() + "', ");
            debugBuffer.append("Remark = '" + zh03PolicyListDto.getRemark() + "', ");
            debugBuffer.append("ItemCode = '" + zh03PolicyListDto.getItemCode() + "', ");
            debugBuffer.append("Rate = '" + zh03PolicyListDto.getRate() + "', ");
            debugBuffer.append("FamilyFlag = '" + zh03PolicyListDto.getFamilyFlag() + "', ");
            debugBuffer.append("ExportIndex = '" + zh03PolicyListDto.getExportIndex() + "', ");
            debugBuffer.append("PersonNo = '" + zh03PolicyListDto.getPersonNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("InusreListCode=").append("'").append(zh03PolicyListDto.getInusreListCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("InusreListCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,zh03PolicyListDto.getIndexNo());
        dbManager.setString(2,zh03PolicyListDto.getRiskCode());
        dbManager.setString(3,zh03PolicyListDto.getKindCode());
        dbManager.setString(4,zh03PolicyListDto.getFamilyNo());
        dbManager.setString(5,zh03PolicyListDto.getFamilyName());
        dbManager.setString(6,zh03PolicyListDto.getFamilySex());
        dbManager.setString(7,zh03PolicyListDto.getFamilyFIdCard());
        dbManager.setString(8,zh03PolicyListDto.getName());
        dbManager.setString(9,zh03PolicyListDto.getAddress());
        dbManager.setString(10,zh03PolicyListDto.getCount());
        dbManager.setDouble(11,zh03PolicyListDto.getUnitAmount());
        dbManager.setDouble(12,zh03PolicyListDto.getSumAmount());
        dbManager.setDouble(13,zh03PolicyListDto.getSumPremium());
        dbManager.setString(14,zh03PolicyListDto.getHandlerCode());
        dbManager.setDateTime(15,zh03PolicyListDto.getInputDate());
        dbManager.setDateTime(16,zh03PolicyListDto.getStartDate());
        dbManager.setDateTime(17,zh03PolicyListDto.getEndDate());
        dbManager.setString(18,zh03PolicyListDto.getFlag());
        dbManager.setString(19,zh03PolicyListDto.getRemark());
        dbManager.setString(20,zh03PolicyListDto.getItemCode());
        dbManager.setString(21,zh03PolicyListDto.getRate());
        dbManager.setString(22,zh03PolicyListDto.getFamilyFlag());
        dbManager.setString(23,zh03PolicyListDto.getExportIndex());
        dbManager.setString(24,zh03PolicyListDto.getPersonNo());
        //设置条件字段;
        dbManager.setString(25,zh03PolicyListDto.getInusreListCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusreListCode InusreListCode
     * @return Zh03PolicyListDto
     * @throws Exception
     */
    public Zh03PolicyListDto findByPrimaryKey(String inusreListCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("InusreListCode,");
        buffer.append("IndexNo,");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("FamilySex,");
        buffer.append("FamilyFIdCard,");
        buffer.append("Name,");
        buffer.append("Address,");
        buffer.append("Count,");
        buffer.append("UnitAmount,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("HandlerCode,");
        buffer.append("InputDate,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("ItemCode,");
        buffer.append("Rate,");
        buffer.append("FamilyFlag,");
        buffer.append("ExportIndex,");
        buffer.append("PersonNo ");
        buffer.append("FROM Zh03PolicyList ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("InusreListCode=").append("'").append(inusreListCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("InusreListCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusreListCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        Zh03PolicyListDto zh03PolicyListDto = null;
        if(resultSet.next()){
            zh03PolicyListDto = new Zh03PolicyListDto();
            zh03PolicyListDto.setInusreListCode(dbManager.getString(resultSet,1));
            zh03PolicyListDto.setIndexNo(dbManager.getString(resultSet,2));
            zh03PolicyListDto.setRiskCode(dbManager.getString(resultSet,3));
            zh03PolicyListDto.setKindCode(dbManager.getString(resultSet,4));
            zh03PolicyListDto.setFamilyNo(dbManager.getString(resultSet,5));
            zh03PolicyListDto.setFamilyName(dbManager.getString(resultSet,6));
            zh03PolicyListDto.setFamilySex(dbManager.getString(resultSet,7));
            zh03PolicyListDto.setFamilyFIdCard(dbManager.getString(resultSet,8));
            zh03PolicyListDto.setName(dbManager.getString(resultSet,9));
            zh03PolicyListDto.setAddress(dbManager.getString(resultSet,10));
            zh03PolicyListDto.setCount(dbManager.getString(resultSet,11));
            zh03PolicyListDto.setUnitAmount(dbManager.getDouble(resultSet,12));
            zh03PolicyListDto.setSumAmount(dbManager.getDouble(resultSet,13));
            zh03PolicyListDto.setSumPremium(dbManager.getDouble(resultSet,14));
            zh03PolicyListDto.setHandlerCode(dbManager.getString(resultSet,15));
            zh03PolicyListDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,16));
            zh03PolicyListDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            zh03PolicyListDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            zh03PolicyListDto.setFlag(dbManager.getString(resultSet,19));
            zh03PolicyListDto.setRemark(dbManager.getString(resultSet,20));
            zh03PolicyListDto.setItemCode(dbManager.getString(resultSet,21));
            zh03PolicyListDto.setRate(dbManager.getString(resultSet,22));
            zh03PolicyListDto.setFamilyFlag(dbManager.getString(resultSet,23));
            zh03PolicyListDto.setExportIndex(dbManager.getString(resultSet,24));
            zh03PolicyListDto.setPersonNo(dbManager.getString(resultSet,25));
        }
        resultSet.close();
        return zh03PolicyListDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("InusreListCode,");
        buffer.append("IndexNo,");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("FamilySex,");
        buffer.append("FamilyFIdCard,");
        buffer.append("Name,");
        buffer.append("Address,");
        buffer.append("Count,");
        buffer.append("UnitAmount,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("HandlerCode,");
        buffer.append("InputDate,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("ItemCode,");
        buffer.append("Rate,");
        buffer.append("FamilyFlag,");
        buffer.append("ExportIndex,");
        buffer.append("PersonNo ");
        buffer.append("FROM Zh03PolicyList WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        Zh03PolicyListDto zh03PolicyListDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            zh03PolicyListDto = new Zh03PolicyListDto();
            zh03PolicyListDto.setInusreListCode(dbManager.getString(resultSet,"InusreListCode"));
            zh03PolicyListDto.setIndexNo(dbManager.getString(resultSet,"IndexNo"));
            zh03PolicyListDto.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            zh03PolicyListDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            zh03PolicyListDto.setFamilyNo(dbManager.getString(resultSet,"FamilyNo"));
            zh03PolicyListDto.setFamilyName(dbManager.getString(resultSet,"FamilyName"));
            zh03PolicyListDto.setFamilySex(dbManager.getString(resultSet,"FamilySex"));
            zh03PolicyListDto.setFamilyFIdCard(dbManager.getString(resultSet,"FamilyFIdCard"));
            zh03PolicyListDto.setName(dbManager.getString(resultSet,"Name"));
            zh03PolicyListDto.setAddress(dbManager.getString(resultSet,"Address"));
            zh03PolicyListDto.setCount(dbManager.getString(resultSet,"Count"));
            zh03PolicyListDto.setUnitAmount(dbManager.getDouble(resultSet,"UnitAmount"));
            zh03PolicyListDto.setSumAmount(dbManager.getDouble(resultSet,"SumAmount"));
            zh03PolicyListDto.setSumPremium(dbManager.getDouble(resultSet,"SumPremium"));
            zh03PolicyListDto.setHandlerCode(dbManager.getString(resultSet,"HandlerCode"));
            zh03PolicyListDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,"InputDate"));
            zh03PolicyListDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"StartDate"));
            zh03PolicyListDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"EndDate"));
            zh03PolicyListDto.setFlag(dbManager.getString(resultSet,"Flag"));
            zh03PolicyListDto.setRemark(dbManager.getString(resultSet,"Remark"));
            zh03PolicyListDto.setItemCode(dbManager.getString(resultSet,"ItemCode"));
            zh03PolicyListDto.setRate(dbManager.getString(resultSet,"Rate"));
            zh03PolicyListDto.setFamilyFlag(dbManager.getString(resultSet,"FamilyFlag"));
            zh03PolicyListDto.setExportIndex(dbManager.getString(resultSet,"ExportIndex"));
            zh03PolicyListDto.setPersonNo(dbManager.getString(resultSet,"PersonNo"));
            collection.add(zh03PolicyListDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Zh03PolicyList WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM Zh03PolicyList WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findFamilyNoByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
	    	StringBuffer buffer = new StringBuffer(400);
	        //拼SQL语句
	        buffer.append("SELECT distinct ");
	    	buffer.append("e.PolicyNo,");
	    	
	    	//buffer.append("a.InsuredName,");
	    	buffer.append("e.Starttime as startdate,");
	    	buffer.append("e.Endtime as enddate,");
	    	
	    	//buffer.append("a.OthFlag,");
	    	buffer.append("e.riskcode,");
	    	buffer.append("e.classcode ");
	    	//buffer.append("a.sumquantity,");
	    	//buffer.append("a.flag,");
	    	//buffer.append("a.underwriteflag");
	    	//buffer.append("d.familyno");
	    	
	    	////////////////////

	        buffer.append(" FROM zh03policylist d,insuremainlist e " +
	        		" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.flag in ('1') and d.kindcode='2742001'  and d.personno='1'  and ");
	        buffer.append(conditions);
	        boolean supportPaging = false;//数据库是否支持分页
	        if (pageNo > 0){
	            //对Oracle优化
	            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
	                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
	                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
	                supportPaging=true;
	            }
	            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
	                String sql = buffer.toString();
	                buffer.setLength(0);
	                buffer.append("select * from ( select rownumber() over(");
	                int orderByIndex = sql.toLowerCase().indexOf("order by");
	                if ( orderByIndex>0 ) {
	                   buffer.append( sql.substring(orderByIndex) );
	                }
	                buffer.append(") as rownumber_,");
	                buffer.append(sql.substring( 6 ));
	                buffer.append(" ) as temp_ where rownumber_");
	                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
	                supportPaging=true;
	            }
	        }
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = null;
	        try
	        {
	        	System.err.println("buffer:"+buffer.toString());
		        resultSet = dbManager.executeQuery(buffer.toString());
		        int count=0;
		        if(supportPaging==false && pageNo>1){
		            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
		        }
		
		        //定义返回结果集合
		        Collection collection = new ArrayList(rowsPerPage);
		        PrpCmainDto prpCmainDto = null;
		        while(resultSet.next()){
		            if (supportPaging == false && pageNo>0) {
		                count++;
		                if(count > rowsPerPage){
		                    break;
		                }
		            }
		
		            prpCmainDto = new PrpCmainDto();
		            prpCmainDto.setPolicyNo(dbManager.getString(resultSet,1));
		            //prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
		            //prpCmainDto.setInsuredName(dbManager.getString(resultSet,3));
		            prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,2));
		            prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
		            //prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
		             //添加保单是否已经注销标志
		            //prpCmainDto.setOthFlag(dbManager.getString(resultSet,7));
		            prpCmainDto.setRiskCode( dbManager.getString(resultSet,4));
		            prpCmainDto.setClassCode( dbManager.getString(resultSet,5));
		            
		            
		             //add by guolei  20070519 增加团单
		            //if(dbManager.getString(resultSet,11).length()>=2){
		            	//prpCmainDto.setInsuredName(dbManager.getString(resultSet,3)+"等"+dbManager.getString(resultSet,10)+"人");	
		            //}
		            //添加见费出单的标志
		            //prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 12));
		            //增加车牌号码
	
		            //FamilyNoRegistDto familyNoRegistDto = new FamilyNoRegistDto();
		            //familyNoRegistDto.setPrpCmainDto(prpCmainDto);
		            //familyNoRegistDto.setFamilyNo(dbManager.getString(resultSet, 13));
		            collection.add(prpCmainDto);
		        }
		        resultSet.close();
		        return collection;
    		}
		    catch(Exception exception){
		        resultSet.close();
		        throw exception;
		    }
		    finally{
		    	resultSet.close();
		    }
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getFamilyNoCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(400);
        buffer.append("SELECT count(*) FROM zh03policylist d,insuremainlist e " +
	" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.flag in ('1')  and d.kindcode='2742001'  and d.personno='1' and ");
        buffer.append(conditions);
        System.err.println("conditions:"+conditions);

        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
