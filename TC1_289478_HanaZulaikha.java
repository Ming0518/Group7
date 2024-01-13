package login;

import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Test Case for Financial Information Management System - Login (1)
 * 
 * @author Hana
 */
public class TC1_289478_HanaZulaikha {

    /**
     * Test Case for Valid Login
     */
    @Test
    public void LoginValid() throws InterruptedException {
        // Set the path to your geckodriver executable
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fimsclone.kerisi.my/");
        Thread.sleep(1000);

        System.out.println("Start");
        
        // Input Username
        driver.findElement(By.xpath("//*[@id=\"userID\"]")).sendKeys("ENTRY3");
        System.out.println("Username inserted");
        Thread.sleep(1000);

        // Input Password
        driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("qwertyuiop");
        System.out.println("Password inserted");
        Thread.sleep(1000);

        // Click Login
        driver.findElement(By.name("login")).click();
        System.out.println("Login");
        Thread.sleep(1000);

        // Get the current URL to verify successful login
        String currentUrl = driver.getCurrentUrl();

        // Expect URL substring
        String expectedSubstring = "https://fimsclone.kerisi.my/index.php?a=NjQ1PUFYWW5WV1B3RjJabDkxZHlGR2N3Vm1jbTBXWnVWWFNFMVRNMGNETW1RR2RmeFdhelJYYXVkMlhpbDNYbkozYjFCWFBoeEdiNTc1";
        Assert.assertTrue(currentUrl.contains(expectedSubstring));
        System.out.println("Successful Login");
        
        // Close window
        driver.quit();
    }

    /**
     * Test Case for Financial Information Management System - Login (1)
     * 
     * @author Hana
     */
        @Test
        public void Menutoloan() throws InterruptedException {
            // Set the path to your geckodriver executable
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://fimsclone.kerisi.my/");
            Thread.sleep(1000);
            
            System.out.println("Start");

            // Input Username
            driver.findElement(By.xpath("//*[@id=\"userID\"]")).sendKeys("ENTRY3");
            System.out.println("Username inserted");
            Thread.sleep(1000);

            // Input Password
            driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("qwertyuiop");
            System.out.println("Password inserted");
            Thread.sleep(1000);

            // Click Login
            driver.findElement(By.name("login")).click();
            System.out.println("Login");
            Thread.sleep(1000);

            // Click on the menu button directly
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[2]/h4")).click();
            System.out.println("Menu Button");
            Thread.sleep(2000);

            
         // Assert that the menu button is visible (replace with the actual XPath)
            WebElement menuButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[2]/h4"));
            Assert.assertTrue("Menu button is not visible", menuButton.isDisplayed());
            System.out.println("Menu Button has successfully hidden");

            // Close window
            driver.quit();
        }

        
        /**
         * Test Case for Financial Information Management System - Password Visibility Toggle
         * 
         * @author Hana
         */
 
