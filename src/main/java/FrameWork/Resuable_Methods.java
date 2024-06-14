package FrameWork;

import Pages.ApplicationPages.DataCenter;
import Pages.CommonPages.CommonPageElements;
import io.cucumber.java.an.E;
import io.cucumber.java.et.Ja;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

import static Pages.ApplicationPages.DataCenter.*;

public class Resuable_Methods {

    static WebDriver driver = Browsers.driver;

    public static void SetBrowserWindow(int n) throws InterruptedException, AWTException {
        Thread.sleep(1000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        for (int i = 1; i <= n; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    public static synchronized Object execJavascript(String script, Object... args) {
        JavascriptExecutor scriptExe = ((JavascriptExecutor) driver);
        return scriptExe.executeScript(script, args);
    }

    public static void elementFocus(WebElement element) throws Exception {
        execJavascript("arguments[0].style.border='3px solid green'", element);
    }

    public static void FocusListElements(List<WebElement> elements) throws Exception {
        for (WebElement ele : elements){
            elementFocus(ele);
        }
    }

    public static void jsClick(WebElement element) throws InterruptedException {
        Thread.sleep(1500);
        execJavascript("arguments[0].click();", element);
    }

    public static void Click(WebElement element) throws InterruptedException {
        Thread.sleep(2000);
        element.click();
    }

    public static void WaitForTitle(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains(text));
    }

    public static void WaitUntilElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void WaitForText(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public static void WaitUntil(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void VerifyCurrentPage(String text, String PageName) throws Exception {
        try {

            if (text.contains(PageName)) {
                Thread.sleep(2000);
                WebElement element1 = driver.findElement(By.xpath("//h1[text()='" + PageName + "']"));
                if (element1.isDisplayed()) {
                    WaitUntil(element1);
                    elementFocus(element1);
                    String value = element1.getText();
                    Assert.assertEquals(text, value);
//                System.out.println(element1.getText() + " is displayed " + PageName + " page");
                }
            } else {
                Thread.sleep(2000);
                WebElement element1 = driver.findElement(By.xpath("//h2[text()='" + text + "']"));
                if (element1.isDisplayed()) {
                    elementFocus(element1);
                    String value = element1.getText();
                    Assert.assertEquals(text, value);
//                System.out.println(element1.getText() + " is displayed " + PageName + " page");
                }
            }


        } catch (Exception e) {

        }
    }

    public static void SaveAndClick(String text) {
        try {
            shortWait();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            JavascriptExecutor jsc = (JavascriptExecutor) driver;
            jsc.executeScript("window.scrollBy(0,150)");
//           shortWait();
            WaitUntil(Savebtn);
            jsClick(Savebtn);
            shortWait();
            WebElement element = driver.findElement(By.xpath("//span[text()='" + text + "']"));
            WaitUntil(element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            shortWait();

            jsClick(element);
        } catch (Exception e) {
            System.out.println("Exception in SaveAndClick method" + e);
        }
    }

    public static void UploadFile(WebElement element, String path) throws AWTException, InterruptedException {
        shortWait();
        WebElement file = element;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", file);
        Robot r = new Robot();
        Thread.sleep(2000);
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);

        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(7000);
        driver.findElement(By.xpath("//span[text()='Done']")).click();

    }

    public static void UploadFile1(WebElement element, String path) throws AWTException, InterruptedException {
        shortWait();
        WebElement file = element;
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", file);
        Robot r = new Robot();
        Thread.sleep(3000);
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Thread.sleep(5000);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);

        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(7000);
        driver.findElement(By.xpath("//span[text()='Done']")).click();

    }


    public static void shortWait() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void ScrollUntil(WebElement element) throws AWTException {
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].scrollIntoView(true);", element);
        Robot r = new Robot();
        for (int i = 1; i <= 3; i++) {
            r.keyPress(KeyEvent.VK_UP);
        }
        r.keyRelease(KeyEvent.VK_UP);
    }

    public static void ScrollUntil1(WebElement element) throws AWTException, InterruptedException {
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        jsc.executeScript("window.scrollBy(0,-100)");
    }

    public static void ScrollByRobot(int n) throws AWTException {
        Robot robot = new Robot();
        for (int i = 1; i <= n; i++) {
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }
    }

    public static HashMap DataFromExcell(String SheetName, String PageName) throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\NABERS_DATA.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook xss = new XSSFWorkbook(fis);
        XSSFSheet xs = xss.getSheet(SheetName);
        HashMap<String, String> data = new HashMap<>();
        for (int i = 0; i <= xs.getLastRowNum(); i++) {
            Row R_No = xs.getRow(i);
            Cell value = R_No.getCell(0);
            String cellvalue = value.toString();
            if (cellvalue.equalsIgnoreCase(PageName)) {
                for (int cell = 0; cell <= R_No.getLastCellNum() - 1; cell++) {
                    Row header = xs.getRow(i);
                    Cell headerValue = header.getCell(cell);
                    String hv = headerValue.toString();
                    Row headerbelowvalue = xs.getRow(i + 1);
                    Cell flowvalue = headerbelowvalue.getCell(cell);
                    String fv = flowvalue.toString();
                    data.put(hv, fv);
                }
            }
        }
//        System.out.println(data);
        return data;
    }

    public static String DataFormatter(String date) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date inputDate = inputFormat.parse(date);
        String value = outputFormat.format(inputDate);
        return value;
    }

    public static void TextField(WebElement element, String value) throws Exception {
        ShortWait();
        WaitUntil(element);
        if (element.isDisplayed()) {
            elementFocus(element);
            element.sendKeys(value);
        }
    }

