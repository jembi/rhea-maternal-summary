<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:hasPrivilege privilege="View Encounters">

<c:choose>
<c:when test="${model.isPatientFemale}">
<div>
	<form method="post" action="${pageContext.request.contextPath}/moduleServlet/maternalsummary/renderPDFServlet">
		<input type="hidden" name="redir" value="${pageContext.request.contextPath}/patientDashboard.form?patientId=<%=request.getParameter("patientId")%>"/>
		<input type="hidden" name="patientId" value="<%=request.getParameter("patientId")%>"/>
		<input type="submit" value='<spring:message code="maternalsummary.exportToPdf" />'>
	</form>
	<form method="post" action="${pageContext.request.contextPath}/moduleServlet/maternalsummary/refreshFromSHRServlet">
		<input type="hidden" name="redir" value="${pageContext.request.contextPath}/patientDashboard.form?patientId=<%=request.getParameter("patientId")%>"/>
		<input type="hidden" name="patientId" value="<%=request.getParameter("patientId")%>"/>
		<input type="submit" value='<spring:message code="maternalsummary.refreshFromSHR" />'>
	</form>
	<br/>
</div>
<b class="boxHeader"><spring:message code="maternalsummary.obsHistory" /></b>
<div class="box">
	<table width="63%">
	<tbody>
		<tr>
			<td style="vertical-align: top;">
				<fieldset>
				<legend><spring:message code="maternalsummary.numberOf" /></legend>
					<table cellpadding="5">
					<tbody>
						<tr><td><spring:message code="maternalsummary.pregnancies" /></td><td><b>${model.obsHistory.numPregnancies}</b></td></tr>
						<tr><td><spring:message code="maternalsummary.births" /></td><td><b>${model.obsHistory.numBirths}</b></td></tr>
						<tr><td><spring:message code="maternalsummary.liveBirths" /></td><td><b>${model.obsHistory.numLiveBirths}</b></td></tr>
						<tr><td><spring:message code="maternalsummary.stillBirths" /></td><td><b>${model.obsHistory.numStillBirths}</b></td></tr>
						<tr><td><spring:message code="maternalsummary.cSections" /></td><td><b>${model.obsHistory.numCSections}</b></td></tr>
					</tbody>
					</table>
				</fieldset>
			</td>
			<td style="vertical-align: top;">
				<table>
				<tbody>
				<tr><td>
					<fieldset>
					<legend><spring:message code="maternalsummary.lastBorn" /></legend>
						<table cellpadding="5">
						<tbody>
							<tr>
								<td><spring:message code="maternalsummary.status" /></td>
								<c:choose>
									<c:when test="${model.obsHistory.lastBornAlive == null}">
										<td></td>
									</c:when>
									<c:when test="${model.obsHistory.lastBornAlive}">
										<td><b><spring:message code="maternalsummary.alive" /></b></td>
									</c:when>
									<c:when test="${!model.obsHistory.lastBornAlive}">
										<td><b><spring:message code="maternalsummary.dead" /></b></td>
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr><td><spring:message code="maternalsummary.birthDate" /></td><td><b><openmrs:formatDate date="${model.obsHistory.lastBornBirthDate}" type="medium" /></b></td></tr>
						</tbody>
						</table>
					</fieldset>
				</td></tr>
				<tr><td>
					<table cellpadding="5">
					<tbody>
						<tr><td><spring:message code="maternalsummary.dateOfLMP" /></td><td><b><openmrs:formatDate date="${model.obsHistory.dateOfLMP}" type="medium" /></b></td></tr>
						<tr><td><spring:message code="maternalsummary.expectedDeliveryDate" /></td><td><b><openmrs:formatDate date="${model.obsHistory.expectedDeliveryDate}" type="medium" /></b></td></tr>
					</tbody>
					</table>
				</td></tr>
				</tbody>
				</table>
			</td>
			<td style="vertical-align: top;">
				<table cellpadding="5">
				<tbody>
					<tr>
						<td><spring:message code="maternalsummary.gestationalAge" /></td>
						<td>
							<c:choose>
								<c:when test="${model.obsHistory.gestationalAge != null}">
									<b>${model.obsHistory.gestationalAge} <spring:message code="maternalsummary.weeks" /></b>
								</c:when>
							</c:choose>
						</td>
					</tr>
					<tr><td><spring:message code="maternalsummary.childsPresentation" /></td><td><b>${model.obsHistory.presentation}</b></td></tr>
					<%-- <tr>
						<c:choose>
							<c:when test="${model.obsHistory.isSeroPositive}">
								<td><spring:message code="maternalsummary.highestWHOStage" /></td><td><b>${model.obsHistory.highestWHOStage}</b></td>
							</c:when>
						</c:choose>
					</tr> --%>
				</tbody>
				</table>
			</td>
			<td style="vertical-align: top;">
				<fieldset>
				<legend><spring:message code="maternalsummary.risks" /></legend>
				<table cellpadding="5">
				<tbody>
					<c:forEach var="risk" items="${model.obsHistory.risks}">
					<tr>
						<td><openmrs:formatDate date="${risk.dateReported}" type="medium"/></td>
						<td>${risk.risk}</td>
					</tr>
					</c:forEach>
				</tbody>
				</table>
				</fieldset>
			</td>
			<td style="vertical-align: top;">
				<fieldset>
				<legend><spring:message code="maternalsummary.obsRisks" /></legend>
				<table cellpadding="5">
				<tbody>
					<c:forEach var="obsRisk" items="${model.obsHistory.obsRisks}">
					<tr>
						<td><openmrs:formatDate date="${obsRisk.dateReported}" type="medium"/></td>
						<td>${obsRisk.risk}</td>
					</tr>
					</c:forEach>
				</tbody>
				</table>
				</fieldset>
			</td>
			<td style="vertical-align: top;">
				<fieldset>
				<legend><spring:message code="maternalsummary.pastMedicalHistory" /></legend>
				<table cellpadding="5">
					<tbody>
					<c:forEach var="historyItem" items="${model.medicalHistory.history}">
						<tr>
							<td><openmrs:formatDate date="${historyItem.date}" type="medium" /></td>
							<td>${historyItem.history}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				</fieldset>
			</td>
		</tr>
	</tbody>
	</table>

