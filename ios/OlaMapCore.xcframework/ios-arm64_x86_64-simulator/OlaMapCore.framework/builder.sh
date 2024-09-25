rm -rf build

# For iOS Device
xcodebuild archive \
-scheme OlaMapCore \
-sdk iphoneos \
-configuration Release \
-destination 'generic/platform=iOS' \
-archivePath './build/OlaMapCore.framework-iphoneos.xcarchive' \
SKIP_INSTALL=NO \
BUILD_LIBRARIES_FOR_DISTRIBUTION=YES

## For Simulators
xcodebuild archive \
-scheme OlaMapCore \
-sdk iphoneos \
-configuration Release \
-destination 'generic/platform=iOS Simulator' \
-archivePath './build/OlaMapCore.framework-iphonesimulator.xcarchive' \
SKIP_INSTALL=NO \
BUILD_LIBRARIES_FOR_DISTRIBUTION=YES

## Create XCFramework
xcodebuild -create-xcframework \
 -framework './build/OlaMapCore.framework-iphonesimulator.xcarchive/Products/Library/Frameworks/OlaMapCore.framework' \
-framework './build/OlaMapCore.framework-iphoneos.xcarchive/Products/Library/Frameworks/OlaMapCore.framework' \
-output './build/OlaMapCore.xcframework'
