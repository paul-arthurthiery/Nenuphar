import React from 'react';
import { ListItem, ListItemIcon, ListItemText } from 'material-ui/List';

import HomeIcon from 'material-ui-icons/Home';
import FolderSharedIcon from 'material-ui-icons/FolderShared';
import NotificationsIcon from 'material-ui-icons/Notifications';

const menuItems = (
  <div style={{ height: '100%' }}>
    <ListItem button>
      <ListItemIcon>
        <HomeIcon />
      </ListItemIcon>
      <ListItemText primary="Accueil" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <FolderSharedIcon />
      </ListItemIcon>
      <ListItemText primary="Matière 1" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <FolderSharedIcon />
      </ListItemIcon>
      <ListItemText primary="Matière 2" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <NotificationsIcon />
      </ListItemIcon>
      <ListItemText primary="Notifications" />
    </ListItem>
  </div>
);

export default menuItems;
