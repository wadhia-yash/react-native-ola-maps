export type LatLng = {
  latitude: number;
  longitude: number;
};

export type Region = LatLng & {
  altitude: number;
  zoomLevel: number;
};
