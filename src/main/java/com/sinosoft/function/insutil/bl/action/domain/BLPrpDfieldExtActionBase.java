package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDfieldExtDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDfieldExt;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdfieldext��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDfieldExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpDfieldExtActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDfieldExtActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDfieldExtDto prpDfieldExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDfieldExtDto prpDfieldExtDto) throws Exception{
        DBPrpDfieldExt dbPrpDfieldExt = new DBPrpDfieldExt(dbManager);
        //�����¼
        dbPrpDfieldExt.insert(prpDfieldExtDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param codeType codetype
     * @param riskCode riskcode
     * @param codeCode codecode
     * @param columnName columnname
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType,String riskCode,String codeCode,String columnName) throws Exception{
        DBPrpDfieldExt dbPrpDfieldExt = new DBPrpDfieldExt(dbManager);
        //ɾ����¼
        dbPrpDfieldExt.delete(codeType, riskCode, codeCode, columnName);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDfieldExt dbPrpDfieldExt = new DBPrpDfieldExt(dbManager);
        //������ɾ����¼
        dbPrpDfieldExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDfieldExtDto prpDfieldExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDfieldExtDto prpDfieldExtDto) throws Exception{
        DBPrpDfieldExt dbPrpDfieldExt = new DBPrpDfieldExt(dbManager);
        //���¼�¼
        dbPrpDfieldExt.update(prpDfieldExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param codeType codetype
     * @param riskCode riskcode
     * @param codeCode codecode
     * @param columnName columnname
     * @return prpDfieldExtDto prpDfieldExtDto
     * @throws Exception
     */
    public PrpDfieldExtDto findByPrimaryKey(DBManager dbManager,String codeType,String riskCode,String codeCode,String columnName) throws Exception{
        DBPrpDfieldExt dbPrpDfieldExt = new DBPrpDfieldExt(dbManager);
        //����DTO
        PrpDfieldExtDto prpDfieldExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpDfieldExtDto = dbPrpDfieldExt.findByPrimaryKey(codeType, riskCode, codeCode, columnName);
        return prpDfieldExtDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDfieldExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDfieldExt dbPrpDfieldExt = new DBPrpDfieldExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDfieldExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDfieldExt.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDfieldExtDto�ļ���
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
        DBPrpDfieldExt dbPrpDfieldExt = new DBPrpDfieldExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDfieldExt.getCount(conditions);
        return count;
    }
}
