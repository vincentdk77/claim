package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDpersonFeeCodeRisk-���˷������ֶ��ձ�����ݷ��ʶ������<br>
 * ������ 2006-06-20 15:51:34.468<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDpersonFeeCodeRiskBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpDpersonFeeCodeRiskBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDpersonFeeCodeRiskBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void insert(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpDpersonFeeCodeRisk (");
        buffer.append("riskCode,");
        buffer.append("feeCode,");
        buffer.append("feeCategory,");
        buffer.append("priority,");
        buffer.append("validStatus,");
        buffer.append("validDate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpDpersonFeeCodeRiskDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpDpersonFeeCodeRiskDto.getFeeCode()).append("',");
            debugBuffer.append("'").append(prpDpersonFeeCodeRiskDto.getFeeCategory()).append("',");
            debugBuffer.append("").append(prpDpersonFeeCodeRiskDto.getPriority()).append(",");
            debugBuffer.append("").append(prpDpersonFeeCodeRiskDto.getValidStatus()).append(",");
            debugBuffer.append("'").append(prpDpersonFeeCodeRiskDto.getValidDate()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpDpersonFeeCodeRiskDto.getRiskCode());
        dbManager.setString(2,prpDpersonFeeCodeRiskDto.getFeeCode());
        dbManager.setString(3,prpDpersonFeeCodeRiskDto.getFeeCategory());
        dbManager.setInt(4,prpDpersonFeeCodeRiskDto.getPriority());
        dbManager.setInt(5,prpDpersonFeeCodeRiskDto.getValidStatus());
        dbManager.setDateTime(6,prpDpersonFeeCodeRiskDto.getValidDate());
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
        buffer.append("INSERT INTO PrpDpersonFeeCodeRisk (");
        buffer.append("riskCode,");
        buffer.append("feeCode,");
        buffer.append("feeCategory,");
        buffer.append("priority,");
        buffer.append("validStatus,");
        buffer.append("validDate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = (PrpDpersonFeeCodeRiskDto)i.next();
            dbManager.setString(1,prpDpersonFeeCodeRiskDto.getRiskCode());
            dbManager.setString(2,prpDpersonFeeCodeRiskDto.getFeeCode());
            dbManager.setString(3,prpDpersonFeeCodeRiskDto.getFeeCategory());
            dbManager.setInt(4,prpDpersonFeeCodeRiskDto.getPriority());
            dbManager.setInt(5,prpDpersonFeeCodeRiskDto.getValidStatus());
            dbManager.setDateTime(6,prpDpersonFeeCodeRiskDto.getValidDate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ���ִ���
     * @param feeCode ���ô���
     * @throws Exception
     */
    public void delete(String riskCode,String feeCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpDpersonFeeCodeRisk ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("feeCode=").append("'").append(feeCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("feeCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,feeCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public void update(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpDpersonFeeCodeRisk SET ");
        buffer.append("feeCategory = ?, ");
        buffer.append("priority = ?, ");
        buffer.append("validStatus = ?, ");
        buffer.append("validDate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpDpersonFeeCodeRisk SET ");
            debugBuffer.append("feeCategory = '" + prpDpersonFeeCodeRiskDto.getFeeCategory() + "', ");
            debugBuffer.append("priority = " + prpDpersonFeeCodeRiskDto.getPriority() + ", ");
            debugBuffer.append("validStatus = " + prpDpersonFeeCodeRiskDto.getValidStatus() + ", ");
            debugBuffer.append("validDate = '" + prpDpersonFeeCodeRiskDto.getValidDate() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(prpDpersonFeeCodeRiskDto.getRiskCode()).append("' AND ");
            debugBuffer.append("feeCode=").append("'").append(prpDpersonFeeCodeRiskDto.getFeeCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("feeCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpDpersonFeeCodeRiskDto.getFeeCategory());
        dbManager.setInt(2,prpDpersonFeeCodeRiskDto.getPriority());
        dbManager.setInt(3,prpDpersonFeeCodeRiskDto.getValidStatus());
        dbManager.setDateTime(4,prpDpersonFeeCodeRiskDto.getValidDate());
        //���������ֶ�;
        dbManager.setString(5,prpDpersonFeeCodeRiskDto.getRiskCode());
        dbManager.setString(6,prpDpersonFeeCodeRiskDto.getFeeCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param riskCode ���ִ���
     * @param feeCode ���ô���
     * @return PrpDpersonFeeCodeRiskDto
     * @throws Exception
     */
    public PrpDpersonFeeCodeRiskDto findByPrimaryKey(String riskCode,String feeCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("riskCode,");
        buffer.append("feeCode,");
        buffer.append("feeCategory,");
        buffer.append("priority,");
        buffer.append("validStatus,");
        buffer.append("validDate ");
        buffer.append("FROM PrpDpersonFeeCodeRisk ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("feeCode=").append("'").append(feeCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("feeCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,feeCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = null;
        if(resultSet.next()){
            prpDpersonFeeCodeRiskDto = new PrpDpersonFeeCodeRiskDto();
            prpDpersonFeeCodeRiskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDpersonFeeCodeRiskDto.setFeeCode(dbManager.getString(resultSet,2));
            prpDpersonFeeCodeRiskDto.setFeeCategory(dbManager.getString(resultSet,3));
            prpDpersonFeeCodeRiskDto.setPriority(dbManager.getInt(resultSet,4));
            prpDpersonFeeCodeRiskDto.setValidStatus(dbManager.getInt(resultSet,5));
            prpDpersonFeeCodeRiskDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
        }
        resultSet.close();
        return prpDpersonFeeCodeRiskDto;
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
        buffer.append("riskCode,");
        buffer.append("feeCode,");
        buffer.append("feeCategory,");
        buffer.append("priority,");
        buffer.append("validStatus,");
        buffer.append("validDate ");
        buffer.append("FROM PrpDpersonFeeCodeRisk WHERE ");
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
        PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpDpersonFeeCodeRiskDto = new PrpDpersonFeeCodeRiskDto();
            prpDpersonFeeCodeRiskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDpersonFeeCodeRiskDto.setFeeCode(dbManager.getString(resultSet,2));
            prpDpersonFeeCodeRiskDto.setFeeCategory(dbManager.getString(resultSet,3));
            prpDpersonFeeCodeRiskDto.setPriority(dbManager.getInt(resultSet,4));
            prpDpersonFeeCodeRiskDto.setValidStatus(dbManager.getInt(resultSet,5));
            prpDpersonFeeCodeRiskDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            collection.add(prpDpersonFeeCodeRiskDto);
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
        buffer.append("DELETE FROM PrpDpersonFeeCodeRisk WHERE ");
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
        String  statement ;
            statement ="SELECT count(1) FROM PrpDpersonFeeCodeRisk WHERE ";
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
