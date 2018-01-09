import React, { Component } from 'react';
import Button from 'material-ui/Button';
import './LoginForm.css';
import TextField from 'material-ui/TextField';
import Logo from './Logo.png';

class Login extends Component {
  constructor(props){
    super(props);
    this.state = {name: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({name: event.target.value});
  }

  handleSubmit(event) {
    alert('Submitted name: ' + this.state.name);
  }


  render() {
    return (
      <div className="Login">
        <h1>
          Nénu<span>phar</span>
        </h1>
        <img src={Logo} />
        <form onSubmit={this.handleSubmit} action="" method="post">
          <TextField className="textfield" placeholder="login ISEP" value={this.state.name} onChange={this.handleChange}/>
          <br/>
          <TextField className="textfield" placeholder="Mot de passe ISEP"/>
          <br/>
          <Button className="button" raised={true} type="submit" children="Se connecter" onClick={console.log(this.state.label)}/>
        </form>
      </div>
    );
  }
}

export default Login;
