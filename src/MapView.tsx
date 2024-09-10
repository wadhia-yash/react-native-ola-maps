import { useCallback } from 'react';
import { requireNativeComponent, View } from 'react-native';
import type { NativeSyntheticEvent, ViewProps } from 'react-native';
import type { Region } from './sharedTypes';

// Use the native OlaMapView component
const OlaMapView = requireNativeComponent('CliqueMap');

export type MapViewProps = ViewProps & {
  /**
   * The initial region to be displayed by the map. Use this prop instead of 'region'
   */
  initialRegion?: Region;
  /**
   * Callback that is called once the map is ready.
   */
  onMapReady?: (event?: NativeSyntheticEvent<{}>) => void;
};

const MapView = (props: MapViewProps) => {
  const { onMapReady } = props;

  const handleMapReady = useCallback(() => {
    if (onMapReady) {
      onMapReady();
    }
  }, [onMapReady]);

  return (
    <View style={{ flex: 1, backgroundColor: 'green' }}>
      <OlaMapView style={{ flex: 1 }} onMapReady={handleMapReady} {...props} />
    </View>
  );
};

export default MapView;
