import { postJson } from './request';
const TOKEN_STORAGE_KEY = "nenuphar_access_token";
var userInfo = {
  name: '',
  lastName: ''
}

export function login(username, password) {
  return postJson("/login", {
    login: username,
    password: password,
  });
}

export const checkAuth = async () => {
  var token = localStorage.getItem(TOKEN_STORAGE_KEY);

  if (!token) return false;

  return await postJson(
    "/authenticate", {
      token: token,
    }
  ).then(
    (data) => data.status === 200
  ).catch(
    () => false
  );
}

export const getUserInfo = async () => {
  var token = localStorage.getItem(TOKEN_STORAGE_KEY);

  if (!token) return false;

  return await postJson(
    "/authenticate", {
      token: token,
    }
  ).then(
    (response) => {
      userInfo.name = response.data.name;
      userInfo.lastName = response.data.lastName;
      return userInfo;
    }
  ).catch(
    () => false
  );
}


export function setToken(token) {
  localStorage.setItem(TOKEN_STORAGE_KEY, token);
}

export function deleToken() {
   localStorage.removeItem(TOKEN_STORAGE_KEY);
   console.log("deleted Token");
}
