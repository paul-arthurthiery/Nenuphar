import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, withRouter } from 'react-router-dom';

import Reboot from 'material-ui/Reboot';
import { MuiThemeProvider, createMuiTheme } from 'material-ui/styles';
import { teal } from 'material-ui/colors';

import './index.css';

import PageLayout from './components/PageLayout';

import Login from './pages/Login';
import StudentHome from './pages/student/Home';
import TeamMembers from './pages/student/TeamMembers';
import TeamMember from './pages/student/TeamMember';
import Subject from './pages/student/Subject';
import {checkAuth} from './services/userService'
import Loading from './components/Loading'


const theme = createMuiTheme({
  palette: {
    type: 'dark',
    primary: teal,
  }
});

class App extends Component {
  state = {
    isAuthenticated : false,
    loadingAuthentication : true,
  }

  async componentWillMount() {
    const authenticated = await checkAuth();
    this.setAuthenticated(authenticated);
  }

  setAuthenticated = (authenticated) => {
    this.setState({
      isAuthenticated : Boolean(authenticated),
      loadingAuthentication : false,
    });
  }

  render() {
    const LoginPage = (props) => {
      return (
        <Login
          onLoginSuccess={() => this.setAuthenticated(true)}
          {...props}
        />
      );
    }



    return (
      <Reboot>
        <MuiThemeProvider theme={theme}>
          <Router>
            {
              this.state.loadingAuthentication ?
                <div style={{ height: '100%', width: '100%', backgroundColor: 'black' }}>
                  <Loading />
                </div>
                :
                this.state.isAuthenticated ?
                  <PageLayout>
                    <Route path="/accueil" component={StudentHome} />
                    <Route path="/subject/:subject" component={Subject} />
                    <Route path="/team/member/:id" component={TeamMember} />
                    <Route exact path="/team" component={TeamMembers} />
                  </PageLayout>
                  :
                  <Route exact path="/" render={(props) => <LoginPage {...props} />} />
            }
          </Router>
        </MuiThemeProvider>
      </Reboot>
    );
  }
}

ReactDOM.render(<App />, document.getElementById('root'));
