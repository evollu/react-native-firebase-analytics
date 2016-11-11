'use strict';

var React = require('react-native');
var {NativeModules} = React;

var FIRAnalytics = NativeModules.RNFIRAnalytics;

class FA {

    static setUserId(userId) {
        FIRAnalytics.setUserId(userId);
    }

    static setUserProperty(name, property) {
        FIRAnalytics.setUserProperty(name, property);
    }

    static logEvent(name, parameters) {
        FIRAnalytics.logEvent(name, parameters);
    }

    static setScreenName(name) {
        FIRAnalytics.setScreenName(name);
    }

    static setEnabled(enabled) {
        FIRAnalytics.setEnabled(enabled);
    }
}

module.exports = FA;
