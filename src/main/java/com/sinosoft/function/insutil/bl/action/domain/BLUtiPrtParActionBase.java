package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtParDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiPrtPar;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtpar��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtParActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtParActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiPrtParActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiPrtParDto utiPrtParDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPrtParDto utiPrtParDto) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //�����¼
        dbUtiPrtPar.insert(utiPrtParDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param fileName filename
     * @param labelNo labelno
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //ɾ����¼
        dbUtiPrtPar.delete(fileName, labelNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //������ɾ����¼
        dbUtiPrtPar.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiPrtParDto utiPrtParDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPrtParDto utiPrtParDto) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //���¼�¼
        dbUtiPrtPar.update(utiPrtParDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param fileName filename
     * @param labelNo labelno
     * @return utiPrtParDto utiPrtParDto
     * @throws Exception
     */
    public UtiPrtParDto findByPrimaryKey(DBManager dbManager,String fileName,String labelNo) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        //����DTO
        UtiPrtParDto utiPrtParDto = null;
        //��ѯ����,��ֵ��DTO
        utiPrtParDto = dbUtiPrtPar.findByPrimaryKey(fileName, labelNo);
        return utiPrtParDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiPrtParDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiPrtPar.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiPrtPar.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiPrtParDto�ļ���
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
        DBUtiPrtPar dbUtiPrtPar = new DBUtiPrtPar(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPrtPar.getCount(conditions);
        return count;
    }
}