    public static void SelectFromDropDown(WebElement element, List<WebElement> elements, String text) throws InterruptedException {
        Click(element);
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(text)) {
                ele.click();
            }
        }
    }

    public static void ShortWait() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    public static void ChooseRadioBtn(List<WebElement> elements, String text) throws InterruptedException {
        Thread.sleep(2000);
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(text)) {
                WaitUntilElementToBeClickable(ele);
                jsClick(ele);
                break;
            }
        }
    }

    public static int findRowPositionInExcel(String dataSheetFile, String dataSheetName, int colNumber, String columnHeader) throws IOException, InvalidFormatException {
        FileInputStream fis = new FileInputStream(dataSheetFile);
        XSSFWorkbook xss = new XSSFWorkbook(fis);
        XSSFSheet sheet = xss.getSheet(dataSheetName);
        int rowPosition = -1;
        try {
            for (int rowNumber = 0; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
                Row row = sheet.getRow(rowNumber);
                Cell cell = row.getCell(colNumber);
                String columnVal = cell.toString();
                if (columnVal.equalsIgnoreCase(columnHeader)) {
                    rowPosition = rowNumber;
                    break;
                }
            }
        } catch (Exception e) {

        }
        xss.close();
        return rowPosition;
    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
        }
        return date != null;
    }

    public static HashMap<Integer, HashMap<String, String>> DataForTable(String ratingSheetName, WebDriver driver, String tableName) throws IOException, InvalidFormatException {
        String dataSheetPathAndName = System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\NABERS_DATA.xlsx";
        FileInputStream fis = new FileInputStream(dataSheetPathAndName);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(ratingSheetName);

        /*code start for table name reding*/
        HashMap<Integer, String> hmTableNameRead = new HashMap();
        for (int v = 0; v <= sheet.getLastRowNum(); v++) {
            Row sheetRow = sheet.getRow(v);
            try {
                Cell sheetCell = sheetRow.getCell(0);

                if (!sheetCell.toString().equalsIgnoreCase("")) {
                    hmTableNameRead.put(v, sheetCell.toString());
                }
            } catch (Exception e) {
            }
        }
        /*code end for table name reading*/


        int rowNumberIs = findRowPositionInExcel(dataSheetPathAndName, ratingSheetName, 0, tableName);

//        System.out.println(" RownumberIs  "+rowNumberIs);

        HashMap<Integer, HashMap<String, String>> hashMapData = new HashMap();
        Integer noOfRowsInTable = 0;
        String key_Main_Page = null;
        int rowNumberIsforKey = rowNumberIs;
        do {

            Row rowKey = sheet.getRow(rowNumberIsforKey);
            Row rowvalue = sheet.getRow(rowNumberIs + 1);

            HashMap<String, String> executionPerameters = new HashMap<>();
            for (int cell = 1; cell < rowKey.getLastCellNum(); cell++) {
                try {
                    Cell cellvalue = rowvalue.getCell(cell);
                    String value_Main_Page = cellvalue.toString();

                    if (isValidFormat("dd-MMM-yyyy", value_Main_Page)) {
                        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date inputDate = inputFormat.parse(value_Main_Page);
                        value_Main_Page = outputFormat.format(inputDate);
                    }

                    Cell keyValue = rowKey.getCell(cell);
                    key_Main_Page = keyValue.toString();
                    executionPerameters.put(key_Main_Page, value_Main_Page);
                } catch (Exception e) {
                    break;
                }

            }
//            System.out.println(executionPerameters);
            noOfRowsInTable++;
            hashMapData.put(noOfRowsInTable, executionPerameters);
//            System.out.println(hashMapData);
            rowNumberIs++;
            rowvalue = sheet.getRow(rowNumberIs + 1);
            Cell keyValue = rowvalue.getCell(1);
            key_Main_Page = keyValue.toString();
//            if(key_Main_Page.isEmpty()){
//                break;
//            }
        } while (!key_Main_Page.isEmpty());


        return hashMapData;
    }

    public static void FillDataIntoNonUtilityMeter(WebDriver driver, String executionSheetName, String TableName) throws IOException, InvalidFormatException, InterruptedException, AWTException {

        HashMap<Integer, HashMap<String, String>> tableData = DataForTable1(executionSheetName, driver, TableName);

        System.out.println(tableData);
        Thread.sleep(1500);

        Robot robot = new Robot();

        List<WebElement> ele = driver.findElements(By.xpath("//div[2]/div/div/div/table/thead/tr/th"));
        int tableHeaderCount = ele.size();
        int count = 0;
        for (int rowOfTable = 1; rowOfTable <= tableData.size(); rowOfTable++) {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//small[text()='Add rows']")).click();
            for
            (int i = 1; i < tableHeaderCount; i++) {
                try {
                    String vinayXp = "//div[2]/div/div/div/table/thead/tr/th[" + i + "]";
                    WebElement element = driver.findElement(By.xpath(vinayXp));
                    int cell = i - 1;
                    String v = element.getText();
                    if (!v.equalsIgnoreCase("")) {
                        int row = 1;
                        String rowinWeb = "//div[1]/div/div/div/table/tbody/tr[" + rowOfTable + "]/th";
//                        System.out.println(driver.findElement(By.xpath(rowinWeb)).getText());
                        Thread.sleep(1000);

                        for (Map.Entry<String, String> cellOfTable : tableData.get(rowOfTable).entrySet()) {
                            String cellval = "//div[1]/div/div/div/table/thead/tr/th[" + i + "]/../../../tbody/tr[" + rowOfTable + "]/td[" + cell + "]";
                            WebElement cellinweb = driver.findElement(By.xpath(cellval));
                            String tableKeyValue = cellOfTable.getKey();
                            if (element.getText().contains(tableKeyValue)) {
                                if (element.getText().contains("Meter read")) {
                                    count++;
                                }
                                if (count == 2) {
                                    Thread.sleep(1000);
                                    clickAndEnterValueInTextBox(cellinweb, tableData.get(rowOfTable).get("Last Meter read"));
                                    robot.keyPress(KeyEvent.VK_ENTER);
                                    robot.keyRelease(KeyEvent.VK_ENTER);
                                    break;
                                }
//                                System.out.println(cellval);
                                Thread.sleep(1000);
                                clickAndEnterValueInTextBox(cellinweb, cellOfTable.getValue());
                                robot.keyPress(KeyEvent.VK_ENTER);
                                robot.keyRelease(KeyEvent.VK_ENTER);
//                                System.out.println(rowOfTable + " " + element.getText());
                                break;
                            } else if
                            (element.getText().contains(tableKeyValue.substring(0, tableKeyValue.length() - 2))) {
                                if
                                (cellinweb.getText().isEmpty()) {
                                    Thread.sleep(1000);
                                    clickAndEnterValueInTextBox(cellinweb, cellOfTable.getValue());
                                    robot.keyPress(KeyEvent.VK_ENTER);
                                    robot.keyRelease(KeyEvent.VK_ENTER);
//                                    System.out.println(rowOfTable + " " + element.getText());
                                }
                            }
                        }
                    }
                } catch
                (Exception e) {
                }
            }
        }
    }


    public static void FillDataIntoTheWebTable1(WebDriver driver, String executionSheetName, String TableName) throws IOException, InvalidFormatException, InterruptedException, AWTException {

        HashMap<Integer, HashMap<String, String>> tableData = DataForTable1(executionSheetName, driver, TableName);

        Thread.sleep(1000);

        Robot robot = new Robot();

        List<WebElement> ele = driver.findElements(By.xpath("//div[2]/div/div/div/table/thead/tr/th"));
        int tableHeaderCount = ele.size();
        for (int rowOfTable = 1; rowOfTable <= tableData.size(); rowOfTable++) {
            Thread.sleep(1500);
            driver.findElement(By.xpath("//small[text()='Add rows']")).click();
            for
            (int i = 1; i < tableHeaderCount; i++) {
                try {
                    String vinayXp = "//div[2]/div/div/div/table/thead/tr/th[" + i + "]";
                    WebElement element = driver.findElement(By.xpath(vinayXp));
                    int cell = i - 1;
                    String v = element.getText();
                    if (!v.equalsIgnoreCase("")) {
                        int row = 1;
                        String rowinWeb = "//div[1]/div/div/div/table/tbody/tr[" + rowOfTable + "]/th";
//                        System.out.println(driver.findElement(By.xpath(rowinWeb)).getText());
                        Thread.sleep(1500);

                        for (Map.Entry<String, String> cellOfTable : tableData.get(rowOfTable).entrySet()) {
                            String cellval = "//div[1]/div/div/div/table/thead/tr/th[" + i + "]/../../../tbody/tr[" + rowOfTable + "]/td[" + cell + "]";
                            WebElement cellinweb = driver.findElement(By.xpath(cellval));
                            String tableKeyValue = cellOfTable.getKey();
                            if (element.getText().contains(tableKeyValue)) {
//                                System.out.println(cellval);
                                Thread.sleep(1000);
                                clickAndEnterValueInTextBox(cellinweb, cellOfTable.getValue());
                                robot.keyPress(KeyEvent.VK_ENTER);
                                robot.keyRelease(KeyEvent.VK_ENTER);
//                                System.out.println(rowOfTable + " " + element.getText());
                                break;
                            } else if
                            (element.getText().contains(tableKeyValue.substring(0, tableKeyValue.length() - 2))) {
                                if
                                (cellinweb.getText().isEmpty()) {
                                    Thread.sleep(1000);
                                    clickAndEnterValueInTextBox(cellinweb, cellOfTable.getValue());
                                    robot.keyPress(KeyEvent.VK_ENTER);
                                    robot.keyRelease(KeyEvent.VK_ENTER);
//                                    System.out.println(rowOfTable + " " + element.getText());
                                }
                            }
                        }
                    }
                } catch
                (Exception e) {
                }
            }
        }
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//label[text()='Start billing period']/following-sibling::lightning-input//input")).click();

    }

    public static void FillDataIntoTheWebTable(WebDriver driver, String executionSheetName, String TableName) throws IOException, InvalidFormatException, InterruptedException, AWTException {

        HashMap<Integer, HashMap<String, String>> tableData = DataForTable1(executionSheetName, driver, TableName);

        System.out.println(tableData);
        Thread.sleep(1500);

        Robot robot = new Robot();

        List<WebElement> ele = driver.findElements(By.xpath("//div[2]/div/div/div/table/thead/tr/th"));
        int tableHeaderCount = ele.size();
        for
        (int rowOfTable = 1; rowOfTable <= tableData.size(); rowOfTable++) {
            Thread.sleep(1500);
            driver.findElement(By.xpath("//small[text()='Add rows']")).click();
            for
            (int i = 1; i < tableHeaderCount; i++) {
                try {
                    String vinayXp = "//div[2]/div/div/div/table/thead/tr/th[" + i + "]";
                    WebElement element = driver.findElement(By.xpath(vinayXp));
                    int cell = i - 1;
                    String v = element.getText();
                    if (!v.equalsIgnoreCase("")) {
                        int row = 1;
                        String rowinWeb = "//div[1]/div/div/div/table/tbody/tr[" + rowOfTable + "]/th";
//                        System.out.println(driver.findElement(By.xpath(rowinWeb)).getText());
//                        Thread.sleep(2000);
                        for (Map.Entry<String, String> cellOfTable : tableData.get(rowOfTable).entrySet()) {
                            String cellval = "//div[1]/div/div/div/table/thead/tr/th[" + i + "]/../../../tbody/tr[" + rowOfTable + "]/td[" + cell + "]";
                            WebElement cellinweb = driver.findElement(By.xpath(cellval));
                            String tableKeyValue = cellOfTable.getKey();
                            if (element.getText().contains(tableKeyValue)) {
//                                System.out.println(cellval);
                                Thread.sleep(1000);
                                clickAndEnterValueInTextBox(cellinweb, cellOfTable.getValue());
                                robot.keyPress(KeyEvent.VK_ENTER);
                                robot.keyRelease(KeyEvent.VK_ENTER);
//                                System.out.println(rowOfTable + " " + element.getText());
                                break;
                            } else if
                            (element.getText().contains(tableKeyValue.substring(0, tableKeyValue.length() - 2))) {
                                if
                                (cellinweb.getText().isEmpty()) {
                                    Thread.sleep(1000);
                                    clickAndEnterValueInTextBox(cellinweb, cellOfTable.getValue());
                                    robot.keyPress(KeyEvent.VK_ENTER);
                                    robot.keyRelease(KeyEvent.VK_ENTER);
//                                    System.out.println(rowOfTable + " " + element.getText());
                                }
                            }
                        }
                    }
                } catch
                (Exception e) {
                }
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Start billing period']/following-sibling::lightning-input//input")).click();

    }

    public static void EnterValueIntoAreaAndHourTable(WebDriver driver, String executionSheetName, String TableName) throws InterruptedException, AWTException, IOException, InvalidFormatException {

        HashMap<Integer, HashMap<String, String>> tableData = DataForTable1(executionSheetName, driver, TableName);

        System.out.println(tableData);
        Thread.sleep(1500);

        Robot robot = new Robot();

        List<WebElement> ele = driver.findElements(By.xpath("//div[@class='ht_clone_top_left_corner handsontable']/div/div/div/table/thead/tr/th/div"));
        int tableHeaderCount = ele.size();
        for
        (int rowOfTable = 1; rowOfTable <= tableData.size(); rowOfTable++) {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//small[text()='Add rows']")).click();
            for (int i = 1; i <= tableHeaderCount; i++) {
                try {
                    String Xpath = "//div[@class='ht_clone_top_left_corner handsontable']/div/div/div/table/thead/tr/th[" + i + "]/div/span";
                    WebElement element = driver.findElement(By.xpath(Xpath));
                    int cell = i - 1;
                    String v = element.getText();
                    if (!v.equalsIgnoreCase("")) {
                        int row = 1;
                        String rowinWeb = "//div[1]/div/div/div/table/tbody/tr[" + rowOfTable + "]/th";
                        Thread.sleep(1000);

                        for (Map.Entry<String, String> cellOfTable : tableData.get(rowOfTable).entrySet()) {
                            String cellval = "//div[1]/div/div[4]/div/div/div/table/tbody/tr[" + rowOfTable + "]/td[" + cell + "]";
                            WebElement cellinweb = driver.findElement(By.xpath(cellval));
                            String tableKeyValue = cellOfTable.getKey();
                            if (element.getText().contains(tableKeyValue)) {
//                                System.out.println(cellval);
                                Thread.sleep(1000);
                                clickAndEnterValueInTextBox(cellinweb, cellOfTable.getValue());
                                robot.keyPress(KeyEvent.VK_ENTER);
                                robot.keyRelease(KeyEvent.VK_ENTER);
                                Thread.sleep(1500);
                                break;
//                                System.out.println(rowOfTable + " " + element.getText());
                            } else if
                            (element.getText().contains(tableKeyValue.substring(0, tableKeyValue.length() - 2))) {
                                if
                                (cellinweb.getText().isEmpty()) {
                                    Thread.sleep(1500);
                                    clickAndEnterValueInTextBox(cellinweb, cellOfTable.getValue());
                                    robot.keyPress(KeyEvent.VK_ENTER);
                                    robot.keyRelease(KeyEvent.VK_ENTER);
//                                    System.out.println(rowOfTable + " " + element.getText());
                                }
                            }
                        }
                    }
                } catch
                (Exception e) {
                }
            }
        }
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//label[text()='Start billing period']/following-sibling::lightning-input//input")).click();

    }

    public static void clickAndEnterValueInTextBox(WebElement element, String inputText) throws Exception {
        if (element.isDisplayed()) {
            element.click();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Actions action = new Actions(driver);
            action.sendKeys(element, inputText).perform();

        }
    }

    public static void EnterDetailsIntoGridElectricity(String sector) throws Exception {
        HashMap<String, String> ReadFromExcel = DataFromExcell(sector, "Grid electricity");
        ChooseRadioBtn(DoPremisesHaveEmbeddeNetwork, ReadFromExcel.get("Does Premises have embedded work"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        if (ReadFromExcel.get("Utility Meter").equalsIgnoreCase("Yes")) {
//            WaitUntil(AddUtilityMeter);
//            jsClick(AddUtilityMeter);
//            shortWait();
//            VerifyTabInNavigationMenu("Utility 1");
            HashMap<Integer, HashMap<String, String>> tableData = DataForTable(sector + "TabularData", driver, "Utility meter");
            System.out.println(tableData);
            shortWait();
            for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
                WaitUntil(AddUtilityMeter);
                jsClick(AddUtilityMeter);
                shortWait();
                UtilityMeter(NumberOfUtility, driver, tableData.get(NumberOfUtility), sector + "TabularData");
                shortWait();
            }
        }
        if (ReadFromExcel.get("Non Utility Meter").equalsIgnoreCase("Yes")) {
            HashMap<Integer, HashMap<String, String>> tableData = DataForTable(sector + "TabularData", driver, "Non Utility Meter1");
            System.out.println(tableData);
            Thread.sleep(2000);
            for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
                NonUtilityMeter(NumberOfUtility, driver, tableData.get(NumberOfUtility), sector + "TabularData");
                Thread.sleep(2000);
            }
        }
        if (ReadFromExcel.get("Non-utility meter exclusions").equalsIgnoreCase("Yes")) {
            shortWait();
            NonUtilityMeterExclusion(driver, sector + "TabularData");

        }
    }

    public static void EnterDetailsIntoRenewableElectricity(String Sector) throws InterruptedException {
        try {
            CommonPageElements commonPageElements = new CommonPageElements(driver);
            HashMap<String, String> ReadFromExcel = DataFromExcell(Sector, "Renewable electricity");
            if (ReadFromExcel.get("Do Premises have OREG").equalsIgnoreCase("Yes")) {
                ChooseRadioBtn(commonPageElements.Do_System_Has_OREG, ReadFromExcel.get("Do Premises have OREG"));
//                String path = System.getProperty("user.dir") + "\\src\\test\\java\\Documents\\dummy-pdf_2.pdf";
                WaitUntil(commonPageElements.UploadFile);
                DataCenter dataCenter = new DataCenter();
                dataCenter.EnterDetailsIntoRatingDetails();
                TextField(commonPageElements.TotalAmountOfOREG, ReadFromExcel.get("total capacity of the OREG"));
                ScrollByRobot(1);
                String value = ReadFromExcel.get("OREG system is connected to  RMRS");
                switch (value) {
                    case "Yes":
                        System.out.println(ReadFromExcel.get("OREG system is connected to  RMRS"));
                        ChooseRadioBtn(commonPageElements.OREGIsConnectedToRMRS, ReadFromExcel.get("OREG system is connected to  RMRS"));
                        TextField(commonPageElements.DateOfValidation, "30/4/2024");
                        TextField(commonPageElements.TotalOnsiteeRenewableEnergyConsumption, ReadFromExcel.get("total onsite renewable electricity consumption"));
                        TextField(commonPageElements.LGCsWereCreatedAndSold, ReadFromExcel.get("How many LGCs were created and sold"));
                        TextField(commonPageElements.LGCsWereVoluntarilySurrendered, ReadFromExcel.get("How many LGCs were voluntarily surrendered"));
                        ChooseRadioBtn(commonPageElements.HasOnsiteRenewableConsumptionEnteredOnThisPage, ReadFromExcel.get("Has onsite renewable consumption entered on this page"));
                        TextField(commonPageElements.totalAmountOfDe_CoupledGreenpower, ReadFromExcel.get("total amount of de-coupled Greenpower purchased"));
                        TextField(commonPageElements.offsiteLargeScaleGenerationCertificates, ReadFromExcel.get("offsite Large-scale Generation Certificates"));
                        TextField(commonPageElements.RenewableElectricityTextarea, "Nabers");
                        break;

                    case "No":
                        ChooseRadioBtn(commonPageElements.OREGIsConnectedToRMRS, ReadFromExcel.get("OREG system is connected to  RMRS"));

                        break;

                    case "Not applicable":
                        ChooseRadioBtn(commonPageElements.OREGIsConnectedToRMRS, ReadFromExcel.get("OREG system is connected to  RMRS"));

                        break;

                    default:
                        System.out.println(" No Option selected");
                }

            } else {
                ChooseRadioBtn(commonPageElements.Do_System_Has_OREG, ReadFromExcel.get("Do Premises have OREG"));
                TextField(commonPageElements.totalAmountOfDe_CoupledGreenpower, ReadFromExcel.get("total amount of de-coupled Greenpower purchased"));
                TextField(commonPageElements.offsiteLargeScaleGenerationCertificates, ReadFromExcel.get("offsite Large-scale Generation Certificates"));

            }

        } catch (Exception e) {
            System.out.println("upload  " + e);
        }


    }


    public static void EnterDetailsIntoGasAndLPG(String sector) throws Exception {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        HashMap<String, String> ReadFromExcel = DataFromExcell(sector, "Gas and LPG");
        if (ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?").equalsIgnoreCase("Yes")) {
            shortWait();
            ChooseRadioBtn(commonPageElements.AreThereAnySourcesOfGas_LPGInTheRatedPremises, ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?"));
            if (ReadFromExcel.get("Add utility meter  inclusion").equalsIgnoreCase("Yes")) {
                WaitUntil(AddUtilityMeter);
                jsClick(AddUtilityMeter);
                Thread.sleep(3000);
                HashMap<Integer, HashMap<String, String>> tableData = DataForTable(sector + "TabularData", driver, "Gas and LPG utility meter");
                Thread.sleep(2000);
                for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
                    GasAndLpgUtilityMeter(NumberOfUtility, driver, tableData.get(NumberOfUtility), sector + "TabularData");
                    shortWait();
                    driver.findElement(By.xpath("//span[text()='Gas and LPG']")).click();
                }
            }
        } else {

        }
    }

    public static void EnterDetailsIntoGasAndLPG1(String PageName, String sector) throws Exception {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        HashMap<String, String> ReadFromExcel = DataFromExcell(sector, "Gas and LPG");
        if (ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?").equalsIgnoreCase("Yes")) {
            shortWait();
            ChooseRadioBtn(commonPageElements.AreThereAnySourcesOfGas_LPGInTheRatedPremises, ReadFromExcel.get("Are there any sources of gas or LPG in the rated premises?"));
            if (ReadFromExcel.get("Add utility meter  inclusion").equalsIgnoreCase("Yes")) {
                WaitUntil(AddUtilityMeter);
                jsClick(AddUtilityMeter);
                System.out.println(PageName+" utility meter");
                Thread.sleep(3000);
                HashMap<Integer, HashMap<String, String>> tableData = DataForTable(sector + "TabularData", driver, PageName+" utility meter");
                Thread.sleep(2000);
                for (int NumberOfUtility = 1; NumberOfUtility <= tableData.size(); NumberOfUtility++) {
                    GasAndLpgUtilityMeter(NumberOfUtility, driver, tableData.get(NumberOfUtility), sector + "TabularData");
                    shortWait();
                    driver.findElement(By.xpath("//span[text()='Gas and LPG']")).click();
                }
            }

        } else {

        }


    }

    public static void EnterDetailsIntoDiesel(String Sector) throws IOException, InterruptedException {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        HashMap<String, String> ReadFromExcel = DataFromExcell(Sector, "Diesel");
        if (ReadFromExcel.get("Are there any sources of diesel").equalsIgnoreCase("Yes")) {
            // need to write "Yes" flow.
        } else {
            ChooseRadioBtn(commonPageElements.AreThereAnySourcesOfDieselInTheRatedPremises, ReadFromExcel.get("Are there any sources of diesel"));
        }

    }


    public static void WaterUtilityMeter(int rowNumber, HashMap datavalues, String executionSheetName) throws Exception {
        try {

            CommonPageElements commonPageElements = new CommonPageElements(driver);
            WaitUntil(GasAndLpgMeterDetails);
            ScrollUntil(GasAndLpgMeterDetails);
            HashMap<Integer, HashMap<String, String>> tableData = DataForTable(executionSheetName, driver, "Water Utility meter");
            System.out.println(tableData.get(rowNumber).get("Description of coverage"));
            Thread.sleep(2000);
            TextField(commonPageElements.DescriptionOfCoverage, tableData.get(rowNumber).get("Description of coverage").toString());
            TextField(commonPageElements.Meter_Number, tableData.get(rowNumber).get("Meter number").toString());
            TextField(commonPageElements.WaterProvider, tableData.get(rowNumber).get("Water provider/supplier").toString());
            TextField(commonPageElements.AccountNumber, tableData.get(rowNumber).get("Account number").toString());
            elementFocus(commonPageElements.StartingDate);
            elementFocus(commonPageElements.EndingDate);
//            FillDataIntoTheWebTable1(driver, executionSheetName, datavalues.get("Table").toString());
            FillDataIntoTheWebTable(driver, executionSheetName, datavalues.get("Table").toString());
            shortWait();
            driver.findElement(By.xpath("//span[text()='Water']")).click();

        } catch (Exception e) {

        }
    }

    public static void UtilityMeter(int rowNumber, WebDriver driver, HashMap datavalues, String executionSheetName) throws Exception {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        WaitUntil(MeterDetails);
        ScrollUntil(MeterDetails);
        HashMap<Integer, HashMap<String, String>> tableData = DataForTable(executionSheetName, driver, "Utility meter");
        Thread.sleep(1500);
        TextField(commonPageElements.DescriptionOfCoverage, tableData.get(rowNumber).get("Description of coverage").toString());
        TextField(commonPageElements.NMI, tableData.get(rowNumber).get("NMI").toString());
        TextField(commonPageElements.ElectricityProvider, tableData.get(rowNumber).get("Electricity provider/supplier").toString());
        TextField(commonPageElements.AccountNumber, tableData.get(rowNumber).get("Account number").toString());
        elementFocus(commonPageElements.StartingDate);
        elementFocus(commonPageElements.EndingDate);
        FillDataIntoTheWebTable(driver, executionSheetName, datavalues.get("Table").toString());
        ScrollByRobot(1);
        ChooseRadioBtn(commonPageElements.WasAnyOfTheGreenPowerYou_veEnteredAboveOn_Sold, tableData.get(rowNumber).get("Was any of the GreenPower you’ve entered above on-sold"));
        shortWait();
        driver.findElement(By.xpath("//span[text()='Grid electricity']")).click();
    }

    public static void NonUtilityMeter(int rowNumber, WebDriver driver, HashMap datavalues, String executionSheetName) throws IOException, InvalidFormatException, InterruptedException, AWTException {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        HashMap<String, String> ReadFromExcel = DataFromExcell(executionSheetName, "Non Utility Meter");
        shortWait();
        driver.findElement(By.xpath("//button[text()='Add non-utility meter inclusion']")).click();
        Thread.sleep(2000);
        FillDataIntoNonUtilityMeter(driver, executionSheetName, ReadFromExcel.get("Table"));
        shortWait();
        ChooseRadioBtn(commonPageElements.ProofOfRMRSHaveValidatedFor10years, ReadFromExcel.get("Proof of RMRS have validated for 10 years"));
        ChooseRadioBtn(commonPageElements.DidAnyMetersRequireAdjustment, ReadFromExcel.get("did any meters require adjustment?"));
        shortWait();
        driver.findElement(By.xpath("//span[text()='Grid electricity']")).click();

    }

    public static void NonUtilityMeterExclusion(WebDriver driver, String executionSheetName) throws Exception {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        HashMap<String, String> ReadFromExcel = DataFromExcell(executionSheetName, "Non-utility meter exclusions");
        shortWait();
        driver.findElement(By.xpath("//button[text()='Add non-utility meter exclusions']")).click();
        Thread.sleep(2000);
        FillDataIntoNonUtilityMeter(driver, executionSheetName, ReadFromExcel.get("Table"));
        ScrollUntil(commonPageElements.DownloadTemplate);
        shortWait();
        ChooseRadioBtn(commonPageElements.DidAnyMetersRequireAdjustment, ReadFromExcel.get("did any meters require adjustment?"));
        ChooseRadioBtn(commonPageElements.ProofOfRMRSHaveValidatedFor10years, ReadFromExcel.get("Proof Of RMRS Have Validated For 10years"));
        shortWait();
        driver.findElement(By.xpath("//span[text()='Grid electricity']")).click();

    }

    public static void NonUtilityMeterExclusion1(WebDriver driver, String executionSheetName, String PageName) throws Exception {
        CommonPageElements commonPageElements = new CommonPageElements(driver);

        HashMap<String, String> ReadFromExcel = DataFromExcell(executionSheetName, PageName + " Non-utility meter exclusions");
        System.out.println("fjdk " + ReadFromExcel);
        shortWait();
        driver.findElement(By.xpath("//button[text()='Add non-utility meter exclusions']")).click();
        Thread.sleep(4000);
        System.out.println(ReadFromExcel.get("Table"));
//        FillDataIntoNonUtilityMeter(driver, executionSheetName, ReadFromExcel.get("Table"));
//        ScrollUntil(commonPageElements.DownloadTemplate);
//        shortWait();
//        ChooseRadioBtn(commonPageElements.DidAnyMetersRequireAdjustment, ReadFromExcel.get("did any meters require adjustment?"));
//        ChooseRadioBtn(commonPageElements.ProofOfRMRSHaveValidatedFor10years, ReadFromExcel.get("Proof Of RMRS Have Validated For 10years"));
//        shortWait();
//        driver.findElement(By.xpath("//span[text()='"+PageName+"']")).click();

    }


    public static HashMap<Integer, HashMap<String, String>> DataForTable1(String ratingSheetName, WebDriver driver, String tableName) throws IOException, InvalidFormatException {
        String dataSheetPathAndName = System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\NABERS_DATA.xlsx";
        FileInputStream fis = new FileInputStream(dataSheetPathAndName);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(ratingSheetName);

        /*code start for table name reding*/
        HashMap<Integer, String> hmTableNameRead = new HashMap();
        for (int v = 0; v <= sheet.getLastRowNum(); v++) {
            Row sheetRow = sheet.getRow(v);
            try {
                Cell sheetCell = sheetRow.getCell(0);

                if (!sheetCell.toString().equalsIgnoreCase("")) {
                    hmTableNameRead.put(v, sheetCell.toString());
                }
            } catch (Exception e) {
            }
        }
        /*code end for table name reading*/


        int rowNumberIs = findRowPositionInExcel(dataSheetPathAndName, ratingSheetName, 0, tableName);

        System.out.println(" RownumberIs  " + rowNumberIs);

        HashMap<Integer, HashMap<String, String>> hashMapData = new HashMap();
        Integer noOfRowsInTable = 0;
        String key_Main_Page = null;
        int rowNumberIsforKey = rowNumberIs;
        do {

            Row rowKey = sheet.getRow(rowNumberIsforKey);
            Row rowvalue = sheet.getRow(rowNumberIs + 1);

            HashMap<String, String> executionPerameters = new HashMap<>();
            for (int cell = 1; cell < rowKey.getLastCellNum(); cell++) {
                try {
                    Cell cellvalue = rowvalue.getCell(cell);
                    String value_Main_Page = cellvalue.toString();

                    if (isValidFormat("dd-MMM-yyyy", value_Main_Page)) {
                        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date inputDate = inputFormat.parse(value_Main_Page);
                        value_Main_Page = outputFormat.format(inputDate);
                    }

                    Cell keyValue = rowKey.getCell(cell);
                    key_Main_Page = keyValue.toString();
                    executionPerameters.put(key_Main_Page, value_Main_Page);
                } catch (Exception e) {
                    break;
                }

            }
            System.out.println(executionPerameters);
            noOfRowsInTable++;
            hashMapData.put(noOfRowsInTable, executionPerameters);
//            System.out.println(hashMapData);
            rowNumberIs++;
            rowvalue = sheet.getRow(rowNumberIs + 1);
            Cell keyValue = rowvalue.getCell(1);
            key_Main_Page = keyValue.toString();
//            if(key_Main_Page.isEmpty()){
//                break;
//            }
        } while (!key_Main_Page.isEmpty());


        return hashMapData;
    }

    public static void TakeScreenShot(String Name) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            String formattedDateTime = now.format(formatter);

            String desc = "D:\\NABERS_PROJECT\\src\\main\\java\\Screenshots\\" + Name + " " + formattedDateTime + ".png";
            File path = Paths.get(desc).toFile();
            Files.copy(src.toPath(), path.toPath());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void GasAndLpgUtilityMeter(int rowNumber, WebDriver driver, HashMap datavalues, String executionSheetName) throws Exception {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        WaitUntil(GasAndLpgMeterDetails);
        ScrollUntil(GasAndLpgMeterDetails);
        HashMap<Integer, HashMap<String, String>> tableData = DataForTable(executionSheetName, driver, "Gas and LPG utility meter");
        Thread.sleep(2000);
        TextField(commonPageElements.DescriptionOfCoverage, tableData.get(rowNumber).get("Description of coverage "));
        TextField(commonPageElements.Meter_Number, tableData.get(rowNumber).get("Meter number"));
        TextField(commonPageElements.GasProvider, tableData.get(rowNumber).get("Gas provider/supplier"));
        TextField(commonPageElements.AccountNumber, tableData.get(rowNumber).get("Account number"));
//        FillDataIntoTheWebTable1(driver, executionSheetName, datavalues.get("Table").toString());
        FillDataIntoTheWebTable(driver, executionSheetName, datavalues.get("Table").toString());
    }

    public static void DieselTanks(int rowNumber, WebDriver driver, HashMap datavalues, String executionSheetName) throws Exception {
        WaitUntil(Tank1);
        HashMap<Integer, HashMap<String, String>> tableData = DataForTable("DataCenterTabularData", driver, "Diesel Tank");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@placeholder='E.g. Backup generator'])[" + rowNumber + "]")).sendKeys(tableData.get(rowNumber).get("What is this tank used for"));
        driver.findElement(By.xpath("(//button[@aria-haspopup='listbox'])[" + rowNumber + "]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("(//button[@aria-haspopup='listbox'])[" + rowNumber + "]/../following-sibling::div/lightning-base-combobox-item/span[@class='slds-media__body']/span[text()]"));

        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(tableData.get(rowNumber).get("Consumption measurement method"))) {
                jsClick(ele);
                break;
            }
        }
        driver.findElement(By.xpath("(//label[text()='Tank capacity (L)'])[" + rowNumber + "]/following-sibling::lightning-input//input")).sendKeys(tableData.get(rowNumber).get("Tank capacity"));
        ShortWait();

        String value = tableData.get(rowNumber).get("Consumption measurement method");
        switch (value) {
            case "Real consumption: bills":

                break;
            case "Tank reading: start and end of rating period":
//                Map<String, String> ReadFromExcel = DataFromExcellUsingLHMap("DataCenterTabularData", value);
//                int HeaderSize = driver.findElements(By.xpath("//div[@class='ht_clone_top handsontable']/div/div/div/table/thead/tr/th")).size();
//                int DataSize = driver.findElements(By.xpath("//div[@class='ht_master handsontable']/div/div/div/table/tbody/tr/td")).size();
//
//                for (int i = 2; i <= HeaderSize - 1; i++) {
//
//                    String element = driver.findElement(By.xpath("//div[@class='ht_clone_top handsontable']/div/div/div/table/thead/tr/th[" + i + "]/div/span")).getText();
//                    System.out.println("tank tables data  " + element);
//                    for (Map.Entry<String, String> data : ReadFromExcel.entrySet()) {
//                        ShortWait();
//                        if (element.contains(data.getKey())) {
//                            for (int j = i - 1; i <= HeaderSize - 1; j++) {
//                                WebElement element1 = driver.findElement(By.xpath("//div[@class='ht_master handsontable']/div/div/div/table/tbody/tr/td[" + j + "]"));
//                                ShortWait();
//                                clickAndEnterValueInTextBox(element1, data.getValue());
//
//                            }
//                        }
//                    }
//
//                }


                break;
            case "Tank readings: end of rating period":
                break;
            case "Tank capacity":
                break;
            case "No consumption for this tank during rating period":
                break;
            default:
                System.out.println("");
                break;
        }

        FillDataIntoTheWebTable1(driver, executionSheetName, datavalues.get("Consumption measurement method").toString());

    }

    public static List<ArrayList> ArrayDataFromExcel(String SheetName, String TableName) throws IOException, InvalidFormatException {
        List<ArrayList> sheetData = new ArrayList<>();
        String path = "D:\\NABERS\\src\\test\\java\\TestData\\NABERS_DATA.xlsx";
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook xss = new XSSFWorkbook(fis);
        XSSFSheet sheet = xss.getSheet("OfficeTabularData");
        for (int v = 0; v <= sheet.getLastRowNum(); v++) {
            Row sheetRow = sheet.getRow(v);
            Cell sheetCell = sheetRow.getCell(0);
            String value = sheetCell.toString();
            Boolean var = false;

            if (value.equalsIgnoreCase(TableName)) {
                int rowNumberIs = findRowPositionInExcel(path, SheetName, 0, TableName);
                System.out.println(rowNumberIs);

                for (int i = rowNumberIs; i <= sheet.getLastRowNum(); i++) {
                    ArrayList rowData = new ArrayList<>();
                    Row row = sheet.getRow(v);
                    for (int j = 1; j <= row.getLastCellNum() - 1; j++) {
                        Cell cell1 = sheet.getRow(i).getCell(j);

                        try {
                            String cellvalue = cell1.toString();
                            rowData.add(cellvalue);
                        } catch (NullPointerException n) {
                            return sheetData;
                        }
                    }
                    sheetData.add(rowData);

                }
            }
        }
        return sheetData;
    }

    public static void VerifyTabInNavigationMenu(String text) throws Exception {
        shortWait();
        WebElement element = driver.findElement(By.xpath("//span[text()='" + text + "']"));
        WaitUntil(element);
        if (element.isDisplayed()) {
            elementFocus(element);
        }
    }

    public static void UserClickOnButton(String text) throws AWTException, InterruptedException {
        ShortWait();
        WebElement element = driver.findElement(By.xpath("//button[text()='" + text + "']"));
        ScrollUntil(element);
        WaitUntil(element);
        if (element.isDisplayed()) {
            jsClick(element);
        }
    }

    public static void CalculateRating() throws InterruptedException {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        jsClick(commonPageElements.CalculateRating);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(commonPageElements.CalculateRating)));
        Thread.sleep(7000);
    }

    public static void ClickOnMenuItem(String item) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//span[text()='" + item + "']"));
        WaitUntil(element);
        jsClick(element);
    }

    public static void validateRatingResults() throws Exception {
        shortWait();
        List<WebElement> result = driver.findElements(By.xpath("//table[@class='noHTMLTableOutputs slds-m-top_small']"));
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        for (WebElement ele: result){
            jsc.executeScript("window.scrollBy(0,150)");
            elementFocus(ele);
            jsc.executeScript("window.scrollBy(0,500)");
        }
        jsc.executeScript("window.scrollBy(0,500)");
        shortWait();
        WebElement ratingInputs = driver.findElement(By.xpath("//table[@class='noHTMLTableInputs slds-m-top_large']"));
        elementFocus(ratingInputs);
        WebElement ratingInputs2 = driver.findElement(By.xpath("//table[@class='noHTMLTableInputsReverse']"));
        elementFocus(ratingInputs2);
    }


    public static void EnterDetailsIntoCertificationProcess(String Sector) {
        try {
            CommonPageElements commonPageElements = new CommonPageElements(driver);
            HashMap<String, String> ReadFromExcel = DataFromExcell(Sector, "Certification process");
            ScrollUntil(commonPageElements.InvoicingDetails);
            jsClick(commonPageElements.IConfirm);
            jsClick(commonPageElements.ConfirmCustomerAuthorisation);
            DataCenter dataCenter = new DataCenter();
            dataCenter.EnterDetailsIntoRatingDetails();
            ScrollByRobot(1);
            if (ReadFromExcel.get("Has this rating been carried out").equalsIgnoreCase("Yes")) {
                FocusListElements(commonPageElements.HasThisRatingBeenCarriedOut);
                ChooseRadioBtn(commonPageElements.HasThisRatingBeenCarriedOut, ReadFromExcel.get("Has this rating been carried out"));
            } else {
                FocusListElements(commonPageElements.HasThisRatingBeenCarriedOut);
                ChooseRadioBtn(commonPageElements.HasThisRatingBeenCarriedOut, ReadFromExcel.get("Has this rating been carried out"));
                TextField(commonPageElements.HasThisRatingBeenCarriedOutTextarea, "Nabers");
            }

            if (ReadFromExcel.get("Did you carry out a site visit?").equalsIgnoreCase("Yes")) {
                FocusListElements(commonPageElements.DidYouCarryOutSiteVisit);
                ChooseRadioBtn(commonPageElements.DidYouCarryOutSiteVisit, ReadFromExcel.get("Did you carry out a site visit?"));
            } else {
                FocusListElements(commonPageElements.DidYouCarryOutSiteVisit);
                ChooseRadioBtn(commonPageElements.DidYouCarryOutSiteVisit, ReadFromExcel.get("Did you carry out a site visit?"));
                TextField(commonPageElements.DidYouCarryOutSiteVisitTextarea, "Nabers");
            }
            System.out.println("Salman  "+ReadFromExcel.get("Do you have any conflict of interest"));
            if (ReadFromExcel.get("Do you have any conflict of interest").equalsIgnoreCase("No")) {
                FocusListElements(commonPageElements.DoYouHaveAnyConflictOfInterest);
                ChooseRadioBtn(commonPageElements.DoYouHaveAnyConflictOfInterest, ReadFromExcel.get("Do you have any conflict of interest"));
            } else {
                FocusListElements(commonPageElements.DoYouHaveAnyConflictOfInterest);
                ChooseRadioBtn(commonPageElements.DoYouHaveAnyConflictOfInterest, ReadFromExcel.get("Do you have any conflict of interest"));
                TextField(commonPageElements.DoYouHaveAnyConflictOfInterestTextarea, "NabersNabers");
            }
            WaitUntil(commonPageElements.ConfirmationOfAccuracy);
            shortWait();
            elementFocus(commonPageElements.ConfirmationOfAccuracy);
            jsClick(commonPageElements.ConfirmationOfAccuracy);
            WaitUntil(commonPageElements.LodgeRating);
            Tooltip();
            shortWait();
            elementFocus(commonPageElements.LodgeRating);
            jsClick(commonPageElements.LodgeRating);

        } catch (Exception e) {
        }
    }

    public static void Tooltip() throws Exception {
        CommonPageElements commonPageElements = new CommonPageElements(driver);
        if (commonPageElements.ToolTip.isDisplayed()){
            elementFocus(commonPageElements.ToolTip);
        }
    }


}
