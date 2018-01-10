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

const App = () => (
  <Reboot>
    <MuiThemeProvider theme={theme}>
      <Router>
        <PageLayout>
          <Route path="/home" component={StudentHome} />
          <Route path="/subject" component={Subject} />
          <Route path="/team/member/:id" component={TeamMember} />
          <Route exact path="/team" component={TeamMembers} />
          <Route exact path="/" component={Login} />
        </PageLayout>
      </Router>
    </MuiThemeProvider>
  </Reboot>
)

ReactDOM.render(<App />, document.getElementById('root'));
