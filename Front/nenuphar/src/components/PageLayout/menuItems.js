import React from 'react';
import { ListItem, ListItemIcon, ListItemText } from 'material-ui/List';

import HomeIcon from 'material-ui-icons/Home';
import FolderSharedIcon from 'material-ui-icons/FolderShared';
import NotificationsIcon from 'material-ui-icons/Notifications';

import { Link } from 'react-router-dom';

const menuItems = (
  <div style={{ height: '100%' }}>
    <Link to="/home">
      <ListItem button>
        <ListItemIcon>
          <HomeIcon />
        </ListItemIcon>
        <ListItemText primary="Accueil" />
      </ListItem>
    </Link>

    <Link to="/subject">
      <ListItem button>
        <ListItemIcon>
          <FolderSharedIcon />
        </ListItemIcon>
        <ListItemText primary="Matière 1" />
      </ListItem>
    </Link>


    <Link to="/subject">
      <ListItem button>
        <ListItemIcon>
          <FolderSharedIcon />
        </ListItemIcon>
        <ListItemText primary="Matière 2" />
      </ListItem>
    </Link>


    <Link to="/notifications">
      <ListItem button>
        <ListItemIcon>
          <NotificationsIcon />
        </ListItemIcon>
        <ListItemText primary="Notifications" />
      </ListItem>
    </Link>

  </div>
);

export default menuItems;
