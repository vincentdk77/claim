package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������վݵ����ݷ��ʶ������<br>
 * ������ 2006-02-25 11:37:06.953<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLIndemnityReceiptBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLIndemnityReceiptBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLIndemnityReceiptBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @throws Exception
     */
    public void insert(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLIndemnityReceipt (");
        buffer.append("BusinessNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("UnitBank,");
        buffer.append("UnitAccount,");
        buffer.append("Account,");
        buffer.append("IdentifyNumber,");
        buffer.append("VisaCode,");
        buffer.append("VisaName,");
        buffer.append("PrintNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getCertiType()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getUnitBank()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getUnitAccount()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getAccount()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getVisaCode()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getVisaName()).append("',");
            debugBuffer.append("'").append(prpLIndemnityReceiptDto.getPrintNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLIndemnityReceiptDto.getBusinessNo());
        dbManager.setString(2,prpLIndemnityReceiptDto.getCertiType());
        dbManager.setString(3,prpLIndemnityReceiptDto.getPolicyNo());
        dbManager.setString(4,prpLIndemnityReceiptDto.getInsuredCode());
        dbManager.setString(5,prpLIndemnityReceiptDto.getInsuredName());
        dbManager.setString(6,prpLIndemnityReceiptDto.getUnitBank());
        dbManager.setString(7,prpLIndemnityReceiptDto.getUnitAccount());
        dbManager.setString(8,prpLIndemnityReceiptDto.getAccount());
        dbManager.setString(9,prpLIndemnityReceiptDto.getIdentifyNumber());
        dbManager.setString(10,prpLIndemnityReceiptDto.getVisaCode());
        dbManager.setString(11,prpLIndemnityReceiptDto.getVisaName());
        dbManager.setString(12,prpLIndemnityReceiptDto.getPrintNo());
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
        buffer.append("INSERT INTO PrpLIndemnityReceipt (");
        buffer.append("BusinessNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("UnitBank,");
        buffer.append("UnitAccount,");
        buffer.append("Account,");
        buffer.append("IdentifyNumber,");
        buffer.append("VisaCode,");
        buffer.append("VisaName,");
        buffer.append("PrintNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = (PrpLIndemnityReceiptDto)i.next();
            dbManager.setString(1,prpLIndemnityReceiptDto.getBusinessNo());
            dbManager.setString(2,prpLIndemnityReceiptDto.getCertiType());
            dbManager.setString(3,prpLIndemnityReceiptDto.getPolicyNo());
            dbManager.setString(4,prpLIndemnityReceiptDto.getInsuredCode());
            dbManager.setString(5,prpLIndemnityReceiptDto.getInsuredName());
            dbManager.setString(6,prpLIndemnityReceiptDto.getUnitBank());
            dbManager.setString(7,prpLIndemnityReceiptDto.getUnitAccount());
            dbManager.setString(8,prpLIndemnityReceiptDto.getAccount());
            dbManager.setString(9,prpLIndemnityReceiptDto.getIdentifyNumber());
            dbManager.setString(10,prpLIndemnityReceiptDto.getVisaCode());
            dbManager.setString(11,prpLIndemnityReceiptDto.getVisaName());
            dbManager.setString(12,prpLIndemnityReceiptDto.getPrintNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param businessNo ҵ���
     * @throws Exception
     */
    public void delete(String businessNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLIndemnityReceipt ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(businessNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLIndemnityReceiptDto prpLIndemnityReceiptDto
     * @throws Exception
     */
    public void update(PrpLIndemnityReceiptDto prpLIndemnityReceiptDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLIndemnityReceipt SET ");
        buffer.append("CertiType = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("InsuredCode = ?, ");
        buffer.append("InsuredName = ?, ");
        buffer.append("UnitBank = ?, ");
        buffer.append("UnitAccount = ?, ");
        buffer.append("Account = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        buffer.append("VisaCode = ?, ");
        buffer.append("VisaName = ?, ");
        buffer.append("PrintNo = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLIndemnityReceipt SET ");
            debugBuffer.append("CertiType = '" + prpLIndemnityReceiptDto.getCertiType() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLIndemnityReceiptDto.getPolicyNo() + "', ");
            debugBuffer.append("InsuredCode = '" + prpLIndemnityReceiptDto.getInsuredCode() + "', ");
            debugBuffer.append("InsuredName = '" + prpLIndemnityReceiptDto.getInsuredName() + "', ");
            debugBuffer.append("UnitBank = '" + prpLIndemnityReceiptDto.getUnitBank() + "', ");
            debugBuffer.append("UnitAccount = '" + prpLIndemnityReceiptDto.getUnitAccount() + "', ");
            debugBuffer.append("Account = '" + prpLIndemnityReceiptDto.getAccount() + "', ");
            debugBuffer.append("IdentifyNumber = '" + prpLIndemnityReceiptDto.getIdentifyNumber() + "', ");
            debugBuffer.append("VisaCode = '" + prpLIndemnityReceiptDto.getVisaCode() + "', ");
            debugBuffer.append("VisaName = '" + prpLIndemnityReceiptDto.getVisaName() + "', ");
            debugBuffer.append("PrintNo = '" + prpLIndemnityReceiptDto.getPrintNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(prpLIndemnityReceiptDto.getBusinessNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLIndemnityReceiptDto.getCertiType());
        dbManager.setString(2,prpLIndemnityReceiptDto.getPolicyNo());
        dbManager.setString(3,prpLIndemnityReceiptDto.getInsuredCode());
        dbManager.setString(4,prpLIndemnityReceiptDto.getInsuredName());
        dbManager.setString(5,prpLIndemnityReceiptDto.getUnitBank());
        dbManager.setString(6,prpLIndemnityReceiptDto.getUnitAccount());
        dbManager.setString(7,prpLIndemnityReceiptDto.getAccount());
        dbManager.setString(8,prpLIndemnityReceiptDto.getIdentifyNumber());
        dbManager.setString(9,prpLIndemnityReceiptDto.getVisaCode());
        dbManager.setString(10,prpLIndemnityReceiptDto.getVisaName());
        dbManager.setString(11,prpLIndemnityReceiptDto.getPrintNo());
        //���������ֶ�;
        dbManager.setString(12,prpLIndemnityReceiptDto.getBusinessNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param businessNo ҵ���
     * @return PrpLIndemnityReceiptDto
     * @throws Exception
     */
    public PrpLIndemnityReceiptDto findByPrimaryKey(String businessNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("BusinessNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("UnitBank,");
        buffer.append("UnitAccount,");
        buffer.append("Account,");
        buffer.append("IdentifyNumber,");
        buffer.append("VisaCode,");
        buffer.append("VisaName,");
        buffer.append("PrintNo ");
        buffer.append("FROM PrpLIndemnityReceipt ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(businessNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = null;
        if(resultSet.next()){
            prpLIndemnityReceiptDto = new PrpLIndemnityReceiptDto();
            prpLIndemnityReceiptDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLIndemnityReceiptDto.setCertiType(dbManager.getString(resultSet,2));
            prpLIndemnityReceiptDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLIndemnityReceiptDto.setInsuredCode(dbManager.getString(resultSet,4));
            prpLIndemnityReceiptDto.setInsuredName(dbManager.getString(resultSet,5));
            prpLIndemnityReceiptDto.setUnitBank(dbManager.getString(resultSet,6));
            prpLIndemnityReceiptDto.setUnitAccount(dbManager.getString(resultSet,7));
            prpLIndemnityReceiptDto.setAccount(dbManager.getString(resultSet,8));
            prpLIndemnityReceiptDto.setIdentifyNumber(dbManager.getString(resultSet,9));
            prpLIndemnityReceiptDto.setVisaCode(dbManager.getString(resultSet,10));
            prpLIndemnityReceiptDto.setVisaName(dbManager.getString(resultSet,11));
            prpLIndemnityReceiptDto.setPrintNo(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return prpLIndemnityReceiptDto;
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
        buffer.append("BusinessNo,");
        buffer.append("CertiType,");
        buffer.append("PolicyNo,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("UnitBank,");
        buffer.append("UnitAccount,");
        buffer.append("Account,");
        buffer.append("IdentifyNumber,");
        buffer.append("VisaCode,");
        buffer.append("VisaName,");
        buffer.append("PrintNo ");
        buffer.append("FROM PrpLIndemnityReceipt WHERE ");
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
        PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLIndemnityReceiptDto = new PrpLIndemnityReceiptDto();
            prpLIndemnityReceiptDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLIndemnityReceiptDto.setCertiType(dbManager.getString(resultSet,2));
            prpLIndemnityReceiptDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLIndemnityReceiptDto.setInsuredCode(dbManager.getString(resultSet,4));
            prpLIndemnityReceiptDto.setInsuredName(dbManager.getString(resultSet,5));
            prpLIndemnityReceiptDto.setUnitBank(dbManager.getString(resultSet,6));
            prpLIndemnityReceiptDto.setUnitAccount(dbManager.getString(resultSet,7));
            prpLIndemnityReceiptDto.setAccount(dbManager.getString(resultSet,8));
            prpLIndemnityReceiptDto.setIdentifyNumber(dbManager.getString(resultSet,9));
            prpLIndemnityReceiptDto.setVisaCode(dbManager.getString(resultSet,10));
            prpLIndemnityReceiptDto.setVisaName(dbManager.getString(resultSet,11));
            prpLIndemnityReceiptDto.setPrintNo(dbManager.getString(resultSet,12));
            collection.add(prpLIndemnityReceiptDto);
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
        buffer.append("DELETE FROM PrpLIndemnityReceipt WHERE ");
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
          statement = "SELECT count(1) FROM PrpLIndemnityReceipt WHERE ";
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
