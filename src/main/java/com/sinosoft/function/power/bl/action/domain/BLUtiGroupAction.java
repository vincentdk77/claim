package com.sinosoft.function.power.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiGroup  Ȩ����ű��ҵ�������չ��<br>
 * ������ 2004-11-09 10:40:54.648<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupAction extends BLUtiGroupActionBase{
    private static Log logger = LogFactory.getLog(BLUtiGroupAction.class);

    /**
     * ���캯��
     */
    public BLUtiGroupAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiGroupDto utiGroupDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiGroupDto utiGroupDto,String mode) throws Exception{
    }
}
