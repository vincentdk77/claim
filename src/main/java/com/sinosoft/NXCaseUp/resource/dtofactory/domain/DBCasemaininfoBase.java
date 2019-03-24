package com.sinosoft.NXCaseUp.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasemaininfoDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CASEMAININFO�����ݷ��ʶ������<br>
 * ������ 2015-09-25 12:30:11.546<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCasemaininfoBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBCasemaininfoBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCasemaininfoBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void insert(CasemaininfoDto casemaininfoDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Casemaininfo (");
        buffer.append("Comcode,");
        buffer.append("Policyno,");
        buffer.append("Caseno,");
        buffer.append("Claimno,");
        buffer.append("Underwriteenddate,");
        buffer.append("Endcasedate,");
        buffer.append("Asumpaid,");
        buffer.append("Asumfee,");
        buffer.append("Casemoney,");
        buffer.append("Casemoneyfee,");
        buffer.append("Presumpaid,");
        buffer.append("Presumfee,");
        buffer.append("Damageinsured,");
        buffer.append("Lossesnumber,");
        buffer.append("Lossesunitcode,");
        buffer.append("Reopenedtype,");
        buffer.append("Times,");
        buffer.append("Affectedarea,");
        buffer.append("Lossarea,");
        buffer.append("Lawsuitflag,");
        buffer.append("Farmercount,");
        buffer.append("Claimcode,");
        buffer.append("Damagedarea ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(casemaininfoDto.getComcode()).append("',");
            debugBuffer.append("'").append(casemaininfoDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(casemaininfoDto.getCaseno()).append("',");
            debugBuffer.append("'").append(casemaininfoDto.getClaimno()).append("',");
            debugBuffer.append("'").append(casemaininfoDto.getUnderwriteenddate()).append("',");
            debugBuffer.append("'").append(casemaininfoDto.getEndcasedate()).append("',");
            debugBuffer.append("").append(casemaininfoDto.getAsumpaid()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getAsumfee()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getCasemoney()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getCasemoneyfee()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getPresumpaid()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getPresumfee()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getDamageinsured()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getLossesnumber()).append(",");
            debugBuffer.append("'").append(casemaininfoDto.getLossesunitcode()).append("',");
            debugBuffer.append("'").append(casemaininfoDto.getReopenedtype()).append("',");
            debugBuffer.append("").append(casemaininfoDto.getTimes()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getAffectedarea()).append(",");
            debugBuffer.append("").append(casemaininfoDto.getLossarea()).append(",");
            debugBuffer.append("'").append(casemaininfoDto.getLawsuitflag()).append("',");
            debugBuffer.append("").append(casemaininfoDto.getFarmercount()).append(",");
            debugBuffer.append("'").append(casemaininfoDto.getClaimcode()).append("',");
            debugBuffer.append("").append(casemaininfoDto.getDamagedarea()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,casemaininfoDto.getComcode());
        dbManager.setString(2,casemaininfoDto.getPolicyno());
        dbManager.setString(3,casemaininfoDto.getCaseno());
        dbManager.setString(4,casemaininfoDto.getClaimno());
        dbManager.setDateTime(5,casemaininfoDto.getUnderwriteenddate());
        dbManager.setDateTime(6,casemaininfoDto.getEndcasedate());
        dbManager.setDouble(7,casemaininfoDto.getAsumpaid());
        dbManager.setDouble(8,casemaininfoDto.getAsumfee());
        dbManager.setDouble(9,casemaininfoDto.getCasemoney());
        dbManager.setDouble(10,casemaininfoDto.getCasemoneyfee());
        dbManager.setDouble(11,casemaininfoDto.getPresumpaid());
        dbManager.setDouble(12,casemaininfoDto.getPresumfee());
        dbManager.setLong(13,casemaininfoDto.getDamageinsured());
        dbManager.setDouble(14,casemaininfoDto.getLossesnumber());
        dbManager.setString(15,casemaininfoDto.getLossesunitcode());
        dbManager.setString(16,casemaininfoDto.getReopenedtype());
        dbManager.setInt(17,casemaininfoDto.getTimes());
        dbManager.setDouble(18,casemaininfoDto.getAffectedarea());
        dbManager.setDouble(19,casemaininfoDto.getLossarea());
        dbManager.setString(20,casemaininfoDto.getLawsuitflag());
        dbManager.setLong(21,casemaininfoDto.getFarmercount());
        dbManager.setString(22,casemaininfoDto.getClaimcode());
        dbManager.setDouble(23,casemaininfoDto.getDamagedarea());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Casemaininfo (");
        buffer.append("Comcode,");
        buffer.append("Policyno,");
        buffer.append("Caseno,");
        buffer.append("Claimno,");
        buffer.append("Underwriteenddate,");
        buffer.append("Endcasedate,");
        buffer.append("Asumpaid,");
        buffer.append("Asumfee,");
        buffer.append("Casemoney,");
        buffer.append("Casemoneyfee,");
        buffer.append("Presumpaid,");
        buffer.append("Presumfee,");
        buffer.append("Damageinsured,");
        buffer.append("Lossesnumber,");
        buffer.append("Lossesunitcode,");
        buffer.append("Reopenedtype,");
        buffer.append("Times,");
        buffer.append("Affectedarea,");
        buffer.append("Lossarea,");
        buffer.append("Lawsuitflag,");
        buffer.append("Farmercount,");
        buffer.append("Claimcode,");
        buffer.append("Damagedarea ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CasemaininfoDto casemaininfoDto = (CasemaininfoDto)i.next();
            dbManager.setString(1,casemaininfoDto.getComcode());
            dbManager.setString(2,casemaininfoDto.getPolicyno());
            dbManager.setString(3,casemaininfoDto.getCaseno());
            dbManager.setString(4,casemaininfoDto.getClaimno());
            dbManager.setDateTime(5,casemaininfoDto.getUnderwriteenddate());
            dbManager.setDateTime(6,casemaininfoDto.getEndcasedate());
            dbManager.setDouble(7,casemaininfoDto.getAsumpaid());
            dbManager.setDouble(8,casemaininfoDto.getAsumfee());
            dbManager.setDouble(9,casemaininfoDto.getCasemoney());
            dbManager.setDouble(10,casemaininfoDto.getCasemoneyfee());
            dbManager.setDouble(11,casemaininfoDto.getPresumpaid());
            dbManager.setDouble(12,casemaininfoDto.getPresumfee());
            dbManager.setLong(13,casemaininfoDto.getDamageinsured());
            dbManager.setDouble(14,casemaininfoDto.getLossesnumber());
            dbManager.setString(15,casemaininfoDto.getLossesunitcode());
            dbManager.setString(16,casemaininfoDto.getReopenedtype());
            dbManager.setInt(17,casemaininfoDto.getTimes());
            dbManager.setDouble(18,casemaininfoDto.getAffectedarea());
            dbManager.setDouble(19,casemaininfoDto.getLossarea());
            dbManager.setString(20,casemaininfoDto.getLawsuitflag());
            dbManager.setLong(21,casemaininfoDto.getFarmercount());
            dbManager.setString(22,casemaininfoDto.getClaimcode());
            dbManager.setDouble(23,casemaininfoDto.getDamagedarea());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param comcode COMCODE
     * @throws Exception
     */
    public void delete(String comcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Casemaininfo ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Comcode=").append("'").append(comcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Comcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,comcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void update(CasemaininfoDto casemaininfoDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Casemaininfo SET ");
        buffer.append("Policyno = ?, ");
        buffer.append("Caseno = ?, ");
        buffer.append("Claimno = ?, ");
        buffer.append("Underwriteenddate = ?, ");
        buffer.append("Endcasedate = ?, ");
        buffer.append("Asumpaid = ?, ");
        buffer.append("Asumfee = ?, ");
        buffer.append("Casemoney = ?, ");
        buffer.append("Casemoneyfee = ?, ");
        buffer.append("Presumpaid = ?, ");
        buffer.append("Presumfee = ?, ");
        buffer.append("Damageinsured = ?, ");
        buffer.append("Lossesnumber = ?, ");
        buffer.append("Lossesunitcode = ?, ");
        buffer.append("Reopenedtype = ?, ");
        buffer.append("Times = ?, ");
        buffer.append("Affectedarea = ?, ");
        buffer.append("Lossarea = ?, ");
        buffer.append("Lawsuitflag = ?, ");
        buffer.append("Farmercount = ?, ");
        buffer.append("Claimcode = ?, ");
        buffer.append("Damagedarea = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Casemaininfo SET ");
            debugBuffer.append("Policyno = '" + casemaininfoDto.getPolicyno() + "', ");
            debugBuffer.append("Caseno = '" + casemaininfoDto.getCaseno() + "', ");
            debugBuffer.append("Claimno = '" + casemaininfoDto.getClaimno() + "', ");
            debugBuffer.append("Underwriteenddate = '" + casemaininfoDto.getUnderwriteenddate() + "', ");
            debugBuffer.append("Endcasedate = '" + casemaininfoDto.getEndcasedate() + "', ");
            debugBuffer.append("Asumpaid = " + casemaininfoDto.getAsumpaid() + ", ");
            debugBuffer.append("Asumfee = " + casemaininfoDto.getAsumfee() + ", ");
            debugBuffer.append("Casemoney = " + casemaininfoDto.getCasemoney() + ", ");
            debugBuffer.append("Casemoneyfee = " + casemaininfoDto.getCasemoneyfee() + ", ");
            debugBuffer.append("Presumpaid = " + casemaininfoDto.getPresumpaid() + ", ");
            debugBuffer.append("Presumfee = " + casemaininfoDto.getPresumfee() + ", ");
            debugBuffer.append("Damageinsured = " + casemaininfoDto.getDamageinsured() + ", ");
            debugBuffer.append("Lossesnumber = " + casemaininfoDto.getLossesnumber() + ", ");
            debugBuffer.append("Lossesunitcode = '" + casemaininfoDto.getLossesunitcode() + "', ");
            debugBuffer.append("Reopenedtype = '" + casemaininfoDto.getReopenedtype() + "', ");
            debugBuffer.append("Times = " + casemaininfoDto.getTimes() + ", ");
            debugBuffer.append("Affectedarea = " + casemaininfoDto.getAffectedarea() + ", ");
            debugBuffer.append("Lossarea = " + casemaininfoDto.getLossarea() + ", ");
            debugBuffer.append("Lawsuitflag = '" + casemaininfoDto.getLawsuitflag() + "', ");
            debugBuffer.append("Farmercount = " + casemaininfoDto.getFarmercount() + ", ");
            debugBuffer.append("Claimcode = '" + casemaininfoDto.getClaimcode() + "', ");
            debugBuffer.append("Damagedarea = " + casemaininfoDto.getDamagedarea() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Comcode=").append("'").append(casemaininfoDto.getComcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Comcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,casemaininfoDto.getPolicyno());
        dbManager.setString(2,casemaininfoDto.getCaseno());
        dbManager.setString(3,casemaininfoDto.getClaimno());
        dbManager.setDateTime(4,casemaininfoDto.getUnderwriteenddate());
        dbManager.setDateTime(5,casemaininfoDto.getEndcasedate());
        dbManager.setDouble(6,casemaininfoDto.getAsumpaid());
        dbManager.setDouble(7,casemaininfoDto.getAsumfee());
        dbManager.setDouble(8,casemaininfoDto.getCasemoney());
        dbManager.setDouble(9,casemaininfoDto.getCasemoneyfee());
        dbManager.setDouble(10,casemaininfoDto.getPresumpaid());
        dbManager.setDouble(11,casemaininfoDto.getPresumfee());
        dbManager.setLong(12,casemaininfoDto.getDamageinsured());
        dbManager.setDouble(13,casemaininfoDto.getLossesnumber());
        dbManager.setString(14,casemaininfoDto.getLossesunitcode());
        dbManager.setString(15,casemaininfoDto.getReopenedtype());
        dbManager.setInt(16,casemaininfoDto.getTimes());
        dbManager.setDouble(17,casemaininfoDto.getAffectedarea());
        dbManager.setDouble(18,casemaininfoDto.getLossarea());
        dbManager.setString(19,casemaininfoDto.getLawsuitflag());
        dbManager.setLong(20,casemaininfoDto.getFarmercount());
        dbManager.setString(21,casemaininfoDto.getClaimcode());
        dbManager.setDouble(22,casemaininfoDto.getDamagedarea());
        //���������ֶ�;
        dbManager.setString(23,casemaininfoDto.getComcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param comcode COMCODE
     * @return CasemaininfoDto
     * @throws Exception
     */
    public CasemaininfoDto findByPrimaryKey(String comcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Comcode,");
        buffer.append("Policyno,");
        buffer.append("Caseno,");
        buffer.append("Claimno,");
        buffer.append("Underwriteenddate,");
        buffer.append("Endcasedate,");
        buffer.append("Asumpaid,");
        buffer.append("Asumfee,");
        buffer.append("Casemoney,");
        buffer.append("Casemoneyfee,");
        buffer.append("Presumpaid,");
        buffer.append("Presumfee,");
        buffer.append("Damageinsured,");
        buffer.append("Lossesnumber,");
        buffer.append("Lossesunitcode,");
        buffer.append("Reopenedtype,");
        buffer.append("Times,");
        buffer.append("Affectedarea,");
        buffer.append("Lossarea,");
        buffer.append("Lawsuitflag,");
        buffer.append("Farmercount,");
        buffer.append("Claimcode,");
        buffer.append("Damagedarea ");
        buffer.append("FROM Casemaininfo ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Comcode=").append("'").append(comcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Comcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,comcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CasemaininfoDto casemaininfoDto = null;
        if(resultSet.next()){
            casemaininfoDto = new CasemaininfoDto();
            casemaininfoDto.setComcode(dbManager.getString(resultSet,1));
            casemaininfoDto.setPolicyno(dbManager.getString(resultSet,2));
            casemaininfoDto.setCaseno(dbManager.getString(resultSet,3));
            casemaininfoDto.setClaimno(dbManager.getString(resultSet,4));
            casemaininfoDto.setUnderwriteenddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            casemaininfoDto.setEndcasedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            casemaininfoDto.setAsumpaid(dbManager.getDouble(resultSet,7));
            casemaininfoDto.setAsumfee(dbManager.getDouble(resultSet,8));
            casemaininfoDto.setCasemoney(dbManager.getDouble(resultSet,9));
            casemaininfoDto.setCasemoneyfee(dbManager.getDouble(resultSet,10));
            casemaininfoDto.setPresumpaid(dbManager.getDouble(resultSet,11));
            casemaininfoDto.setPresumfee(dbManager.getDouble(resultSet,12));
            casemaininfoDto.setDamageinsured(dbManager.getLong(resultSet,13));
            casemaininfoDto.setLossesnumber(dbManager.getDouble(resultSet,14));
            casemaininfoDto.setLossesunitcode(dbManager.getString(resultSet,15));
            casemaininfoDto.setReopenedtype(dbManager.getString(resultSet,16));
            casemaininfoDto.setTimes(dbManager.getInt(resultSet,17));
            casemaininfoDto.setAffectedarea(dbManager.getDouble(resultSet,18));
            casemaininfoDto.setLossarea(dbManager.getDouble(resultSet,19));
            casemaininfoDto.setLawsuitflag(dbManager.getString(resultSet,20));
            casemaininfoDto.setFarmercount(dbManager.getLong(resultSet,21));
            casemaininfoDto.setClaimcode(dbManager.getString(resultSet,22));
            casemaininfoDto.setDamagedarea(dbManager.getDouble(resultSet,23));
        }
        resultSet.close();
        return casemaininfoDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Comcode,");
        buffer.append("Policyno,");
        buffer.append("Caseno,");
        buffer.append("Claimno,");
        buffer.append("Underwriteenddate,");
        buffer.append("Endcasedate,");
        buffer.append("Asumpaid,");
        buffer.append("Asumfee,");
        buffer.append("Casemoney,");
        buffer.append("Casemoneyfee,");
        buffer.append("Presumpaid,");
        buffer.append("Presumfee,");
        buffer.append("Damageinsured,");
        buffer.append("Lossesnumber,");
        buffer.append("Lossesunitcode,");
        buffer.append("Reopenedtype,");
        buffer.append("Times,");
        buffer.append("Affectedarea,");
        buffer.append("Lossarea,");
        buffer.append("Lawsuitflag,");
        buffer.append("Farmercount,");
        buffer.append("Claimcode,");
        buffer.append("Damagedarea ");
        buffer.append("FROM Casemaininfo WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //Ŀǰֻ��Oracle�Ż�
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
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

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        CasemaininfoDto casemaininfoDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            casemaininfoDto = new CasemaininfoDto();
            casemaininfoDto.setComcode(dbManager.getString(resultSet,1));
            casemaininfoDto.setPolicyno(dbManager.getString(resultSet,2));
            casemaininfoDto.setCaseno(dbManager.getString(resultSet,3));
            casemaininfoDto.setClaimno(dbManager.getString(resultSet,4));
            casemaininfoDto.setUnderwriteenddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            casemaininfoDto.setEndcasedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            casemaininfoDto.setAsumpaid(dbManager.getDouble(resultSet,7));
            casemaininfoDto.setAsumfee(dbManager.getDouble(resultSet,8));
            casemaininfoDto.setCasemoney(dbManager.getDouble(resultSet,9));
            casemaininfoDto.setCasemoneyfee(dbManager.getDouble(resultSet,10));
            casemaininfoDto.setPresumpaid(dbManager.getDouble(resultSet,11));
            casemaininfoDto.setPresumfee(dbManager.getDouble(resultSet,12));
            casemaininfoDto.setDamageinsured(dbManager.getLong(resultSet,13));
            casemaininfoDto.setLossesnumber(dbManager.getDouble(resultSet,14));
            casemaininfoDto.setLossesunitcode(dbManager.getString(resultSet,15));
            casemaininfoDto.setReopenedtype(dbManager.getString(resultSet,16));
            casemaininfoDto.setTimes(dbManager.getInt(resultSet,17));
            casemaininfoDto.setAffectedarea(dbManager.getDouble(resultSet,18));
            casemaininfoDto.setLossarea(dbManager.getDouble(resultSet,19));
            casemaininfoDto.setLawsuitflag(dbManager.getString(resultSet,20));
            casemaininfoDto.setFarmercount(dbManager.getLong(resultSet,21));
            casemaininfoDto.setClaimcode(dbManager.getString(resultSet,22));
            casemaininfoDto.setDamagedarea(dbManager.getDouble(resultSet,23));
            collection.add(casemaininfoDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Casemaininfo WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM (SELECT * FROM Casemaininfo WHERE ");
        buffer.append(conditions);
        buffer.append(")");
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
