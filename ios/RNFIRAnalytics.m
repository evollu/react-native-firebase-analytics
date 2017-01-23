#import "RNFIRAnalytics.h"
#import <FirebaseAnalytics/FirebaseAnalytics.h>

@implementation RNFIRAnalytics

RCT_EXPORT_MODULE()

@synthesize bridge = _bridge;

- (NSDictionary<NSString *, id> *)constantsToExport
{
  return nil;
}

- (void)dealloc
{
  [[NSNotificationCenter defaultCenter] removeObserver:self];
}

RCT_EXPORT_METHOD(setUserId: (NSString*) userId)
{
  [FIRAnalytics setUserID:userId];
}

RCT_EXPORT_METHOD(setUserProperty: (NSString*)name property: (NSString*)property)
{
  [FIRAnalytics setUserPropertyString:property forName:name];
}

RCT_EXPORT_METHOD(logEvent: (NSString*)name property: (NSDictionary*)parameters)
{
  [FIRAnalytics logEventWithName:name parameters:parameters];
}

RCT_EXPORT_METHOD(setScreenName: (NSString*)name)
{
  [FIRAnalytics setScreenName:name screenClass:nil];
}

RCT_EXPORT_METHOD(setEnabled: (BOOL)enabled)
{
  [[FIRAnalyticsConfiguration sharedInstance] setAnalyticsCollectionEnabled:enabled];
}

@end
