package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiFileDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utifile�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiFileBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiFileBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiFileBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiFileDto utiFileDto
     * @throws Exception
     */
    public void insert(UtiFileDto utiFileDto) throws Exception{
        String statement = " Insert Into UtiFile(" + 
                           " FileName," + 
                           " LineNo," + 
                           " Text) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiFileDto.getFileName());
        dbManager.setInt(2,utiFileDto.getLineNo());
        dbManager.setString(3,utiFileDto.getText());
        dbManager.executePreparedUpdate();

        log.info("DBUtiFileBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiFileDto utiFileDto = (UtiFileDto)i.next();
            insert(utiFileDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param fileName filename
     * @param lineNo lineno
     * @throws Exception
     */
    public void delete(String fileName,int lineNo) throws Exception{
        String statement = " Delete From UtiFile Where " +
                           " FileName = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,fileName);
        dbManager.setInt(2,lineNo);
        dbManager.executePreparedUpdate();
        log.info("DBUtiFileBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiFileDto utiFileDto
     * @throws Exception
     */
    public void update(UtiFileDto utiFileDto) throws Exception{
        String statement = " Update UtiFile Set Text = ? Where " +
                           " FileName = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiFileDto.getText());
        //���������ֶ�;
        dbManager.setString(2,utiFileDto.getFileName());
        dbManager.setInt(3,utiFileDto.getLineNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiFileBase.update() success!");
    }

    /**
     * ����������һ������
     * @param fileName filename
     * @param lineNo lineno
     * @return UtiFileDto
     * @throws Exception
     */
    public UtiFileDto findByPrimaryKey(String fileName,int lineNo) throws Exception{
        String statement = " Select FileName," + 
                           " LineNo," + 
                           " Text From UtiFile Where " +
                           " FileName = ? And " + 
                           " LineNo = ?";
        UtiFileDto utiFileDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,fileName);
        dbManager.setInt(2,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiFileDto = new UtiFileDto();
            utiFileDto.setFileName(dbManager.getString(resultSet,1));
            utiFileDto.setLineNo(dbManager.getInt(resultSet,2));
            utiFileDto.setText(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBUtiFileBase.findByPrimaryKey() success!");
        return utiFileDto;
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
                           " LineNo," + 
                           " Text From UtiFile Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiFileDto utiFileDto = null;
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

            utiFileDto = new UtiFileDto();
            utiFileDto.setFileName(dbManager.getString(resultSet,1));
            utiFileDto.setLineNo(dbManager.getInt(resultSet,2));
            utiFileDto.setText(dbManager.getString(resultSet,3));
            collection.add(utiFileDto);
        }
        resultSet.close();
        log.info("DBUtiFileBase.findByConditions() success!");
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
        String statement = "Delete From UtiFile Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiFileBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiFile Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiFileBase.getCount() success!");
        return count;
    }
}
