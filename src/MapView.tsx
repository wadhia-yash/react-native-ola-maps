import { requireNativeComponent } from 'react-native';

const OlaMapNative = requireNativeComponent('OlaMapView');

const MapView = () => <OlaMapNative />;

export default MapView;
