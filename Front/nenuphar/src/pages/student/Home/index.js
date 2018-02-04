import React, { Component } from 'react';

import { Link } from 'react-router-dom';
import Grid from 'material-ui/Grid';
import Button from 'material-ui/Button';
import TextField from 'material-ui/TextField';
import Typography from 'material-ui/Typography';
import Doughnut from '../../../components/SkillGraph';

import PersonIcon from 'material-ui-icons/Person';


import SubjectGraphMockup from '../../../components/SubjectGraphMockup';
import PageLayout from '../../../components/PageLayout';
import Loading from '../../../components/Loading';
import {getRecentSubSkills} from '../../../services/courseService';

export default class StudentHome extends Component {
  state = {
    loading: false,
    data: [],
    colors: ['#2ecc71', '#e74c3c']
  };

  async componentDidMount () {
    this.setState({ loading: true });

    // fetch data here calling a service :
    this.loadRecentSubSkills();

    // TDDO update this.state.data:
    this.setState({ loading: false });
  }

   loadRecentSubSkills = async () => {
    var recentSubSkills = await getRecentSubSkills();
    this.setState({ data: recentSubSkills});
    console.log(this.state.data[0][1]);
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
                    <Grid item xs={12} sm={6} key={i} style={{color: 'white', textAlign: 'center'}}>
                      <h3 >{this.state.data[i][0]}</h3>
                      <Doughnut  data={[
                        {
                          value: this.state.data[i][1],
                          color: this.state.colors[0]
                        }, {
                          value: 5-this.state.data[i][1],
                          color: this.state.colors[1]
                        }
                      ]} />
                      <h3 >{this.state.data[i][1]+"/5"}</h3>
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
