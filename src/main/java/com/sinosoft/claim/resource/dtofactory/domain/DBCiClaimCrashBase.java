package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimCrash ���������¼�����ݷ��ʶ������<br>
 * ������ 2007-01-24 19:47:39.812<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimCrashBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCiClaimCrashBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCiClaimCrashBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public void insert(CiClaimCrashDto ciClaimCrashDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CiClaimCrash (");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("ClaimCompany,");
        buffer.append("DamageDate,");
        buffer.append("ReportDate,");
        buffer.append("ClaimDate,");
        buffer.append("EndCaseDate,");
        buffer.append("SumClaim,");
        buffer.append("SumPaid,");
        buffer.append("ClaimStatus,");
        buffer.append("AccidentNo,");
        buffer.append("ActorFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(ciClaimCrashDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(ciClaimCrashDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(ciClaimCrashDto.getClaimCompany()).append("',");
            debugBuffer.append("'").append(ciClaimCrashDto.getDamageDate()).append("',");
            debugBuffer.append("'").append(ciClaimCrashDto.getReportDate()).append("',");
            debugBuffer.append("'").append(ciClaimCrashDto.getClaimDate()).append("',");
            debugBuffer.append("'").append(ciClaimCrashDto.getEndCaseDate()).append("',");
            debugBuffer.append("").append(ciClaimCrashDto.getSumClaim()).append(",");
            debugBuffer.append("").append(ciClaimCrashDto.getSumPaid()).append(",");
            debugBuffer.append("'").append(ciClaimCrashDto.getClaimStatus()).append("',");
            debugBuffer.append("'").append(ciClaimCrashDto.getAccidentNo()).append("',");
            debugBuffer.append("'").append(ciClaimCrashDto.getActorFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,ciClaimCrashDto.getPolicyNo());
        dbManager.setInt(2,ciClaimCrashDto.getSerialNo());
        dbManager.setString(3,ciClaimCrashDto.getClaimCompany());
        dbManager.setDateTime(4,ciClaimCrashDto.getDamageDate());
        dbManager.setDateTime(5,ciClaimCrashDto.getReportDate());
        dbManager.setDateTime(6,ciClaimCrashDto.getClaimDate());
        dbManager.setDateTime(7,ciClaimCrashDto.getEndCaseDate());
        dbManager.setDouble(8,ciClaimCrashDto.getSumClaim());
        dbManager.setDouble(9,ciClaimCrashDto.getSumPaid());
        dbManager.setString(10,ciClaimCrashDto.getClaimStatus());
        dbManager.setString(11,ciClaimCrashDto.getAccidentNo());
        dbManager.setString(12,ciClaimCrashDto.getActorFlag());
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
        buffer.append("INSERT INTO CiClaimCrash (");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("ClaimCompany,");
        buffer.append("DamageDate,");
        buffer.append("ReportDate,");
        buffer.append("ClaimDate,");
        buffer.append("EndCaseDate,");
        buffer.append("SumClaim,");
        buffer.append("SumPaid,");
        buffer.append("ClaimStatus,");
        buffer.append("AccidentNo,");
        buffer.append("ActorFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CiClaimCrashDto ciClaimCrashDto = (CiClaimCrashDto)i.next();
            dbManager.setString(1,ciClaimCrashDto.getPolicyNo());
            dbManager.setInt(2,ciClaimCrashDto.getSerialNo());
            dbManager.setString(3,ciClaimCrashDto.getClaimCompany());
            dbManager.setDateTime(4,ciClaimCrashDto.getDamageDate());
            dbManager.setDateTime(5,ciClaimCrashDto.getReportDate());
            dbManager.setDateTime(6,ciClaimCrashDto.getClaimDate());
            dbManager.setDateTime(7,ciClaimCrashDto.getEndCaseDate());
            dbManager.setDouble(8,ciClaimCrashDto.getSumClaim());
            dbManager.setDouble(9,ciClaimCrashDto.getSumPaid());
            dbManager.setString(10,ciClaimCrashDto.getClaimStatus());
            dbManager.setString(11,ciClaimCrashDto.getAccidentNo());
            dbManager.setString(12,ciClaimCrashDto.getActorFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CiClaimCrash ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public void update(CiClaimCrashDto ciClaimCrashDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CiClaimCrash SET ");
        buffer.append("ClaimCompany = ?, ");
        buffer.append("DamageDate = ?, ");
        buffer.append("ReportDate = ?, ");
        buffer.append("ClaimDate = ?, ");
        buffer.append("EndCaseDate = ?, ");
        buffer.append("SumClaim = ?, ");
        buffer.append("SumPaid = ?, ");
        buffer.append("ClaimStatus = ?, ");
        buffer.append("AccidentNo = ?, ");
        buffer.append("ActorFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CiClaimCrash SET ");
            debugBuffer.append("ClaimCompany = '" + ciClaimCrashDto.getClaimCompany() + "', ");
            debugBuffer.append("DamageDate = '" + ciClaimCrashDto.getDamageDate() + "', ");
            debugBuffer.append("ReportDate = '" + ciClaimCrashDto.getReportDate() + "', ");
            debugBuffer.append("ClaimDate = '" + ciClaimCrashDto.getClaimDate() + "', ");
            debugBuffer.append("EndCaseDate = '" + ciClaimCrashDto.getEndCaseDate() + "', ");
            debugBuffer.append("SumClaim = " + ciClaimCrashDto.getSumClaim() + ", ");
            debugBuffer.append("SumPaid = " + ciClaimCrashDto.getSumPaid() + ", ");
            debugBuffer.append("ClaimStatus = '" + ciClaimCrashDto.getClaimStatus() + "', ");
            debugBuffer.append("AccidentNo = '" + ciClaimCrashDto.getAccidentNo() + "', ");
            debugBuffer.append("ActorFlag = '" + ciClaimCrashDto.getActorFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(ciClaimCrashDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(ciClaimCrashDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,ciClaimCrashDto.getClaimCompany());
        dbManager.setDateTime(2,ciClaimCrashDto.getDamageDate());
        dbManager.setDateTime(3,ciClaimCrashDto.getReportDate());
        dbManager.setDateTime(4,ciClaimCrashDto.getClaimDate());
        dbManager.setDateTime(5,ciClaimCrashDto.getEndCaseDate());
        dbManager.setDouble(6,ciClaimCrashDto.getSumClaim());
        dbManager.setDouble(7,ciClaimCrashDto.getSumPaid());
        dbManager.setString(8,ciClaimCrashDto.getClaimStatus());
        dbManager.setString(9,ciClaimCrashDto.getAccidentNo());
        dbManager.setString(10,ciClaimCrashDto.getActorFlag());
        //���������ֶ�;
        dbManager.setString(11,ciClaimCrashDto.getPolicyNo());
        dbManager.setInt(12,ciClaimCrashDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param policyNo ������
     * @param serialNo ���
     * @return CiClaimCrashDto
     * @throws Exception
     */
    public CiClaimCrashDto findByPrimaryKey(String policyNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("ClaimCompany,");
        buffer.append("DamageDate,");
        buffer.append("ReportDate,");
        buffer.append("ClaimDate,");
        buffer.append("EndCaseDate,");
        buffer.append("SumClaim,");
        buffer.append("SumPaid,");
        buffer.append("ClaimStatus,");
        buffer.append("AccidentNo,");
        buffer.append("ActorFlag ");
        buffer.append("FROM CiClaimCrash ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CiClaimCrashDto ciClaimCrashDto = null;
        if(resultSet.next()){
            ciClaimCrashDto = new CiClaimCrashDto();
            ciClaimCrashDto.setPolicyNo(dbManager.getString(resultSet,1));
            ciClaimCrashDto.setSerialNo(dbManager.getInt(resultSet,2));
            ciClaimCrashDto.setClaimCompany(dbManager.getString(resultSet,3));
            ciClaimCrashDto.setDamageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            ciClaimCrashDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            ciClaimCrashDto.setClaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            ciClaimCrashDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            ciClaimCrashDto.setSumClaim(dbManager.getDouble(resultSet,8));
            ciClaimCrashDto.setSumPaid(dbManager.getDouble(resultSet,9));
            ciClaimCrashDto.setClaimStatus(dbManager.getString(resultSet,10));
            ciClaimCrashDto.setAccidentNo(dbManager.getString(resultSet,11));
            ciClaimCrashDto.setActorFlag(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return ciClaimCrashDto;
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
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("ClaimCompany,");
        buffer.append("DamageDate,");
        buffer.append("ReportDate,");
        buffer.append("ClaimDate,");
        buffer.append("EndCaseDate,");
        buffer.append("SumClaim,");
        buffer.append("SumPaid,");
        buffer.append("ClaimStatus,");
        buffer.append("AccidentNo,");
        buffer.append("ActorFlag ");
        buffer.append("FROM CiClaimCrash WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //Ŀǰֻ��Oracle�Ż�
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") T WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
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
        CiClaimCrashDto ciClaimCrashDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            ciClaimCrashDto = new CiClaimCrashDto();
            ciClaimCrashDto.setPolicyNo(dbManager.getString(resultSet,1));
            ciClaimCrashDto.setSerialNo(dbManager.getInt(resultSet,2));
            ciClaimCrashDto.setClaimCompany(dbManager.getString(resultSet,3));
            ciClaimCrashDto.setDamageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            ciClaimCrashDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            ciClaimCrashDto.setClaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            ciClaimCrashDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            ciClaimCrashDto.setSumClaim(dbManager.getDouble(resultSet,8));
            ciClaimCrashDto.setSumPaid(dbManager.getDouble(resultSet,9));
            ciClaimCrashDto.setClaimStatus(dbManager.getString(resultSet,10));
            ciClaimCrashDto.setAccidentNo(dbManager.getString(resultSet,11));
            ciClaimCrashDto.setActorFlag(dbManager.getString(resultSet,12));
            collection.add(ciClaimCrashDto);
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
        buffer.append("DELETE FROM CiClaimCrash WHERE ");
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
        String statement;
        statement="SELECT count(*) FROM (SELECT * FROM CiClaimCrash WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        buffer.append(") T ");
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