            @Test
            public void testPasswordVisibilityToggle() throws InterruptedException {
                // Set the path to your geckodriver executable
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://fimsclone.kerisi.my/");
                Thread.sleep(1000);
                
                System.out.println("Start");
                
                // Input Username
                driver.findElement(By.xpath("//*[@id=\"userID\"]")).sendKeys("ENTRY3");
                System.out.println("Username inserted");
                Thread.sleep(1000);

                // Input Password
                WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"userPassword\"]"));
                System.out.println("Password inserted");
                passwordInput.sendKeys("qwertyuiop");

                // Verify password is initially hidden
                Assert.assertEquals("password", passwordInput.getAttribute("type"));

                // Click on the eye icon to toggle password visibility
                driver.findElement(By.className("fas")).click();
                Thread.sleep(500); // Give it some time to toggle

                // Verify password is visible
                Assert.assertEquals("text", passwordInput.getAttribute("type"));

                // Click on the eye icon again to toggle password visibility back
                driver.findElement(By.className("fas")).click();
                Thread.sleep(500); // Give it some time to toggle back

                // Verify password is hidden again
                Assert.assertEquals("password", passwordInput.getAttribute("type"));

                // Close window
                driver.quit();
            }
   
            /**
             * Test Case for Financial Information Management System - Incorrect Login
             * 
             * @author Hana
             */
                /**
                 * Test Case for Incorrect Login (No Username and Password)
                 */
                @Test
                public void testIncorrectLoginNoCredentials() throws InterruptedException {
                    // Set the path to your chromedriver executable
                	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

                    WebDriver driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.get("https://fimsclone.kerisi.my/");
                    Thread.sleep(1000);

                    // Click Login without entering username and password
                    driver.findElement(By.name("login")).click();
                    Thread.sleep(1000);

                    // Verify that the expected error message is displayed
                    String expectedErrorMessage = "User not exist"; // Replace with the actual expected error message
                    String actualErrorMessage = driver.findElement(By.xpath("//*[@id='error']")).getText();

                    Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

                    // Close window
                    driver.quit();
                }
           
                /**
                 * Test Case for Financial Information Management System - Incorrect Login (No Username)
                 * 
                 * @author Hana
                 */
  
                    /**
                     * Test Case for Incorrect Login (No Username, but Password provided)
                     */
                    @Test
                    public void LoginTest7() throws InterruptedException {
                        // Set the path to your geckodriver executable
                        System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

                        WebDriver driver = new ChromeDriver();
                        driver.manage().window().maximize();
                        driver.get("https://fimsclone.kerisi.my/");
                        Thread.sleep(1000);
                ;

                        // Input Password without entering a username
                        driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("qwertyuiop");
                        Thread.sleep(1000);

                        // Click Login
                        driver.findElement(By.name("login")).click();
                        Thread.sleep(1000);

                        // Verify that the expected error message is displayed
                        String expectedErrorMessage = "User not exist"; // Replace with the actual expected error message
                        String actualErrorMessage = driver.findElement(By.xpath("//*[@id='error']")).getText();

                        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
                            driver.quit();
                        }
                    
                    /**
                     * Test Case for Financial Information Management System - Incorrect Login (Password Not Required)
                     * 
                     * @author Hana
                     */
                  

                        /**
                         * Test Case for Incorrect Login (Password Not Required)
                         */
                        @Test
                        public void testIncorrectLogin() throws InterruptedException, TimeoutException {
                            // Set the path to your geckodriver executable
                            System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

                            WebDriver driver = new ChromeDriver();
                            driver.manage().window().maximize();
                            driver.get("https://fimsclone.kerisi.my/");
                            Thread.sleep(1000);

                            // Input Username without entering a password
                            driver.findElement(By.xpath("//*[@id=\"userID\"]")).sendKeys("ENTRY3");
                            Thread.sleep(1000);

                            // Click Login
                            driver.findElement(By.name("login")).click();
                            Thread.sleep(1000);

                            // Verify that the expected error message is displayed
                            String expectedErrorMessage = "Invalid username or password"; // Replace with the actual expected error message
                            String actualErrorMessage = driver.findElement(By.xpath("//*[@id='error']")).getText();

                            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
                                driver.quit();
                        }
                        /**
                         * Test Case for Financial Information Management System - Incorrect Login (Incorrect Username)
                         * 
                         * @author Hana
                         */
                       

                            /**
                             * Test Case for Incorrect Login (Incorrect Username)
                             */
                            @Test
                            public void testIncorrectLogin11() throws InterruptedException, TimeoutException {
                                // Set the path to your geckodriver executable
                                System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

                                WebDriver driver = new ChromeDriver();
                                driver.manage().window().maximize();
                                driver.get("https://fimsclone.kerisi.my/");
                                Thread.sleep(1000);

                                // Input Incorrect Username
                                driver.findElement(By.xpath("//*[@id=\"userID\"]")).sendKeys("ENTRYYYY3");
                                Thread.sleep(1000);

                                // Input Password
                                driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("qwertyuiop");
                                Thread.sleep(1000);

                                

                                // Click Login
                                driver.findElement(By.name("login")).click();
                                Thread.sleep(1000);

                                // Verify that the expected error message is displayed
                                String expectedErrorMessage = "User not exist"; // Replace with the actual expected error message
                                String actualErrorMessage = driver.findElement(By.xpath("//*[@id='error']")).getText();

                                Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
                                    driver.quit();
                                }
                            /**
                             * Test Case for Financial Information Management System - Incorrect Login (Incorrect Password)
                             * 
                             * @author Hana
                             */
                          

                                /**
                                 * Test Case for Incorrect Login (Incorrect Password)
                                 */
                                @Test
                                public void testIncorrectLogin1() throws InterruptedException {
                                    // Set the path to your geckodriver executable
                                	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

                                	 WebDriver driver = new ChromeDriver();
                                     driver.manage().window().maximize();
                                     driver.get("https://fimsclone.kerisi.my/");
                                     Thread.sleep(1000);

                                     driver.findElement(By.xpath("//*[@id=\"userID\"]")).sendKeys("ENTRY3");
                                     System.out.println("Entered username"); // Add this line
                                     Thread.sleep(1000);

                                     driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("qwertuop2111");
                                     System.out.println("Entered incorrect password"); // Add this line
                                     Thread.sleep(1000);

                                     driver.findElement(By.name("login")).click();
                                     System.out.println("Clicked login button"); // Add this line
                                     Thread.sleep(1000);

                                     // Verify that the expected error message is displayed
                                     String expectedErrorMessage = "Invalid username or password"; // Replace with the actual expected error message
                                     String actualErrorMessage = driver.findElement(By.xpath("//*[@id='error']")).getText();

                                     Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
                                         driver.quit();
                             }
                                /**
                                 * Test Case for Financial Information Management System - Logout Session (No)
                                 * 
                                 * @author Hana
                                 */
                               
                                    /**
                                     * Test Case for Logout Session (No)
                                     */
                                    @Test
                                    public void testLogoutSessionNo() throws InterruptedException {
                                        // Set the path to your geckodriver executable
                                        System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

                                        WebDriver driver = new ChromeDriver();
                                        driver.manage().window().maximize();
                                        driver.get("https://fimsclone.kerisi.my/");
                                        Thread.sleep(1000);

                                        // Input Email
                                        driver.findElement(By.id("userID")).sendKeys("ENTRY3");
                                        Thread.sleep(1000);

                                        // Input Password
                                        driver.findElement(By.id("userPassword")).sendKeys("qwertyuiop");
                                        Thread.sleep(1000);

                                        // Click Login
                                        driver.findElement(By.name("login")).click();
                                        Thread.sleep(1000);

                                        System.out.println("After Login");
                                        
                                       
                                       
                                     // Select Logout Dropdown Button
                                        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/a")).click();
                                        Thread.sleep(2000);
                                        
                                        // Click Logout Button
                                        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/a")).click();
                                        Thread.sleep(2000);


                                        // Click No to cancel logout 
                                        driver.findElement(By.xpath("/html/body/div[18]/div/div/div[3]/button[1]")).click(); // Replace with the correct XPath
                                        Thread.sleep(2000);

                                        System.out.println("Logout Cancelled");

                                        String expectedUrl = "https://fimsclone.kerisi.my/index.php?a=NjQ1PUFYWW5WV1B3RjJabDkxZHlGR2N3Vm1jbTBXWnVWWFNFMVRNMGNETW1RR2RmeFdhelJYYXVkMlhpbDNYbkozYjFCWFBoeEdiNTc1"; 


                                        // Verify that the user is redirected to the login page after logout
                                        String currentUrl = driver.getCurrentUrl();
                                        Assert.assertTrue(currentUrl.contains(expectedUrl));

                                            driver.quit();
                                        }
                                    /**
                                     * Test Case for Financial Information Management System - Logout Session ( YES ) 
                                     * 
                                     * @author Hana
                                     */
                                   

                                        /**
                                         * Test Case for Logout Session
                                         */
                                        @Test
                                        public void testLogoutSession() throws InterruptedException {
                                            // Set the path to your geckodriver executable
                                            System.setProperty("webdriver.gecko.driver", "C:\\Users\\60174\\Downloads\\geckodriver-v0.34.0-win32\\geckodriver.exe");

                                            WebDriver driver = new ChromeDriver();
                                            driver.manage().window().maximize();
                                            driver.get("https://fimsclone.kerisi.my/");
                                            Thread.sleep(1000);

                                            // Input Email
                                            driver.findElement(By.xpath("//*[@id=\"userID\"]")).sendKeys("ENTRY3");
                                            Thread.sleep(1000);

                                            // Input Password
                                            driver.findElement(By.xpath("//*[@id=\"userPassword\"]")).sendKeys("qwertyuiop");
                                            Thread.sleep(1000);

                                            // Click Login
                                            driver.findElement(By.name("login")).click();
                                            Thread.sleep(1000);

                                            
                                            System.out.println("After Class");
                                            
                                            // Select Logout Dropdown Button
                                            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/a")).click();
                                            Thread.sleep(2000);
                                            
                                            // Click Logout Button
                                            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/a")).click();
                                            Thread.sleep(2000);
                                            
                                            // Click OK to Confirm Logout
                                            driver.findElement(By.xpath("/html/body/div[18]/div/div/div[3]/button[2]")).click();
                                            Thread.sleep(2000);
                                            
                                            System.out.println("Logout Successful");
                                         
                                           
                                            // Expect URL
                                            String expectedUrl = "https://fimsclone.kerisi.my/index.php?a=NjQ1PUFYWW5WV1B3RjJabDkxZHlGR2N3Vm1jbTBXWnVWWFNFMVRNMGNETW1RR2RmeFdhelJYYXVkMlhpbDNYbkozYjFCWFBoeEdiNTc1"; 


                                            // Verify that the user is redirected to the login page after logout
                                            String currentUrl = driver.getCurrentUrl();
                                            Assert.assertTrue("User is not redirected to the login page after logout. Actual URL: " + currentUrl,
                                                    currentUrl.contains("/login.php"));

                                         // Close WebDriver instance
                                            if (driver != null) {
                                                driver.quit();
                                            }
                                    }
                                    }





