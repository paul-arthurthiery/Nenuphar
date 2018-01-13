import React, { Component } from 'react';
import Button from 'material-ui/Button';
import './LoginForm.css';
import TextField from 'material-ui/TextField';
import Logo from '../../logo.png';
import Request from '../../services/request';
import axios from 'axios';

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

  handleSubmit = (event) => {
    event.preventDefault();

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
          <Button className="button" raised={true} type="submit" onClick={console.log(this.handleSubmit)}>
            Connexion
          </Button>
        </form>
      </div>
    );
  }
}
