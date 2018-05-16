/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ru.emdev.samples.petcatalog.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import ru.emdev.samples.petcatalog.service.PetServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link PetServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link ru.emdev.samples.petcatalog.model.PetSoap}.
 * If the method in the service utility returns a
 * {@link ru.emdev.samples.petcatalog.model.Pet}, that is translated to a
 * {@link ru.emdev.samples.petcatalog.model.PetSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PetServiceHttp
 * @see ru.emdev.samples.petcatalog.model.PetSoap
 * @see PetServiceUtil
 * @generated
 */
@ProviderType
public class PetServiceSoap {
	public static int countByGroup(long groupId) throws RemoteException {
		try {
			int returnValue = PetServiceUtil.countByGroup(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static ru.emdev.samples.petcatalog.model.PetSoap[] getByGroup(
		long groupId, int start, int end) throws RemoteException {
		try {
			java.util.List<ru.emdev.samples.petcatalog.model.Pet> returnValue = PetServiceUtil.getByGroup(groupId,
					start, end);

			return ru.emdev.samples.petcatalog.model.PetSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static ru.emdev.samples.petcatalog.model.PetSoap getPet(long petId)
		throws RemoteException {
		try {
			ru.emdev.samples.petcatalog.model.Pet returnValue = PetServiceUtil.getPet(petId);

			return ru.emdev.samples.petcatalog.model.PetSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updatePet(ru.emdev.samples.petcatalog.model.PetSoap pet)
		throws RemoteException {
		try {
			PetServiceUtil.updatePet(ru.emdev.samples.petcatalog.model.impl.PetModelImpl.toModel(
					pet));
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deletePet(long petId) throws RemoteException {
		try {
			PetServiceUtil.deletePet(petId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PetServiceSoap.class);
}