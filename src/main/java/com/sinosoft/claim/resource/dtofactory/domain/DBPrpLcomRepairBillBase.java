package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomRepairBillDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplcomrepairbill-����ά�޷�Ʊ������ݷ��ʶ������<br>
 * ������ 2005-05-26 09:04:13.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcomRepairBillBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLcomRepairBillBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    
    public DBPrpLcomRepairBillBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcomRepairBillDto prpLcomRepairBillDto
     * @throws Exception
     */
    public void insert(PrpLcomRepairBillDto prpLcomRepairBillDto) throws Exception{
        String mainStatement = " Insert Into PrpLcomRepairBill (" + 
                           " CompensateNo," + 
                           " ITEMNO," + 
                           " CARKIND," + 
                           " licenseno," + 
                           " frameno," + 
                           " BILLTYPE," + 
                           " BILLNO)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcomRepairBillDto.getCompenSateNo() + "'," + 
                           "'" + prpLcomRepairBillDto.getItemno()  + "'," + 
                           "'" + prpLcomRepairBillDto.getCarkind() + "'," + 
                           "'" + prpLcomRepairBillDto.getLicenseno()+ "'," + 
                           "'" + prpLcomRepairBillDto.getFrameno() + "'," + 
                           "" + prpLcomRepairBillDto.getBillType() + "," + 
            			   "'" + prpLcomRepairBillDto.getBillNo() +"')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcomRepairBillDto.getCompenSateNo());
        dbManager.setLong(2,prpLcomRepairBillDto.getItemno());
        dbManager.setString(3,prpLcomRepairBillDto.getCarkind());
        dbManager.setString(4,prpLcomRepairBillDto.getLicenseno() );
        dbManager.setString(5,prpLcomRepairBillDto.getFrameno() );
        dbManager.setString(6,prpLcomRepairBillDto.getBillType());
        dbManager.setString(7,prpLcomRepairBillDto.getBillNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcomRepairBillBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcomRepairBill (" + 
                               " CompensateNo," + 
                               " ITEMNO," + 
                               " CARKIND," + 
                               " licenseno," + 
                               " frameno," + 
                               " BILLTYPE," + 
        				       " BILLNO )";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        int j= 0;
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	PrpLcomRepairBillDto prpLcomRepairBillDto = (PrpLcomRepairBillDto)i.next();
            dbManager.setString(1,prpLcomRepairBillDto.getCompenSateNo());
            dbManager.setLong(2,prpLcomRepairBillDto.getItemno());
            dbManager.setString(3,prpLcomRepairBillDto.getCarkind());
            dbManager.setString(4,prpLcomRepairBillDto.getLicenseno() );
            dbManager.setString(5,prpLcomRepairBillDto.getFrameno() );
            dbManager.setString(6,prpLcomRepairBillDto.getBillType());
            dbManager.setString(7,prpLcomRepairBillDto.getBillNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcomRepairBillBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param compensateNo �����������
     * @throws Exception
     */
    public void delete(String compensateNo) throws Exception{
        String statement = " Delete From PrpLcomRepairBill" + 
	            		   " Where " +
                           " CompensateNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcomRepairBill Where " +
                           " CompensateNo = '" + compensateNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcomRepairBillBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcomRepairBillDto prpLcomRepairBillDto
     * @throws Exception
     */
    public void update(PrpLcomRepairBillDto prpLcomRepairBillDto) throws Exception{
        String statement = " Update PrpLcomRepairBill Set CARKIND = ?," + 
                           " BILLTYPE = ?," + 
                           " BILLNO = ? " + 
	            		   " Where " +
                           " CompensateNo = ? and ITEMNO= ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcomRepairBill Set " + 
                           " CARKIND = '" + prpLcomRepairBillDto.getCarkind() + "'," + 
                           " BILLTYPE = '" + prpLcomRepairBillDto.getBillType()  + "'," + 
                           " BILLNO = '" + prpLcomRepairBillDto.getBillNo() + "'" + 
			               " Where " +
                           " CompensateNo = '" + prpLcomRepairBillDto.getCompenSateNo() 
                           + "' and ITEMNO="+prpLcomRepairBillDto.getItemno();
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLcomRepairBillDto.getCarkind());
        dbManager.setString(2,prpLcomRepairBillDto.getBillType());
        dbManager.setString(3,prpLcomRepairBillDto.getBillNo());
        dbManager.setString(4,prpLcomRepairBillDto.getCompenSateNo());
        dbManager.setLong(5,prpLcomRepairBillDto.getItemno());
 
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcomRepairBillBase.update() success!");
    }
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select COMPENSATENO," + 
                           " ITEMNO," + 
                           " CARKIND," + 
                           " licenseno," + 
                           " frameno," + 
                           " BILLTYPE," + 
                           " BILLNO" + 
                           " From prplcomrepairbill Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcomRepairBillDto prpLcomRepairBillDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLcomRepairBillDto = new PrpLcomRepairBillDto();
            prpLcomRepairBillDto.setCompenSateNo(dbManager.getString(resultSet,1));
            prpLcomRepairBillDto.setItemno(dbManager.getLong(resultSet, 2));
            prpLcomRepairBillDto.setCarkind(dbManager.getString(resultSet, 3));
            prpLcomRepairBillDto.setLicenseno(dbManager.getString(resultSet, 4));
            prpLcomRepairBillDto.setFrameno(dbManager.getString(resultSet, 5));
            prpLcomRepairBillDto.setBillType(dbManager.getString(resultSet, 6));
            prpLcomRepairBillDto.setBillNo(dbManager.getString(resultSet, 7));
            collection.add(prpLcomRepairBillDto);
        }
        resultSet.close();
        logger.info("DBPrpLcomRepairBillBase.findByConditions() success!");
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpLcomRepairBill Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcomRepairBillBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcomRepairBill Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcomRepairBillBase.getCount() success!");
        return count;
    }
    
   
}


