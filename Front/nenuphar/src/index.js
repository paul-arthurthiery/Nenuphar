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

const theme = createMuiTheme({
  palette: {
    type: 'dark',
    primary: teal,
  }
});

const App = () => {
  setAuthenticated = () => {
    this.setState()
  }

  const isAuthenticated = //// check if authenticated
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
