package io.testinium.constant;

import org.openqa.selenium.By;

public class ConstantsHomePage {

 public static final String BASE_URL = "https://www.beymen.com";
 public static final By KADIN_MENU = By.className("kadin");
 public static final By KADIN_GIYIM = By.linkText("GİYİM");
 public static final String KADIN_URL ="https://www.beymen.com/kadin-giyim-10020";
 public static final By LIST_DISCOUNTS = By.className("m-productCard__oldPrice");
 public static final By OLD_PRICE = By.xpath("//span[@class='m-productCard__discnt']/following-sibling::span/span[1]");
 public static final By NEW_PRICE = By.xpath("//span[@class='m-productCard__discnt']/following-sibling::span/span[2]");

}

