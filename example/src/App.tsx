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
      />
    </View>
  );
}
