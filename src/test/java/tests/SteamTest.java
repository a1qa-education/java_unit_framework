package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SteamTest {

    @Test
    public void STEAM_TC_001_Dynamic_Filtering_Windows_Singleplayer_Ascending_Price_Sorting()
            throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("https://store.steampowered.com/");

        Assert.assertNotNull(driver.getTitle());
        Assert.assertNotNull(driver.findElement(By.tagName("body")));
        Assert.assertNotNull(driver.findElement(By.tagName("body")));

        WebElement search = driver.findElement(By.xpath("//form//input[@autocomplete='off']"));

        if (search != null) {
            if (search.isDisplayed()) {
                if (search.isEnabled()) {
                    Assert.assertTrue(search.isDisplayed());
                    Assert.assertTrue(search.isEnabled());

                    search.sendKeys("strategy");
                    search.submit();
                }
            }
        }

        Thread.sleep(5000);

        WebElement windowsCheckbox = driver.findElement(By.xpath("//span[@role='button']//span[contains(text(),'Windows')]"));

        if (windowsCheckbox != null) {
            windowsCheckbox.click();
        }

        Thread.sleep(3000);

        WebElement singlePlayer = driver.findElement(By.xpath("//span[@role='button']//span[contains(text(),'Singleplayer')]"));

        if (singlePlayer != null) {
            singlePlayer.click();
        }

        Thread.sleep(3000);

        WebElement sortDropdown = driver.findElement(By.xpath("//button[contains(@onclick,'sort_by')]"));

        sortDropdown.click();

        Thread.sleep(2000);

        WebElement lowestPrice = driver.findElement(By.xpath("//*[contains(text(),'Lowest Price')]"));

        lowestPrice.click();

        Thread.sleep(5000);

        List<Double> prices = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            try {
                WebElement priceElement = driver.findElement(
                                By.xpath(
                                        "//a[contains(@class,'search_result_row')][" + i +
                                                "]//*[contains(@class,'discount_final_price')]"
                                )
                        );
                String raw = priceElement.getText();
                prices.add(Double.parseDouble(raw.replace("$", "")));
            } catch (Exception e) {
                System.out.println("Ignoring error: " + e.getMessage());
            }
        }

        List<Double> expected = new ArrayList<>(prices);

        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < expected.size() - i; j++) {
                try {
                    if (expected.get(j) > expected.get(j + 1)) {
                        Double temp = expected.get(j);
                        expected.set(j, expected.get(j + 1));
                        expected.set(j + 1, temp);
                    }
                } catch (Exception ignored) {
                }
            }
        }

        Assert.assertEquals(prices.toString(), expected.toString());

        driver.quit();
    }

    @Test
    public void STEAM_TC_002_Dynamic_Filtering_macOS_Indie_Descending_Price_Sorting()
            throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("https://store.steampowered.com/");

        Assert.assertNotNull(driver.getTitle());
        Assert.assertNotNull(driver.findElement(By.tagName("body")));
        Assert.assertNotNull(driver.findElement(By.tagName("body")));

        WebElement search = driver.findElement(By.xpath("//form//input[@autocomplete='off']"));

        if (search != null) {
            if (search.isDisplayed()) {
                if (search.isEnabled()) {
                    Assert.assertTrue(search.isDisplayed());
                    Assert.assertTrue(search.isEnabled());

                    search.sendKeys("strategy");
                    search.submit();
                }
            }
        }

        Thread.sleep(5000);

        WebElement macCheckbox = driver.findElement(By.xpath("//span[@role='button']//span[contains(text(),'macOS')]"));

        if (macCheckbox != null) {
            macCheckbox.click();
        }

        Thread.sleep(3000);

        WebElement indie = driver.findElement(By.xpath("//span[@role='button']//span[contains(text(),'Indie')]"));

        if (indie != null) {
            indie.click();
        }

        Thread.sleep(3000);

        WebElement sortDropdown = driver.findElement(By.xpath("//button[contains(@onclick,'sort_by')]"));

        sortDropdown.click();

        Thread.sleep(2000);

        WebElement highestPrice = driver.findElement(By.xpath("//*[contains(text(),'Highest Price')]"));

        highestPrice.click();

        Thread.sleep(5000);

        List<Double> prices = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            try {
                WebElement priceElement =
                        driver.findElement(
                                By.xpath(
                                        "//a[contains(@class,'search_result_row')][" + i +
                                                "]//*[contains(@class,'discount_final_price')]"
                                )
                        );
                String raw = priceElement.getText();
                prices.add(Double.parseDouble(raw.replace("$", "")));
            } catch (Exception e) {
                System.out.println("Ignoring error: " + e.getMessage());
            }
        }

        List<Double> expected = new ArrayList<>(prices);

        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < expected.size() - i; j++) {
                try {
                    if (expected.get(j) < expected.get(j + 1)) {
                        Double temp = expected.get(j);
                        expected.set(j, expected.get(j + 1));
                        expected.set(j + 1, temp);
                    }
                } catch (Exception ignored) {
                }
            }
        }

        Assert.assertEquals(prices.toString(), expected.toString());

        driver.quit();
    }
}