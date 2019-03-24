package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfCondition;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WfCondition�����������������ҵ�������չ��<br>
 * ������ 2004-08-09 19:54:54.996<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfConditionAction extends BLSwfConditionActionBase{
    private static Log logger = LogFactory.getLog(BLSwfConditionAction.class);

    /**
     * ���캯��
     */
    public BLSwfConditionAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param swfConditionDto swfConditionDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfConditionDto swfConditionDto,String mode) throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param wfConditionDto wfConditionDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,SwfConditionDto swfConditionDto) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        Collection conditionList = swfConditionDto.getConditionList() ;
        //�����¼
        dbSwfCondition.insertAll(conditionList);
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param wfConditionDto wfConditionDto
     * @throws Exception
     */
    public boolean executeResult(DBManager dbManager,String conditions) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        return (boolean) dbSwfCondition.executeResult(conditions);

    }



}
