package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiFileDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBUtiFile;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utifile��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiFileActionBase{
    private static Log log = LogFactory.getLog(BLUtiFileActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param fileName filename
     * @param lineNo lineno
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
     * @param fileName filename
     * @param lineNo lineno
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

        count = dbUtiFile.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiFile.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����utiFileDto�ļ���
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
        DBUtiFile dbUtiFile = new DBUtiFile(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiFile.getCount(conditions);
        return count;
    }
}
