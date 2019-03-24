package com.sinosoft.servlet.accisd.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.sinosoft.servlet.accisd.dto.AcciSDRequestDto;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.sysframework.common.util.StringUtils;

public class XMLHealHelper {

	/**
	 * ɽ���⽡�շ�����Ϣ���ͱ���ת��
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public AcciSDRequestDto getAcciSDXMLToDto(String xmlStr) throws Exception{
		//1��xmlת��
		AcciSDRequestDto acciSDRequestDto = new AcciSDRequestDto();
		PrpLAcciBaseInfoSDDto prpLAcciBaseInfoSDDto = new PrpLAcciBaseInfoSDDto();
		System.out.println("������-----------\n"+xmlStr);
		Document document = DocumentHelper.parseText(xmlStr);
		//�õ����ڵ�PACKET
		Element packet = document.getRootElement();
		for (Iterator it=packet.elementIterator("Head"); it.hasNext();){
			Element head=(Element)it.next();
			acciSDRequestDto.setRequestType(parseNode(head.selectSingleNode("RequestType")));
			acciSDRequestDto.setUserCode(parseNode(head.selectSingleNode("UserCode")));
			acciSDRequestDto.setPassWord(parseNode(head.selectSingleNode("PassWord")));
		}
		//�õ�BODY�ڵ�
		for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();){
			PrpLAcciClaimInfoSDDto requestBaseDto = null;
			List<PrpLAcciClaimInfoSDDto> requestList = new ArrayList<PrpLAcciClaimInfoSDDto>();
			Element body=(Element)bit.next();
			for (Iterator it=body.elementIterator("BaseInfo"); it.hasNext();){
				Element head=(Element)it.next();
				prpLAcciBaseInfoSDDto.setName(parseNode(head.selectSingleNode("Name")));
				prpLAcciBaseInfoSDDto.setGender(parseNode(head.selectSingleNode("Gender")));
				prpLAcciBaseInfoSDDto.setBirthday(parseNode(head.selectSingleNode("Birthday")));
				prpLAcciBaseInfoSDDto.setCredentialType(parseNode(head.selectSingleNode("CredentialType")));
				prpLAcciBaseInfoSDDto.setCredentialNo(parseNode(head.selectSingleNode("CredentialNo")));
				acciSDRequestDto.setPrpLAcciBaseInfoSDDto(prpLAcciBaseInfoSDDto);
				for (Iterator dit=head.elementIterator("ClaimInfo"); dit.hasNext();){
					Element data=(Element)dit.next();
					requestBaseDto = new PrpLAcciClaimInfoSDDto();
					requestBaseDto.setName(parseNode(head.selectSingleNode("Name")));
					requestBaseDto.setCredentialType(parseNode(head.selectSingleNode("CredentialType")));
					requestBaseDto.setCredentialNo(parseNode(head.selectSingleNode("CredentialNo")));
					requestBaseDto.setClaimNo(parseNode(data.selectSingleNode("ClaimNo")));
					requestBaseDto.setClaimDate(parseNode(data.selectSingleNode("ClaimDate")));
					requestBaseDto.setCompanyCode(parseNode(data.selectSingleNode("CompanyCode")));
					requestBaseDto.setLossDate(parseNode(data.selectSingleNode("LossDate")));
					requestBaseDto.setLossResult(parseNode(data.selectSingleNode("LossResult")));
					requestList.add(requestBaseDto);
				}
			}
			acciSDRequestDto.setPrpLAcciClaimInfoSDDtoList(requestList);
		}
		return acciSDRequestDto;
	}

	/**
	 * �������ڸ�ʽ
	 * @param dateString
	 * 8���ַ�������
	 * @return YYYYMMDD��ʽ������
	 */
    private String correctDate(String dateString) {
        String result = StringUtils.replace(dateString, "-", "");
        return result;
    }
    
	private static String parseNode(Node node)
	{
		if (node==null)
		{
			return null;
		}
		return node.getText();
	}
	
	private static double parseDouble(String data)
	{
		if (data!=null && data!="")
		{
			return Double.parseDouble(data);
		}
		return 0;
	}
}
