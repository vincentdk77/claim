package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLctext-���������ֱ�����ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.171<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLctextBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLctextBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLctextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLctextDto prpLctextDto
     * @throws Exception
     */
    public void insert(PrpLctextDto prpLctextDto) throws Exception{
        String mainStatement = " Insert Into PrpLctext (" + 
                           " CompensateNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLctextDto.getCompensateNo() + "'," + 
                           "'" + prpLctextDto.getTextType() + "'," + 
                           "" + prpLctextDto.getLineNo() + "," + 
                           "'" + prpLctextDto.getContext() + "'," + 
                           "'" + prpLctextDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLctextDto.getCompensateNo());
        dbManager.setString(2,prpLctextDto.getTextType());
        dbManager.setInt(3,prpLctextDto.getLineNo());
        dbManager.setString(4,prpLctextDto.getContext());
        dbManager.setString(5,prpLctextDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLctextBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLctext (" + 
                           " CompensateNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLctextDto prpLctextDto = (PrpLctextDto)i.next();
            dbManager.setString(1,prpLctextDto.getCompensateNo());
            dbManager.setString(2,prpLctextDto.getTextType());
            dbManager.setInt(3,prpLctextDto.getLineNo());
            dbManager.setString(4,prpLctextDto.getContext());
            dbManager.setString(5,prpLctextDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLctextBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param compensateNo ���������
     * @param textType ����˵������ ��
--** ������/��ע/��
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(String compensateNo,String textType,int lineNo) throws Exception{
        String statement = " Delete From PrpLctext" + 
	            		   " Where " +
                           " CompensateNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLctext Where " +
                           " CompensateNo = '" + compensateNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,textType);
        dbManager.setInt(3,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLctextBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLctextDto prpLctextDto
     * @throws Exception
     */
    public void update(PrpLctextDto prpLctextDto) throws Exception{
        String statement = " Update PrpLctext Set Context = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " CompensateNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLctext Set " + 
                           " CompensateNo = '" + prpLctextDto.getCompensateNo() + "'," + 
                           " TextType = '" + prpLctextDto.getTextType() + "'," + 
                           " LineNo = " + prpLctextDto.getLineNo() + "," + 
                           " Context = '" + prpLctextDto.getContext() + "'," + 
                           " Flag = '" + prpLctextDto.getFlag() + "'" + 
			               " Where " +
                           " CompensateNo = '" + prpLctextDto.getCompensateNo() + "' And " + 
                           " TextType = '" + prpLctextDto.getTextType() + "' And " + 
                           " LineNo = " + prpLctextDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLctextDto.getContext());
        dbManager.setString(2,prpLctextDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpLctextDto.getCompensateNo());
        dbManager.setString(4,prpLctextDto.getTextType());
        dbManager.setInt(5,prpLctextDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLctextBase.update() success!");
    }

    /**
     * ����������һ������
     * @param compensateNo ���������
     * @param textType ����˵������ ��
--** ������/��ע/��
     * @param lineNo �к�
     * @return PrpLctextDto
     * @throws Exception
     */
    public PrpLctextDto findByPrimaryKey(String compensateNo,String textType,int lineNo) throws Exception{
        String mainStatement = " Select CompensateNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLctext";
        String statement = mainStatement + " Where " +
                           " CompensateNo = ? And " + 
                           " TextType = ? And " + 
                           " LineNo = ?";
        PrpLctextDto prpLctextDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " CompensateNo = '" + compensateNo + "' And " + 
                           " TextType = '" + textType + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,textType);
        dbManager.setInt(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLctextDto = new PrpLctextDto();
            prpLctextDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLctextDto.setTextType(dbManager.getString(resultSet,2));
            prpLctextDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLctextDto.setContext(dbManager.getString(resultSet,4));
            prpLctextDto.setFlag(dbManager.getString(resultSet,5));
            logger.info("DBPrpLctextBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLctextBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLctextDto;
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
        String statement = "Select CompensateNo," + 
                           " TextType," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLctext Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLctextDto prpLctextDto = null;
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

            prpLctextDto = new PrpLctextDto();
            prpLctextDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLctextDto.setTextType(dbManager.getString(resultSet,2));
            prpLctextDto.setLineNo(dbManager.getInt(resultSet,3));
            prpLctextDto.setContext(dbManager.getString(resultSet,4));
            prpLctextDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpLctextDto);
        }
        resultSet.close();
        logger.info("DBPrpLctextBase.findByConditions() success!");
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
        String statement = "Delete From PrpLctext Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLctextBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLctext Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLctextBase.getCount() success!");
        return count;
    }
}
