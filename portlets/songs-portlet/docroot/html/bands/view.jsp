<%
/**
 * Copyright (c) 2000-2009 Musiccabins, Inc. All rights reserved.
 *
 *
 */
%>

<%@ include file="/init.jsp" %>

<jsp:useBean id="addPublisherURL" class="java.lang.String" scope="request" />

<liferay-ui:success key="band-added" message="band-added-successfully" />

<portlet:actionURL name="addBand" var="editBandURL" />

<aui:form action="<%= editBandURL %>" method="post" name="fm">

	<aui:input name="name" />
	<aui:input name="description" />
	<aui:input name="friendlyURL" />

	<aui:button type="submit" value="add-band" />
</aui:form>