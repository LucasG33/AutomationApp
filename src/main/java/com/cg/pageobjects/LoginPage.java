package com.cg.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Component
public class LoginPage {

	private ExtentReports extent;
	private ExtentTest extentTest;

	@Autowired
	WebDriver driver;

	public void openPage() {
		extent = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
		extent.attachReporter(sparkReporter);

		extentTest = extent.createTest("Test Consultoria Global", "Validar que la direccion de correo no es valida");

		driver.get("http://consultoriaglobal.com.ar");

		extentTest.log(Status.INFO, "Se abrió la página de CG.");
	}

	public void navigate() {
		WebElement contactoLink = driver.findElement(By.linkText("Contáctenos"));
		contactoLink.click();
		extentTest.log(Status.INFO, "Se ha redirigido a la seccion de contacto.");

	}

	public void fillForm(String nombre, String email, String asunto, String mensaje) {
		WebElement nombreInput = driver.findElement(By.name("your-name"));
		nombreInput.sendKeys(nombre);
		WebElement emailInput = driver.findElement(By.name("your-email"));
		emailInput.sendKeys(email);
		WebElement asuntoInput = driver.findElement(By.name("your-subject"));
		asuntoInput.sendKeys(asunto);
		WebElement mensajeInput = driver.findElement(By.name("your-message"));
		mensajeInput.sendKeys(mensaje);

		extentTest.log(Status.INFO, "Se ha llenado el formulario.");

	}

	public String getAlert() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@role=\"alert\"])[1]")));
		String lblAlert = driver.findElement(By.xpath("(//span[@role=\"alert\"])[1]")).getText();
		extentTest.log(Status.INFO, "texto correo invalido: " + lblAlert);
		return lblAlert;
	}

	public void sendForm() {
		WebElement enviarButton = driver.findElement(By.xpath("//input[@value=\"Enviar\"]"));

		enviarButton.click();
		extentTest.log(Status.INFO, "Se ha enviado el formulario de contacto");

	}

	public void quitDriver() {

		driver.close();
		driver.quit();

		extentTest.log(Status.INFO, "Se cerró el driver.");

		extent.flush();
	}
}