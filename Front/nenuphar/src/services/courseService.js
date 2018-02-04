import { postJson } from './request';
const TOKEN_STORAGE_KEY = "nenuphar_access_token";

export const getCourses = async() => {
  var token = localStorage.getItem(TOKEN_STORAGE_KEY);

  if (!token) return false;
  console.log(token);
  return await postJson(
    "/get_courses", {
      token: token,
    }
  ).then(
    (response) => {
      console.log(response);
      let courses = [];
      if(response.data.length == 0) {
        console.log("no courses in response");
        courses = ["Matière 1", "Matière 2", "Matière 3"];
      }
      response.data.forEach( function(element) {
        courses.push(element.name);
        console.log(element.name);
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
      if(response.data.length == 0) {
        response.data = mockResponse;
      }
      response.data.forEach( function(element) {
        recentSubSkills.push([element[3], element[2]]);
      });
      console.log(recentSubSkills);
      return recentSubSkills;
    }
  ).catch(
    () => {
      return false;
    }
  );
}
