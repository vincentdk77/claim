package com.sinosoft.AgriXZrequest.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;
import com.sinosoft.AgriXZrequest.resource.dtofactory.domain.DBCorrectRequest_Temp;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CorrectRequest_Temp��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCorrectRequest_TempActionBase{
    private static Logger logger = Logger.getLogger(BLCorrectRequest_TempActionBase.class);

    /**
     * ���캯��
     */
    public BLCorrectRequest_TempActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CorrectRequest_TempDto correctRequest_TempDto)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //�����¼
        dbCorrectRequest_Temp.insert(correctRequest_TempDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param batchNo batchNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String batchNo)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //ɾ����¼
        dbCorrectRequest_Temp.delete(batchNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //������ɾ����¼
        dbCorrectRequest_Temp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CorrectRequest_TempDto correctRequest_TempDto)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //���¼�¼
        dbCorrectRequest_Temp.update(correctRequest_TempDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param batchNo batchNo
     * @return correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public CorrectRequest_TempDto findByPrimaryKey(DBManager dbManager,String batchNo)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        //����DTO
        CorrectRequest_TempDto correctRequest_TempDto = null;
        //��ѯ����,��ֵ��DTO
        correctRequest_TempDto = dbCorrectRequest_Temp.findByPrimaryKey(batchNo);
        return correctRequest_TempDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCorrectRequest_Temp.getCount(conditions);
        collection = dbCorrectRequest_Temp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����correctRequest_TempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCorrectRequest_Temp.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBCorrectRequest_Temp dbCorrectRequest_Temp = new DBCorrectRequest_Temp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCorrectRequest_Temp.getCount(conditions);
        return count;
    }
}