</div>
<b class="boxHeader"><spring:message code="maternalsummary.previousPregnancies" /></b>
<div class="box">
	<table cellpadding="5">
	<thead>
		<tr>
			<th><spring:message code="maternalsummary.no" /></th>
			<th><spring:message code="maternalsummary.date" /></th>
			<th><spring:message code="maternalsummary.modeOfDelivery" /></th>
			<th><spring:message code="maternalsummary.typeOfBirth" /></th>
			<th><spring:message code="maternalsummary.birthWeight" /></th>
			<th><spring:message code="maternalsummary.gender" /></th>
			<th><spring:message code="maternalsummary.pretermTerm" /></th>
			<th><spring:message code="maternalsummary.bloodLossAtDelivery" /></th>
			<th><spring:message code="maternalsummary.maternalOutcome" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dsItem" items="${model.deliverySummary}">
		<tr>
			<td>${dsItem.number}</td>
			<td><openmrs:formatDate date="${dsItem.dateTime}" type="medium"/></td>
			<td>${dsItem.modeOfDelivery}</td>
			<td>${dsItem.typeOfBirth}</td>
			<td>${dsItem.birthWeight} kg</td>
			<td>${dsItem.gender}</td>
			<td>${dsItem.pretermOrTerm}</td>
			<td>${dsItem.bloodLoss}</td>
			<td>${dsItem.maternalOutcome}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
<b class="boxHeader"><spring:message code="maternalsummary.ancVisits" /></b>
<div class="box">
	<table cellpadding="5">
	<thead>
		<tr>
			<th><spring:message code="maternalsummary.date" /></th>
			<th><spring:message code="maternalsummary.gestationalAge" /></th>
			<th><spring:message code="maternalsummary.weight" /></th>
			<th><spring:message code="maternalsummary.weightChange" /></th>
			<th><spring:message code="maternalsummary.bloodPressure" /></th>
			<th><spring:message code="maternalsummary.temperature" /></th>
			<th><spring:message code="maternalsummary.fundalHeight" /></th>
			<th><spring:message code="maternalsummary.fetalHeartRate" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ANCVisit" items="${model.ANCVisits}">
		<tr>
			<td><openmrs:formatDate date="${ANCVisit.date}" type="medium" /></td>
			<td>${ANCVisit.weeksPregnant} <spring:message code="maternalsummary.weeks" /></td>
			<td>${ANCVisit.weight} kg</td>
			<td>${ANCVisit.weightChange} kg</td>
			<td>${ANCVisit.bloodPressureSystolic} / ${ANCVisit.bloodPressureDiastolic} mmHg</td>
			<td>${ANCVisit.temperature} °C</td>
			<td>${ANCVisit.uterusLength} cm</td>
			<td>${ANCVisit.fetalHeartRate} bpm</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
