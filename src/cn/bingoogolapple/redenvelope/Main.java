package cn.bingoogolapple.redenvelope;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Main extends UiAutomatorTestCase {
	
	/**
	 * 确保你已经配置好了java、android、ant环境变量
	 * 
	 * 运行UIAutomator
	 * 1. cd到项目根目录
	 * 2. android create uitest-project -n redenvelope -t 1 -p .
	 * 3. 修改build.xml <project name="redenvelope" default="help"> => <project name="redenvelope" default="build">
	 * 4. ant -buildfile build.xml
	 * 5. adb push ./bin/redenvelope.jar /data/local/tmp/
	 * 6. adb shell uiautomator runtest redenvelope.jar -c  cn.bingoogolapple.redenvelope.Main#testAlipay
	 * 
	 * 
	 * 抢完后记得停止UIAutomator（否则你的手机会疯掉的）
	 * ctrl + c
	 */
	public void testAlipay() throws UiObjectNotFoundException {
		UiDevice uiDevice = UiDevice.getInstance();
		uiDevice.pressHome();
		sleep(1000);
		UiObject alipay = new UiObject(new UiSelector().text("支付宝钱包"));
		alipay.clickAndWaitForNewWindow();
		sleep(4000);

		int height = uiDevice.getDisplayHeight() - 150;
		int width = uiDevice.getDisplayWidth() - 150;
		
		for (int i = 0; i < 100; i++) {
			for(int x = 150; x < width;) {
				for(int y= 200; y < height;) {
					uiDevice.click(x, y);
					y += 150;
				}
				x += 150;
			}
		}	
		uiDevice.pressHome();
	}

}