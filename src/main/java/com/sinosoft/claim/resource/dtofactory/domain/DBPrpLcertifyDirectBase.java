package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcertifyDirect������ָ�������ݷ��ʶ������<br>
 * ������ 2006-06-20 15:15:26.875<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLcertifyDirectBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLcertifyDirectBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcertifyDirectBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void insert(PrpLcertifyDirectDto prpLcertifyDirectDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLcertifyDirect (");
        buffer.append("RegistNo,");
        buffer.append("SerialNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("LossItemCode,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("ColumnValue,");
        buffer.append("Flag,");
        buffer.append("CompelFlag,");
        buffer.append("BusinessFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getRegistNo()).append("',");
            debugBuffer.append("").append(prpLcertifyDirectDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getLossItemCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getTypeCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getTypeName()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getColumnValue()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getCompelFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getBusinessFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLcertifyDirectDto.getRegistNo());
        dbManager.setInt(2,prpLcertifyDirectDto.getSerialNo());
        dbManager.setString(3,prpLcertifyDirectDto.getRiskCode());
        dbManager.setString(4,prpLcertifyDirectDto.getPolicyNo());
        dbManager.setString(5,prpLcertifyDirectDto.getLossItemCode());
        dbManager.setString(6,prpLcertifyDirectDto.getTypeCode());
        dbManager.setString(7,prpLcertifyDirectDto.getTypeName());
        dbManager.setString(8,prpLcertifyDirectDto.getColumnValue());
        dbManager.setString(9,prpLcertifyDirectDto.getFlag());
        dbManager.setString(10,prpLcertifyDirectDto.getCompelFlag());
        dbManager.setString(11,prpLcertifyDirectDto.getBusinessFlag());
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
        buffer.append("INSERT INTO PrpLcertifyDirect (");
        buffer.append("RegistNo,");
        buffer.append("SerialNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("LossItemCode,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("ColumnValue,");
        buffer.append("Flag,");
        buffer.append("CompelFlag,");
        buffer.append("BusinessFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcertifyDirectDto prpLcertifyDirectDto = (PrpLcertifyDirectDto)i.next();
            dbManager.setString(1,prpLcertifyDirectDto.getRegistNo());
            dbManager.setInt(2,prpLcertifyDirectDto.getSerialNo());
            dbManager.setString(3,prpLcertifyDirectDto.getRiskCode());
            dbManager.setString(4,prpLcertifyDirectDto.getPolicyNo());
            dbManager.setString(5,prpLcertifyDirectDto.getLossItemCode());
            dbManager.setString(6,prpLcertifyDirectDto.getTypeCode());
            dbManager.setString(7,prpLcertifyDirectDto.getTypeName());
            dbManager.setString(8,prpLcertifyDirectDto.getColumnValue());
            dbManager.setString(9,prpLcertifyDirectDto.getFlag());
            dbManager.setString(10,prpLcertifyDirectDto.getCompelFlag());
            dbManager.setString(11,prpLcertifyDirectDto.getBusinessFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param registNo ��������
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLcertifyDirect ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void update(PrpLcertifyDirectDto prpLcertifyDirectDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLcertifyDirect SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("TypeCode = ?, ");
        buffer.append("TypeName = ?, ");
        buffer.append("ColumnValue = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("CompelFlag = ?, ");
        buffer.append("BusinessFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLcertifyDirect SET ");
            debugBuffer.append("RiskCode = '" + prpLcertifyDirectDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLcertifyDirectDto.getPolicyNo() + "', ");
            debugBuffer.append("TypeCode = '" + prpLcertifyDirectDto.getTypeCode() + "', ");
            debugBuffer.append("TypeName = '" + prpLcertifyDirectDto.getTypeName() + "', ");
            debugBuffer.append("ColumnValue = '" + prpLcertifyDirectDto.getColumnValue() + "', ");
            debugBuffer.append("Flag = '" + prpLcertifyDirectDto.getFlag() + "', ");
            debugBuffer.append("CompelFlag = '" + prpLcertifyDirectDto.getCompelFlag() + "', ");
            debugBuffer.append("BusinessFlag = '" + prpLcertifyDirectDto.getBusinessFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(prpLcertifyDirectDto.getRegistNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLcertifyDirectDto.getSerialNo()).append(" AND ");
            debugBuffer.append("LossItemCode=").append("'").append(prpLcertifyDirectDto.getLossItemCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLcertifyDirectDto.getRiskCode());
        dbManager.setString(2,prpLcertifyDirectDto.getPolicyNo());
        dbManager.setString(3,prpLcertifyDirectDto.getTypeCode());
        dbManager.setString(4,prpLcertifyDirectDto.getTypeName());
        dbManager.setString(5,prpLcertifyDirectDto.getColumnValue());
        dbManager.setString(6,prpLcertifyDirectDto.getFlag());
        dbManager.setString(7,prpLcertifyDirectDto.getCompelFlag());
        dbManager.setString(8,prpLcertifyDirectDto.getBusinessFlag());
        //���������ֶ�;
        dbManager.setString(9,prpLcertifyDirectDto.getRegistNo());
        dbManager.setInt(10,prpLcertifyDirectDto.getSerialNo());
        dbManager.setString(11,prpLcertifyDirectDto.getLossItemCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param registNo ��������
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @return PrpLcertifyDirectDto
     * @throws Exception
     */
    public PrpLcertifyDirectDto findByPrimaryKey(String registNo,int serialNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("SerialNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("LossItemCode,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("ColumnValue,");
        buffer.append("Flag,");
        buffer.append("CompelFlag,");
        buffer.append("BusinessFlag ");
        buffer.append("FROM PrpLcertifyDirect ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLcertifyDirectDto prpLcertifyDirectDto = null;
        if(resultSet.next()){
            prpLcertifyDirectDto = new PrpLcertifyDirectDto();
            prpLcertifyDirectDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcertifyDirectDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLcertifyDirectDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcertifyDirectDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcertifyDirectDto.setLossItemCode(dbManager.getString(resultSet,5));
            prpLcertifyDirectDto.setTypeCode(dbManager.getString(resultSet,6));
            prpLcertifyDirectDto.setTypeName(dbManager.getString(resultSet,7));
            prpLcertifyDirectDto.setColumnValue(dbManager.getString(resultSet,8));
            prpLcertifyDirectDto.setFlag(dbManager.getString(resultSet,9));
            prpLcertifyDirectDto.setCompelFlag(dbManager.getString(resultSet,10));
            prpLcertifyDirectDto.setBusinessFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prpLcertifyDirectDto;
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
        buffer.append("RegistNo,");
        buffer.append("SerialNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("LossItemCode,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("ColumnValue,");
        buffer.append("Flag,");
        buffer.append("CompelFlag,");
        buffer.append("BusinessFlag ");
        buffer.append("FROM PrpLcertifyDirect WHERE ");
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
        PrpLcertifyDirectDto prpLcertifyDirectDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLcertifyDirectDto = new PrpLcertifyDirectDto();
            prpLcertifyDirectDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcertifyDirectDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLcertifyDirectDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcertifyDirectDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcertifyDirectDto.setLossItemCode(dbManager.getString(resultSet,5));
            prpLcertifyDirectDto.setTypeCode(dbManager.getString(resultSet,6));
            prpLcertifyDirectDto.setTypeName(dbManager.getString(resultSet,7));
            prpLcertifyDirectDto.setColumnValue(dbManager.getString(resultSet,8));
            prpLcertifyDirectDto.setFlag(dbManager.getString(resultSet,9));
            prpLcertifyDirectDto.setCompelFlag(dbManager.getString(resultSet,10));
            prpLcertifyDirectDto.setBusinessFlag(dbManager.getString(resultSet,11));
            collection.add(prpLcertifyDirectDto);
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
        buffer.append("DELETE FROM PrpLcertifyDirect WHERE ");
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
          statement = "SELECT count(1) FROM PrpLcertifyDirect WHERE ";
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
