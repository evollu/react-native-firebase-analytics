
## Installation

- Run `npm install react-native-firebase-analytics --save`
- Run rnpm link

## Android Configuration

- In `android/build.gradle`
```gradle
dependencies {
classpath 'com.android.tools.build:gradle:2.0.0'
classpath 'com.google.gms:google-services:3.0.0' // <- Add this line
```

- In `android/app/build.gradle`
```gradle
apply plugin: "com.android.application"
apply plugin: 'com.google.gms.google-services' // <- Add this line
...
```


### IOS Configuration

install pod 'Firebase/Messaging'

in AppDelegate.m add
```
#import "FCMModule.h"
...

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
....
[FIRApp configure]; <-- add this line
}

```


### FCM config file
In [firebase console](https://console.firebase.google.com/), you can get `google-services.json` file and place it in `android/app` directory and get `googleServices-info.plist` file and place it in `/ios` directory

### Usage

```javascript

var Analytics = require('react-native-firebase-analytics');

componentWillMount() {
  Analytics.logEvent('view_item', {
    'item_id': 'login'
  });
}

```

For more info regarding predefind event and params, visit [firebase api](https://firebase.google.com/docs/reference/android/com/google/firebase/analytics/FirebaseAnalytics.Event#constant-summary)

