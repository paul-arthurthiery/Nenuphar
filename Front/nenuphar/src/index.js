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
import Loading from './components/Loading'


const theme = createMuiTheme({
  palette: {
    type: 'dark',
    primary: teal,
  }
});

export class App extends Component {
  state = {
    isAuthenticated : false,
    loadingAuthentication : true,
  }



  async componentWillMount(){
    console.log("loading authentication : " + this.state.loadingAuthentication + ", " + "is authenticated : " +this.state.isAuthenticated);
    console.log(localStorage.getItem("nenuphar_access_token").toString());
    this.setState({
      isAuthenticated : await checkAuth(),
      loadingAuthentication : false,
    }, () => {
      this.props.history.push("/accueil");
    });
    console.log("loading authentication : " + this.state.loadingAuthentication + ", " + "is authenticated : " +this.state.isAuthenticated);

  }






  render(){
    const LoginPage = (props) => {
      return (
        <Login
          onLoginSuccess={() => this.setState({isAuthenticated : true})}
          {...props}
        />
      );
    }
    return (
      <Reboot>
        <MuiThemeProvider theme={theme}>
          <Router>
            { this.state.isLoading ?
              <Loading></Loading>
              :
              this.state.isAuthenticated ?
              <PageLayout>
              </PageLayout>
              :

                <Route exact path="/" render={LoginPage}/>

            }
          </Router>
        </MuiThemeProvider>
      </Reboot>
    );
  }
}

ReactDOM.render(<App />, document.getElementById('root'));
