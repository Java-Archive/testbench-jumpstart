package junit.org.rapidpm.vaadin.ui.app;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.GridElement;
import com.vaadin.testbench.elements.TextFieldElement;
import org.openqa.selenium.WebDriver;
import org.rapidpm.vaadin.addons.testbench.junit5.pageobject.AbstractVaadinPageObject;

import static org.rapidpm.vaadin.ui.app.MyUI.*;

public class AddressBookPageObject extends AbstractVaadinPageObject {


  public AddressBookPageObject(WebDriver webDriver) {
    super(webDriver);
  }


  public String getLastNameAtIndex(int index) {
    return $(GridElement.class).first()
                               .getCell(index, 1).getText();
  }

  public String getFirstNameAtIndex(int index) {
    return $(GridElement.class).first()
                               .getCell(index, 0).getText();
  }

  public CustomerFormPageObject selectEntryAtIndex(int index) {
    $(GridElement.class).first()
                        .getCell(index, 0).click();
    final CustomerFormPageObject result = new CustomerFormPageObject(getDriver());
    result.setDriver(getDriver());
    return result;
  }

  public CustomerFormPageObject createNewEntry() {
    $(ButtonElement.class).caption("Add new customer").first().click();
    final CustomerFormPageObject result = new CustomerFormPageObject(getDriver());
    result.setDriver(getDriver());
    return result;
  }

  public CustomerFormPageObject activeCustomerForm() {
    final CustomerFormPageObject result = new CustomerFormPageObject(getDriver());
    result.setDriver(getDriver());
    return result;
  }


  public TextFieldElement filterTextField() {
    return $(TextFieldElement.class).id(FILTER_TF);
  }

  public GridElement dataGrid() {
    return $(GridElement.class).id(DATA_GRID);
  }

  public ButtonElement clearFilterBTN() {
    return $(ButtonElement.class).id(CLEAR_FILTER_BTN);
  }

}
