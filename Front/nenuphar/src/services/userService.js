import { postJson } from './request';
const TOKEN_STORAGE_KEY = "nenuphar_access_token";


export function login(username, password) {
  return postJson("/login", {
    login: username,
    password: password,
  });
}

export const checkAuth = async () => {
  var token = localStorage.getItem(TOKEN_STORAGE_KEY).toString();
  await postJson("/authenticate", {
    token: token,
  }).then( (data) => {
    console.log(data.status);
    if (data.status == 200){
      console.log("status is ok");
      return true;
    }
    return data.status;
  }).catch( () => {
    return false;
  });;
}
