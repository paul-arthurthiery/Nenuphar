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
        courses.push(element[1]);
        console.log(element[1]);
      });
      return courses;
    }
  ).catch(
    () => {
      return false;
    }
  );
}
