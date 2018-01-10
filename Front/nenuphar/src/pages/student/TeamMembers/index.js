import React, { Component } from 'react';

import { Link } from 'react-router-dom';
import Grid from 'material-ui/Grid';
import Button from 'material-ui/Button';
import TextField from 'material-ui/TextField';
import Typography from 'material-ui/Typography';

import PersonIcon from 'material-ui-icons/Person';

import PageLayout from '../../../components/PageLayout';
import Loading from '../../../components/Loading';
import TeamMember from '../../../components/TeamMember';

import { fetchTeamMembers } from '../../../services/teamService';

export default class TeamMembers extends Component {
  state = {
    members: [],
    loading: false,
  };

  async componentDidMount () {
    this.setState({ loading: true });
    const members = await fetchTeamMembers();
    this.setState({ loading: false, members });
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
                  this.state.members.map((m) => {
                    return (
                      <Grid item xs={12} sm={6} key={m.id}>
                        <TeamMember id={m.id} name={m.name} />
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
