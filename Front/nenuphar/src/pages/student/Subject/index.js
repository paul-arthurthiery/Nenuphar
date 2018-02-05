import React from 'react';

import { Link } from 'react-router-dom';

import Button from 'material-ui/Button';

import PageLayout from '../../../components/PageLayout';
import SubjectGraphMockup from '../../../components/SubjectGraphMockup';
import {GradeDoughnut} from '../../../components/SkillGraph';
import {getCourseInfo, getCourses} from '../../../services/courseService';
import Loading from '../../../components/Loading';

export default class Subject extends React.Component {
  state = {
    loading: false,
    arrayOfSkillInfos: [],
    courseArray: [],
    course: null
  }

  componentWillMount() {
    this.setState({course: this.props.match.params.subject});
  }

  async componentDidMount() {
    this.loadCourseInfo();
  }

  loadCourseInfo = async () => {
    this.setState({loading : true});
    var courseArray = await getCourses();
    var currentID = courseArray[courseArray.map((x) => x.name).indexOf(this.state.course)].id;
    var receivedArray = await getCourseInfo(currentID);
    this.setState({arrayOfSkillInfos: receivedArray, loading: false});
  }

  render() {
    return (
      <div style={{ height: '100%', width: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center', flexDirection: 'column', textAlign: 'center' }}>

      {
        this.state.loading ?
          <Loading />
        :
        <div>
          {
            this.state.arrayOfSkillInfos.map((i) => {
              return(
                <div style={{ width: '100%', maxWidth: 512, margin: '0 auto', marginBottom: 16, color: 'white' }} key={i.skillName.toString()}>
                  <h1 style={{ textDecoration: 'underline' }}>{i.skillName}</h1>
                  {
                    i.subSkillGrades.map((element, index) => {
                      return (
                        <div key={i.subSkillNames[index].toString()}>

                          <h3>{i.subSkillNames[index]+':'}</h3>
                          <GradeDoughnut grade={element}/>
                          <h3>{element+'/5'}</h3>
                        </div>
                      );
                    })
                  }
                </div>
              );
            })
          }

          <Link to="/team">
            <Button raised color="primary">Accès au reste du groupe</Button>
          </Link>
        </div>
      }
      </div>
    )
  }
}
