import { postJson } from './request';
const TOKEN_STORAGE_KEY = "nenuphar_access_token";


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
