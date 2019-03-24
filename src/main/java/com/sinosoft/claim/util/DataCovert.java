package com.sinosoft.claim.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.custom.DTreeDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;

/**
 * ����ת��������
 * @author Administrator
 *
 */
public class DataCovert{
	/**
	 * ��ҵ�����ݶ���ת��Ϊ���ͽṹ����
	 * @param colls ԭ����
	 * @param codeType ��������
	 * @return
	 */
	public static Collection collectionToTree(Collection colls,String codeType){
		Collection trees = new ArrayList();
		if("ComCode".equals(codeType)){
			Iterator it = colls.iterator();
			while(it.hasNext()){
				DTreeDto dTreeDto = new DTreeDto();
				PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)it.next();
				dTreeDto.setId(prpDcompanyDto.getComCode());
				dTreeDto.setParentId(prpDcompanyDto.getUpperComCode());
				dTreeDto.setName(prpDcompanyDto.getComCName());
				trees.add(dTreeDto);
			}
			
		}else if("jobComCode".equals(codeType)){
			Iterator it = colls.iterator();
			while(it.hasNext()){
				DTreeDto dTreeDto = new DTreeDto();
				PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)it.next();
				dTreeDto.setId(prpDcompanyDto.getComCode());
				dTreeDto.setParentId(prpDcompanyDto.getUpperComCode());
				dTreeDto.setName(prpDcompanyDto.getComCName());
				trees.add(dTreeDto);
			}
		}
		return trees;
	}
}
