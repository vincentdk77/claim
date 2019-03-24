package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtFormDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPrtForm;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtform���Ӻ��ݱ�ͷ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtFormActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtFormActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiPrtFormActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiPrtFormDto utiPrtFormDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPrtFormDto utiPrtFormDto) throws Exception{
        DBUtiPrtForm dbUtiPrtForm = new DBUtiPrtForm(dbManager);
        //�����¼
        dbUtiPrtForm.insert(utiPrtFormDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param headCode ��ͷ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String headCode) throws Exception{
        DBUtiPrtForm dbUtiPrtForm = new DBUtiPrtForm(dbManager);
        //ɾ����¼
        dbUtiPrtForm.delete(headCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPrtForm dbUtiPrtForm = new DBUtiPrtForm(dbManager);
        //������ɾ����¼
        dbUtiPrtForm.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiPrtFormDto utiPrtFormDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPrtFormDto utiPrtFormDto) throws Exception{
        DBUtiPrtForm dbUtiPrtForm = new DBUtiPrtForm(dbManager);
        //���¼�¼
        dbUtiPrtForm.update(utiPrtFormDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param headCode ��ͷ����
     * @return utiPrtFormDto utiPrtFormDto
     * @throws Exception
     */
    public UtiPrtFormDto findByPrimaryKey(DBManager dbManager,String headCode) throws Exception{
        DBUtiPrtForm dbUtiPrtForm = new DBUtiPrtForm(dbManager);
        //����DTO
        UtiPrtFormDto utiPrtFormDto = null;
        //��ѯ����,��ֵ��DTO
        utiPrtFormDto = dbUtiPrtForm.findByPrimaryKey(headCode);
        return utiPrtFormDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiPrtFormDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPrtForm dbUtiPrtForm = new DBUtiPrtForm(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPrtForm.getCount(conditions);
        collection = dbUtiPrtForm.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPrtForm dbUtiPrtForm = new DBUtiPrtForm(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPrtForm.getCount(conditions);
        return count;
    }
}
