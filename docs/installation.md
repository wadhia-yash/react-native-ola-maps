# Installation

Install the library from npm:

```sh
$ npm install react-native-ola-maps
```

One has to use [Ola Maps](https://maps.olakrutrim.com/), which in turn requires you to obtain an [API Key](https://maps.olakrutrim.com/docs/auth)

## Android

### Specify your Ola Maps API key

Add your API key to your manifest file (`android/app/src/main/AndroidManifest.xml`):

```xml
<application>
   <!-- You will only need to add this meta-data tag, but make sure it's a child of application -->
   <meta-data
        android:name="com.ola.mapsdk.API_KEY"
        android:value="Your Ola maps API Key Here" />
</application>
```

---

## iOS

After installing the npm package, we need to install the pod.

```sh
$ cd ios && pod install
```

### Enabling Ola Maps
Add your API key and Project ID to your Info.plist file (`ios/<ProjectName>/Info.plist`)

```xml
<plist version="1.0">
        <dict>
                <key>OlaMapAPIKey</key>
	        <string>YOUR OLA MAP API KEY HERE HERE</string>
	        <key>OlaMapProjectId</key>
	        <string>YOUR OLA MAP PROJECT ID HERE</string>
        </dict>
</plist>
```

### Pod Installation

```ruby
  target 'OlaMapsExampleTests' do
    inherit! :complete
    # Add the following pod to access ola maps pod
    pod 'OlaMaps', :git => 'https://github.com/wadhia-yash/ola-maps-pods.git'
  end
```

You've made it 👍. More things are coming into the picture