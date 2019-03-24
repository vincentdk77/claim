package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiFileDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiFile;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utifile��ӡ�ļ����ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiFileActionBase{
    private static Log log = LogFactory.getLog(BLUtiFileActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiFileActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiFileDto utiFileDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiFileDto utiFileDto) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //�����¼
        dbUtiFile.insert(utiFileDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fileName �ļ�����
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,int lineNo) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //ɾ����¼
        dbUtiFile.delete(fileName, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //������ɾ����¼
        dbUtiFile.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiFileDto utiFileDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiFileDto utiFileDto) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //���¼�¼
        dbUtiFile.update(utiFileDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param fileName �ļ�����
     * @param lineNo �к�
     * @return utiFileDto utiFileDto
     * @throws Exception
     */
    public UtiFileDto findByPrimaryKey(DBManager dbManager,String fileName,int lineNo) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        //����DTO
        UtiFileDto utiFileDto = null;
        //��ѯ����,��ֵ��DTO
        utiFileDto = dbUtiFile.findByPrimaryKey(fileName, lineNo);
        return utiFileDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiFileDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiFile.getCount(conditions);
        collection = dbUtiFile.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiFile.getCount(conditions);
        return count;
    }
}
