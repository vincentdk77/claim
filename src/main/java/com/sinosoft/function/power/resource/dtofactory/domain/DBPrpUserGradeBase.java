package com.sinosoft.function.power.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpUserGrade Ա��Ȩ�ޱ�����ݷ��ʶ������<br>
 * ������ 2004-11-09 10:40:49.301<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpUserGradeBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpUserGradeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpUserGradeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void insert(PrpUserGradeDto prpUserGradeDto) throws Exception{
        String mainStatement = " Insert Into PrpUserGrade (" + 
                           " UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpUserGradeDto.getUserCode() + "'," + 
                           "'" + prpUserGradeDto.getGroupCode() + "'," + 
                           "'" + prpUserGradeDto.getTaskCode() + "'," + 
                           "'" + prpUserGradeDto.getCheckCode() + "'," + 
                           "'" + prpUserGradeDto.getValue() + "'," + 
                           "'" + prpUserGradeDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpUserGradeDto.getUserCode());
        dbManager.setString(2,prpUserGradeDto.getGroupCode());
        dbManager.setString(3,prpUserGradeDto.getTaskCode());
        dbManager.setString(4,prpUserGradeDto.getCheckCode());
        dbManager.setString(5,prpUserGradeDto.getValue());
        dbManager.setString(6,prpUserGradeDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpUserGradeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpUserGradeDto prpUserGradeDto = (PrpUserGradeDto)i.next();
            insert(prpUserGradeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param userCode Ա������
     * @param groupCode Ȩ����Ŵ���
     * @param taskCode �������
     * @param checkCode Ȩ�޼������
     * @throws Exception
     */
    public void delete(String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        String statement = " Delete From PrpUserGrade" + 
	            		   " Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpUserGrade Where " +
                           " UserCode = '" + userCode + "' And " + 
                           " GroupCode = '" + groupCode + "' And " + 
                           " TaskCode = '" + taskCode + "' And " + 
                           " CheckCode = '" + checkCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,groupCode);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpUserGradeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void update(PrpUserGradeDto prpUserGradeDto) throws Exception{
        String statement = " Update PrpUserGrade Set Value = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpUserGrade Set " + 
                           " UserCode = '" + prpUserGradeDto.getUserCode() + "'," + 
                           " GroupCode = '" + prpUserGradeDto.getGroupCode() + "'," + 
                           " TaskCode = '" + prpUserGradeDto.getTaskCode() + "'," + 
                           " CheckCode = '" + prpUserGradeDto.getCheckCode() + "'," + 
                           " Value = '" + prpUserGradeDto.getValue() + "'," + 
                           " Flag = '" + prpUserGradeDto.getFlag() + "'" + 
			               " Where " +
                           " UserCode = '" + prpUserGradeDto.getUserCode() + "' And " + 
                           " GroupCode = '" + prpUserGradeDto.getGroupCode() + "' And " + 
                           " TaskCode = '" + prpUserGradeDto.getTaskCode() + "' And " + 
                           " CheckCode = '" + prpUserGradeDto.getCheckCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpUserGradeDto.getValue());
        dbManager.setString(2,prpUserGradeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpUserGradeDto.getUserCode());
        dbManager.setString(4,prpUserGradeDto.getGroupCode());
        dbManager.setString(5,prpUserGradeDto.getTaskCode());
        dbManager.setString(6,prpUserGradeDto.getCheckCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpUserGradeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param userCode Ա������
     * @param groupCode Ȩ����Ŵ���
     * @param taskCode �������
     * @param checkCode Ȩ�޼������
     * @return PrpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeDto findByPrimaryKey(String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        String mainStatement = " Select UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " Flag From PrpUserGrade";
        String statement = mainStatement + " Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ?";
        PrpUserGradeDto prpUserGradeDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " UserCode = '" + userCode + "' And " + 
                           " GroupCode = '" + groupCode + "' And " + 
                           " TaskCode = '" + taskCode + "' And " + 
                           " CheckCode = '" + checkCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,groupCode);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpUserGradeDto = new PrpUserGradeDto();
            prpUserGradeDto.setUserCode(dbManager.getString(resultSet,1));
            prpUserGradeDto.setGroupCode(dbManager.getString(resultSet,2));
            prpUserGradeDto.setTaskCode(dbManager.getString(resultSet,3));
            prpUserGradeDto.setCheckCode(dbManager.getString(resultSet,4));
            prpUserGradeDto.setValue(dbManager.getString(resultSet,5));
            prpUserGradeDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        logger.info("DBPrpUserGradeBase.findByPrimaryKey() success!");
        return prpUserGradeDto;
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
        String statement = "Select UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " Flag From PrpUserGrade Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpUserGradeDto prpUserGradeDto = null;
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

            prpUserGradeDto = new PrpUserGradeDto();
            prpUserGradeDto.setUserCode(dbManager.getString(resultSet,1));
            prpUserGradeDto.setGroupCode(dbManager.getString(resultSet,2));
            prpUserGradeDto.setTaskCode(dbManager.getString(resultSet,3));
            prpUserGradeDto.setCheckCode(dbManager.getString(resultSet,4));
            prpUserGradeDto.setValue(dbManager.getString(resultSet,5));
            prpUserGradeDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpUserGradeDto);
        }
        resultSet.close();
        logger.info("DBPrpUserGradeBase.findByConditions() success!");
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
        String statement = "Delete From PrpUserGrade Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpUserGradeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpUserGrade Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpUserGradeBase.getCount() success!");
        return count;
    }
}
