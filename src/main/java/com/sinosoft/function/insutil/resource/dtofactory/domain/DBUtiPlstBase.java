package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPlstDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiplst�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPlstBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiPlstBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiPlstBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiPlstDto utiPlstDto
     * @throws Exception
     */
    public void insert(UtiPlstDto utiPlstDto) throws Exception{
        String statement = " Insert Into UtiPlst(" + 
                           " FileName," + 
                           " LabelNo," + 
                           " FieldName," + 
                           " FieldMeaning," + 
                           " FieldFormat," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPlstDto.getFileName());
        dbManager.setString(2,utiPlstDto.getLabelNo());
        dbManager.setString(3,utiPlstDto.getFieldName());
        dbManager.setString(4,utiPlstDto.getFieldMeaning());
        dbManager.setString(5,utiPlstDto.getFieldFormat());
        dbManager.setString(6,utiPlstDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPlstBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPlstDto utiPlstDto = (UtiPlstDto)i.next();
            insert(utiPlstDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param fileName filename
     * @param labelNo labelno
     * @throws Exception
     */
    public void delete(String fileName,String labelNo) throws Exception{
        String statement = " Delete From UtiPlst Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,fileName);
        dbManager.setString(2,labelNo);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPlstBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiPlstDto utiPlstDto
     * @throws Exception
     */
    public void update(UtiPlstDto utiPlstDto) throws Exception{
        String statement = " Update UtiPlst Set FieldName = ?," + 
                           " FieldMeaning = ?," + 
                           " FieldFormat = ?," + 
                           " Flag = ? Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiPlstDto.getFieldName());
        dbManager.setString(2,utiPlstDto.getFieldMeaning());
        dbManager.setString(3,utiPlstDto.getFieldFormat());
        dbManager.setString(4,utiPlstDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,utiPlstDto.getFileName());
        dbManager.setString(6,utiPlstDto.getLabelNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPlstBase.update() success!");
    }

    /**
     * ����������һ������
     * @param fileName filename
     * @param labelNo labelno
     * @return UtiPlstDto
     * @throws Exception
     */
    public UtiPlstDto findByPrimaryKey(String fileName,String labelNo) throws Exception{
        String statement = " Select FileName," + 
                           " LabelNo," + 
                           " FieldName," + 
                           " FieldMeaning," + 
                           " FieldFormat," + 
                           " Flag From UtiPlst Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        UtiPlstDto utiPlstDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,fileName);
        dbManager.setString(2,labelNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPlstDto = new UtiPlstDto();
            utiPlstDto.setFileName(dbManager.getString(resultSet,1));
            utiPlstDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPlstDto.setFieldName(dbManager.getString(resultSet,3));
            utiPlstDto.setFieldMeaning(dbManager.getString(resultSet,4));
            utiPlstDto.setFieldFormat(dbManager.getString(resultSet,5));
            utiPlstDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBUtiPlstBase.findByPrimaryKey() success!");
        return utiPlstDto;
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
        String statement = "Select FileName," + 
                           " LabelNo," + 
                           " FieldName," + 
                           " FieldMeaning," + 
                           " FieldFormat," + 
                           " Flag From UtiPlst Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPlstDto utiPlstDto = null;
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

            utiPlstDto = new UtiPlstDto();
            utiPlstDto.setFileName(dbManager.getString(resultSet,1));
            utiPlstDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPlstDto.setFieldName(dbManager.getString(resultSet,3));
            utiPlstDto.setFieldMeaning(dbManager.getString(resultSet,4));
            utiPlstDto.setFieldFormat(dbManager.getString(resultSet,5));
            utiPlstDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(utiPlstDto);
        }
        resultSet.close();
        log.info("DBUtiPlstBase.findByConditions() success!");
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
        String statement = "Delete From UtiPlst Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPlstBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiPlst Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPlstBase.getCount() success!");
        return count;
    }
}
