import { requireNativeComponent } from 'react-native';
import { View } from 'react-native';

// Use the native OlaMapView component
const OlaMapView = requireNativeComponent('MapView');

const MapView = () => {
  return (
    <View>
      <OlaMapView />
    </View>
  );
};

export default MapView;
