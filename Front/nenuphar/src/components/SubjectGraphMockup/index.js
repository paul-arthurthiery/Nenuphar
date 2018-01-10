import React from 'react';

import mockup from './stats-mockup.png';
import detailedMockup from './stats-details-mockup.png';

export default (props) => (
  <img style={{width: '100%'}} src={props.withDetails ? detailedMockup : mockup} alt="Mockup graphe d'evaluation"/>
)
