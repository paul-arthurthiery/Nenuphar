import { postJson } from './request';
const TOKEN_STORAGE_KEY = "nenuphar_access_token";

export const getCourses = async() => {
  var token = localStorage.getItem(TOKEN_STORAGE_KEY);

  if (!token) return false;
  return await postJson(
    "/get_courses", {
      token: token,
    }
  ).then(
    (response) => {
      let courses = [];
      if(response.data.length == 0) {
        courses = ["Matière 1", "Matière 2", "Matière 3"];
      }
      response.data.forEach( function(element) {
        courses.push({name: element.name, id: element.id});
      });
      return courses;
    }
  ).catch(
    () => {
      return false;
    }
  );
}

export const getRecentSubSkills = async() => {
  var token = localStorage.getItem(TOKEN_STORAGE_KEY);

  if (!token) return false;

  return await postJson(
    "/get_lastgradedsubskills", {
      token: token,
    }
  ).then(
    (response) => {
      let recentSubSkills = [];
      let mockResponse = [[1, "4/02/2018", 2, "First SubSkill"], [2, "4/02/2018", 5, "Second SubSkill"], [3, "4/02/2018", 3, "Third SubSkill"], [4, "4/02/2018", 4, "Fourth SubSkill"]];
      //if(response.data.length == 0) {
        response.data = mockResponse;
      //}
      response.data.forEach( function(element) {
        recentSubSkills.push([element[3], element[2]]);
      });
      return recentSubSkills;
    }
  ).catch(
    () => {
      return false;
    }
  );
}

export const getCourseInfo = async(courseID) => {
  var token = localStorage.getItem(TOKEN_STORAGE_KEY);

  if (!token) return false;

  return await postJson(
    "/get_all", {
      course_id: courseID,
      uuid: token
    }
  ).then(
    (response) => {
      let data = response.data;
      let courseArray = [];

      let mockResponse = [
        [
          {"id":1,"name":"Lire","nbrSubSkills":1,"recommendedWeek":null,"course":2,"courseID":null}
        ],
        [
          [
            {"id":1,"name":"Alphabet","grade":1,"skill":1,"skillID":null}
          ]
        ],
        [
          [
            {"id":2,"level":3,"date":"2018-02-01","subskill":1,"user":3,"subSkillID":null,"userID":null}
          ]
        ]
      ];
      if (data.length == 0 || data[0].length == 0) {
        data = mockResponse;
      }
      let currentIndex = 0;
      data[0].forEach( function (element) {
        let skillInfo = {
          skillName : '',
          subSkillNames : [],
          subSkillGrades : []
        };
        skillInfo.skillName = element.name;
        data[1][currentIndex].forEach(function(element) {
          skillInfo.subSkillNames.push(element.name);
        });
        data[2][currentIndex].forEach(function (element) {
          skillInfo.subSkillGrades.push(element.level);
        })
        courseArray.push(skillInfo);
        currentIndex ++;
      })
      return courseArray;
    }
  ).catch(
    () => {
      return false;
    }
  )
}
