import React, {Component} from 'react';
import { ListItem, ListItemIcon, ListItemText } from 'material-ui/List';

import HomeIcon from 'material-ui-icons/Home';
import FolderSharedIcon from 'material-ui-icons/FolderShared';
import NotificationsIcon from 'material-ui-icons/Notifications';
import {getCourses} from '../../services/courseService';
import {deleToken} from '../../services/userService';
import ExitToAppIcon from 'material-ui-icons/ExitToApp';
import Loading from '../../components/Loading';


import { Link } from 'react-router-dom';


export default class MenuItems extends Component {
  state = {
    loading: false,
    courseArray: []
  };


async componentDidMount(){
  this.setState({loading: true})
  var courseArray = await getCourses();
  this.setState({ courseArray: courseArray, loading: false});

}

logout = () => {
  deleToken();
  this.props.history.replace("/");
}


render(){
  return(
  <div>
    <Link to="/accueil">
      <ListItem button>
        <ListItemIcon>
          <HomeIcon />
        </ListItemIcon>
        <ListItemText primary="Accueil" />
      </ListItem>
    </Link>

    {
      this.state.loading ?
        <Loading />
      :
      this.state.courseArray.map((courseInfo) => (
        <Link to={'/subject/'+courseInfo.name} key={courseInfo.name.toString()}>
          <ListItem button>
            <ListItemIcon>
              <FolderSharedIcon />
            </ListItemIcon>
            <ListItemText primary={courseInfo.name} />
          </ListItem>
        </Link>
      ))
    }



    <Link to="/notifications">
      <ListItem button>
        <ListItemIcon>
          <NotificationsIcon />
        </ListItemIcon>
        <ListItemText primary="Notifications" />
      </ListItem>
    </Link>

    <Link to="/" onClick={this.logout}>
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
