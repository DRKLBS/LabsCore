[![Release](https://jitpack.io/v/DRKLBS/LabsCore.svg)]
(https://jitpack.io/#DRKLBS/LabsCore)

Create your plugins lightning fast with LabsCore API, save all your time and focus on the main logic of your plugin. We provide a lot of useful features and utilities to make your life easier.

Some of the features we provide:
- Easily manage and create GUIs menus
- Create and manage custom items and entities
- Connect to databases and manage data or use our built-in data storage
- Annotations to easily manage commands and listeners
- And much more...
# Getting Started
1. Import Core API using Maven or Gradle
2. Change **extends JavaPlugin** to **extends CorePlugin** (Required to register all basic functionalities and listeners on our side automatically)
3. Change **OnEnable** to **onCoreEnable** and **OnDisable** to **onCoreDisable** (We occupy these methods to perform basic logic)
# Importing Core API
Do not forget to replace **VERSION** with the latest version of the API
You can find the latest version [here](https://github.com/DRKLBS/LabsCore/releases),
or just use the latest version tag **main-SNAPSHOT**
## Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
    <groupId>com.github.DRKLBS</groupId>
    <artifactId>LabsCore</artifactId>
    <version>VERSION</version>
</dependency>
```
## Gradle
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```
```gradle
dependencies {
    implementation 'com.github.DRKLBS:LabsCore:VERSION'
}
```