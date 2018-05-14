package user.service.wrapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author akakunin
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class UserServiceWrapper extends UserLocalServiceWrapper {
	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress,
        String password, Map<String, String[]> headerMap,
        Map<String, String[]> parameterMap, Map<String, Object> resultsMap)
    	throws PortalException {

    	System.out.println(
        	"Authenticating user by EMAIL address " + emailAddress);
    	return super.authenticateByEmailAddress(companyId, emailAddress, password,
        	headerMap, parameterMap, resultsMap);
	}

	public UserServiceWrapper() {
		super(null);
	}

}