from selenium import webdriver
from selenium.webdriver.common.by import By


gridUrl = "hub.lambdatest.com/wd/hub"
user = "himanshu.sheth"
accessKey = "yin5rVbp0KcrvhnqubaglRPOKwywdPIyTJPU64jgVNPBfubTe3"

capabilities = {
    'LT:Options': {
        "build": "MAC OS Build",
        "name": "Safari Test Case",
        "platformName": "MacOS Monterey"
    },
    "browserName": "Opera",
    "browserVersion": "84.0",
}

url = "https://" + user + ":" + accessKey + "@" + gridUrl

driver = webdriver.Remote(
    command_executor=url,
    desired_capabilities=capabilities)
driver.get("https://www.lambdatest.com/selenium-playground/table-data-download-demo")
driver.maximize_window()
driver.implicitly_wait(5)
e1 = driver.find_element(By.XPATH, '//*[@class="dt-button buttons-pdf buttons-html5"]')
if type(e1) is dict:
    ele = list(e1.values())[0]
    e1 = driver.create_web_element(element_id=ele)
e1.click()
driver.quit()
