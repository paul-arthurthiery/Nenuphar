import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import Reboot from 'material-ui/Reboot';
import { MuiThemeProvider, createMuiTheme } from 'material-ui/styles';
import { teal } from 'material-ui/colors';

import './index.css';

import PageLayout from './components/PageLayout';

import Login from './pages/Login';
import StudentHome from './pages/Student/Home';
import TeamMembers from './pages/Student/TeamMembers';
import TeamMember from './pages/Student/TeamMember';
import Subject from './pages/Student/Subject';
import {checkAuth} from './services/userService'


const theme = createMuiTheme({
  palette: {
    type: 'dark',
    primary: teal,
  }
});

export class App extends Component {
  state = {
    isAuthenticated : false
  }

  async componentWillMount(){
    this.setState({isAuthenticated : checkAuth()});
    console.log(this.state.isAuthenticated);
  }




  render(){
  return (
    <Reboot>
      <MuiThemeProvider theme={theme}>
        <Router>
          { this.state.isAuthenticated ?
            <PageLayout>
            </PageLayout>
            :
            <div>
              <Route exact path="/" component={Login} onLoginSuccess={() => this.setState({isAuthenticated : true})} />
            </div>
          }
        </Router>
      </MuiThemeProvider>
    </Reboot>
  );
}}

ReactDOM.render(<App />, document.getElementById('root'));
