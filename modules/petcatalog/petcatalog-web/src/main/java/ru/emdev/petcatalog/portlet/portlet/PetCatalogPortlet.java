package ru.emdev.petcatalog.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
	
	private ThemeDisplay getThemeDisplay(PortletRequest request) {
		return (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	
	@Reference
	public void setPetLocalService(PetLocalService petLocalService) {
		this.petLocalService = petLocalService;
	}
	
	PetLocalService 	petLocalService;
}