from selenium.webdriver.common.by import By
from selenium import webdriver

gridUrl = "hub.lambdatest.com/wd/hub"
user = "himanshu.sheth"
accessKey = "yin5rVbp0KcrvhnqubaglRPOKwywdPIyTJPU64jgVNPBfubTe3"

capabilities = {
    'LT:Options': {

        "build": "Chrome Test",
        "name": "Chrome Test",
        "platformName": "Windows 11"
    },
    "browserName": "Chrome",
    "browserVersion": "100.0",
}

url = "https://" + user + ":" + accessKey + "@" + gridUrl
driver = webdriver.Remote(
    command_executor=url,
    desired_capabilities=capabilities)
# Setting preferences for Chrome
# opts = {"download.default_directory": "D:\\Gunjan\\Selenium\\DownloadedFiles"}
# options.add_experimental_option('prefs', opts)
# Setting the driver executable path
# driver = webdriver.Chrome(executable_path='D:\\Gunjan\\Selenium\\chromedriver', chrome_options=options)
# Opening the URL
driver.get("https://www.lambdatest.com/selenium-playground/table-data-download-demo")
driver.maximize_window()
# Locating the download button and clicking on it
driver.find_element(by=By.XPATH, value='//*[@id="example_wrapper"]/div[1]/a[4]').click()
driver.implicitly_wait(10)
# Closing the driver
driver.close()
