import { postJson } from './request';
const TOKEN_STORAGE_KEY = "nenuphar_access_token";


export function login(username, password) {
  return postJson("/login", {
    login: username,
    password: password,
  });
}

export function checkAuth() {
  var token = localStorage.getItem(TOKEN_STORAGE_KEY).toString();
  postJson("/authenticate", token).then( (data) => {
    if (data.status == "200"){
      return true;
    }
    return false;
  }).catch( () => {
    return false;
  });;
}
