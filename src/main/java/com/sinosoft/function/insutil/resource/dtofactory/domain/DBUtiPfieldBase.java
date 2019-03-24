package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPfieldDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipfield�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPfieldBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiPfieldBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiPfieldBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public void insert(UtiPfieldDto utiPfieldDto) throws Exception{
        String statement = " Insert Into UtiPfield(" + 
                           " FileName," + 
                           " LabelNo," + 
                           " FieldName," + 
                           " SelFlag," + 
                           " TabName," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPfieldDto.getFileName());
        dbManager.setString(2,utiPfieldDto.getLabelNo());
        dbManager.setString(3,utiPfieldDto.getFieldName());
        dbManager.setString(4,utiPfieldDto.getSelFlag());
        dbManager.setString(5,utiPfieldDto.getTabName());
        dbManager.setString(6,utiPfieldDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPfieldBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPfieldDto utiPfieldDto = (UtiPfieldDto)i.next();
            insert(utiPfieldDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param fileName filename
     * @param labelNo labelno
     * @throws Exception
     */
    public void delete(String fileName,String labelNo) throws Exception{
        String statement = " Delete From UtiPfield Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,fileName);
        dbManager.setString(2,labelNo);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPfieldBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiPfieldDto utiPfieldDto
     * @throws Exception
     */
    public void update(UtiPfieldDto utiPfieldDto) throws Exception{
        String statement = " Update UtiPfield Set FieldName = ?," + 
                           " SelFlag = ?," + 
                           " TabName = ?," + 
                           " Flag = ? Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiPfieldDto.getFieldName());
        dbManager.setString(2,utiPfieldDto.getSelFlag());
        dbManager.setString(3,utiPfieldDto.getTabName());
        dbManager.setString(4,utiPfieldDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,utiPfieldDto.getFileName());
        dbManager.setString(6,utiPfieldDto.getLabelNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPfieldBase.update() success!");
    }

    /**
     * ����������һ������
     * @param fileName filename
     * @param labelNo labelno
     * @return UtiPfieldDto
     * @throws Exception
     */
    public UtiPfieldDto findByPrimaryKey(String fileName,String labelNo) throws Exception{
        String statement = " Select FileName," + 
                           " LabelNo," + 
                           " FieldName," + 
                           " SelFlag," + 
                           " TabName," + 
                           " Flag From UtiPfield Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        UtiPfieldDto utiPfieldDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,fileName);
        dbManager.setString(2,labelNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPfieldDto = new UtiPfieldDto();
            utiPfieldDto.setFileName(dbManager.getString(resultSet,1));
            utiPfieldDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPfieldDto.setFieldName(dbManager.getString(resultSet,3));
            utiPfieldDto.setSelFlag(dbManager.getString(resultSet,4));
            utiPfieldDto.setTabName(dbManager.getString(resultSet,5));
            utiPfieldDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBUtiPfieldBase.findByPrimaryKey() success!");
        return utiPfieldDto;
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
                           " SelFlag," + 
                           " TabName," + 
                           " Flag From UtiPfield Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPfieldDto utiPfieldDto = null;
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

            utiPfieldDto = new UtiPfieldDto();
            utiPfieldDto.setFileName(dbManager.getString(resultSet,1));
            utiPfieldDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPfieldDto.setFieldName(dbManager.getString(resultSet,3));
            utiPfieldDto.setSelFlag(dbManager.getString(resultSet,4));
            utiPfieldDto.setTabName(dbManager.getString(resultSet,5));
            utiPfieldDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(utiPfieldDto);
        }
        resultSet.close();
        log.info("DBUtiPfieldBase.findByConditions() success!");
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
        String statement = "Delete From UtiPfield Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPfieldBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiPfield Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPfieldBase.getCount() success!");
        return count;
    }
}
