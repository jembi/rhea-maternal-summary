<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:hasPrivilege privilege="View Encounters">
<div>
	<form method="post" action="${pageContext.request.contextPath}/moduleServlet/maternalsummary/renderPDFServlet">
		<input type="hidden" name="redir" value="${pageContext.request.contextPath}/patientDashboard.form?patientId=<%=request.getParameter("patientId")%>"/>
		<input type="hidden" name="patientId" value="<%=request.getParameter("patientId")%>"/>
		<input type="submit" value="Export to PDF">
	</form>
	<br/>
</div>
<b class="boxHeader">Obs History</b>
<div class="box">
	<table width="63%">
	<tbody>
		<tr>
			<td style="vertical-align: top;">
				<fieldset>
				<legend>Number of</legend>
					<table cellpadding="5">
					<tbody>
						<tr><td>Pregnancies</td><td><b>${model.obsHistory.numPregnancies}</b></td></tr>
						<tr><td>Births</td><td><b>${model.obsHistory.numBirths}</b></td></tr>
						<tr><td>Live Births</td><td><b>${model.obsHistory.numLiveBirths}</b></td></tr>
						<tr><td>Still Births</td><td><b>${model.obsHistory.numStillBirths}</b></td></tr>
						<tr><td>C-Sections</td><td><b>${model.obsHistory.numCSections}</b></td></tr>
					</tbody>
					</table>
				</fieldset>
			</td>
			<td style="vertical-align: top;">
				<table>
				<tbody>
				<tr><td>
					<fieldset>
					<legend>Last Born</legend>
						<table cellpadding="5">
						<tbody>
							<tr>
								<td>Status</td>
								<c:choose>
									<c:when test="${model.obsHistory.lastBornAlive == null}">
										<td></td>
									</c:when>
									<c:when test="${model.obsHistory.lastBornAlive}">
										<td><b>Alive</b></td>
									</c:when>
									<c:when test="${!model.obsHistory.lastBornAlive}">
										<td><b>Dead</b></td>
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr><td>Birth Date</td><td><b><openmrs:formatDate date="${model.obsHistory.lastBornBirthDate}" type="medium" /></b></td></tr>
						</tbody>
						</table>
					</fieldset>
				</td></tr>
				<tr><td>
					<table cellpadding="5">
					<tbody>
						<tr><td>Date of LMP</td><td><b><openmrs:formatDate date="${model.obsHistory.dateOfLMP}" type="medium" /></b></td></tr>
						<tr><td>Expected Delivery Date</td><td><b><openmrs:formatDate date="${model.obsHistory.expectedDeliveryDate}" type="medium" /></b></td></tr>
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
						<td>Gestational Age</td>
						<td>
							<c:choose>
								<c:when test="${model.obsHistory.gestationalAge != null}">
									<b>${model.obsHistory.gestationalAge} weeks</b>
								</c:when>
							</c:choose>
						</td>
					</tr>
					<tr><td>Child's presentation inside</td><td><b>${model.obsHistory.presentation}</b></td></tr>
					<tr>
						<c:choose>
							<c:when test="${model.obsHistory.isSeroPositive}">
								<td>Highest WHO Stage</td><td><b>${model.obsHistory.highestWHOStage}</b></td>
							</c:when>
						</c:choose>
					</tr>
				</tbody>
				</table>
			</td>
			<td style="vertical-align: top;">
				<fieldset>
				<legend>Risks</legend>
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
				<legend>Past Medical History</legend>
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
<b class="boxHeader">Previous Pregnancies</b>
<div class="box">
	<table cellpadding="5">
	<thead>
		<tr>
			<th>No.</th>
			<th>Date/Time</th>
			<th>Mode of Delivery</th>
			<th>Type of Birth</th>
			<th>Birth Weight</th>
			<th>Gender</th>
			<th>Preterm/Term</th>
			<th>Blood Loss at delivery</th>
			<th>Maternal Outcome</th>
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
<b class="boxHeader">ANC Visits</b>
<div class="box">
	<table cellpadding="5">
	<thead>
		<tr>
			<th>Date</th>
			<th>Gestational Age</th>
			<th>Weight</th>
			<th>Blood Pressure</th>
			<th>Temperature</th>
			<th>Fundal Height</th>
			<th>Fetal Heart Rate</th>
			<th>Presentation</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ANCVisit" items="${model.ANCVisits}">
		<tr>
			<td><openmrs:formatDate date="${ANCVisit.date}" type="medium" /></td>
			<td>${ANCVisit.weeksPregnant} weeks</td>
			<td>${ANCVisit.weight} kg</td>
			<td>${ANCVisit.bloodPressureSystolic} / ${ANCVisit.bloodPressureDiastolic}</td>
			<td>${ANCVisit.temperature} °C</td>
			<td>${ANCVisit.uterusLength} cm</td>
			<td>${ANCVisit.fetalHeartRate}</td>
			<td>${ANCVisit.presentation}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
<b class="boxHeader">Medications and Treatment</b>
<div class="box">
	<table>
		<tbody>
		<tr>
			<td style="vertical-align: top;">
				<fieldset>
				<legend>Current Medication</legend>
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
			<legend>Treatment Interventions</legend>
			<table cellpadding="5">
				<tbody>
				<c:forEach var="intervention" items="${model.testsAndTreatment.interventions}">
					<tr>
						<td><openmrs:formatDate date="${intervention.date}" type="medium" /></td>
						<td>Given ${intervention.intervention}</td>
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
<b class="boxHeader">Lab</b>
<div class="box">
	<table>
		<tbody>
		<tr>
			<td style="vertical-align: top;">
			<fieldset>
			<legend>Testing</legend>
			<table cellpadding="5">
				<thead>
					<tr>
						<th><b>Date</b></th>
						<th><b>Test</b></th>
						<th><b>Result</b></th>
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
				</tbody>
			</table>
			<br/>
			<table>
				<tbody>
					<tr>
						<td>Syphilis Treatment</td>
						<td><b>${model.testsAndTreatment.tests.treatedForSyphilis}</b></td>
					</tr>
				</tbody>
			</table>
			</fieldset>
			</td>
			<td style="vertical-align: top;">
			<fieldset>
			<legend>Partner Testing</legend>
			<table cellpadding="5">
				<thead>
					<tr>
						<th><b>Date</b></th>
						<th><b>Test</b></th>
						<th><b>Result</b></th>
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
						<td>Syphilis Treatment</td>
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
<b class="boxHeader">ARV Regimens</b>
<div class="box">
	<table>
		<tbody>
		<tr>
			<td style="vertical-align: top;">
			<table cellpadding="5">
				<thead>
					<tr>
						<th>Creatinine Level</th>
						<th>CD4 Date</th>
						<th>CD4 Count</th>
						<th>WHO Stage</th>
						<th>ARV Date</th>
						<th>ARV Regimen</th>
						<th>Cotrimoxazole Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="spw" items="${model.testsAndTreatment.seroPositiveWomen}">
						<tr>
							<td>${spw.creatinineLevel} mmol/L</td>
							<td><openmrs:formatDate date="${spw.CD4CountDate}" type="medium" /></td>
							<td>${spw.CD4Count}</td>
							<td>${spw.WHOStage}</td>
							<td><openmrs:formatDate date="${spw.ARVProphylaxisDate}" type="medium" /></td>
							<td>${spw.ARVProphylaxis}</td>
							<td><openmrs:formatDate date="${spw.cotrimoxazoleStartDate}" type="medium" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</td>
		</tr>
		</tbody>
	</table>
</div>
</openmrs:hasPrivilege>