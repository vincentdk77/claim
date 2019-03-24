package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpIDcodeDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpIDcode;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidcode��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDcodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDcodeActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpIDcodeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpIDcodeDto prpIDcodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpIDcodeDto prpIDcodeDto) throws Exception{
        DBPrpIDcode dbPrpIDcode = new DBPrpIDcode(dbManager);
        //�����¼
        dbPrpIDcode.insert(prpIDcodeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param codeType codetype
     * @param riskCode riskcode
     * @param codeCode codecode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType,String riskCode,String codeCode) throws Exception{
        DBPrpIDcode dbPrpIDcode = new DBPrpIDcode(dbManager);
        //ɾ����¼
        dbPrpIDcode.delete(codeType, riskCode, codeCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpIDcode dbPrpIDcode = new DBPrpIDcode(dbManager);
        //������ɾ����¼
        dbPrpIDcode.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpIDcodeDto prpIDcodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpIDcodeDto prpIDcodeDto) throws Exception{
        DBPrpIDcode dbPrpIDcode = new DBPrpIDcode(dbManager);
        //���¼�¼
        dbPrpIDcode.update(prpIDcodeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param codeType codetype
     * @param riskCode riskcode
     * @param codeCode codecode
     * @return prpIDcodeDto prpIDcodeDto
     * @throws Exception
     */
    public PrpIDcodeDto findByPrimaryKey(DBManager dbManager,String codeType,String riskCode,String codeCode) throws Exception{
        DBPrpIDcode dbPrpIDcode = new DBPrpIDcode(dbManager);
        //����DTO
        PrpIDcodeDto prpIDcodeDto = null;
        //��ѯ����,��ֵ��DTO
        prpIDcodeDto = dbPrpIDcode.findByPrimaryKey(codeType, riskCode, codeCode);
        return prpIDcodeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpIDcodeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpIDcode dbPrpIDcode = new DBPrpIDcode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpIDcode.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpIDcode.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpIDcodeDto�ļ���
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
        DBPrpIDcode dbPrpIDcode = new DBPrpIDcode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpIDcode.getCount(conditions);
        return count;
    }
}
