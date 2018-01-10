import React from 'react';

import { Link } from 'react-router-dom';

import Button from 'material-ui/Button';

import PageLayout from '../../../components/PageLayout';
import SubjectGraphMockup from '../../../components/SubjectGraphMockup';

export default class Subject extends React.Component {
  render() {
    return (
      <div style={{ height: '100%', width: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center', flexDirection: 'column' }}>
        <div style={{ width: '100%', maxWidth: 512, margin: '0 auto', marginBottom: 16 }}>
          <SubjectGraphMockup withDetails />
        </div>

        <Link to="/team">
          <Button raised color="primary">Accès au reste du groupe</Button>
        </Link>
      </div>
    )
  }
}
