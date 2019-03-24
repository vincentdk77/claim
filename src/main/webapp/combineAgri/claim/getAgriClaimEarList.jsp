
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.gyic.claim.utils.Utils"%>
<%@page import="com.gyic.claim.dto.domain.HerdpolicylistDto"%>
<%@page import="com.gyic.claim.dto.domain.PrplcompensateearDto"%>
<%@page import="org.dom4j.Document"%>
<%@page import="org.dom4j.DocumentHelper"%>
<%@page import="org.dom4j.Element"%>
<%@page import="java.io.PrintWriter"%>


<%@page contentType="text/xml;charset=GBK"%>
<%
	//PrintWriter out = reponse.getWriter();
	String strPoliceNo = request.getParameter("policyNo");
	String strEarList = request.getParameter("earList");
	Collection herdInsuranceList = new ArrayList();
	String[] earList = getSplitedString(strEarList, ",");
	String strEar = "";
	String nodeType = request.getParameter("nodeType");
	Document dom = DocumentHelper.createDocument();
	dom.setXMLEncoding("GBK");
	Element root = dom.addElement("prpLEarNoList");
	if(null!= earList && earList.length>0){
		for(int i=0; i<earList.length; i++){
			strEar = earList[i];
			PrplcompensateearDto prplcompensateearDto = Utils.getPrplcompensateearDtobyEarNo(strPoliceNo, nodeType, strEar);
			System.out.println("prplcompensateearDto is "+prplcompensateearDto);
			if(null!=prplcompensateearDto){
				System.out.println("prplcompensateearDto earno is "+prplcompensateearDto.getEarno());
				setPrplcompensateearDtoToElement(prplcompensateearDto,root);
			}else{
				try{
					herdInsuranceList = Utils.findHerdpolicylist(strPoliceNo,strEar);
				}catch(java.lang.Exception e){
					System.out.println("Utils.findHerdinsurancelist throw exception!");
				}
				if(null!=herdInsuranceList && herdInsuranceList.size()==2){
					Collection insureMainListDtoList = (Collection)herdInsuranceList.toArray()[0];
					Collection herdPolicyListDtoList = (Collection)herdInsuranceList.toArray()[1];
					//�����жϱ����Ƿ��ж�����嵥�����û��������������Ŷ������жϣ�����ȥ�嵥�л�ȡ�������Ϣ��
					if(null != insureMainListDtoList && insureMainListDtoList.size()>0){
					
						if(null != herdPolicyListDtoList && herdPolicyListDtoList.size()>0){
							Iterator it = herdPolicyListDtoList.iterator();
							//���ڰ��ն���Ų�ѯ�����嵥���صĶ����б�ֻȡ��һ����
							HerdpolicylistDto herdpolicylistDto = new HerdpolicylistDto();
							while(it.hasNext()){
								herdpolicylistDto = (HerdpolicylistDto)it.next();
								break;
							}
							setHerdpolicylistDtoToElement(herdpolicylistDto,root);
						}else{
							setGetItFromToElement(strEar,root,"None");
						}
					}else if(Utils.checkPolicyBeforeOnlineDate(strPoliceNo)){// �������û���嵥���嵥�����ж��ǲ�������ֳ�ո���֮ǰ�ı���������ǣ����жϣ���������
						setGetItFromToElement(strEar,root,"PolicyBeforeOnlineDate");
					}else {// �������û���嵥���嵥���Ҳ�������ֳ�ո���֮ǰ�ı���������������
						setGetItFromToElement(strEar,root,"None");
					}
				}
			}
		}
	}
	System.out.println("xml is "+dom.asXML());
	//����xml��ʽ������
	out.print(dom.asXML());
%>
<%!
	private String[] getSplitedString(String str, String splitSign){
	 	String[] result = null;
	 	if(null != str || !"".equals(str)){
 			result = str.split(splitSign);
	 	}
	 	return result;
	 }
	 private void setPrplcompensateearDtoToElement(PrplcompensateearDto prplcompensateearDto,Element root){
	 	if(null!=prplcompensateearDto){
	 		Element temp = null;
	 		Element element = root.addElement("SingleEarNoInfo");
	 		temp = element.addElement("prpLearNo");
			temp.addText(prplcompensateearDto.getEarno());
			temp = element.addElement("fname");
			temp.addText(prplcompensateearDto.getName());
			temp = element.addElement("idCard");
			temp.addText(prplcompensateearDto.getId_card());
			temp = element.addElement("bank");
			temp.addText(prplcompensateearDto.getBank());
			temp = element.addElement("account");
			temp.addText(prplcompensateearDto.getAccount());
			temp = element.addElement("estimateLoss");
			temp.addText(String.valueOf(prplcompensateearDto.getEstimateloss()));
			temp = element.addElement("GetEarNoFrom");
			temp.addText("prplcompensateear");
	 	}
	 }
	 private void setHerdpolicylistDtoToElement(HerdpolicylistDto herdpolicylistDto,Element root){
	 	if(null!=herdpolicylistDto){
	 		Element temp = null;
	 		Element element = root.addElement("SingleEarNoInfo");
	 		temp = element.addElement("prpLearNo");
			temp.addText(herdpolicylistDto.getEarlabel());
			temp = element.addElement("fname");
			temp.addText(herdpolicylistDto.getFname());
			temp = element.addElement("idCard");
			temp.addText(herdpolicylistDto.getFidcard());
			temp = element.addElement("bank");
			temp.addText(herdpolicylistDto.getBank());
			temp = element.addElement("account");
			temp.addText(herdpolicylistDto.getBankcard());
			temp = element.addElement("estimateLoss");
			temp.addText("");
			temp = element.addElement("GetEarNoFrom");
			temp.addText("herdpolicylist");
	 	}
	 }
	 private void setGetItFromToElement(String earNo,Element root,String getItFrom){
	 	if(null!=earNo){
	 		Element temp = null;
	 		Element element = root.addElement("SingleEarNoInfo");
	 		temp = element.addElement("prpLearNo");
			temp.addText(earNo);
			temp = element.addElement("GetEarNoFrom");
			temp.addText(getItFrom);
	 	}
	 }
	 
	 
%>