package com.amc.txrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amc.txbase.ExcelUtils;
import com.amc.txbase.TxBase;


public class RecordLocatorObjects extends TxBase {

	ExcelUtils excelUtils = new ExcelUtils();

	@FindBy(xpath = "//div[contains(text(), 'Record Locator')]")
	WebElement recordLocator;

	@FindBy(xpath = "//input[@type='search']")
	WebElement recordSearchField;
	
	@FindBy(xpath = "//*[@id='recordLocator']/tbody/tr/td[10]/button")
	WebElement recordOpenButton;
	
	@FindBy(xpath = "//div[contains(text(), 'Material')]")
	WebElement Material;
	
	public void recordLocatorSelection() throws Exception {

		switchToFirstFrame();
		
		System.out.println(" Driver Entered Into First Frame successful..");
		
		ExplicitWait(recordLocator);

		recordLocator.click();

		//logStep("RecordLocator button is selected");
		
		System.out.println("RecordLocator button is selected");
		
		switchBackFromFrame();

		Thread.sleep(3000);

		System.out.println(" Driver Exits From First Frame successful..");

	}

	public void recordSearchField() throws Exception {

		
		excelUtils.readingexcelFiles("Records");

					
			switchToSecondFrame();
			
			System.out.println("Driver Entered Into Second Frame successful ..");
					
			ExplicitWait(recordSearchField);
			   
			recordSearchField.getText();
			
				ExplicitWait(recordSearchField);

				Thread.sleep(2000);
				
				//recordSearchField.sendKeys(excelUtils.excelData[i][0]);
				
				//recordSearchField.sendKeys(TxBase.Mattextvalue);
				
				recordSearchField.sendKeys("LSIT01021708");
				
				System.out.println(" Portal Record Is : " + TxBase.Mattextvalue );
							

		ExplicitWait(recordOpenButton);
		
		Thread.sleep(2000);
		
		recordOpenButton.click();
		
		logStep(" WOP to MP to Portal Integration is Success : " + TxBase.Mattextvalue );
		
		System.out.println("Selected record is launched successfully..");
		
		switchBackFromFrame();
		
		System.out.println("Driver Exits From Second Frame successful...");
		
		Thread.sleep(14000);
		
		//int count = 0;

		switchToThirdFrame();

		System.out.println("Driver Entered Into Third Frame Successful..");

		//ExplicitWait(Material);

		//Thread.sleep(2000);

		//Material.click();

		String relatedValue = "Expected Number of Segments";

		String indexValue = null;

		// Taking all data of Material section into collections list
		
		List<WebElement> expList = driver.findElements(By.xpath("//table[starts-with(@id, 'table_id_fld_')]/tbody/tr"));

		// Taking the Expected no# segements value 
		
		for (int i = 30; i <= expList.size(); i++) {

			String expValue = expList.get(i).getText();

			if (expValue.contains(relatedValue)) {

				indexValue = expList.get(i).getText().replaceAll(relatedValue, "").trim();

				break;
			}

		}

		// Converting expected no# of segments string value into Integer value.
		
		int result = Integer.parseInt(indexValue);

		System.out.println("expectedSegments : " + result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		//driverWOP.close();
	}
}