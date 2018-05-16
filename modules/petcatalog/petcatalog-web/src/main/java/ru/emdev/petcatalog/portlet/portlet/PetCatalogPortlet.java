package ru.emdev.petcatalog.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ru.emdev.petcatalog.portlet.constants.PetCatalogPortletKeys;
import ru.emdev.samples.petcatalog.model.Pet;
import ru.emdev.samples.petcatalog.service.PetLocalService;

/**
 * @author akakunin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PetCatalog Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PetCatalogPortletKeys.PetCatalog,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PetCatalogPortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(PetCatalogPortlet.class.getName());
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = getThemeDisplay(request);

        Group group = themeDisplay.getScopeGroup();
        List<Pet> pets;
        int petsCount = 0;

        try {
                pets = petLocalService.getByGroup(group.getGroupId(), -1, -1);
                petsCount = petLocalService.countByGroup(group.getGroupId());
            

            request.setAttribute("pets", pets);
            request.setAttribute("petsCount", petsCount);
        } catch (Exception ex) {
            log.error("Cannot get pets", ex);
        }
    		
		super.render(request, response);
	}
	
	public void addPet(ActionRequest request, ActionResponse response) {
        ThemeDisplay themeDisplay = getThemeDisplay(request);
        String redirect = ParamUtil.getString(request, WebKeys.REDIRECT);

        String name = ParamUtil.getString(request, "name");
        String description = ParamUtil.getString(request, "description");
        Double price = ParamUtil.getDouble(request, "price");
        Date birthday = getDateFromRequest(request, "birthday");

        try {
            log.info("User " + themeDisplay.getUserId() + " attemtps to add new pet");
            Pet pet = petLocalService.addPet(themeDisplay.getCompanyId(),
                    themeDisplay.getScopeGroupId(),
                    themeDisplay.getUserId(),
                    name, description, price, birthday);

            log.info("Pet " + pet.getPetId() + " added/updated");
        } catch (Exception ex) {
            log.error("Cannot add pet", ex);
            copyRequestParameters(request, response);
            SessionErrors.add(request, "cannot-add-pet");
        }
    }
	
	private ThemeDisplay getThemeDisplay(PortletRequest request) {
		return (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	
	
	protected void copyRequestParameters(ActionRequest request, ActionResponse response) {
        // copy parameters from action request to response
        for (Object key : request.getParameterMap().keySet()) {
            String val = request.getParameter((String) key);
            if (val != null && !"image".equals(key) && !((String) key).startsWith("fileName")) {
                response.setRenderParameter((String) key, val);
            }
        }
    }

	/// Get Date from Request
	protected Date getDateFromRequest(PortletRequest request, String prefix) {
        return getDateFromRequest(PortalUtil.getHttpServletRequest(request), prefix);
    }


    protected Date getDateFromRequest(HttpServletRequest request, String prefix) {

        return getDateFromRequest(request, prefix, null);
    }


    protected Date getDateFromRequest(HttpServletRequest request, String prefix, TimeZone timeZone) {
        int month = ParamUtil.getInteger(request, prefix + "Month");
        int day = ParamUtil.getInteger(request, prefix + "Day");
        int year = ParamUtil.getInteger(request, prefix + "Year");

        Locale locale = request.getLocale();
        if (timeZone == null) {
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            timeZone = themeDisplay.getTimeZone();
        }

        return getDate(month, day, year, locale, timeZone);

    }

    protected Date getDate(int month, int day, int year, Locale locale, TimeZone timeZone) {

        Calendar date = CalendarFactoryUtil.getCalendar(timeZone, locale);

        date.set(Calendar.MONTH, month);
        date.set(Calendar.DATE, day);
        date.set(Calendar.YEAR, year);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        return date.getTime();
    }
    
	@Reference
	public void setPetLocalService(PetLocalService petLocalService) {
		this.petLocalService = petLocalService;
	}
	
	PetLocalService 	petLocalService;
}