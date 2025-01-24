package com.tp.demo.OrganizationTest;

import java.util.Random;

import org.testng.annotations.Test;

import com.tp.demo.baseutility.BaseClass;
import com.tp.objectRepositoryutility.CreatingNewOrganisationPage;
import com.tp.objectRepositoryutility.HomePage;
import com.tp.objectRepositoryutility.OrganisationInfromationPage;
import com.tp.objectRepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass{
	@Test
	public void createOrgTest() {
		
		Random random=new Random();
		int ranNum=random.nextInt(1000);
		driver.get("http://localhost:8888/");
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsHeader().click();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateOrganization().click();
		String exp_orgName="Whatsapp_"+ranNum;
		CreatingNewOrganisationPage cnop=new CreatingNewOrganisationPage(driver);
		cnop.createOrganization(exp_orgName, "7845127845", "whatsapp123@gmail.com", "Bengaluru");
		OrganisationInfromationPage oip=new OrganisationInfromationPage(driver);
		String act_orgName=oip.getOrganisationInfoHeader().getText();
		oip.verify(exp_orgName, act_orgName);
		}
}
