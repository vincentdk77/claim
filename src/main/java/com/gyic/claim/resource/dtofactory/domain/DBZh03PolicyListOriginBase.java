package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListOriginDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03PolicyListOrigin的数据访问对象基类<br>
 */
public class DBZh03PolicyListOriginBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBZh03PolicyListOriginBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBZh03PolicyListOriginBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public void insert(Zh03PolicyListOriginDto zh03PolicyListOriginDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Zh03PolicyListOrigin (");
        buffer.append("Inusrelistcode,");
        buffer.append("Indexno,");
        buffer.append("Riskcode,");
        buffer.append("Kindcode,");
        buffer.append("Familyno,");
        buffer.append("Familyname,");
        buffer.append("Familysex,");
        buffer.append("Familyfidcard,");
        buffer.append("Name,");
        buffer.append("Address,");
        buffer.append("Count,");
        buffer.append("Unitamount,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Handlercode,");
        buffer.append("Inputdate,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("Itemcode,");
        buffer.append("Rate,");
        buffer.append("Familyflag,");
        buffer.append("ExportIndex,");
        buffer.append("PersonNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getIndexno()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getKindcode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getFamilyno()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getFamilyname()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getFamilysex()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getFamilyfidcard()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getName()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getAddress()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getCount()).append("',");
            debugBuffer.append("").append(zh03PolicyListOriginDto.getUnitamount()).append(",");
            debugBuffer.append("").append(zh03PolicyListOriginDto.getSumamount()).append(",");
            debugBuffer.append("").append(zh03PolicyListOriginDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getHandlercode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getInputdate()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getStartdate()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getEnddate()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getFlag()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getRemark()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getItemcode()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getRate()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getFamilyflag()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getExportIndex()).append("',");
            debugBuffer.append("'").append(zh03PolicyListOriginDto.getPersonNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,zh03PolicyListOriginDto.getInusrelistcode());
        dbManager.setString(2,zh03PolicyListOriginDto.getIndexno());
        dbManager.setString(3,zh03PolicyListOriginDto.getRiskcode());
        dbManager.setString(4,zh03PolicyListOriginDto.getKindcode());
        dbManager.setString(5,zh03PolicyListOriginDto.getFamilyno());
        dbManager.setString(6,zh03PolicyListOriginDto.getFamilyname());
        dbManager.setString(7,zh03PolicyListOriginDto.getFamilysex());
        dbManager.setString(8,zh03PolicyListOriginDto.getFamilyfidcard());
        dbManager.setString(9,zh03PolicyListOriginDto.getName());
        dbManager.setString(10,zh03PolicyListOriginDto.getAddress());
        dbManager.setString(11,zh03PolicyListOriginDto.getCount());
        dbManager.setDouble(12,zh03PolicyListOriginDto.getUnitamount());
        dbManager.setDouble(13,zh03PolicyListOriginDto.getSumamount());
        dbManager.setDouble(14,zh03PolicyListOriginDto.getSumpremium());
        dbManager.setString(15,zh03PolicyListOriginDto.getHandlercode());
        dbManager.setDateTime(16,zh03PolicyListOriginDto.getInputdate());
        dbManager.setDateTime(17,zh03PolicyListOriginDto.getStartdate());
        dbManager.setDateTime(18,zh03PolicyListOriginDto.getEnddate());
        dbManager.setString(19,zh03PolicyListOriginDto.getFlag());
        dbManager.setString(20,zh03PolicyListOriginDto.getRemark());
        dbManager.setString(21,zh03PolicyListOriginDto.getItemcode());
        dbManager.setString(22,zh03PolicyListOriginDto.getRate());
        dbManager.setString(23,zh03PolicyListOriginDto.getFamilyflag());
        dbManager.setString(24,zh03PolicyListOriginDto.getExportIndex());
        dbManager.setString(25,zh03PolicyListOriginDto.getPersonNo());
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
        buffer.append("INSERT INTO Zh03PolicyListOrigin (");
        buffer.append("Inusrelistcode,");
        buffer.append("Indexno,");
        buffer.append("Riskcode,");
        buffer.append("Kindcode,");
        buffer.append("Familyno,");
        buffer.append("Familyname,");
        buffer.append("Familysex,");
        buffer.append("Familyfidcard,");
        buffer.append("Name,");
        buffer.append("Address,");
        buffer.append("Count,");
        buffer.append("Unitamount,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Handlercode,");
        buffer.append("Inputdate,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("Itemcode,");
        buffer.append("Rate,");
        buffer.append("Familyflag,");
        buffer.append("ExportIndex,");
        buffer.append("PersonNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            Zh03PolicyListOriginDto zh03PolicyListOriginDto = (Zh03PolicyListOriginDto)i.next();
            dbManager.setString(1,zh03PolicyListOriginDto.getInusrelistcode());
            dbManager.setString(2,zh03PolicyListOriginDto.getIndexno());
            dbManager.setString(3,zh03PolicyListOriginDto.getRiskcode());
            dbManager.setString(4,zh03PolicyListOriginDto.getKindcode());
            dbManager.setString(5,zh03PolicyListOriginDto.getFamilyno());
            dbManager.setString(6,zh03PolicyListOriginDto.getFamilyname());
            dbManager.setString(7,zh03PolicyListOriginDto.getFamilysex());
            dbManager.setString(8,zh03PolicyListOriginDto.getFamilyfidcard());
            dbManager.setString(9,zh03PolicyListOriginDto.getName());
            dbManager.setString(10,zh03PolicyListOriginDto.getAddress());
            dbManager.setString(11,zh03PolicyListOriginDto.getCount());
            dbManager.setDouble(12,zh03PolicyListOriginDto.getUnitamount());
            dbManager.setDouble(13,zh03PolicyListOriginDto.getSumamount());
            dbManager.setDouble(14,zh03PolicyListOriginDto.getSumpremium());
            dbManager.setString(15,zh03PolicyListOriginDto.getHandlercode());
            dbManager.setDateTime(16,zh03PolicyListOriginDto.getInputdate());
            dbManager.setDateTime(17,zh03PolicyListOriginDto.getStartdate());
            dbManager.setDateTime(18,zh03PolicyListOriginDto.getEnddate());
            dbManager.setString(19,zh03PolicyListOriginDto.getFlag());
            dbManager.setString(20,zh03PolicyListOriginDto.getRemark());
            dbManager.setString(21,zh03PolicyListOriginDto.getItemcode());
            dbManager.setString(22,zh03PolicyListOriginDto.getRate());
            dbManager.setString(23,zh03PolicyListOriginDto.getFamilyflag());
            dbManager.setString(24,zh03PolicyListOriginDto.getExportIndex());
            dbManager.setString(25,zh03PolicyListOriginDto.getPersonNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Zh03PolicyListOrigin ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @throws Exception
     */
    public void update(Zh03PolicyListOriginDto zh03PolicyListOriginDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Zh03PolicyListOrigin SET ");
        buffer.append("Indexno = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Kindcode = ?, ");
        buffer.append("Familyno = ?, ");
        buffer.append("Familyname = ?, ");
        buffer.append("Familysex = ?, ");
        buffer.append("Familyfidcard = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("Count = ?, ");
        buffer.append("Unitamount = ?, ");
        buffer.append("Sumamount = ?, ");
        buffer.append("Sumpremium = ?, ");
        buffer.append("Handlercode = ?, ");
        buffer.append("Inputdate = ?, ");
        buffer.append("Startdate = ?, ");
        buffer.append("Enddate = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Itemcode = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("Familyflag = ?, ");
        buffer.append("ExportIndex = ?, ");
        buffer.append("PersonNo = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Zh03PolicyListOrigin SET ");
            debugBuffer.append("Indexno = '" + zh03PolicyListOriginDto.getIndexno() + "', ");
            debugBuffer.append("Riskcode = '" + zh03PolicyListOriginDto.getRiskcode() + "', ");
            debugBuffer.append("Kindcode = '" + zh03PolicyListOriginDto.getKindcode() + "', ");
            debugBuffer.append("Familyno = '" + zh03PolicyListOriginDto.getFamilyno() + "', ");
            debugBuffer.append("Familyname = '" + zh03PolicyListOriginDto.getFamilyname() + "', ");
            debugBuffer.append("Familysex = '" + zh03PolicyListOriginDto.getFamilysex() + "', ");
            debugBuffer.append("Familyfidcard = '" + zh03PolicyListOriginDto.getFamilyfidcard() + "', ");
            debugBuffer.append("Name = '" + zh03PolicyListOriginDto.getName() + "', ");
            debugBuffer.append("Address = '" + zh03PolicyListOriginDto.getAddress() + "', ");
            debugBuffer.append("Count = '" + zh03PolicyListOriginDto.getCount() + "', ");
            debugBuffer.append("Unitamount = " + zh03PolicyListOriginDto.getUnitamount() + ", ");
            debugBuffer.append("Sumamount = " + zh03PolicyListOriginDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + zh03PolicyListOriginDto.getSumpremium() + ", ");
            debugBuffer.append("Handlercode = '" + zh03PolicyListOriginDto.getHandlercode() + "', ");
            debugBuffer.append("Inputdate = '" + zh03PolicyListOriginDto.getInputdate() + "', ");
            debugBuffer.append("Startdate = '" + zh03PolicyListOriginDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + zh03PolicyListOriginDto.getEnddate() + "', ");
            debugBuffer.append("Flag = '" + zh03PolicyListOriginDto.getFlag() + "', ");
            debugBuffer.append("Remark = '" + zh03PolicyListOriginDto.getRemark() + "', ");
            debugBuffer.append("Itemcode = '" + zh03PolicyListOriginDto.getItemcode() + "', ");
            debugBuffer.append("Rate = '" + zh03PolicyListOriginDto.getRate() + "', ");
            debugBuffer.append("Familyflag = '" + zh03PolicyListOriginDto.getFamilyflag() + "', ");
            debugBuffer.append("ExportIndex = '" + zh03PolicyListOriginDto.getExportIndex() + "', ");
            debugBuffer.append("PersonNo = '" + zh03PolicyListOriginDto.getPersonNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(zh03PolicyListOriginDto.getInusrelistcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,zh03PolicyListOriginDto.getIndexno());
        dbManager.setString(2,zh03PolicyListOriginDto.getRiskcode());
        dbManager.setString(3,zh03PolicyListOriginDto.getKindcode());
        dbManager.setString(4,zh03PolicyListOriginDto.getFamilyno());
        dbManager.setString(5,zh03PolicyListOriginDto.getFamilyname());
        dbManager.setString(6,zh03PolicyListOriginDto.getFamilysex());
        dbManager.setString(7,zh03PolicyListOriginDto.getFamilyfidcard());
        dbManager.setString(8,zh03PolicyListOriginDto.getName());
        dbManager.setString(9,zh03PolicyListOriginDto.getAddress());
        dbManager.setString(10,zh03PolicyListOriginDto.getCount());
        dbManager.setDouble(11,zh03PolicyListOriginDto.getUnitamount());
        dbManager.setDouble(12,zh03PolicyListOriginDto.getSumamount());
        dbManager.setDouble(13,zh03PolicyListOriginDto.getSumpremium());
        dbManager.setString(14,zh03PolicyListOriginDto.getHandlercode());
        dbManager.setDateTime(15,zh03PolicyListOriginDto.getInputdate());
        dbManager.setDateTime(16,zh03PolicyListOriginDto.getStartdate());
        dbManager.setDateTime(17,zh03PolicyListOriginDto.getEnddate());
        dbManager.setString(18,zh03PolicyListOriginDto.getFlag());
        dbManager.setString(19,zh03PolicyListOriginDto.getRemark());
        dbManager.setString(20,zh03PolicyListOriginDto.getItemcode());
        dbManager.setString(21,zh03PolicyListOriginDto.getRate());
        dbManager.setString(22,zh03PolicyListOriginDto.getFamilyflag());
        dbManager.setString(23,zh03PolicyListOriginDto.getExportIndex());
        dbManager.setString(24,zh03PolicyListOriginDto.getPersonNo());
        //设置条件字段;
        dbManager.setString(25,zh03PolicyListOriginDto.getInusrelistcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @return Zh03PolicyListOriginDto
     * @throws Exception
     */
    public Zh03PolicyListOriginDto findByPrimaryKey(String inusrelistcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Indexno,");
        buffer.append("Riskcode,");
        buffer.append("Kindcode,");
        buffer.append("Familyno,");
        buffer.append("Familyname,");
        buffer.append("Familysex,");
        buffer.append("Familyfidcard,");
        buffer.append("Name,");
        buffer.append("Address,");
        buffer.append("Count,");
        buffer.append("Unitamount,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Handlercode,");
        buffer.append("Inputdate,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("Itemcode,");
        buffer.append("Rate,");
        buffer.append("Familyflag,");
        buffer.append("ExportIndex,");
        buffer.append("PersonNo ");
        buffer.append("FROM Zh03PolicyListOrigin ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        Zh03PolicyListOriginDto zh03PolicyListOriginDto = null;
        if(resultSet.next()){
            zh03PolicyListOriginDto = new Zh03PolicyListOriginDto();
            zh03PolicyListOriginDto.setInusrelistcode(dbManager.getString(resultSet,1));
            zh03PolicyListOriginDto.setIndexno(dbManager.getString(resultSet,2));
            zh03PolicyListOriginDto.setRiskcode(dbManager.getString(resultSet,3));
            zh03PolicyListOriginDto.setKindcode(dbManager.getString(resultSet,4));
            zh03PolicyListOriginDto.setFamilyno(dbManager.getString(resultSet,5));
            zh03PolicyListOriginDto.setFamilyname(dbManager.getString(resultSet,6));
            zh03PolicyListOriginDto.setFamilysex(dbManager.getString(resultSet,7));
            zh03PolicyListOriginDto.setFamilyfidcard(dbManager.getString(resultSet,8));
            zh03PolicyListOriginDto.setName(dbManager.getString(resultSet,9));
            zh03PolicyListOriginDto.setAddress(dbManager.getString(resultSet,10));
            zh03PolicyListOriginDto.setCount(dbManager.getString(resultSet,11));
            zh03PolicyListOriginDto.setUnitamount(dbManager.getDouble(resultSet,12));
            zh03PolicyListOriginDto.setSumamount(dbManager.getDouble(resultSet,13));
            zh03PolicyListOriginDto.setSumpremium(dbManager.getDouble(resultSet,14));
            zh03PolicyListOriginDto.setHandlercode(dbManager.getString(resultSet,15));
            zh03PolicyListOriginDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            zh03PolicyListOriginDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            zh03PolicyListOriginDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            zh03PolicyListOriginDto.setFlag(dbManager.getString(resultSet,19));
            zh03PolicyListOriginDto.setRemark(dbManager.getString(resultSet,20));
            zh03PolicyListOriginDto.setItemcode(dbManager.getString(resultSet,21));
            zh03PolicyListOriginDto.setRate(dbManager.getString(resultSet,22));
            zh03PolicyListOriginDto.setFamilyflag(dbManager.getString(resultSet,23));
            zh03PolicyListOriginDto.setExportIndex(dbManager.getString(resultSet,24));
            zh03PolicyListOriginDto.setPersonNo(dbManager.getString(resultSet,25));
        }
        resultSet.close();
        return zh03PolicyListOriginDto;
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
        buffer.append("Inusrelistcode,");
        buffer.append("Indexno,");
        buffer.append("Riskcode,");
        buffer.append("Kindcode,");
        buffer.append("Familyno,");
        buffer.append("Familyname,");
        buffer.append("Familysex,");
        buffer.append("Familyfidcard,");
        buffer.append("Name,");
        buffer.append("Address,");
        buffer.append("Count,");
        buffer.append("Unitamount,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Handlercode,");
        buffer.append("Inputdate,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("Itemcode,");
        buffer.append("Rate,");
        buffer.append("Familyflag,");
        buffer.append("ExportIndex,");
        buffer.append("PersonNo ");
        buffer.append("FROM Zh03PolicyListOrigin WHERE ");
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
        Zh03PolicyListOriginDto zh03PolicyListOriginDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            zh03PolicyListOriginDto = new Zh03PolicyListOriginDto();
            zh03PolicyListOriginDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            zh03PolicyListOriginDto.setIndexno(dbManager.getString(resultSet,"Indexno"));
            zh03PolicyListOriginDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            zh03PolicyListOriginDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            zh03PolicyListOriginDto.setFamilyno(dbManager.getString(resultSet,"Familyno"));
            zh03PolicyListOriginDto.setFamilyname(dbManager.getString(resultSet,"Familyname"));
            zh03PolicyListOriginDto.setFamilysex(dbManager.getString(resultSet,"Familysex"));
            zh03PolicyListOriginDto.setFamilyfidcard(dbManager.getString(resultSet,"Familyfidcard"));
            zh03PolicyListOriginDto.setName(dbManager.getString(resultSet,"Name"));
            zh03PolicyListOriginDto.setAddress(dbManager.getString(resultSet,"Address"));
            zh03PolicyListOriginDto.setCount(dbManager.getString(resultSet,"Count"));
            zh03PolicyListOriginDto.setUnitamount(dbManager.getDouble(resultSet,"Unitamount"));
            zh03PolicyListOriginDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            zh03PolicyListOriginDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            zh03PolicyListOriginDto.setHandlercode(dbManager.getString(resultSet,"Handlercode"));
            zh03PolicyListOriginDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Inputdate"));
            zh03PolicyListOriginDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            zh03PolicyListOriginDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            zh03PolicyListOriginDto.setFlag(dbManager.getString(resultSet,"Flag"));
            zh03PolicyListOriginDto.setRemark(dbManager.getString(resultSet,"Remark"));
            zh03PolicyListOriginDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            zh03PolicyListOriginDto.setRate(dbManager.getString(resultSet,"Rate"));
            zh03PolicyListOriginDto.setFamilyflag(dbManager.getString(resultSet,"Familyflag"));
            zh03PolicyListOriginDto.setExportIndex(dbManager.getString(resultSet,"ExportIndex"));
            zh03PolicyListOriginDto.setPersonNo(dbManager.getString(resultSet,"PersonNo"));
            collection.add(zh03PolicyListOriginDto);
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
        buffer.append("DELETE FROM Zh03PolicyListOrigin WHERE ");
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
        buffer.append("SELECT count(*) FROM Zh03PolicyListOrigin WHERE ");
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
