package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDaccidentDeductDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDaccidentDeduct-�¹����������ʵ����ݷ��ʶ������<br>
 * ������ 2006-06-05 19:44:13.609<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDaccidentDeductBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpDaccidentDeductBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDaccidentDeductBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void insert(PrpDaccidentDeductDto prpDaccidentDeductDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpDaccidentDeduct (");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("IndemnityDuty,");
        buffer.append("DangerLevel,");
        buffer.append("DeductibleRate,");
        buffer.append("ValidStatus,");
        buffer.append("ValidDate,");
        buffer.append("DeductPeriod ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpDaccidentDeductDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpDaccidentDeductDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpDaccidentDeductDto.getIndemnityDuty()).append("',");
            debugBuffer.append("'").append(prpDaccidentDeductDto.getDangerLevel()).append("',");
            debugBuffer.append("").append(prpDaccidentDeductDto.getDeductibleRate()).append(",");
            debugBuffer.append("'").append(prpDaccidentDeductDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(prpDaccidentDeductDto.getValidDate()).append("',");
            debugBuffer.append("'").append(prpDaccidentDeductDto.getDeductPeriod()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpDaccidentDeductDto.getRiskCode());
        dbManager.setString(2,prpDaccidentDeductDto.getKindCode());
        dbManager.setString(3,prpDaccidentDeductDto.getIndemnityDuty());
        dbManager.setString(4,prpDaccidentDeductDto.getDangerLevel());
        dbManager.setDouble(5,prpDaccidentDeductDto.getDeductibleRate());
        dbManager.setString(6,prpDaccidentDeductDto.getValidStatus());
        dbManager.setDateTime(7,prpDaccidentDeductDto.getValidDate());
        dbManager.setString(8,prpDaccidentDeductDto.getDeductPeriod());
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
        buffer.append("INSERT INTO PrpDaccidentDeduct (");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("IndemnityDuty,");
        buffer.append("DangerLevel,");
        buffer.append("DeductibleRate,");
        buffer.append("ValidStatus,");
        buffer.append("ValidDate,");
        buffer.append("DeductPeriod ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpDaccidentDeductDto prpDaccidentDeductDto = (PrpDaccidentDeductDto)i.next();
            dbManager.setString(1,prpDaccidentDeductDto.getRiskCode());
            dbManager.setString(2,prpDaccidentDeductDto.getKindCode());
            dbManager.setString(3,prpDaccidentDeductDto.getIndemnityDuty());
            dbManager.setString(4,prpDaccidentDeductDto.getDangerLevel());
            dbManager.setDouble(5,prpDaccidentDeductDto.getDeductibleRate());
            dbManager.setString(6,prpDaccidentDeductDto.getValidStatus());
            dbManager.setDateTime(7,prpDaccidentDeductDto.getValidDate());
            dbManager.setString(8,prpDaccidentDeductDto.getDeductPeriod());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param indemnityDuty �⳥���δ���
     * @param dangerLevel ����ˮƽ
     * @param deductPeriod ����
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpDaccidentDeduct ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RiskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(kindCode).append("' AND ");
            debugBuffer.append("IndemnityDuty=").append("'").append(indemnityDuty).append("' AND ");
            debugBuffer.append("DangerLevel=").append("'").append(dangerLevel).append("' AND ");
            debugBuffer.append("DeductPeriod=").append("'").append(deductPeriod).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RiskCode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("IndemnityDuty = ? And ");
        buffer.append("DangerLevel = ? And ");
        buffer.append("DeductPeriod = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        dbManager.setString(3,indemnityDuty);
        dbManager.setString(4,dangerLevel);
        dbManager.setString(5,deductPeriod);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @throws Exception
     */
    public void update(PrpDaccidentDeductDto prpDaccidentDeductDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpDaccidentDeduct SET ");
        buffer.append("DeductibleRate = ?, ");
        buffer.append("ValidStatus = ?, ");
        buffer.append("ValidDate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpDaccidentDeduct SET ");
            debugBuffer.append("DeductibleRate = " + prpDaccidentDeductDto.getDeductibleRate() + ", ");
            debugBuffer.append("ValidStatus = '" + prpDaccidentDeductDto.getValidStatus() + "', ");
            debugBuffer.append("ValidDate = '" + prpDaccidentDeductDto.getValidDate() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RiskCode=").append("'").append(prpDaccidentDeductDto.getRiskCode()).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(prpDaccidentDeductDto.getKindCode()).append("' AND ");
            debugBuffer.append("IndemnityDuty=").append("'").append(prpDaccidentDeductDto.getIndemnityDuty()).append("' AND ");
            debugBuffer.append("DangerLevel=").append("'").append(prpDaccidentDeductDto.getDangerLevel()).append("' AND ");
            debugBuffer.append("DeductPeriod=").append("'").append(prpDaccidentDeductDto.getDeductPeriod()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RiskCode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("IndemnityDuty = ? And ");
        buffer.append("DangerLevel = ? And ");
        buffer.append("DeductPeriod = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setDouble(1,prpDaccidentDeductDto.getDeductibleRate());
        dbManager.setString(2,prpDaccidentDeductDto.getValidStatus());
        dbManager.setDateTime(3,prpDaccidentDeductDto.getValidDate());
        //���������ֶ�;
        dbManager.setString(4,prpDaccidentDeductDto.getRiskCode());
        dbManager.setString(5,prpDaccidentDeductDto.getKindCode());
        dbManager.setString(6,prpDaccidentDeductDto.getIndemnityDuty());
        dbManager.setString(7,prpDaccidentDeductDto.getDangerLevel());
        dbManager.setString(8,prpDaccidentDeductDto.getDeductPeriod());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param indemnityDuty �⳥���δ���
     * @param dangerLevel ����ˮƽ
     * @param deductPeriod ����
     * @return PrpDaccidentDeductDto
     * @throws Exception
     */
    public PrpDaccidentDeductDto findByPrimaryKey(String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("IndemnityDuty,");
        buffer.append("DangerLevel,");
        buffer.append("DeductibleRate,");
        buffer.append("ValidStatus,");
        buffer.append("ValidDate,");
        buffer.append("DeductPeriod ");
        buffer.append("FROM PrpDaccidentDeduct ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RiskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(kindCode).append("' AND ");
            debugBuffer.append("IndemnityDuty=").append("'").append(indemnityDuty).append("' AND ");
            debugBuffer.append("DangerLevel=").append("'").append(dangerLevel).append("' AND ");
            debugBuffer.append("DeductPeriod=").append("'").append(deductPeriod).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RiskCode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("IndemnityDuty = ? And ");
        buffer.append("DangerLevel = ? And ");
        buffer.append("DeductPeriod = ?");
        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        dbManager.setString(3,indemnityDuty);
        dbManager.setString(4,dangerLevel);
        dbManager.setString(5,deductPeriod);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpDaccidentDeductDto prpDaccidentDeductDto = null;
        
        if(resultSet.next()){
            prpDaccidentDeductDto = new PrpDaccidentDeductDto();
            prpDaccidentDeductDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDaccidentDeductDto.setKindCode(dbManager.getString(resultSet,2));
            prpDaccidentDeductDto.setIndemnityDuty(dbManager.getString(resultSet,3));
            prpDaccidentDeductDto.setDangerLevel(dbManager.getString(resultSet,4));
            prpDaccidentDeductDto.setDeductibleRate(dbManager.getDouble(resultSet,5));
            prpDaccidentDeductDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDaccidentDeductDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpDaccidentDeductDto.setDeductPeriod(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        return prpDaccidentDeductDto;
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
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("IndemnityDuty,");
        buffer.append("DangerLevel,");
        buffer.append("DeductibleRate,");
        buffer.append("ValidStatus,");
        buffer.append("ValidDate,");
        buffer.append("DeductPeriod ");
        buffer.append("FROM PrpDaccidentDeduct WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrpDaccidentDeductDto prpDaccidentDeductDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpDaccidentDeductDto = new PrpDaccidentDeductDto();
            prpDaccidentDeductDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDaccidentDeductDto.setKindCode(dbManager.getString(resultSet,2));
            prpDaccidentDeductDto.setIndemnityDuty(dbManager.getString(resultSet,3));
            prpDaccidentDeductDto.setDangerLevel(dbManager.getString(resultSet,4));
            prpDaccidentDeductDto.setDeductibleRate(dbManager.getDouble(resultSet,5));
            prpDaccidentDeductDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDaccidentDeductDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpDaccidentDeductDto.setDeductPeriod(dbManager.getString(resultSet,8));
            collection.add(prpDaccidentDeductDto);
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
        buffer.append("DELETE FROM PrpDaccidentDeduct WHERE ");
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
        String statement ;
         statement = "SELECT count(1) FROM PrpDaccidentDeduct WHERE ";
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
