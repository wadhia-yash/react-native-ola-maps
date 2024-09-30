import { useCallback } from 'react';
import { requireNativeComponent, View } from 'react-native';
import type { NativeSyntheticEvent, ViewProps } from 'react-native';
import type { Region } from './sharedTypes';

// Use the native OlaMapView component
const OlaMapView = requireNativeComponent('OlaMapView');

export type MapViewProps = ViewProps & {
  /**
   * The initial region to be displayed by the map. Use this prop instead of 'region'
   */
  initialRegion?: Region;
  /**
   * Callback that is called once the map is ready.
   */
  onMapReady?: (event?: NativeSyntheticEvent<{}>) => void;
  /**
   * This is iOS related feature.
   * The tile url helps you to style the maps. For more information follow the link.
   * https://maps.olakrutrim.com/apidocs/tiles
   */
  tileUrl?: string;
};

const MapView = (props: MapViewProps) => {
  const { onMapReady } = props;

  const handleMapReady = useCallback(() => {
    if (onMapReady) {
      onMapReady();
    }
  }, [onMapReady]);
  console.log('tile', props);

  return (
    <View style={{ flex: 1, backgroundColor: 'green' }}>
      <OlaMapView style={{ flex: 1 }} onMapReady={handleMapReady} {...props} />
    </View>
  );
};

export default MapView;
