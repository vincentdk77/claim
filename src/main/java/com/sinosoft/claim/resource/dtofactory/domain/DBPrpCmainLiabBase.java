package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainLiabDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPTMAINLIAB-责任险保单信息的数据访问对象基类<br>
 * 创建于 2005-06-28 15:26:07.953<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCmainLiabBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpCmainLiabBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCmainLiabBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCmainLiabDto prpCmainLiabDto
     * @throws Exception
     */
    public void insert(PrpCmainLiabDto prpCmainLiabDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCmainLiab (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("RiskKind,");
        buffer.append("CertificateNo,");
        buffer.append("CertificateDate,");
        buffer.append("CertificateDepart,");
        buffer.append("BusinessCode,");
        buffer.append("PracticeDate,");
        buffer.append("BusinessDetail,");
        buffer.append("BusinessSite,");
        buffer.append("InsureArea,");
        buffer.append("SaleArea,");
        buffer.append("OfficeType,");
        buffer.append("OfficeGrade,");
        buffer.append("BkWardStartDate,");
        buffer.append("BkWardEndDate,");
        buffer.append("StaffCount,");
        buffer.append("PreTurnOver,");
        buffer.append("NowTurnOver,");
        buffer.append("ElectricPower,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCmainLiabDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getRiskKind()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getCertificateNo()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getCertificateDate()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getCertificateDepart()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getBusinessCode()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getPracticeDate()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getBusinessDetail()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getBusinessSite()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getInsureArea()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getSaleArea()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getOfficeType()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getOfficeGrade()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getBkWardStartDate()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getBkWardEndDate()).append("',");
            debugBuffer.append("").append(prpCmainLiabDto.getStaffCount()).append(",");
            debugBuffer.append("").append(prpCmainLiabDto.getPreTurnOver()).append(",");
            debugBuffer.append("").append(prpCmainLiabDto.getNowTurnOver()).append(",");
            debugBuffer.append("").append(prpCmainLiabDto.getElectricPower()).append(",");
            debugBuffer.append("'").append(prpCmainLiabDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpCmainLiabDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpCmainLiabDto.getPolicyNo());
        dbManager.setString(2,prpCmainLiabDto.getRiskCode());
        dbManager.setString(3,prpCmainLiabDto.getRiskKind());
        dbManager.setString(4,prpCmainLiabDto.getCertificateNo());
        dbManager.setDateTime(5,prpCmainLiabDto.getCertificateDate());
        dbManager.setString(6,prpCmainLiabDto.getCertificateDepart());
        dbManager.setString(7,prpCmainLiabDto.getBusinessCode());
        dbManager.setDateTime(8,prpCmainLiabDto.getPracticeDate());
        dbManager.setString(9,prpCmainLiabDto.getBusinessDetail());
        dbManager.setString(10,prpCmainLiabDto.getBusinessSite());
        dbManager.setString(11,prpCmainLiabDto.getInsureArea());
        dbManager.setString(12,prpCmainLiabDto.getSaleArea());
        dbManager.setString(13,prpCmainLiabDto.getOfficeType());
        dbManager.setString(14,prpCmainLiabDto.getOfficeGrade());
        dbManager.setDateTime(15,prpCmainLiabDto.getBkWardStartDate());
        dbManager.setDateTime(16,prpCmainLiabDto.getBkWardEndDate());
        dbManager.setLong(17,prpCmainLiabDto.getStaffCount());
        dbManager.setDouble(18,prpCmainLiabDto.getPreTurnOver());
        dbManager.setDouble(19,prpCmainLiabDto.getNowTurnOver());
        dbManager.setDouble(20,prpCmainLiabDto.getElectricPower());
        dbManager.setString(21,prpCmainLiabDto.getRemark());
        dbManager.setString(22,prpCmainLiabDto.getFlag());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCmainLiab (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("RiskKind,");
        buffer.append("CertificateNo,");
        buffer.append("CertificateDate,");
        buffer.append("CertificateDepart,");
        buffer.append("BusinessCode,");
        buffer.append("PracticeDate,");
        buffer.append("BusinessDetail,");
        buffer.append("BusinessSite,");
        buffer.append("InsureArea,");
        buffer.append("SaleArea,");
        buffer.append("OfficeType,");
        buffer.append("OfficeGrade,");
        buffer.append("BkWardStartDate,");
        buffer.append("BkWardEndDate,");
        buffer.append("StaffCount,");
        buffer.append("PreTurnOver,");
        buffer.append("NowTurnOver,");
        buffer.append("ElectricPower,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCmainLiabDto prpCmainLiabDto = (PrpCmainLiabDto)i.next();
            dbManager.setString(1,prpCmainLiabDto.getPolicyNo());
            dbManager.setString(2,prpCmainLiabDto.getRiskCode());
            dbManager.setString(3,prpCmainLiabDto.getRiskKind());
            dbManager.setString(4,prpCmainLiabDto.getCertificateNo());
            dbManager.setDateTime(5,prpCmainLiabDto.getCertificateDate());
            dbManager.setString(6,prpCmainLiabDto.getCertificateDepart());
            dbManager.setString(7,prpCmainLiabDto.getBusinessCode());
            dbManager.setDateTime(8,prpCmainLiabDto.getPracticeDate());
            dbManager.setString(9,prpCmainLiabDto.getBusinessDetail());
            dbManager.setString(10,prpCmainLiabDto.getBusinessSite());
            dbManager.setString(11,prpCmainLiabDto.getInsureArea());
            dbManager.setString(12,prpCmainLiabDto.getSaleArea());
            dbManager.setString(13,prpCmainLiabDto.getOfficeType());
            dbManager.setString(14,prpCmainLiabDto.getOfficeGrade());
            dbManager.setDateTime(15,prpCmainLiabDto.getBkWardStartDate());
            dbManager.setDateTime(16,prpCmainLiabDto.getBkWardEndDate());
            dbManager.setLong(17,prpCmainLiabDto.getStaffCount());
            dbManager.setDouble(18,prpCmainLiabDto.getPreTurnOver());
            dbManager.setDouble(19,prpCmainLiabDto.getNowTurnOver());
            dbManager.setDouble(20,prpCmainLiabDto.getElectricPower());
            dbManager.setString(21,prpCmainLiabDto.getRemark());
            dbManager.setString(22,prpCmainLiabDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param PolicyNo 保单号码
     * @throws Exception
     */
    public void delete(String PolicyNo) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCmainLiab ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(PolicyNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,PolicyNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCmainLiabDto prpCmainLiabDto
     * @throws Exception
     */
    public void update(PrpCmainLiabDto prpCmainLiabDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCmainLiab SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("RiskKind = ?, ");
        buffer.append("CertificateNo = ?, ");
        buffer.append("CertificateDate = ?, ");
        buffer.append("CertificateDepart = ?, ");
        buffer.append("BusinessCode = ?, ");
        buffer.append("PracticeDate = ?, ");
        buffer.append("BusinessDetail = ?, ");
        buffer.append("BusinessSite = ?, ");
        buffer.append("InsureArea = ?, ");
        buffer.append("SaleArea = ?, ");
        buffer.append("OfficeType = ?, ");
        buffer.append("OfficeGrade = ?, ");
        buffer.append("BkWardStartDate = ?, ");
        buffer.append("BkWardEndDate = ?, ");
        buffer.append("StaffCount = ?, ");
        buffer.append("PreTurnOver = ?, ");
        buffer.append("NowTurnOver = ?, ");
        buffer.append("ElectricPower = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCmainLiab SET ");
            debugBuffer.append("RiskCode = '" + prpCmainLiabDto.getRiskCode() + "', ");
            debugBuffer.append("RiskKind = '" + prpCmainLiabDto.getRiskKind() + "', ");
            debugBuffer.append("CertificateNo = '" + prpCmainLiabDto.getCertificateNo() + "', ");
            debugBuffer.append("CertificateDate = '" + prpCmainLiabDto.getCertificateDate() + "', ");
            debugBuffer.append("CertificateDepart = '" + prpCmainLiabDto.getCertificateDepart() + "', ");
            debugBuffer.append("BusinessCode = '" + prpCmainLiabDto.getBusinessCode() + "', ");
            debugBuffer.append("PracticeDate = '" + prpCmainLiabDto.getPracticeDate() + "', ");
            debugBuffer.append("BusinessDetail = '" + prpCmainLiabDto.getBusinessDetail() + "', ");
            debugBuffer.append("BusinessSite = '" + prpCmainLiabDto.getBusinessSite() + "', ");
            debugBuffer.append("InsureArea = '" + prpCmainLiabDto.getInsureArea() + "', ");
            debugBuffer.append("SaleArea = '" + prpCmainLiabDto.getSaleArea() + "', ");
            debugBuffer.append("OfficeType = '" + prpCmainLiabDto.getOfficeType() + "', ");
            debugBuffer.append("OfficeGrade = '" + prpCmainLiabDto.getOfficeGrade() + "', ");
            debugBuffer.append("BkWardStartDate = '" + prpCmainLiabDto.getBkWardStartDate() + "', ");
            debugBuffer.append("BkWardEndDate = '" + prpCmainLiabDto.getBkWardEndDate() + "', ");
            debugBuffer.append("StaffCount = " + prpCmainLiabDto.getStaffCount() + ", ");
            debugBuffer.append("PreTurnOver = " + prpCmainLiabDto.getPreTurnOver() + ", ");
            debugBuffer.append("NowTurnOver = " + prpCmainLiabDto.getNowTurnOver() + ", ");
            debugBuffer.append("ElectricPower = " + prpCmainLiabDto.getElectricPower() + ", ");
            debugBuffer.append("Remark = '" + prpCmainLiabDto.getRemark() + "', ");
            debugBuffer.append("Flag = '" + prpCmainLiabDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpCmainLiabDto.getPolicyNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpCmainLiabDto.getRiskCode());
        dbManager.setString(2,prpCmainLiabDto.getRiskKind());
        dbManager.setString(3,prpCmainLiabDto.getCertificateNo());
        dbManager.setDateTime(4,prpCmainLiabDto.getCertificateDate());
        dbManager.setString(5,prpCmainLiabDto.getCertificateDepart());
        dbManager.setString(6,prpCmainLiabDto.getBusinessCode());
        dbManager.setDateTime(7,prpCmainLiabDto.getPracticeDate());
        dbManager.setString(8,prpCmainLiabDto.getBusinessDetail());
        dbManager.setString(9,prpCmainLiabDto.getBusinessSite());
        dbManager.setString(10,prpCmainLiabDto.getInsureArea());
        dbManager.setString(11,prpCmainLiabDto.getSaleArea());
        dbManager.setString(12,prpCmainLiabDto.getOfficeType());
        dbManager.setString(13,prpCmainLiabDto.getOfficeGrade());
        dbManager.setDateTime(14,prpCmainLiabDto.getBkWardStartDate());
        dbManager.setDateTime(15,prpCmainLiabDto.getBkWardEndDate());
        dbManager.setLong(16,prpCmainLiabDto.getStaffCount());
        dbManager.setDouble(17,prpCmainLiabDto.getPreTurnOver());
        dbManager.setDouble(18,prpCmainLiabDto.getNowTurnOver());
        dbManager.setDouble(19,prpCmainLiabDto.getElectricPower());
        dbManager.setString(20,prpCmainLiabDto.getRemark());
        dbManager.setString(21,prpCmainLiabDto.getFlag());
        //设置条件字段;
        dbManager.setString(22,prpCmainLiabDto.getPolicyNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param PolicyNo 保单号码
     * @return PrpCmainLiabDto
     * @throws Exception
     */
    public PrpCmainLiabDto findByPrimaryKey(String PolicyNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("RiskKind,");
        buffer.append("CertificateNo,");
        buffer.append("CertificateDate,");
        buffer.append("CertificateDepart,");
        buffer.append("BusinessCode,");
        buffer.append("PracticeDate,");
        buffer.append("BusinessDetail,");
        buffer.append("BusinessSite,");
        buffer.append("InsureArea,");
        buffer.append("SaleArea,");
        buffer.append("OfficeType,");
        buffer.append("OfficeGrade,");
        buffer.append("BkWardStartDate,");
        buffer.append("BkWardEndDate,");
        buffer.append("StaffCount,");
        buffer.append("PreTurnOver,");
        buffer.append("NowTurnOver,");
        buffer.append("ElectricPower,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append("FROM PrpCmainLiab ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(PolicyNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,PolicyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCmainLiabDto prpCmainLiabDto = null;
        if(resultSet.next()){
            prpCmainLiabDto = new PrpCmainLiabDto();
            prpCmainLiabDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainLiabDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCmainLiabDto.setRiskKind(dbManager.getString(resultSet,3));
            prpCmainLiabDto.setCertificateNo(dbManager.getString(resultSet,4));
            prpCmainLiabDto.setCertificateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpCmainLiabDto.setCertificateDepart(dbManager.getString(resultSet,6));
            prpCmainLiabDto.setBusinessCode(dbManager.getString(resultSet,7));
            prpCmainLiabDto.setPracticeDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpCmainLiabDto.setBusinessDetail(dbManager.getString(resultSet,9));
            prpCmainLiabDto.setBusinessSite(dbManager.getString(resultSet,10));
            prpCmainLiabDto.setInsureArea(dbManager.getString(resultSet,11));
            prpCmainLiabDto.setSaleArea(dbManager.getString(resultSet,12));
            prpCmainLiabDto.setOfficeType(dbManager.getString(resultSet,13));
            prpCmainLiabDto.setOfficeGrade(dbManager.getString(resultSet,14));
            prpCmainLiabDto.setBkWardStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpCmainLiabDto.setBkWardEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpCmainLiabDto.setStaffCount(dbManager.getLong(resultSet,17));
            prpCmainLiabDto.setPreTurnOver(dbManager.getDouble(resultSet,18));
            prpCmainLiabDto.setNowTurnOver(dbManager.getDouble(resultSet,19));
            prpCmainLiabDto.setElectricPower(dbManager.getDouble(resultSet,20));
            prpCmainLiabDto.setRemark(dbManager.getString(resultSet,21));
            prpCmainLiabDto.setFlag(dbManager.getString(resultSet,22));
        }else{
            logger.info("DBPrpCmainLiabBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpCmainLiabDto;
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
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("RiskKind,");
        buffer.append("CertificateNo,");
        buffer.append("CertificateDate,");
        buffer.append("CertificateDepart,");
        buffer.append("BusinessCode,");
        buffer.append("PracticeDate,");
        buffer.append("BusinessDetail,");
        buffer.append("BusinessSite,");
        buffer.append("InsureArea,");
        buffer.append("SaleArea,");
        buffer.append("OfficeType,");
        buffer.append("OfficeGrade,");
        buffer.append("BkWardStartDate,");
        buffer.append("BkWardEndDate,");
        buffer.append("StaffCount,");
        buffer.append("PreTurnOver,");
        buffer.append("NowTurnOver,");
        buffer.append("ElectricPower,");
        buffer.append("Remark,");
        buffer.append("Flag ");
        buffer.append("FROM PrpCmainLiab WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpCmainLiabDto prpCmainLiabDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpCmainLiabDto = new PrpCmainLiabDto();
            prpCmainLiabDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainLiabDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCmainLiabDto.setRiskKind(dbManager.getString(resultSet,3));
            prpCmainLiabDto.setCertificateNo(dbManager.getString(resultSet,4));
            prpCmainLiabDto.setCertificateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpCmainLiabDto.setCertificateDepart(dbManager.getString(resultSet,6));
            prpCmainLiabDto.setBusinessCode(dbManager.getString(resultSet,7));
            prpCmainLiabDto.setPracticeDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpCmainLiabDto.setBusinessDetail(dbManager.getString(resultSet,9));
            prpCmainLiabDto.setBusinessSite(dbManager.getString(resultSet,10));
            prpCmainLiabDto.setInsureArea(dbManager.getString(resultSet,11));
            prpCmainLiabDto.setSaleArea(dbManager.getString(resultSet,12));
            prpCmainLiabDto.setOfficeType(dbManager.getString(resultSet,13));
            prpCmainLiabDto.setOfficeGrade(dbManager.getString(resultSet,14));
            prpCmainLiabDto.setBkWardStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpCmainLiabDto.setBkWardEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpCmainLiabDto.setStaffCount(dbManager.getLong(resultSet,17));
            prpCmainLiabDto.setPreTurnOver(dbManager.getDouble(resultSet,18));
            prpCmainLiabDto.setNowTurnOver(dbManager.getDouble(resultSet,19));
            prpCmainLiabDto.setElectricPower(dbManager.getDouble(resultSet,20));
            prpCmainLiabDto.setRemark(dbManager.getString(resultSet,21));
            prpCmainLiabDto.setFlag(dbManager.getString(resultSet,22));
            collection.add(prpCmainLiabDto);
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCmainLiab WHERE ");
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
        String statement;
        statement="SELECT count(1) FROM PrpCmainLiab WHERE ";
         statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
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
