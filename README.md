

# react-native-ola-maps

React Native Ola Map components for iOS + Android

## 🚧 ⚠️  Work in Progress ⚠️ 🚧
This library + documentation is currently in progress. More features are on it's way. Please feel free to contribute and raise issues

## Supports
- Android ✅
- iOS ✅
- Expo - coming soon

## Contribution
This project is being maintained by an individual, and any help with issues and pull requests are always appreciated. If you are able and willing to contribute, please read the [guidelines](./CONTRIBUTING.md).

## Installation

See [Installation Instructions](docs/installation.md)


## Component API


[`<MapView />` Component API](docs/mapview.md)

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## General Usage

```js
import MapView from 'react-native-ola-maps';
```

or

```js
var MapView = require('react-native-ola-maps');
```

### Rendering a Map with an initial region
## MapView

```jsx
<MapView
  initialRegion={{
    latitude: 37.78825,
    longitude: -122.4324,
    altitude: 5,
    zoomLevel: 10,
  }}
/>
```
#### Example
This example displays maps

![](https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExYWE2Njd2MWNnczNiOGNudTMwbjUzZWxyOHE3N2hpd2V3cXpnMDJvMyZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/P91h7izxJ5kSAan7ao/giphy.gif)

## License

MIT

---
