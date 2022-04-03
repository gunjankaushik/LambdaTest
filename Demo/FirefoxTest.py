from selenium import webdriver
from selenium.webdriver.common.by import By

#Creating webdriver instance of Firefox Options
options = webdriver.FirefoxOptions()

#Setting preferences for Firefox
options.set_preference("browser.download.folderList", 2)
options.set_preference("browser.download.manager.showWhenStarting", False)
options.set_preference("browser.download.dir", 'D:\\Gunjan\\Selenium\\DownloadedFiles')
options.set_preference("browser.helperApps.neverAsk.saveToDisk", "text/plain")
#Defining the Gecko driver executable path
driver = webdriver.Firefox(executable_path='D:\\Gunjan\\Selenium\\geckodriver',options=options)
#Opening the URL
driver.get("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo")
#Maximising the window
driver.maximize_window()
#Locating the different elements viz- text box, Generate File Button and Download link and performing corresponding actions
driver.find_element(by=By.XPATH, value='//*[@id="textbox"]').send_keys("This is a dummy download file!!!!")
driver.find_element(by=By.ID, value='create').click()
driver.find_element(by=By.ID, value='link-to-download').click()
#Closing the webdriver instance
driver.quit()
