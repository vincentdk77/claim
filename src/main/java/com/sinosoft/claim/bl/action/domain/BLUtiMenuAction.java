package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiMenuDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utimenu�˵����Ʊ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiMenuAction extends BLUtiMenuActionBase{
    private static Log log = LogFactory.getLog(BLUtiMenuAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiMenuAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiMenuDto utiMenuDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiMenuDto utiMenuDto,String mode) throws Exception{
    }
}
