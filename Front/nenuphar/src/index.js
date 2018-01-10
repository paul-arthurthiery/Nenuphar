import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Login from './pages/Login';
import Student from './pages/Student';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

import { MuiThemeProvider, createMuiTheme } from 'material-ui/styles';

const theme = createMuiTheme({
  palette: {
    type: 'dark',
  }
});

const App = () => (
  <MuiThemeProvider theme={theme}>
    <Router>
      <div style={{ height: '100%', 'width': '100%' }}>
        <Route path="/student" component={Student}/>
        <Route exact path="/" component={Login}/>
      </div>
    </Router>
  </MuiThemeProvider>
)

ReactDOM.render(<App />, document.getElementById('root'));
