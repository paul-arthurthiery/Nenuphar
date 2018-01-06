import React, { Component } from 'react';
import Button from 'material-ui/Button';
import './LoginForm.css';
import TextField from 'material-ui/TextField';

class Login extends Component {
  render() {
    return (
      <div className="Login">
        <h1>
          Nénuphar
        </h1>
        <form className="test">
          <TextField>

          </TextField>
          <br></br>
          <TextField>

          </TextField>
        </form>
      </div>
    );
  }
}

export default Login;
