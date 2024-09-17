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

You've made it 👍. More things are coming into the picture