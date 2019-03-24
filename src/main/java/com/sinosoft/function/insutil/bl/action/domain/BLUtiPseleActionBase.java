package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPseleDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiPsele;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utipsele��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPseleActionBase{
    private static Log log = LogFactory.getLog(BLUtiPseleActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiPseleActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiPseleDto utiPseleDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPseleDto utiPseleDto) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //�����¼
        dbUtiPsele.insert(utiPseleDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fileName filename
     * @param orderNo orderno
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,String orderNo) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //ɾ����¼
        dbUtiPsele.delete(fileName, orderNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //������ɾ����¼
        dbUtiPsele.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiPseleDto utiPseleDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPseleDto utiPseleDto) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //���¼�¼
        dbUtiPsele.update(utiPseleDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param fileName filename
     * @param orderNo orderno
     * @return utiPseleDto utiPseleDto
     * @throws Exception
     */
    public UtiPseleDto findByPrimaryKey(DBManager dbManager,String fileName,String orderNo) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        //����DTO
        UtiPseleDto utiPseleDto = null;
        //��ѯ����,��ֵ��DTO
        utiPseleDto = dbUtiPsele.findByPrimaryKey(fileName, orderNo);
        return utiPseleDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiPseleDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiPsele.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiPsele.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiPseleDto�ļ���
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
        DBUtiPsele dbUtiPsele = new DBUtiPsele(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPsele.getCount(conditions);
        return count;
    }
}
