package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLassureDetailDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLassureDetail-��������ϸ�������������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:36.937<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLassureDetailBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLassureDetailBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLassureDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void insert(PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        String mainStatement = " Insert Into PrpLassureDetail (" + 
                           " AssureNo," + 
                           " SerialNo," + 
                           " PolicyNo," + 
                           " LadingNo," + 
                           " GoodsDetailName," + 
                           " Marks," + 
                           " Count," + 
                           " Currency," + 
                           " Amount)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLassureDetailDto.getAssureNo() + "'," + 
                           "" + prpLassureDetailDto.getSerialNo() + "," + 
                           "'" + prpLassureDetailDto.getPolicyNo() + "'," + 
                           "'" + prpLassureDetailDto.getLadingNo() + "'," + 
                           "'" + prpLassureDetailDto.getGoodsDetailName() + "'," + 
                           "'" + prpLassureDetailDto.getMarks() + "'," + 
                           "'" + prpLassureDetailDto.getCount() + "'," + 
                           "'" + prpLassureDetailDto.getCurrency() + "'," + 
                           "'" + prpLassureDetailDto.getAmount() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLassureDetailDto.getAssureNo());
        dbManager.setInt(2,prpLassureDetailDto.getSerialNo());
        dbManager.setString(3,prpLassureDetailDto.getPolicyNo());
        dbManager.setString(4,prpLassureDetailDto.getLadingNo());
        dbManager.setString(5,prpLassureDetailDto.getGoodsDetailName());
        dbManager.setString(6,prpLassureDetailDto.getMarks());
        dbManager.setString(7,prpLassureDetailDto.getCount());
        dbManager.setString(8,prpLassureDetailDto.getCurrency());
        dbManager.setDouble(9,prpLassureDetailDto.getAmount());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLassureDetailBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLassureDetail (" + 
                           " AssureNo," + 
                           " SerialNo," + 
                           " PolicyNo," + 
                           " LadingNo," + 
                           " GoodsDetailName," + 
                           " Marks," + 
                           " Count," + 
                           " Currency," + 
                           " Amount)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLassureDetailDto prpLassureDetailDto = (PrpLassureDetailDto)i.next();
            dbManager.setString(1,prpLassureDetailDto.getAssureNo());
            dbManager.setInt(2,prpLassureDetailDto.getSerialNo());
            dbManager.setString(3,prpLassureDetailDto.getPolicyNo());
            dbManager.setString(4,prpLassureDetailDto.getLadingNo());
            dbManager.setString(5,prpLassureDetailDto.getGoodsDetailName());
            dbManager.setString(6,prpLassureDetailDto.getMarks());
            dbManager.setString(7,prpLassureDetailDto.getCount());
            dbManager.setString(8,prpLassureDetailDto.getCurrency());
            dbManager.setDouble(9,prpLassureDetailDto.getAmount());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLassureDetailBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param assureNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String assureNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLassureDetail" + 
	            		   " Where " +
                           " AssureNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLassureDetail Where " +
                           " AssureNo = '" + assureNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,assureNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLassureDetailBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void update(PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        String statement = " Update PrpLassureDetail Set PolicyNo = ?," + 
                           " LadingNo = ?," + 
                           " GoodsDetailName = ?," + 
                           " Marks = ?," + 
                           " Count = ?," + 
                           " Currency = ?," + 
                           " Amount = ?" + 
	            		   " Where " +
                           " AssureNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLassureDetail Set " + 
                           " AssureNo = '" + prpLassureDetailDto.getAssureNo() + "'," + 
                           " SerialNo = " + prpLassureDetailDto.getSerialNo() + "," + 
                           " PolicyNo = '" + prpLassureDetailDto.getPolicyNo() + "'," + 
                           " LadingNo = '" + prpLassureDetailDto.getLadingNo() + "'," + 
                           " GoodsDetailName = '" + prpLassureDetailDto.getGoodsDetailName() + "'," + 
                           " Marks = '" + prpLassureDetailDto.getMarks() + "'," + 
                           " Count = '" + prpLassureDetailDto.getCount() + "'," + 
                           " Currency = '" + prpLassureDetailDto.getCurrency() + "'," + 
                           " Amount = '" + prpLassureDetailDto.getAmount() + "'" + 
			               " Where " +
                           " AssureNo = '" + prpLassureDetailDto.getAssureNo() + "' And " + 
                           " SerialNo = " + prpLassureDetailDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLassureDetailDto.getPolicyNo());
        dbManager.setString(2,prpLassureDetailDto.getLadingNo());
        dbManager.setString(3,prpLassureDetailDto.getGoodsDetailName());
        dbManager.setString(4,prpLassureDetailDto.getMarks());
        dbManager.setString(5,prpLassureDetailDto.getCount());
        dbManager.setString(6,prpLassureDetailDto.getCurrency());
        dbManager.setDouble(7,prpLassureDetailDto.getAmount());
        //���������ֶ�;
        dbManager.setString(8,prpLassureDetailDto.getAssureNo());
        dbManager.setInt(9,prpLassureDetailDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLassureDetailBase.update() success!");
    }

    /**
     * ����������һ������
     * @param assureNo ������
     * @param serialNo ���
     * @return PrpLassureDetailDto
     * @throws Exception
     */
    public PrpLassureDetailDto findByPrimaryKey(String assureNo,int serialNo) throws Exception{
        String mainStatement = " Select AssureNo," + 
                           " SerialNo," + 
                           " PolicyNo," + 
                           " LadingNo," + 
                           " GoodsDetailName," + 
                           " Marks," + 
                           " Count," + 
                           " Currency," + 
                           " Amount From PrpLassureDetail";
        String statement = mainStatement + " Where " +
                           " AssureNo = ? And " + 
                           " SerialNo = ?";
        PrpLassureDetailDto prpLassureDetailDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " AssureNo = '" + assureNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,assureNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLassureDetailDto = new PrpLassureDetailDto();
            prpLassureDetailDto.setAssureNo(dbManager.getString(resultSet,1));
            prpLassureDetailDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLassureDetailDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLassureDetailDto.setLadingNo(dbManager.getString(resultSet,4));
            prpLassureDetailDto.setGoodsDetailName(dbManager.getString(resultSet,5));
            prpLassureDetailDto.setMarks(dbManager.getString(resultSet,6));
            prpLassureDetailDto.setCount(dbManager.getString(resultSet,7));
            prpLassureDetailDto.setCurrency(dbManager.getString(resultSet,8));
            prpLassureDetailDto.setAmount(dbManager.getDouble(resultSet,9));
            logger.info("DBPrpLassureDetailBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLassureDetailBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLassureDetailDto;
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
        String statement = "Select AssureNo," + 
                           " SerialNo," + 
                           " PolicyNo," + 
                           " LadingNo," + 
                           " GoodsDetailName," + 
                           " Marks," + 
                           " Count," + 
                           " Currency," + 
                           " Amount From PrpLassureDetail Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLassureDetailDto prpLassureDetailDto = null;
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

            prpLassureDetailDto = new PrpLassureDetailDto();
            prpLassureDetailDto.setAssureNo(dbManager.getString(resultSet,1));
            prpLassureDetailDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLassureDetailDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLassureDetailDto.setLadingNo(dbManager.getString(resultSet,4));
            prpLassureDetailDto.setGoodsDetailName(dbManager.getString(resultSet,5));
            prpLassureDetailDto.setMarks(dbManager.getString(resultSet,6));
            prpLassureDetailDto.setCount(dbManager.getString(resultSet,7));
            prpLassureDetailDto.setCurrency(dbManager.getString(resultSet,8));
            prpLassureDetailDto.setAmount(dbManager.getDouble(resultSet,9));
            collection.add(prpLassureDetailDto);
        }
        resultSet.close();
        logger.info("DBPrpLassureDetailBase.findByConditions() success!");
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
        String statement = "Delete From PrpLassureDetail Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLassureDetailBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLassureDetail Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLassureDetailBase.getCount() success!");
        return count;
    }
}
