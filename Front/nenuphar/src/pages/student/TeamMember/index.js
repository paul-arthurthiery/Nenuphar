import React from 'react';

import { Link } from 'react-router-dom';

import Button from 'material-ui/Button';
import IconButton from 'material-ui/IconButton';
import ArrowBack from 'material-ui-icons/ArrowBack';
import Grid from 'material-ui/Grid';

import PageLayout from '../../../components/PageLayout';
import Loading from '../../../components/Loading';
import SubjectGraphMockup from '../../../components/SubjectGraphMockup';
import TeamMember from '../../../components/TeamMember';

import { fetchTeamMembers } from '../../../services/teamService';

export default class Subject extends React.Component {
  state = {
    loading: true,
    selectedMember: null,
  }

  async componentDidMount() {
    const teamMembers = await fetchTeamMembers();
    const selectedId = parseInt(this.props.match.params.id, 10);
    const selectedMember = teamMembers.find(m => m.id === selectedId);
    this.setState({ loading: false, selectedMember });
  }

  render() {
    const { loading, selectedMember } = this.state;

    return (
      <div style={{ height: '100%', width: '100%'}}>
        <div style={{ height: 64 }}>
          <Link to="/team">
            <IconButton>
              <ArrowBack />
            </IconButton>
          </Link>
        </div>

        <div style={{ height: 'calc(100% - 64px)', width: '100%', display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>

          { loading ?
            <Loading />
            :
            <Grid container>
              <Grid item xs={12} sm={3} style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center' }}>
                <TeamMember link={false} name={selectedMember.name} id={selectedMember.id} />
              </Grid>
              <Grid item xs={12} sm={6}>
                <SubjectGraphMockup withDetails />
              </Grid>
            </Grid>
          }
        </div>
      </div>
    )
  }
}
