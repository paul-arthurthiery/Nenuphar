import React, { Component } from 'react';

import { Link } from 'react-router-dom';
import Grid from 'material-ui/Grid';
import Button from 'material-ui/Button';
import TextField from 'material-ui/TextField';
import Typography from 'material-ui/Typography';

import PersonIcon from 'material-ui-icons/Person';


import SubjectGraphMockup from '../../../components/SubjectGraphMockup';
import PageLayout from '../../../components/PageLayout';
import Loading from '../../../components/Loading';

export default class StudentHome extends Component {
  state = {
    loading: false,
    data: [666,666,666,666]
  };

  async componentDidMount () {
    this.setState({ loading: true });

    // fetch data here calling a service :
    await (async () => new Promise(res => setTimeout(() => res(), 1000)))();

    // TDDO update this.state.data:
    this.setState({ loading: false });
  }

  render() {
    return (
      <div style={{ width: '100%', height: '100%' }}>
        {
          this.state.loading ?
            <Loading />
          :
          <div style={{ height: '100%', width: '100%', display: 'flex', alignItems: 'center' }}>
            <Grid container spacing={24} style={{ maxWidth: 512, margin: '0 auto' }}>
              {
                this.state.data.map((_, i) => {
                  return (
                    <Grid item xs={12} sm={6} key={i} style={{ textAlign: i % 2 == 0 ? 'right' : 'left' }}>
                      <SubjectGraphMockup />
                    </Grid>
                  );
                })
              }
            </Grid>
          </div>
        }
      </div>
    );
  }
}
