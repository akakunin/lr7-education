package ru.emdev.samples.petcatalog;


import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ru.emdev.samples.petcatalog.model.Pet;
import ru.emdev.samples.petcatalog.service.PetLocalService;

/**
 * @author akakunin
 */
@Component(
		immediate=true,
		service = Object.class,
		property = { 
			"osgi.command.scope=pets",
			"osgi.command.function=add",
			"osgi.command.function=list"
			})

public class PetCatalogCommands {
	PetLocalService petLocalService;
	
	@Reference
	void bindProductManager (PetLocalService petLocalService) {
		this.petLocalService = petLocalService;
	}
	
	public void add(String name, String description, double price) {
		Date birthday = new Date();
		try {
			// get default companyId, groupId, user
			List<Company> companies = CompanyLocalServiceUtil.getCompanies();
			// just get first company
			Company company = companies.get(0);
			Group group = GroupLocalServiceUtil.getGroup(company.getCompanyId(), GroupConstants.GUEST);
			long userId = group.getCreatorUserId();
			
			Pet pet = petLocalService.addPet(company.getCompanyId(), group.getGroupId(), userId , name, description, price, birthday);
			
			System.out.println("Pet saved with id " + pet.getPetId() + " !");
		} catch (Exception ex) {
			System.out.println("Cannot add pet:" + ex.getMessage());
		}
	}
	
	public void list() {
		try {
			// get default companyId, groupId, user
			List<Company> companies = CompanyLocalServiceUtil.getCompanies();
			// just get first company
			Company company = companies.get(0);
			Group group = GroupLocalServiceUtil.getGroup(company.getCompanyId(), GroupConstants.GUEST);
			
			List<Pet> pets = petLocalService.getByGroup(group.getGroupId(), -1, -1);
			System.out.format("%-5s | %-15s | %-10s | %-40s\n", "#", "NAME", "PRICE", "DESCRIPTION");
			for (Pet pet: pets) {
				System.out.format("%-5s | %-15s | %-10s | %-40s\n", pet.getPetId(), pet.getName(), pet.getPrice(), pet.getDescription());
			}
		} catch (Exception ex) {
			System.out.println("Cannot get list of pets:" + ex.getMessage());
		}
	}
}