<b class="boxHeader"><spring:message code="maternalsummary.medicationsAndTreatment" /></b>
<div class="box">
	<table>
		<tbody>
		<tr>
			<td style="vertical-align: top;">
				<fieldset>
				<legend><spring:message code="maternalsummary.currentMedication" /></legend>
				<table cellpadding="5">
					<tbody>
					<c:forEach var="medicationItem" items="${model.medicalHistory.medication}">
						<tr>
							<td><openmrs:formatDate date="${medicationItem.date}" type="medium" /></td>
							<td>${medicationItem.medication}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				</fieldset>
			</td>
			<td style="vertical-align: top;">
			<fieldset>
			<legend><spring:message code="maternalsummary.treatmentInterventions" /></legend>
			<table cellpadding="5">
				<tbody>
				<c:forEach var="intervention" items="${model.testsAndTreatment.interventions}">
					<tr>
						<td><openmrs:formatDate date="${intervention.date}" type="medium" /></td>
						<td><spring:message code="maternalsummary.given" /> ${intervention.intervention}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</fieldset>
			</td>
		</tr>
		</tbody>
	</table>
</div>
<b class="boxHeader"><spring:message code="maternalsummary.lab" /></b>
<div class="box">
	<table>
		<tbody>
		<tr>
			<td style="vertical-align: top;">
			<table cellpadding="5">
				<thead>
					<tr>
						<th><b><spring:message code="maternalsummary.date" /></b></th>
						<th><b><spring:message code="maternalsummary.test" /></b></th>
						<th><b><spring:message code="maternalsummary.result" /></b></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
					<c:when test="${model.testsAndTreatment.tests.HIVTestDate!=null}">
					<tr>
						<td><openmrs:formatDate date="${model.testsAndTreatment.tests.HIVTestDate}" type="medium" /></td>
						<td>HIV</td>
						<td>${model.testsAndTreatment.tests.HIVResult}</td>
					</tr>
					</c:when>
					</c:choose>
					<c:choose>
					<c:when test="${model.testsAndTreatment.tests.RPRTestDate!=null}">
					<tr>
						<td><openmrs:formatDate date="${model.testsAndTreatment.tests.RPRTestDate}" type="medium" /></td>
						<td>RPR</td>
						<td>${model.testsAndTreatment.tests.RPRResult}</td>
					</tr>
					</c:when>
					</c:choose>
					<%--
					<c:forEach var="spw" items="${model.testsAndTreatment.seroPositiveWomen}">
					<tr>
						<td><openmrs:formatDate date="${spw.CD4CountDate}" type="medium" /></td>
						<td>CD4 Count</td>
						<td>${spw.CD4Count}</td>
					</tr>
					<tr>
						<td></td>
						<td>Creatinine Level</td>
						<td>${spw.creatinineLevel} mmol/L</td>
					</tr>
					</c:forEach>
					--%>
				</tbody>
			</table>
			<br/>
			<table>
				<tbody>
					<tr>
						<td><span title='<spring:message code="maternalsummary.treatedForSyphilisLong" />'><spring:message code="maternalsummary.treatedForSyphilisShort" /></span></td>
						<td><b>${model.testsAndTreatment.tests.treatedForSyphilis}</b></td>
					</tr>
				</tbody>
			</table>
			</td>
			<td style="vertical-align: top;">
			<fieldset>
			<legend><spring:message code="maternalsummary.partnerTesting" /></legend>
			<table cellpadding="5">
				<thead>
					<tr>
						<th><b><spring:message code="maternalsummary.date" /></b></th>
						<th><b><spring:message code="maternalsummary.test" /></b></th>
						<th><b><spring:message code="maternalsummary.result" /></b></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
					<c:when test="${model.testsAndTreatment.partnerTests.HIVTestDate!=null}">
					<tr>
						<td><openmrs:formatDate date="${model.testsAndTreatment.partnerTests.HIVTestDate}" type="medium" /></td>
						<td>HIV</td>
						<td>${model.testsAndTreatment.partnerTests.HIVResult}</td>
					</tr>
					</c:when>
					</c:choose>
					<c:choose>
					<c:when test="${model.testsAndTreatment.partnerTests.RPRTestDate!=null}">
					<tr>
						<td><openmrs:formatDate date="${model.testsAndTreatment.partnerTests.RPRTestDate}" type="medium" /></td>
						<td>RPR</td>
						<td>${model.testsAndTreatment.partnerTests.RPRResult}</td>
					</tr>
					</c:when>
					</c:choose>
				</tbody>
			</table>
			<br/>
			<table>
				<tbody>
					<tr>
						<td><span title='<spring:message code="maternalsummary.partnerTreatedForSyphilisLong" />'><spring:message code="maternalsummary.partnerTreatedForSyphilisShort" /></span></td>
						<td><b>${model.testsAndTreatment.partnerTests.treatedForSyphilis}</b></td>
					</tr>
				</tbody>
			</table>
			</fieldset>
			</td>
		</tr>
		</tbody>
	</table>
