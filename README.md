# EIPulseinRestfulAJAX
EEIT71 spring  boot project in Restful AJAX

## 環境設置
eclipse 設置後端環境
git clone 本專案至本地資料夾，複製RestfulAjaxDemo至eclipse workspace，eclipse -> import -> existing maven project
選擇 RestfulAjaxDemo匯入。
配置application properties
```bash
server.port=8050
server.servlet.context-path=/restfulajaxdemo

spring.datasource.url=jdbc:mysql://localhost:3306/eip_ajax
spring.datasource.username=你的使用者名稱
spring.datasource.password=你的密碼
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true

spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
#spring.jpa.hibernate.ddl-auto=update
spring.mvc.hiddenmethod.filter.enabled=true
spring.devtools.restart.enabled=false

spring.servlet.multipart.max-file-size=50KB
spring.servlet.multipart.max-request-size=10MB

logging.level.org.springframework.context.annotation.ClassPathBeanDefinitionScanner=DEBUG


spring.resources.static-locations=classpath:/static
```
vscode 配置前端VUE環境(需有nodejs環境) 本組使用vite工具開發
複製eip-vuevite資料夾至本地資料夾
打vscode，選擇該專案的資料夾，打開new terminal，運行npm install，再運行npm run dev

資料庫建置(mysql)
請參閱restfulajaxdemo.sql作建置 將employee的第一筆資料之email改為自用信箱，以便測試忘記密碼功能

運行
http://localhost:5173/

開啟eipulse登入頁面
目前ajax實現功能，登入及忘記密碼

剛熟悉VUE，實作功能甚少

更完善的功能寫在舊的spring mvc架構(hibernate+jsp)
放在EIPulse資料夾供參考

##舊專案 環境建置
preference
tomcat server(10.1.3) context.xml配置datasouce
```bash
<Resource driverClassName="com.mysql.cj.jdbc.Driver"
url="jdbc:mysql://localhost:3306/EIPULSE"
name="connectMySQLJDBC/server" username="你的使用者名稱" password="你的密碼"
type="javax.sql.DataSource" auth="Container"
initialSize="5" maxTotal="8" maxIdle="5" maxWaitMillis="-1"
poolPreparedStatements="true" validationQuery="select 1"/>
```

資料庫建置(mysql)
請參閱eipulse.sql作建置 將employee的第一筆資料之email改為自用信箱，以便測試忘記密碼功能
運行login.jsp 以開啟頁面