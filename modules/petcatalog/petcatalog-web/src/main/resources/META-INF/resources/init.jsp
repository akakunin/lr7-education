<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.WindowState" %>

<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.Format"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.SimpleDateFormat"%>


<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="ru.emdev.samples.petcatalog.model.Pet"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
WindowState windowState = renderRequest.getWindowState();
String currentURL = PortalUtil.getCurrentURL(request);
String imagePath = themeDisplay.getPathThemeImages() + "/custom";

// определяем форматы вывода дат (три варианта - только дата, дата и время, только время)
// с учетом локали и пользовательской timezone
DateFormat dateFormatDate = DateFormat.getDateInstance(DateFormat.LONG, locale);
dateFormatDate.setTimeZone(timeZone);
DateFormat dateFormatDateTime = DateFormatFactoryUtil.getDateTime(locale, timeZone);
DateFormat dateFormatTime = DateFormatFactoryUtil.getTime(locale, timeZone);

%>
