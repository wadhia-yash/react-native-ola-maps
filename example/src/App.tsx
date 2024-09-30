import { View } from 'react-native';
import MapView from 'react-native-ola-maps';

export default function App() {
  return (
    <View style={{ flex: 1, backgroundColor: 'tomato' }}>
      <MapView
        initialRegion={{
          latitude: 22.303894,
          longitude: 70.802162,
          altitude: 5,
          zoomLevel: 10,
        }}
        tileUrl="https://api.olamaps.io/tiles/vector/v1/styles/default-light-standard/style.json?key=0.4.0"
      />
    </View>
  );
}
