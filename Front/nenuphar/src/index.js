import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route } from 'react-router-dom';

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

state = {
  isAuthenticated: '',
}

const TOKEN_STORAGE_KEY = "nenuphar_access_token";
var token = localStorage.getItem(TOKEN_STORAGE_KEY);
const authenticationResponse =  checkAuth(token).then( (data) => {return data});

const theme = createMuiTheme({
  palette: {
    type: 'dark',
    primary: teal,
  }
});

const App = () => {
  setAuthenticated = (value) => {
    this.setState({isAuthenticated: value})
  }

  let isAuthenticated;
  (token && authenticationResponse.status=="200") ? setAuthenticated(true) : setAuthenticated(false);

  return (
    <Reboot>
      <MuiThemeProvider theme={theme}>
        <Router>
          { isAuthenticated ?
            <PageLayout>
            </PageLayout>
            :
            <div>
              <Route exact path="/" component={Login} onLoginSuccess={this.setAuthenticated} />
            </div>
          }
        </Router>
      </MuiThemeProvider>
    </Reboot>
  );
}

ReactDOM.render(<App />, document.getElementById('root'));
