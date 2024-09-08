import { View } from 'react-native';
import MapView from 'react-native-ola-maps';

export default function App() {
  return (
    <View style={{ flex: 1, backgroundColor: 'tomato' }}>
      <MapView />
    </View>
  );
}
