import React from 'react';
import { CircularProgress } from 'material-ui/Progress';

export default () => (
  <div style={{ width: '100%', height: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
    <div style={{ flex: 1, textAlign: 'center' }}>
      <CircularProgress size={64} style={{ color: 'white' }} />
    </div>
  </div>
)
