package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiTtyCodeDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiTtyCode;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utittycode��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiTtyCodeActionBase{
    private static Log log = LogFactory.getLog(BLUtiTtyCodeActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLUtiTtyCodeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param utiTtyCodeDto utiTtyCodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiTtyCodeDto utiTtyCodeDto) throws Exception{
        DBUtiTtyCode dbUtiTtyCode = new DBUtiTtyCode(dbManager);
        //�����¼
        dbUtiTtyCode.insert(utiTtyCodeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param ttyCode ttycode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String ttyCode) throws Exception{
        DBUtiTtyCode dbUtiTtyCode = new DBUtiTtyCode(dbManager);
        //ɾ����¼
        dbUtiTtyCode.delete(ttyCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiTtyCode dbUtiTtyCode = new DBUtiTtyCode(dbManager);
        //������ɾ����¼
        dbUtiTtyCode.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param utiTtyCodeDto utiTtyCodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiTtyCodeDto utiTtyCodeDto) throws Exception{
        DBUtiTtyCode dbUtiTtyCode = new DBUtiTtyCode(dbManager);
        //���¼�¼
        dbUtiTtyCode.update(utiTtyCodeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param ttyCode ttycode
     * @return utiTtyCodeDto utiTtyCodeDto
     * @throws Exception
     */
    public UtiTtyCodeDto findByPrimaryKey(DBManager dbManager,String ttyCode) throws Exception{
        DBUtiTtyCode dbUtiTtyCode = new DBUtiTtyCode(dbManager);
        //����DTO
        UtiTtyCodeDto utiTtyCodeDto = null;
        //��ѯ����,��ֵ��DTO
        utiTtyCodeDto = dbUtiTtyCode.findByPrimaryKey(ttyCode);
        return utiTtyCodeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����utiTtyCodeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiTtyCode dbUtiTtyCode = new DBUtiTtyCode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbUtiTtyCode.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiTtyCode.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiTtyCodeDto�ļ���
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
        DBUtiTtyCode dbUtiTtyCode = new DBUtiTtyCode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiTtyCode.getCount(conditions);
        return count;
    }
}
