
# RedEnvelope 

## 过年期间自动抢支付宝红包

### 确保你已经配置好了java、android、ant环境变量

#### 运行UIAutomator

1. cd到项目根目录
2. android create uitest-project -n redenvelope -t 1 -p .
3. 修改build.xml <project name="redenvelope" default="help"> => <project name="redenvelope" default="build">
4. ant -buildfile build.xml
5. adb push ./bin/redenvelope.jar /data/local/tmp/
在支付宝钱包首页开始5秒倒计时的时候执行第6步
6. adb shell uiautomator runtest redenvelope.jar -c  cn.bingoogolapple.redenvelope.Main#testAlipay


#### 抢完后记得停止UIAutomator（否则你的手机会疯掉的）
CTRL + C
