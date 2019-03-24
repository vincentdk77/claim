package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLacciPerson�����ݷ��ʶ������<br>
 * ������ 2005-06-16 13:55:17.687<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinjuryPersonBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLinjuryPersonBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinjuryPersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLacciPersonDto prpLacciPersonDto
     * @throws Exception
     */
    public void insert(PrpLinjuryPersonDto prpLinjuryPersonDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinjuryperson(");
        buffer.append("CompensateNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinjuryPersonDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLinjuryPersonDto.getAcciName()).append("',");
            debugBuffer.append("'").append(prpLinjuryPersonDto.getSex()).append("',");
            debugBuffer.append("'").append(prpLinjuryPersonDto.getIdentifyNumber()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinjuryPersonDto.getCompensateNo());
        dbManager.setString(2,prpLinjuryPersonDto.getAcciName());
        dbManager.setString(3,prpLinjuryPersonDto.getSex());
        dbManager.setString(4,prpLinjuryPersonDto.getIdentifyNumber());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinjuryperson (");
        buffer.append("CompensateNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	PrpLinjuryPersonDto prpLinjuryPersonDto = (PrpLinjuryPersonDto)i.next();
            dbManager.prepareStatement(buffer.toString());
            dbManager.setString(1,prpLinjuryPersonDto.getCompensateNo());
            dbManager.setString(2,prpLinjuryPersonDto.getAcciName());
            dbManager.setString(3,prpLinjuryPersonDto.getSex());
            dbManager.setString(4,prpLinjuryPersonDto.getIdentifyNumber());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param certiNo CertiNo
     * @param certiType CertiType
     * @param serialNo SerialNo
     * @throws Exception
     */
    public void delete(String CompensateNo) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinjuryperson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(CompensateNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? ");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,CompensateNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLacciPersonDto prpLacciPersonDto
     * @throws Exception
     */
    public void update(PrpLinjuryPersonDto prpLinjuryPersonDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinjuryperson SET ");
        buffer.append("AcciName = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("IdentifyNumber = ?,");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(prpLinjuryPersonDto.getAcciName()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLinjuryPersonDto.getAcciName());
        dbManager.setString(2,prpLinjuryPersonDto.getSex());
        dbManager.setString(3,prpLinjuryPersonDto.getIdentifyNumber());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param certiNo CertiNo
     * @param certiType CertiType
     * @param serialNo SerialNo
     * @return PrpLacciPersonDto
     * @throws Exception
     */
    public PrpLinjuryPersonDto findByPrimaryKey(String CompensateNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append(" FROM PrpLinjuryperson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(CompensateNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,CompensateNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinjuryPersonDto prpLinjuryPersonDto = null;
        if(resultSet.next()){
        	prpLinjuryPersonDto = new PrpLinjuryPersonDto();
        	prpLinjuryPersonDto.setCompensateNo(dbManager.getString(resultSet,1));
        	prpLinjuryPersonDto.setAcciName(dbManager.getString(resultSet,2));
        	prpLinjuryPersonDto.setSex(dbManager.getString(resultSet,3));
        	prpLinjuryPersonDto.setIdentifyNumber(dbManager.getString(resultSet,4));
            
        }else{
            logger.info("DBPrpLinjuryPersonBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLinjuryPersonDto;
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
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append(" CompensateNo,");
        buffer.append(" AcciName,");
        buffer.append(" decode(Sex,'1','��','2','Ů','δ֪') Sex,");
        buffer.append(" IdentifyNumber ");
        buffer.append(" FROM PrpLinjuryperson WHERE ");
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
        PrpLinjuryPersonDto prpLinjuryPersonDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLinjuryPersonDto = new PrpLinjuryPersonDto();
            prpLinjuryPersonDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLinjuryPersonDto.setAcciName(dbManager.getString(resultSet,2));
            prpLinjuryPersonDto.setSex(dbManager.getString(resultSet,3));
            prpLinjuryPersonDto.setIdentifyNumber(dbManager.getString(resultSet,4));
            collection.add(prpLinjuryPersonDto);
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinjuryperson WHERE ");
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
        statement = "SELECT count(1) FROM PrpLinjuryperson WHERE ";
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
    
    /**
     * ����ɾ��
     * @param collection collection
     * @throws Exception
     */
    public void deleteAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinjuryPersonDto prpLinjuryPersonDto = (PrpLinjuryPersonDto)i.next();
            StringBuffer buffer = new StringBuffer(200);
            buffer.append("DELETE FROM PrpLinjuryperson ");
            //���������ֶ�;
            buffer.append("WHERE ");
            buffer.append("CompensateNo = ?");
     
            dbManager.prepareStatement(buffer.toString());
            //���������ֶ�;
            dbManager.setString(1,prpLinjuryPersonDto.getCompensateNo());
            dbManager.setString(2,prpLinjuryPersonDto.getAcciName());
            dbManager.setString(3,prpLinjuryPersonDto.getSex());
            dbManager.setString(4,prpLinjuryPersonDto.getIdentifyNumber());
            dbManager.executePreparedUpdate();

        }
    }
    
}
    
    

