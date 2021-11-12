package steps;

import com.sun.tools.jxc.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.ProtractorHomePage;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class AssignmentSteps {

    WebDriver driver = Driver.getDriver();
    ProtractorHomePage protractorHomePage = new ProtractorHomePage();
    Map<String,Object> data;
    int numberOfEmployees;

    @Given("user navigates to Protractor application")
    public void user_navigates_to_Protractor_application() throws InterruptedException {
        Thread.sleep(5000);
       driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
        // driver.get(ConfigReader.getProperty("ProtractorURL"));

    }

    @And("user clicks on Add User button")
    public void user_clicks_on_Add_User_button() throws InterruptedException {
        Thread.sleep(5000);
        protractorHomePage.addUserButton.click();
    }
    @And("user creates user with data")
    public void userCreatesUserWithData(DataTable dataTable) {

        //Converting datable to map to make key and value format
        data = dataTable.asMap(String.class, Object.class);
        protractorHomePage.firstName.sendKeys(data.get("First Name").toString());
        protractorHomePage.lastName.sendKeys(data.get("Last Name").toString());
        protractorHomePage.userName.sendKeys(data.get("User Name").toString());
        protractorHomePage.password.sendKeys(data.get("Password").toString());
        protractorHomePage.companyA.click();

        Select select = new Select(protractorHomePage.role);
        select.selectByValue("0");

        protractorHomePage.email.sendKeys(data.get("Email").toString());
        protractorHomePage.cellPhone.sendKeys(data.get("Cell Phone").toString());
    }



    @Then("user validates that user added to the list")
    public void user_validates_that_user_added_to_the_list() throws InterruptedException {

        numberOfEmployees++;
        List<WebElement> newEmployeeRow = driver.findElements(By.xpath("//tbody["+numberOfEmployees+"]//td[1]"));
        Assert.assertEquals(data.get("First Name").toString(), newEmployeeRow.get(1).getText());

    }
    //Scenario 2
    @And("user clicks on delete button")
    public void userClicksOnDeleteButton() {
        protractorHomePage.deleteButton.click();

    }

    @Then("user validates that user deleted from the list")
    public void userValidatesThatUserDeletedFromTheList() {
        /**
         * Validating that user was deleted from the list
         */
        numberOfEmployees--;
        List<WebElement> newEmployeeRow2 = driver.findElements(By.xpath("//tbody["+numberOfEmployees+"]//td[1]"));
        Assert.assertEquals(data.get("First Name").toString(), newEmployeeRow2.get(1).getText());

    }

}