</div>

<%--
<b class="boxHeader"><spring:message code="maternalsummary.arvRegimens" /></b>
<div class="box">
	<table>
		<tbody>
		<tr>
			<td style="vertical-align: top;">
			<table cellpadding="5">
				<thead>
					<tr>
						<th><spring:message code="maternalsummary.arvDate" /></th>
						<th><spring:message code="maternalsummary.arvRegimen" /></th>
						<th><spring:message code="maternalsummary.cotrimoxazoleDate" /></th>
						<th><spring:message code="maternalsummary.whoStage" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="spw" items="${model.testsAndTreatment.seroPositiveWomen}">
						<tr>
							<td><openmrs:formatDate date="${spw.ARVProphylaxisDate}" type="medium" /></td>
							<td>${spw.ARVProphylaxis}</td>
							<td><openmrs:formatDate date="${spw.cotrimoxazoleStartDate}" type="medium" /></td>
							<td>${spw.WHOStage}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</td>
		</tr>
		</tbody>
	</table>
</div>
--%>

<b class="boxHeader"><spring:message code="maternalsummary.referrals" /></b>
<div class="box">
	<c:choose>
		<c:when test="${model.referrals.referredButNotConfirmed}">
			<p><spring:message code="maternalsummary.hasBeenReferredButNotConfirmed" /></p>
			<p><b><span style="color: #FF0000;"><spring:message code="maternalsummary.hasBeenReferredButNotConfirmedWarning" /></span></b></p>
			<p><a href="http://poc.jembi.org:8080/openmrs_1.6.5_v/module/htmlformentry/htmlFormEntry.form?personId=<%=request.getParameter("patientId")%>&patientId=<%=request.getParameter("patientId")%>&returnUrl=&formId=10">Referral Confirmation Form</a></p>
		</c:when>
	</c:choose>
	<table>
		<tbody>
		<tr>
			<td style="vertical-align: top;">
			<fieldset>
			<legend><spring:message code="maternalsummary.referrals" /></legend>
			<table cellpadding="5">
				<thead>
					<tr>
						<th><b><spring:message code="maternalsummary.date" /></b></th>
						<th><b><spring:message code="maternalsummary.referralLocation" /></b></th>
						<th><b><spring:message code="maternalsummary.referralUrgency" /></b></th>
						<th><b><spring:message code="maternalsummary.referralReason" /></b></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="referral" items="${model.referrals.referrals}">
						<tr>
							<td><openmrs:formatDate date="${referral.date}" type="medium" /></td>
							<td>${referral.referredTo}</td>
							<td>${referral.urgency}</td>
							<td>${referral.reason}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</fieldset>
			</td>
			<td style="vertical-align: top;">
			<fieldset>
			<legend><spring:message code="maternalsummary.confirmations" /></legend>
			<table cellpadding="5">
				<thead>
					<tr>
						<th><b><spring:message code="maternalsummary.date" /></b></th>
						<th><b><spring:message code="maternalsummary.comments" /></b></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="confirmation" items="${model.referrals.confirmations}">
						<tr>
							<td><openmrs:formatDate date="${confirmation.date}" type="medium" /></td>
							<td>${confirmation.comments}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</fieldset>
			</td>
		</tr>
		</tbody>
	</table>
</div>

<b class="boxHeader"><spring:message code="maternalsummary.rapidsmsMsg" /></b>
<div class="box">
	<table>
		<tbody>
		<tr>
			<td style="vertical-align: top;">
			<table cellpadding="5">
				<thead>
					<tr>
						<th><spring:message code="maternalsummary.date" /></th>
						<th><spring:message code="maternalsummary.rapidsmsEncounterType" /></th>
						<th><spring:message code="maternalsummary.rapidsmsCode" /></th>
						<th><spring:message code="maternalsummary.rapidsmsName" /></th>
						<th><spring:message code="maternalsummary.rapidsmsValue" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="rsms" items="${model.rapidsmsMessages}">
						<tr>
							<td><openmrs:formatDate date="${rsms.date}" type="medium" /></td>
							<td>${rsms.type}</td>
							<td>${rsms.code}</td>
							<td>${rsms.name}</td>
							<td>${rsms.value}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</td>
		</tr>
		</tbody>
	</table>
</div>
</c:when>
<c:otherwise>
<div>
<spring:message code="maternalsummary.patientIsMale" />
</div>
</c:otherwise>
</c:choose>

</openmrs:hasPrivilege>
