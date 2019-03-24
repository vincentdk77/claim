package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03InsuranceListDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03InsuranceList的数据访问对象基类<br>
 */
public class DBZh03InsuranceListBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBZh03InsuranceListBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBZh03InsuranceListBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void insert(Zh03InsuranceListDto zh03InsuranceListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Zh03InsuranceList (");
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
            debugBuffer.append("'").append(zh03InsuranceListDto.getInusreListCode()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getIndexNo()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getKindCode()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getFamilyNo()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getFamilyName()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getFamilySex()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getFamilyFIdCard()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getName()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getAddress()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getCount()).append("',");
            debugBuffer.append("").append(zh03InsuranceListDto.getUnitAmount()).append(",");
            debugBuffer.append("").append(zh03InsuranceListDto.getSumAmount()).append(",");
            debugBuffer.append("").append(zh03InsuranceListDto.getSumPremium()).append(",");
            debugBuffer.append("'").append(zh03InsuranceListDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getInputDate()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getStartDate()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getEndDate()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getFlag()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getRemark()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getItemCode()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getRate()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getFamilyFlag()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getExportIndex()).append("',");
            debugBuffer.append("'").append(zh03InsuranceListDto.getPersonNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,zh03InsuranceListDto.getInusreListCode());
        dbManager.setString(2,zh03InsuranceListDto.getIndexNo());
        dbManager.setString(3,zh03InsuranceListDto.getRiskCode());
        dbManager.setString(4,zh03InsuranceListDto.getKindCode());
        dbManager.setString(5,zh03InsuranceListDto.getFamilyNo());
        dbManager.setString(6,zh03InsuranceListDto.getFamilyName());
        dbManager.setString(7,zh03InsuranceListDto.getFamilySex());
        dbManager.setString(8,zh03InsuranceListDto.getFamilyFIdCard());
        dbManager.setString(9,zh03InsuranceListDto.getName());
        dbManager.setString(10,zh03InsuranceListDto.getAddress());
        dbManager.setString(11,zh03InsuranceListDto.getCount());
        dbManager.setDouble(12,zh03InsuranceListDto.getUnitAmount());
        dbManager.setDouble(13,zh03InsuranceListDto.getSumAmount());
        dbManager.setDouble(14,zh03InsuranceListDto.getSumPremium());
        dbManager.setString(15,zh03InsuranceListDto.getHandlerCode());
        dbManager.setDateTime(16,zh03InsuranceListDto.getInputDate());
        dbManager.setDateTime(17,zh03InsuranceListDto.getStartDate());
        dbManager.setDateTime(18,zh03InsuranceListDto.getEndDate());
        dbManager.setString(19,zh03InsuranceListDto.getFlag());
        dbManager.setString(20,zh03InsuranceListDto.getRemark());
        dbManager.setString(21,zh03InsuranceListDto.getItemCode());
        dbManager.setString(22,zh03InsuranceListDto.getRate());
        dbManager.setString(23,zh03InsuranceListDto.getFamilyFlag());
        dbManager.setString(24,zh03InsuranceListDto.getExportIndex());
        dbManager.setString(25,zh03InsuranceListDto.getPersonNo());
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
        buffer.append("INSERT INTO Zh03InsuranceList (");
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
            Zh03InsuranceListDto zh03InsuranceListDto = (Zh03InsuranceListDto)i.next();
            dbManager.setString(1,zh03InsuranceListDto.getInusreListCode());
            dbManager.setString(2,zh03InsuranceListDto.getIndexNo());
            dbManager.setString(3,zh03InsuranceListDto.getRiskCode());
            dbManager.setString(4,zh03InsuranceListDto.getKindCode());
            dbManager.setString(5,zh03InsuranceListDto.getFamilyNo());
            dbManager.setString(6,zh03InsuranceListDto.getFamilyName());
            dbManager.setString(7,zh03InsuranceListDto.getFamilySex());
            dbManager.setString(8,zh03InsuranceListDto.getFamilyFIdCard());
            dbManager.setString(9,zh03InsuranceListDto.getName());
            dbManager.setString(10,zh03InsuranceListDto.getAddress());
            dbManager.setString(11,zh03InsuranceListDto.getCount());
            dbManager.setDouble(12,zh03InsuranceListDto.getUnitAmount());
            dbManager.setDouble(13,zh03InsuranceListDto.getSumAmount());
            dbManager.setDouble(14,zh03InsuranceListDto.getSumPremium());
            dbManager.setString(15,zh03InsuranceListDto.getHandlerCode());
            dbManager.setDateTime(16,zh03InsuranceListDto.getInputDate());
            dbManager.setDateTime(17,zh03InsuranceListDto.getStartDate());
            dbManager.setDateTime(18,zh03InsuranceListDto.getEndDate());
            dbManager.setString(19,zh03InsuranceListDto.getFlag());
            dbManager.setString(20,zh03InsuranceListDto.getRemark());
            dbManager.setString(21,zh03InsuranceListDto.getItemCode());
            dbManager.setString(22,zh03InsuranceListDto.getRate());
            dbManager.setString(23,zh03InsuranceListDto.getFamilyFlag());
            dbManager.setString(24,zh03InsuranceListDto.getExportIndex());
            dbManager.setString(25,zh03InsuranceListDto.getPersonNo());
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
        buffer.append("DELETE FROM Zh03InsuranceList ");
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
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void update(Zh03InsuranceListDto zh03InsuranceListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Zh03InsuranceList SET ");
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
            debugBuffer.append("UPDATE Zh03InsuranceList SET ");
            debugBuffer.append("IndexNo = '" + zh03InsuranceListDto.getIndexNo() + "', ");
            debugBuffer.append("RiskCode = '" + zh03InsuranceListDto.getRiskCode() + "', ");
            debugBuffer.append("KindCode = '" + zh03InsuranceListDto.getKindCode() + "', ");
            debugBuffer.append("FamilyNo = '" + zh03InsuranceListDto.getFamilyNo() + "', ");
            debugBuffer.append("FamilyName = '" + zh03InsuranceListDto.getFamilyName() + "', ");
            debugBuffer.append("FamilySex = '" + zh03InsuranceListDto.getFamilySex() + "', ");
            debugBuffer.append("FamilyFIdCard = '" + zh03InsuranceListDto.getFamilyFIdCard() + "', ");
            debugBuffer.append("Name = '" + zh03InsuranceListDto.getName() + "', ");
            debugBuffer.append("Address = '" + zh03InsuranceListDto.getAddress() + "', ");
            debugBuffer.append("Count = '" + zh03InsuranceListDto.getCount() + "', ");
            debugBuffer.append("UnitAmount = " + zh03InsuranceListDto.getUnitAmount() + ", ");
            debugBuffer.append("SumAmount = " + zh03InsuranceListDto.getSumAmount() + ", ");
            debugBuffer.append("SumPremium = " + zh03InsuranceListDto.getSumPremium() + ", ");
            debugBuffer.append("HandlerCode = '" + zh03InsuranceListDto.getHandlerCode() + "', ");
            debugBuffer.append("InputDate = '" + zh03InsuranceListDto.getInputDate() + "', ");
            debugBuffer.append("StartDate = '" + zh03InsuranceListDto.getStartDate() + "', ");
            debugBuffer.append("EndDate = '" + zh03InsuranceListDto.getEndDate() + "', ");
            debugBuffer.append("Flag = '" + zh03InsuranceListDto.getFlag() + "', ");
            debugBuffer.append("Remark = '" + zh03InsuranceListDto.getRemark() + "', ");
            debugBuffer.append("ItemCode = '" + zh03InsuranceListDto.getItemCode() + "', ");
            debugBuffer.append("Rate = '" + zh03InsuranceListDto.getRate() + "', ");
            debugBuffer.append("FamilyFlag = '" + zh03InsuranceListDto.getFamilyFlag() + "', ");
            debugBuffer.append("ExportIndex = '" + zh03InsuranceListDto.getExportIndex() + "', ");
            debugBuffer.append("PersonNo = '" + zh03InsuranceListDto.getPersonNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("InusreListCode=").append("'").append(zh03InsuranceListDto.getInusreListCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("InusreListCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,zh03InsuranceListDto.getIndexNo());
        dbManager.setString(2,zh03InsuranceListDto.getRiskCode());
        dbManager.setString(3,zh03InsuranceListDto.getKindCode());
        dbManager.setString(4,zh03InsuranceListDto.getFamilyNo());
        dbManager.setString(5,zh03InsuranceListDto.getFamilyName());
        dbManager.setString(6,zh03InsuranceListDto.getFamilySex());
        dbManager.setString(7,zh03InsuranceListDto.getFamilyFIdCard());
        dbManager.setString(8,zh03InsuranceListDto.getName());
        dbManager.setString(9,zh03InsuranceListDto.getAddress());
        dbManager.setString(10,zh03InsuranceListDto.getCount());
        dbManager.setDouble(11,zh03InsuranceListDto.getUnitAmount());
        dbManager.setDouble(12,zh03InsuranceListDto.getSumAmount());
        dbManager.setDouble(13,zh03InsuranceListDto.getSumPremium());
        dbManager.setString(14,zh03InsuranceListDto.getHandlerCode());
        dbManager.setDateTime(15,zh03InsuranceListDto.getInputDate());
        dbManager.setDateTime(16,zh03InsuranceListDto.getStartDate());
        dbManager.setDateTime(17,zh03InsuranceListDto.getEndDate());
        dbManager.setString(18,zh03InsuranceListDto.getFlag());
        dbManager.setString(19,zh03InsuranceListDto.getRemark());
        dbManager.setString(20,zh03InsuranceListDto.getItemCode());
        dbManager.setString(21,zh03InsuranceListDto.getRate());
        dbManager.setString(22,zh03InsuranceListDto.getFamilyFlag());
        dbManager.setString(23,zh03InsuranceListDto.getExportIndex());
        dbManager.setString(24,zh03InsuranceListDto.getPersonNo());
        //设置条件字段;
        dbManager.setString(25,zh03InsuranceListDto.getInusreListCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusreListCode InusreListCode
     * @return Zh03InsuranceListDto
     * @throws Exception
     */
    public Zh03InsuranceListDto findByPrimaryKey(String inusreListCode)
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
        buffer.append("FROM Zh03InsuranceList ");
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
        Zh03InsuranceListDto zh03InsuranceListDto = null;
        if(resultSet.next()){
            zh03InsuranceListDto = new Zh03InsuranceListDto();
            zh03InsuranceListDto.setInusreListCode(dbManager.getString(resultSet,1));
            zh03InsuranceListDto.setIndexNo(dbManager.getString(resultSet,2));
            zh03InsuranceListDto.setRiskCode(dbManager.getString(resultSet,3));
            zh03InsuranceListDto.setKindCode(dbManager.getString(resultSet,4));
            zh03InsuranceListDto.setFamilyNo(dbManager.getString(resultSet,5));
            zh03InsuranceListDto.setFamilyName(dbManager.getString(resultSet,6));
            zh03InsuranceListDto.setFamilySex(dbManager.getString(resultSet,7));
            zh03InsuranceListDto.setFamilyFIdCard(dbManager.getString(resultSet,8));
            zh03InsuranceListDto.setName(dbManager.getString(resultSet,9));
            zh03InsuranceListDto.setAddress(dbManager.getString(resultSet,10));
            zh03InsuranceListDto.setCount(dbManager.getString(resultSet,11));
            zh03InsuranceListDto.setUnitAmount(dbManager.getDouble(resultSet,12));
            zh03InsuranceListDto.setSumAmount(dbManager.getDouble(resultSet,13));
            zh03InsuranceListDto.setSumPremium(dbManager.getDouble(resultSet,14));
            zh03InsuranceListDto.setHandlerCode(dbManager.getString(resultSet,15));
            zh03InsuranceListDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,16));
            zh03InsuranceListDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            zh03InsuranceListDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            zh03InsuranceListDto.setFlag(dbManager.getString(resultSet,19));
            zh03InsuranceListDto.setRemark(dbManager.getString(resultSet,20));
            zh03InsuranceListDto.setItemCode(dbManager.getString(resultSet,21));
            zh03InsuranceListDto.setRate(dbManager.getString(resultSet,22));
            zh03InsuranceListDto.setFamilyFlag(dbManager.getString(resultSet,23));
            zh03InsuranceListDto.setExportIndex(dbManager.getString(resultSet,24));
            zh03InsuranceListDto.setPersonNo(dbManager.getString(resultSet,25));
        }
        resultSet.close();
        return zh03InsuranceListDto;
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
        buffer.append("FROM Zh03InsuranceList WHERE ");
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
        Zh03InsuranceListDto zh03InsuranceListDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            zh03InsuranceListDto = new Zh03InsuranceListDto();
            zh03InsuranceListDto.setInusreListCode(dbManager.getString(resultSet,"InusreListCode"));
            zh03InsuranceListDto.setIndexNo(dbManager.getString(resultSet,"IndexNo"));
            zh03InsuranceListDto.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            zh03InsuranceListDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            zh03InsuranceListDto.setFamilyNo(dbManager.getString(resultSet,"FamilyNo"));
            zh03InsuranceListDto.setFamilyName(dbManager.getString(resultSet,"FamilyName"));
            zh03InsuranceListDto.setFamilySex(dbManager.getString(resultSet,"FamilySex"));
            zh03InsuranceListDto.setFamilyFIdCard(dbManager.getString(resultSet,"FamilyFIdCard"));
            zh03InsuranceListDto.setName(dbManager.getString(resultSet,"Name"));
            zh03InsuranceListDto.setAddress(dbManager.getString(resultSet,"Address"));
            zh03InsuranceListDto.setCount(dbManager.getString(resultSet,"Count"));
            zh03InsuranceListDto.setUnitAmount(dbManager.getDouble(resultSet,"UnitAmount"));
            zh03InsuranceListDto.setSumAmount(dbManager.getDouble(resultSet,"SumAmount"));
            zh03InsuranceListDto.setSumPremium(dbManager.getDouble(resultSet,"SumPremium"));
            zh03InsuranceListDto.setHandlerCode(dbManager.getString(resultSet,"HandlerCode"));
            zh03InsuranceListDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,"InputDate"));
            zh03InsuranceListDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"StartDate"));
            zh03InsuranceListDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"EndDate"));
            zh03InsuranceListDto.setFlag(dbManager.getString(resultSet,"Flag"));
            zh03InsuranceListDto.setRemark(dbManager.getString(resultSet,"Remark"));
            zh03InsuranceListDto.setItemCode(dbManager.getString(resultSet,"ItemCode"));
            zh03InsuranceListDto.setRate(dbManager.getString(resultSet,"Rate"));
            zh03InsuranceListDto.setFamilyFlag(dbManager.getString(resultSet,"FamilyFlag"));
            zh03InsuranceListDto.setExportIndex(dbManager.getString(resultSet,"ExportIndex"));
            zh03InsuranceListDto.setPersonNo(dbManager.getString(resultSet,"PersonNo"));
            collection.add(zh03InsuranceListDto);
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
        buffer.append("DELETE FROM Zh03InsuranceList WHERE ");
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
        buffer.append("SELECT count(*) FROM Zh03InsuranceList WHERE ");
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
}
