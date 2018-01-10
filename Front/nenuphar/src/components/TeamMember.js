import React from 'react';
import {Link} from 'react-router-dom';
import Typography from 'material-ui/Typography';
import PersonIcon from 'material-ui-icons/Person';

const TeamMember = (props) => {
  const content = (
    <div>
      <PersonIcon color="contrast" style={{ height: 72, width: 72 }} />,
      <Typography align="center">{ props.name }</Typography>
    </div>
  );

  return (
    <div style={{ textAlign: 'center' }}>
      {
        props.link ?
          <Link to={`/team/member/${props.id}`}>
            {content}
          </Link>
        :
          content
      }
    </div>
  );
}

TeamMember.defaultProps = {
  link: true,
};

export default TeamMember;
