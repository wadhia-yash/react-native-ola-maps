import { requireNativeComponent } from 'react-native';
import { View } from 'react-native';

// Use the native OlaMapView component
const OlaMapView = requireNativeComponent('CliqueMap');

const MapView = () => {
  return (
    <View style={{ flex: 1, backgroundColor: 'green' }}>
      <OlaMapView style={{ flex: 1 }} />
    </View>
  );
};

export default MapView;
