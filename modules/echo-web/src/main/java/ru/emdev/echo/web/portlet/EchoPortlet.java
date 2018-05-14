package ru.emdev.echo.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ru.emdev.echo.EchoApi;
import ru.emdev.echo.web.constants.EchoPortletKeys;

/**
 * @author akakunin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Echo Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EchoPortletKeys.Echo,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EchoPortlet extends MVCPortlet {
	protected EchoApi echoService;
	
	@Reference
	public void setEchoService(EchoApi echoService) {
		this.echoService = echoService;
	}
	
	/* Echo Action
	 * 
	 */
	public void echo(ActionRequest request, ActionResponse response) {
		String message = ParamUtil.getString(request, "message");
		message = echoService.echo(message);
		request.setAttribute("message", message);
	}
}