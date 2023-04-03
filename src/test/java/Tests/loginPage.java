package Tests;

import Base.loginBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginPage extends loginBase {

    @Test
    public void login(){
       login_po.clickOnHotel();
       login_po.clickOnFlights();
       login_po.handleAlert();
       login_po.clickOnTrain();
       login_po.clickOnCarRentals();
       login_po.clickOnAirportTansfer();
       login_po.clickOnAttrAndTickets();
       login_po.clickOnBundleAndSave();
       login_po.clickOnAttractions();
       login_po.clickOnHomeRewards();
       login_po.clickOnDeals();
       login_po.changeCurrency();
       login_po.changeLanguage();
       login_po.clickOnAPP();
       login_po.clickOnHelp();
    }
}
