package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPvalueDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipvalue�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPvalueBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiPvalueBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiPvalueBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiPvalueDto utiPvalueDto
     * @throws Exception
     */
    public void insert(UtiPvalueDto utiPvalueDto) throws Exception{
        String statement = " Insert Into UtiPvalue(" + 
                           " TtyName," + 
                           " LabelNo," + 
                           " FieldValu," + 
                           " LineNo) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPvalueDto.getTtyName());
        dbManager.setString(2,utiPvalueDto.getLabelNo());
        dbManager.setString(3,utiPvalueDto.getFieldValu());
        dbManager.setInt(4,utiPvalueDto.getLineNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPvalueBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPvalueDto utiPvalueDto = (UtiPvalueDto)i.next();
            insert(utiPvalueDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param ttyName ttyname
     * @throws Exception
     */
    public void delete(String ttyName) throws Exception{
        String statement = " Delete From UtiPvalue Where " +
                           " TtyName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,ttyName);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPvalueBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiPvalueDto utiPvalueDto
     * @throws Exception
     */
    public void update(UtiPvalueDto utiPvalueDto) throws Exception{
        String statement = " Update UtiPvalue Set LabelNo = ?," + 
                           " FieldValu = ?," + 
                           " LineNo = ? Where " +
                           " TtyName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiPvalueDto.getLabelNo());
        dbManager.setString(2,utiPvalueDto.getFieldValu());
        dbManager.setInt(3,utiPvalueDto.getLineNo());
        //���������ֶ�;
        dbManager.setString(4,utiPvalueDto.getTtyName());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPvalueBase.update() success!");
    }

    /**
     * ����������һ������
     * @param ttyName ttyname
     * @return UtiPvalueDto
     * @throws Exception
     */
    public UtiPvalueDto findByPrimaryKey(String ttyName) throws Exception{
        String statement = " Select TtyName," + 
                           " LabelNo," + 
                           " FieldValu," + 
                           " LineNo From UtiPvalue Where " +
                           " TtyName = ?";
        UtiPvalueDto utiPvalueDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,ttyName);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPvalueDto = new UtiPvalueDto();
            utiPvalueDto.setTtyName(dbManager.getString(resultSet,1));
            utiPvalueDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPvalueDto.setFieldValu(dbManager.getString(resultSet,3));
            utiPvalueDto.setLineNo(dbManager.getInt(resultSet,4));
        }
        resultSet.close();
        log.info("DBUtiPvalueBase.findByPrimaryKey() success!");
        return utiPvalueDto;
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
        String statement = "Select TtyName," + 
                           " LabelNo," + 
                           " FieldValu," + 
                           " LineNo From UtiPvalue Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPvalueDto utiPvalueDto = null;
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

            utiPvalueDto = new UtiPvalueDto();
            utiPvalueDto.setTtyName(dbManager.getString(resultSet,1));
            utiPvalueDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPvalueDto.setFieldValu(dbManager.getString(resultSet,3));
            utiPvalueDto.setLineNo(dbManager.getInt(resultSet,4));
            collection.add(utiPvalueDto);
        }
        resultSet.close();
        log.info("DBUtiPvalueBase.findByConditions() success!");
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
        String statement = "Delete From UtiPvalue Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPvalueBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiPvalue Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPvalueBase.getCount() success!");
        return count;
    }
}
