import React, { Component, PropTypes } from 'react';

import Button from 'material-ui/Button';
import TextField from 'material-ui/TextField';

import {login} from '../../services/userService';
import {setToken} from '../../services/userService';

import Logo from '../../logo.png';
import './LoginForm.css';


export default class Login extends Component {
  state = {
    name: '',
    password: '',
  }

  handleNameChange = (event) => {
    this.setState({name: event.target.value});
  }

  handlePasswordChange = (event) => {
    this.setState({password: event.target.value});
  }

  handleSubmit = async (event) => {
    event.preventDefault();
    const response = await login(this.state.name, this.state.password);
    setToken(response.data);
    this.props.onLoginSuccess();

    this.props.history.push("/accueil");
  }

  render() {
    return (
      <div className="LoginPage">
        <h1>
          Nénu<span>phar</span>
        </h1>
        <img src={Logo} />
        <form onSubmit={this.handleSubmit} action="" method="post">
          <TextField className="textfield" placeholder="login ISEP" value={this.state.name} onChange={this.handleNameChange}/>
          <br/>
          <TextField className="textfield" placeholder="Mot de passe ISEP" onChange={this.handlePasswordChange}/>
          <br/>
          <Button className="button" raised={true} type="submit" onClick={this.handleSubmit}>
            Connexion
          </Button>
        </form>
      </div>
    );
  }
}
