package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtFormDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiPrtForm;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtform��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtFormActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtFormActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param headCode headcode
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
     * @param headCode headcode
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

        count = dbUtiPrtForm.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiPrtForm.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiPrtFormDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiPrtForm dbUtiPrtForm = new DBUtiPrtForm(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPrtForm.getCount(conditions);
        return count;
    }
}
