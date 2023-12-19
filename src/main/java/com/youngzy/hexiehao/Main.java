package com.youngzy.hexiehao;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

/**
 * @author youngzy
 * @since 2023-12-19
 */
public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
        // 创建 ChromeDriver 实例
        driver = new ChromeDriver();

        // 登录
        login();
        
        // 选票
        pick();

        // 进入购票页面，找到选择票和购买的元素
//        WebElement ticketDropdown = driver.findElement(By.id("ticketDropdown"));
//        ticketDropdown.click();
//
//        WebElement selectTicket = driver.findElement(By.xpath("//option[text()='Your Ticket']"));
//        selectTicket.click();
//
//        WebElement buyButton = driver.findElement(By.id("buyButton"));
//        buyButton.click();

        // 关闭浏览器
//        driver.quit();
    }

    private static void pick() {
        WebElement dc = driver.findElement(By.linkText("单程"));
        dc.click();
    }

    private static void login() {
        final String loginUrl = "https://kyfw.12306.cn/otn/resources/login.html";
        driver.get(loginUrl);

        String key1 = System.getenv("12306_USERNAME");
        String key2 = System.getenv("12306_PASSWORD");

        // 找到相关的页面元素并进行模拟登录
        WebElement usernameInput = driver.findElement(By.id("J-userName"));
        WebElement passwordInput = driver.findElement(By.id("J-password"));
        usernameInput.sendKeys(key1);
        passwordInput.sendKeys(key2);

        WebElement loginButton = driver.findElement(By.id("J-login"));
        loginButton.click();

        // 短信验证
        // 手动操作

        //
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .ignoring(NoSuchElementException.class)
                .until(d -> {
                    WebElement logout = d.findElement(By.className("logout"));
                    return logout.isDisplayed();
                });

        System.out.println("登录成功！");
    }
}
