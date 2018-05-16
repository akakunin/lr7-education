package ru.emdev.samples.petcatalog.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import ru.emdev.samples.petcatalog.model.Pet;

/**
 * Класс проверки прав доступа к Каталогу объектов (питомцев)
 * 
 * @author akakunin
 * 
 */

@OSGiBeanProperties(
	property = {"resource.name=" + PetCatalogPermission.RESOURCE_NAME}
)
public class PetCatalogPermission extends BaseResourcePermissionChecker {

    public static final String RESOURCE_NAME = "ru.emdev.samples.petcatalog";

    public static final String ACTION_ADD_PET = "ADD_PET";

    public static void check(
            PermissionChecker permissionChecker, long groupId, String actionId)
        throws PortalException {

        if (!contains(permissionChecker, groupId, actionId)) {
        	throw new PrincipalException.MustHavePermission(
    				permissionChecker.getUserId(), RESOURCE_NAME, groupId,
    				actionId);
        }
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, String actionId) {

    	String portletId = PortletProviderUtil.getPortletId(
    			Pet.class.getName(), PortletProvider.Action.EDIT);
    	
        return contains(permissionChecker, RESOURCE_NAME, portletId, groupId, actionId);
    }

    @Override
	public Boolean checkResource(
		PermissionChecker permissionChecker, long classPK, String actionId) {

		return contains(permissionChecker, classPK, actionId);
	}
}
