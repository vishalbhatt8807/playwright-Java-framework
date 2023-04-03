package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;

public class login_PO {
    private Page page;
    String hotel = "Hotels";
    String flights = "Flights";
    String train = "Trains";
    String car = "#header_action_nav_cars";
    String carRental = "Car Rentals";
    String airportTrans = "Airport Transfers";
    String attractionAndTicket = "Attractions & Tickets";
    String bundleAndSave = "Bundle & Save";
    String attractions = "Attractions";
    String homePage = "Trip.com";
    String Trip_com_Rewards= "Trip.com Rewards";
    String deals = "Deals";
    String changeCurrency = "USD";
    String indiaCurrency ="Indian Rupee";
    String changeLang= "span.mc-hd__country-icon";
    String englishUSLang = "English (United States)";
    String app = "App";
    String help = "Help";
    public login_PO(Page page){this.page = page;}

    public void clickOnHotel(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(hotel)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/hotels/");
    }

    public void clickOnFlights(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(flights)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/flights/");
    }
    public void clickOnTrain(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(train)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/trains/china/");
    }

    public void handleAlert(){
        page.waitForTimeout(3000);
        if(page.getByText("Allow").nth(1).isVisible()) {
            page.getByText("Allow").nth(1).click();
        }
        page.waitForTimeout(3000);
    }
    public void clickOnCarRentals(){
        page.locator(car).hover();
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(carRental)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/carhire/online/home?channelid=14409");
    }

    public void clickOnAirportTansfer(){
        page.waitForTimeout(3000);
        page.locator(car).hover();
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(airportTrans)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/airport-transfers/index");
    }


    public void clickOnAttrAndTickets(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(attractionAndTicket)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/things-to-do/ttd-home/?ctm_ref=vactang_page_23810");
        clickOnHomePage();
    }


    public void clickOnBundleAndSave(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(bundleAndSave)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/packages/?sourceFrom=IBUBundle_home");
        clickOnHomePage();
    }

    public void clickOnAttractions(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(attractions)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/travel-guide/");
        clickOnHomePage();
    }

    public void clickOnHomeRewards(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(Trip_com_Rewards)).nth(0).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/customer/loyalty");
        clickOnHomePage();
    }

    public void clickOnDeals(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(deals)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/sale/deals/");
        clickOnHomePage();
    }

    private void clickOnHomePage(){
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(homePage)).click();
        Assert.assertEquals(page.url(),"https://www.trip.com/");
    }

    public void changeCurrency(){
        page.getByText(changeCurrency).click();
        page.getByText(indiaCurrency).click();
    }

    public void changeLanguage(){
        page.locator(changeLang).click();
        page.getByText(englishUSLang).click();
    }


    public void clickOnAPP(){
        page.getByText(app).first().click();
    }


    public void clickOnHelp(){
        Page page1 = page.waitForPopup(() -> {
            page.getByText(help).first().click();
        });


        System.out.println(page1.title());
        page1.getByText("How do I change my ticket?").click();
        page1.getByPlaceholder("Please enter an email address").fill("vishal@gmail.com");
        page1.locator("#ibu_login_close").click();
        Page page2 = page1.waitForPopup(() -> {
            page1.getByText("Confirm").click();
        });

        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(attractionAndTicket)).click();
        Assert.assertEquals(page.url(),"https://us.trip.com/things-to-do/ttd-home/?ctm_ref=vactang_page_23810");
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(homePage)).click();
        Assert.assertEquals(page.url(),"https://us.trip.com/");
    }
}

