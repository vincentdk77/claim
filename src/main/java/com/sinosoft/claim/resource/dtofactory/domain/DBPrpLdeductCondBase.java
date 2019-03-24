package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLdeductCond-��������������������ݷ��ʶ������<br>
 * ������ 2006-06-07 16:25:07.421<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLdeductCondBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLdeductCondBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLdeductCondBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void insert(PrpLdeductCondDto prpLdeductCondDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLdeductCond (");
        buffer.append("CompensateNo,");
        buffer.append("DeductCondCode,");
        buffer.append("DeductCondName,");
        buffer.append("Times ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLdeductCondDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLdeductCondDto.getDeductCondCode()).append("',");
            debugBuffer.append("'").append(prpLdeductCondDto.getDeductCondName()).append("',");
            debugBuffer.append("").append(prpLdeductCondDto.getTimes()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLdeductCondDto.getCompensateNo());
        dbManager.setString(2,prpLdeductCondDto.getDeductCondCode());
        dbManager.setString(3,prpLdeductCondDto.getDeductCondName());
        dbManager.setInt(4,prpLdeductCondDto.getTimes());
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
        buffer.append("INSERT INTO PrpLdeductCond (");
        buffer.append("CompensateNo,");
        buffer.append("DeductCondCode,");
        buffer.append("DeductCondName,");
        buffer.append("Times ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLdeductCondDto prpLdeductCondDto = (PrpLdeductCondDto)i.next();
            dbManager.setString(1,prpLdeductCondDto.getCompensateNo());
            dbManager.setString(2,prpLdeductCondDto.getDeductCondCode());
            dbManager.setString(3,prpLdeductCondDto.getDeductCondName());
            dbManager.setInt(4,prpLdeductCondDto.getTimes());
            dbManager.addBatch();
            
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param compensateNo �������
     * @param deductCondCode ������������
     * @throws Exception
     */
    public void delete(String compensateNo,String deductCondCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLdeductCond ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("DeductCondCode=").append("'").append(deductCondCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("DeductCondCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,deductCondCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void update(PrpLdeductCondDto prpLdeductCondDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLdeductCond SET ");
        buffer.append("DeductCondName = ?, ");
        buffer.append("Times = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLdeductCond SET ");
            debugBuffer.append("DeductCondName = '" + prpLdeductCondDto.getDeductCondName() + "', ");
            debugBuffer.append("Times = " + prpLdeductCondDto.getTimes() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(prpLdeductCondDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("DeductCondCode=").append("'").append(prpLdeductCondDto.getDeductCondCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("DeductCondCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLdeductCondDto.getDeductCondName());
        dbManager.setInt(2,prpLdeductCondDto.getTimes());
        //���������ֶ�;
        dbManager.setString(3,prpLdeductCondDto.getCompensateNo());
        dbManager.setString(4,prpLdeductCondDto.getDeductCondCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param compensateNo �������
     * @param deductCondCode ������������
     * @return PrpLdeductCondDto
     * @throws Exception
     */
    public PrpLdeductCondDto findByPrimaryKey(String compensateNo,String deductCondCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("DeductCondCode,");
        buffer.append("DeductCondName,");
        buffer.append("Times ");
        buffer.append("FROM PrpLdeductCond ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("DeductCondCode=").append("'").append(deductCondCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("DeductCondCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,deductCondCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLdeductCondDto prpLdeductCondDto = null;
        if(resultSet.next()){
            prpLdeductCondDto = new PrpLdeductCondDto();
            prpLdeductCondDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLdeductCondDto.setDeductCondCode(dbManager.getString(resultSet,2));
            prpLdeductCondDto.setDeductCondName(dbManager.getString(resultSet,3));
            prpLdeductCondDto.setTimes(dbManager.getInt(resultSet,4));
        }
        resultSet.close();
        return prpLdeductCondDto;
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
        buffer.append("CompensateNo,");
        buffer.append("DeductCondCode,");
        buffer.append("DeductCondName,");
        buffer.append("Times ");
        buffer.append("FROM PrpLdeductCond WHERE ");
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
        PrpLdeductCondDto prpLdeductCondDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLdeductCondDto = new PrpLdeductCondDto();
            prpLdeductCondDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLdeductCondDto.setDeductCondCode(dbManager.getString(resultSet,2));
            prpLdeductCondDto.setDeductCondName(dbManager.getString(resultSet,3));
            prpLdeductCondDto.setTimes(dbManager.getInt(resultSet,4));
            collection.add(prpLdeductCondDto);
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
        buffer.append("DELETE FROM PrpLdeductCond WHERE ");
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
        statement = "SELECT count(1) FROM PrpLdeductCond WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append("SELECT count(1) FROM PrpLdeductCond WHERE ");
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
