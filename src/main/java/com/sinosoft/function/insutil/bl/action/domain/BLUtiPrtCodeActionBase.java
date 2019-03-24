package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtCodeDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiPrtCode;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtcode��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtCodeActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtCodeActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiPrtCodeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiPrtCodeDto utiPrtCodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPrtCodeDto utiPrtCodeDto) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //�����¼
        dbUtiPrtCode.insert(utiPrtCodeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param instructType instructtype
     * @param instructCode instructcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String instructType,String instructCode) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //ɾ����¼
        dbUtiPrtCode.delete(instructType, instructCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //������ɾ����¼
        dbUtiPrtCode.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiPrtCodeDto utiPrtCodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPrtCodeDto utiPrtCodeDto) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //���¼�¼
        dbUtiPrtCode.update(utiPrtCodeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param instructType instructtype
     * @param instructCode instructcode
     * @return utiPrtCodeDto utiPrtCodeDto
     * @throws Exception
     */
    public UtiPrtCodeDto findByPrimaryKey(DBManager dbManager,String instructType,String instructCode) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        //����DTO
        UtiPrtCodeDto utiPrtCodeDto = null;
        //��ѯ����,��ֵ��DTO
        utiPrtCodeDto = dbUtiPrtCode.findByPrimaryKey(instructType, instructCode);
        return utiPrtCodeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiPrtCodeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiPrtCode.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiPrtCode.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiPrtCodeDto�ļ���
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
        DBUtiPrtCode dbUtiPrtCode = new DBUtiPrtCode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPrtCode.getCount(conditions);
        return count;
    }
}
