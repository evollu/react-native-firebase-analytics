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
}

module.exports = FA;