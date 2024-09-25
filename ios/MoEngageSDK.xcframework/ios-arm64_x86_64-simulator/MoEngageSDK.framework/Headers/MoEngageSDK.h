//
//  MoEngageSDK.h
//  MoEngageSDK
//
//  Created by Rakshitha on 12/10/22.
//  Copyright © 2022 MoEngage. All rights reserved.
//

#import <Foundation/Foundation.h>

//! Project version number for MoEngageSDK.
FOUNDATION_EXPORT double MoEngageSDKVersionNumber;

//! Project version string for MoEngageSDK.
FOUNDATION_EXPORT const unsigned char MoEngageSDKVersionString[];

// In this header, you should import all the public headers of your framework using statements like #import <MoEngageSDK/PublicHeader.h>
#if !defined(__has_include)
#error "MoEngage.h won't be able to import all the modules if your compiler doesn't support __has_include. Please import the headers individually."
#else

#import <MoEngageCore/MoEngageCore-Swift.h>

    #if __has_include(<MoEngageAnalytics/MoEngageAnalytics-Swift.h>)
        #import <MoEngageAnalytics/MoEngageAnalytics-Swift.h>
    #endif

    #if __has_include(<MoEngageMessaging/MoEngageMessaging-Swift.h>)
        #import <MoEngageMessaging/MoEngageMessaging-Swift.h>
    #endif

#endif

