package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
public class AccountsPageSteps {
	
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	AccountsPage accountPage ;
	//AccountsPage accountPage=new AccountsPage(DriverFactory.getDriver());
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		
		   
		
		   List<Map<String,String>> cred = credTable.asMaps(String.class,String.class);
		   String userName=cred.get(0).get("username");
		   String passWord=cred.get(0).get("password");
		   
		   DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		   accountPage=loginPage.doLogin(userName, passWord);
	    
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	    // Write code here that turns the phrase above into concrete actions
		accountPage.getAccountPageTitle();
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable accountsectionTable) {
		
		List<String> expectedSection = accountsectionTable.asList(String.class);
		System.out.println("expected List ::"+expectedSection);
		List<String> actualSectionList=accountPage.getAccountSectionList();
		System.out.println("Actual List from Page::"+actualSectionList);
		
		Assert.assertTrue(expectedSection.containsAll(actualSectionList));
		
		
	    
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
		
		int actualCount=accountPage.getAccountsectionCount();
		Assert.assertTrue(actualCount==expectedCount);
	   
	}
	
	@When("user click on signOut button")
	public void user_click_on_the_signOut_button() {
		loginPage=accountPage.clickOnSignOutButton();
	   
	}



}
