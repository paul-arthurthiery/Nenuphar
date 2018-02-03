import React, {Component} from 'react';
import { ListItem, ListItemIcon, ListItemText } from 'material-ui/List';

import HomeIcon from 'material-ui-icons/Home';
import FolderSharedIcon from 'material-ui-icons/FolderShared';
import NotificationsIcon from 'material-ui-icons/Notifications';
import {getCourses} from '../../services/courseService';
import ExitToAppIcon from 'material-ui-icons/ExitToApp';


import { Link } from 'react-router-dom';


export default class MenuItems extends Component {
  state = { courseArray: []};


async componentDidMount(){
  var courseArray = await getCourses();
  this.setState({ courseArray: courseArray});
  console.log(this.state.courseArray);

}


render(){
  return(
  <div style={{ height: '100%' }}>
    <Link to="/accueil">
      <ListItem button>
        <ListItemIcon>
          <HomeIcon />
        </ListItemIcon>
        <ListItemText primary="Accueil" />
      </ListItem>
    </Link>

    {this.state.courseArray.map((course) => (
      <Link to={'/'+course}>
        <ListItem button>
          <ListItemIcon>
            <FolderSharedIcon />
          </ListItemIcon>
          <ListItemText primary={course} />
        </ListItem>
      </Link>
    ))}



    <Link to="/notifications">
      <ListItem button>
        <ListItemIcon>
          <NotificationsIcon />
        </ListItemIcon>
        <ListItemText primary="Notifications" />
      </ListItem>
    </Link>

    <Link to="/logout">
      <ListItem button>
        <ListItemIcon>
          <ExitToAppIcon />
        </ListItemIcon>
        <ListItemText primary="Déconnexion" />
      </ListItem>
    </Link>

  </div>
);
}}
