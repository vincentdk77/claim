<%@	page contentType="text/html; charset=GBK"	language="java"	%>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<div id="outcontainer" style="width: 100%; padding-bottom: 8px; padding-top: 0px;">
	<div id="content_basic" style="width: 99%;">
		<span style="width: 99%; text-align: left; font-size: 12px">
			<img style="cursor: hand;" src="/claim/images/butExpandBlue.gif" name="PhoneExtImg" onclick="showPage(this,PhoneExt)">�绰��Ϣ<font color="red"></font>
		</span>
		<div id="PhoneExt">
			<table class="common" cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8">
				<tr height=20>
					<td align="center" rowspan="2">����</td>
					<td align="center" rowspan="2">���������ˡ���</td>
					<td align="center" rowspan="2">�ͻ�����</td>
					<td align="center" rowspan="2">${insuredName}</td>
					<td align="center">��ϵ�˵绰</td>
					<td align="center">${insuredMobilePhone}</td>
				</tr>
				<tr height=20>
					<td align="center">��ϵ���ֻ�</td>
					<td align="center">${insuredMobile}</td>
				</tr>
				<tr height=20>
					<td align="center" rowspan=4>��������</td>
					<td align="center" rowspan=4>��������Ϣ������</td>
					<td align="center">����������</td>
					<td align="center">${prplregistdto.reportorName }</td>
					<td align="center">�������</td>
					<td align="center">${prplregistdto.phoneNumber }</td>
				</tr>
				<tr height=20>
					<td align="center" rowspan=2>������������</td>
					<td align="center" rowspan=2>${prplregistdto.insuredName }</td>
					<td align="center">�������˹̶��绰</td>
					<td align="center">${prplregistdto.insuredPhone }</td>
				</tr>
				<tr height=20>
					<td align="center">���������ֻ���</td>
					<td align="center">${prplregistdto.insuredMobilePhone }</td>
				</tr>
				<tr height=20>
					<td align="center">��ʻԱ����</td>
					<td align="center">${prplregistdto.driverName }</td>
					<td align="center">��ʻԱ��ϵ�绰</td>
					<td align="center">${prplregistdto.driverPhone }</td>
				</tr>
				<tr height=20>
					<td align="center">���㹤��</td>
					<td align="center">����֤�ռ�����</td>
					<td align="center">�����ȫ��</td>
					<td align="center">${receiverfullname }</td>
					<td align="center">��ϵ�绰</td>
					<td align="center">${familyphone }</td>
				</tr>
			</table>
		</div>
	
		<span style="width: 99%; text-align: left; font-size: 12px">
			<img style="cursor: hand;" src="/claim/images/butExpandBlue.gif" name="RegistExtImg" onclick="showPage(this,RegistExt)">�ط���Ϣ<font color="red"></font>
		</span>
		<div id="RegistExt">
			<c:if test="${editType ne 'SHOW'}">
			<table class="common" cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8">
				<tr>
					<td class="title w15 textr">�������룺</td>
					<td class="input w35">
						${prplreturnvisitswflogDto.registno}
						<input type="hidden" name="prplreturnvisitswflogDtoRegistNo" id="prplreturnvisitswflogDtoRegistNo" value="${prplreturnvisitswflogDto.registno}"/>
						<input type="hidden" name="businessNo" id="businessNo" value="${prplreturnvisitswflogDto.registno}"/>
						<input type="hidden" name="serialno" id="serialno" value=""/>
						<input type="hidden" name="prplreturnvisitswflogDtoNodeType" id="prplreturnvisitswflogDtoNodeType" value="${nodeType}"/>
						<input type="hidden" name="nodeType" id="nodeType" value="${nodeType}"/>
					</td>
					<td class="title w15 textr">�б�������</td>
					<td class="input">
						${prplreturnvisitswflogDto.comcodename}
						<input type="hidden" name="comcodename" id="comcodename" value="${prplreturnvisitswflogDto.comcodename}"/>
						<input type="hidden" name="comcode" id="comcode" value="${prplreturnvisitswflogDto.comcode}"/>
					</td>
				</tr>
				<tr>
					<td class="title textr">���ط��ˣ�</td>
					<td class="input">
					    <!-- �ɹ��ط� -->
					    <c:if test="${prplreturnvisitswflogDto.nodetype eq 'sched'}">
						<input type="text" id="visitname" class="input w95" name='visitname' cmax="50" cname="���ط���" value="${prplregistdto.reportorName}"/><font color="red">*</font>
						</c:if>
						<!-- �᰸�ط� -->
					    <c:if test="${prplreturnvisitswflogDto.nodetype eq 'endca'}">
						<input type="text" id="visitname" class="input w95" name='visitname' cmax="50" cname="���ط���" value="${prplregistdto.insuredName}"/><font color="red">*</font>
						</c:if>	
						<!-- ���ǽ᰸���ɹ��ط� -->
					    <c:if test="${prplreturnvisitswflogDto.nodetype ne 'endca' and prplreturnvisitswflogDto.nodetype ne 'sched' }">
						<input type="text" id="visitname" class="input w95" name='visitname' cmax="50" cname="���ط���" value="${prplregistdto.insuredName}"/><font color="red">*</font>
						</c:if>	
											
					</td>
					<td class="title textr">��ϵ���룺</td>
					<td class="input">
					 <c:if test="${prplreturnvisitswflogDto.nodetype eq 'sched'||prplreturnvisitswflogDto.nodetype eq 'endca'}">
						<input type="text" id="contact" class="input w95" name='contact' cmax="20" cname="��ϵ����" value="${tel}"/><font color="red">*</font>
					 </c:if>
					 <c:if test="${prplreturnvisitswflogDto.nodetype ne 'endca' and prplreturnvisitswflogDto.nodetype ne 'sched'}">				   
						<input type="text" id="contact" class="input w95" name='contact' cmax="20" cname="��ϵ����" value=""/><font color="red">*</font>							
					 </c:if>					 
					</td>
				</tr>
				<tr>
					<td class="title textr">¼����ˮ�ţ�</td>
					<td class="input">
						<input type="text" id="" class="input w95" name='recorderno' cname="¼����ˮ��" value="" maxlength="20"/>
					</td>
					<td class="title textr">��������ȣ�</td>
					<td class="input">
						<select name="serviceSelect" onclick="selectBut(this,'service');" onchange="turnIssue();"  cname="���������" >
							<option value="0">��ѡ��</option>
							<c:forEach items="${prpDcodeSatisfied}" var="satisfied">
								<option value="${satisfied.codeCode}">${satisfied.codeCName }</option>
							</c:forEach>
						</select>
						<input type="hidden" name="service" id="service" value=""><font id="mustWriteSign" color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title textr">�������⣺</td>
					<td class="input" class="input pleft5" colspan="3">
						<c:forEach items="${prpDcodeVisitIssue}" var="visitIssue">
							<input type="checkbox" name="existissueBox" id="existissueBox" onclick="checkboxBut(this);" value="${visitIssue.codeCode}"/>${visitIssue.codeCName}
						</c:forEach>
						<input type="hidden" size="10" name="existissue" id="existissue" value="">
					</td>
				</tr>
				<tr>
					<td class="title textr">�Ƿ�طóɹ���</td>
					<td class="input textl pleft5">
						<input type="radio" id="" name="visitsuccessRadio" value="1" onclick="selectBut(this,'visitsuccess');defeatedBut(this);toggleRadio(this);">��
						<input type="radio" id="" name="visitsuccessRadio" value="0" onclick="selectBut(this,'visitsuccess');defeatedBut(this);toggleRadio(this);">��<font color="red">*</font>
						<input type="hidden" size="5" name="visitsuccess" id="visitsuccess" value="">
						<%//�ж��Ƿ�طóɹ� %>
						<input type="hidden" size="5" name="visitsuccessState" id="visitsuccessState" value="0">
						
						<div id=divfailradio style="display:none">
							<input type="radio" id="" name="visitfailRadio" value="1" onclick="selectBut(this,'visitfail');selectBut(this,'visitfailState');">�����
							<input type="radio" id="" name="visitfailRadio" value="0" onclick="selectBut(this,'visitfail');selectBut(this,'visitfailState');">�������<font color="red">*</font>
							<input type="hidden" size="5" name="visitfail" id="visitfail" value="">
							<input type="hidden" size="5" name="visitfailState" id="visitfailState" value="0">
						</div>
					</td>
					<td class="title textr">���ɹ�ԭ��</td>
					<td class="input">
						<select name="visitnocauseSelect" onclick="selectBut(this,'visitnocause')" cname="���ɹ�ԭ��">
							<option value="0">��ѡ��</option>
							<c:forEach items="${prpDcodeFailCause}" var="failCause">
								<option value="${failCause.codeCode}">${failCause.codeCName }</option>
							</c:forEach>
						</select>
						<input type="hidden" name="visitnocause" id="visitnocause" value=""><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title textr">�ط������</td>
					<td class="input" colspan="3">
						<input type="hidden" id="visitopinion" class="input w99" cmax="400" name='visitopinion' value="" cname="�ط����"/>
						<textarea class="input w99" rows="4" onchange="textareaValue(this)"></textarea>
					</td>
				</tr>
				<tr>
					<td class="title textr">�ط���Ա��</td>
					<td class="input">
						${user.userName}
						<input type="hidden" name="enteringcode" id="enteringcode" value="">
						<input type="hidden" name="enteringname" id="enteringname" value="">
						<input type="hidden" name="enteringcomcode" id="enteringcomcode" value="">
					</td>
					<td class="title textr">���ʱ�䣺</td>
					<td class="input">
						<input type="hidden" name="enteringtime" id="enteringtime" value="">
					</td>
				</tr>
			</table>
			<!-- ���ӱ���� -->
			<br><br>
			</c:if>		
			<c:forEach items="${prplreturnvisitDtoList}" var="prplreturnvisitDto" varStatus="count">
			<table id="RegistExt" class="common" cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8">
				<tr>
					<td class="title w15 textr">�������룺</td>
					<td class="input w35">
						${prplreturnvisitDto.businessNo}
						<input type="hidden" name="businessNo" id="registNo" value="${prplreturnvisitDto.businessNo}"/>
						<input type="hidden" name="serialno" id="serialno" value="${prplreturnvisitDto.serialno}"/>
						<input type="hidden" name="nodeType" id="nodeType" value="${prplreturnvisitDto.nodetype}"/>
					</td>
					<td class="title w15 textr">�б�������</td>
					<td class="input">
						${prplreturnvisitswflogDto.comcodename}
					</td>
				</tr>
				<tr>
					<td class="title textr">���ط��ˣ�</td>
					<td class="input">
						<input type="text" id="" class="input w95"  name='' value="${prplreturnvisitDto.visitname}" disabled="disabled"/><font color="red">*</font>
						<input type="hidden" id="" class="input w99" name='visitname' value="${prplreturnvisitDto.visitname}"/>
					</td>
					<td class="title textr">��ϵ���룺</td>
					<td class="input">
						<input type="text" id="" class="input w95"  name='' value="${prplreturnvisitDto.contact}" disabled="disabled"/><font color="red">*</font>
						<input type="hidden" id="" class="input w99" name='contact' value="${prplreturnvisitDto.contact}"/>
					</td>
				</tr>
				<tr>
					<td class="title textr">¼����ˮ�ţ�</td>
					<td class="input">
						<input type="text" id="" class="input w95" name='' value="${prplreturnvisitDto.recorderno}" disabled="disabled"/>
						<input type="hidden" id="" class="input w99" name='recorderno' value="${prplreturnvisitDto.recorderno}"/>
					</td>
					<td class="title textr">��������ȣ�</td>
					<td class="input">
						<select name="serviceSelect" onclick="selectBut(this,'service')" disabled="disabled" >
							<option value="0">��ѡ��</option>
							<c:forEach items="${prpDcodeSatisfied}" var="satisfied">
								<option value="${satisfied.codeCode}" <c:if test="${satisfied.codeCode eq prplreturnvisitDto.service}"> selected </c:if> >${satisfied.codeCName}</option>
							</c:forEach>
						</select>
						<input type="hidden" name="service" id="service" value="${prplreturnvisitDto.service}"><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title textr">�������⣺</td>
					<td class="input" class="input pleft5" colspan="3">
						<c:forEach items="${prpDcodeVisitIssue}" var="visitIssue">
							<input type="checkbox" name="existissueBox" id="existissueBox" onclick="checkboxBut(this);" value="${visitIssue.codeCode}" <c:if test="${fn:contains(prplreturnvisitDto.existissue,visitIssue.codeCode)}">checked="" </c:if> disabled="disabled"/>${visitIssue.codeCName}
						</c:forEach>
						<input type="hidden" size="10" name="existissue" id="existissue" value="${prplreturnvisitDto.existissue}"><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title textr">�Ƿ�طóɹ���</td>
					<td class="input textl pleft5">
						<input type="radio" id="" name="visitsuccessRadio${count.index}" value="1" onclick="selectBut(this,'visitsuccess');defeatedBut(this);" <c:if test="${prplreturnvisitDto.visitsuccess eq '1'}">checked="checked"</c:if> disabled="disabled">��
						<input type="radio" id="" name="visitsuccessRadio${count.index}" value="0" onclick="selectBut(this,'visitsuccess');defeatedBut(this);" <c:if test="${prplreturnvisitDto.visitsuccess eq '0'}">checked="checked"</c:if> disabled="disabled">��<font color="red">*</font>
						<input type="hidden" size="5" name="visitsuccess" id="visitsuccess" value="${prplreturnvisitDto.visitsuccess}">
						
						<div id="divfailradio${count.index}" <c:if test="${prplreturnvisitDto.visitsuccess eq '1'}">style="display:none"</c:if>>
							<input type="radio" id="" name="visitfailRadio${count.index}" value="1" <c:if test="${prplreturnvisitDto.visitfail eq '1'}">checked="checked"</c:if> disabled="disabled">�����
							<input type="radio" id="" name="visitfailRadio${count.index}" value="0" <c:if test="${prplreturnvisitDto.visitfail eq '0'}">checked="checked"</c:if> disabled="disabled">�������<font color="red">*</font>
							<input type="hidden" size="5" name="visitfail" id="visitfail" value="${prplreturnvisitDto.visitfail}">
						</div>
					</td>
					<td class="title textr">���ɹ�ԭ��</td>
					<td class="input">
						<select name="visitnocauseSelect" onclick="selectBut(this,'visitnocause')" disabled="disabled">
							<option value="0">��ѡ��</option>
							<c:forEach items="${prpDcodeFailCause}" var="failCause">
								<option value="${failCause.codeCode}" <c:if test="${failCause.codeCode eq prplreturnvisitDto.visitnocause}"> selected </c:if> >${failCause.codeCName }</option>
							</c:forEach>
						</select>
						<input type="hidden" name="visitnocause" id="visitnocause" value="${prplreturnvisitDto.visitnocause}"><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title textr">�ط������</td>
					<td class="input" colspan="3">
						<textarea class="input w99"  rows="4"  disabled="disabled">${prplreturnvisitDto.visitopinion}</textarea>
						<input type="hidden" id="visitopinion" class="input w99"  name='visitopinion' value="${prplreturnvisitDto.visitopinion}"/>
					</td>
				</tr>
				<tr>
					<td class="title textr">�ط���Ա��</td>
					<td class="input">
						${prplreturnvisitDto.enteringname}
						<input type="hidden" name="enteringcode" id="enteringcode" value="${prplreturnvisitDto.enteringcode}">
						<input type="hidden" name="enteringname" id="enteringname" value="${prplreturnvisitDto.enteringname}">
						<input type="hidden" name="enteringcomcode" id="enteringcomcode" value="${prplreturnvisitDto.enteringcomcode}">
					</td>
					<td class="title textr">���ʱ�䣺</td>
					<td class="input">
						${prplreturnvisitDto.enteringtime}
						<input type="hidden" name="enteringtime" id="enteringtime" value="${prplreturnvisitDto.enteringtime}">
					</td>
				</tr>
			</table>
			<br><br>
			</c:forEach>
		</div>
	</div>
</div>