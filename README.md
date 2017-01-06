[![Gitter](https://badges.gitter.im/evollu/react-native-firebase-analytics.svg)](https://gitter.im/evollu/react-native-firebase-analytics?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

## Version table
| version | RN        | FCM     |
| ------- |:----------|:-------:|
| 2.0.0   | >= 0.40.0 | >=9.6    |
| 1.0.6   | <0.40.0   | >=9.6    |

## Installation

- Run `npm install react-native-firebase-analytics --save`
- Run `rnpm link`

or you can combine them into
- Run `rnpm install react-native-firebase-analytics`

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

install pod 'Firebase/Core'

in AppDelegate.m add
```diff
...

 - (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
....
+ [FIRApp configure];
}

}

```


### FCM config file
In [firebase console](https://console.firebase.google.com/), you can get `google-services.json` file and place it in `android/app` directory and get `googleServices-info.plist` file and place it in `/ios` directory

### Usage

```javascript

var Analytics = require('react-native-firebase-analytics');

componentWillMount() {
  if (environment === 'staging') {
    Analytics.setEnabled(false);
  }
  
  
  Analytics.setUserId('11111');
  Analytics.setUserProperty('propertyName', 'propertyValue');

  Analytics.logEvent('view_item', {
    'item_id': 'login'
  });
   
}
```

For more info regarding predefind event and params, visit [firebase api](https://firebase.google.com/docs/reference/android/com/google/firebase/analytics/FirebaseAnalytics.Event#constant-summary)

### Got Issues?
Issues and pull requests are welcomed!
