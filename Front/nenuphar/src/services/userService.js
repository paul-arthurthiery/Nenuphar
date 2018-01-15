import { postJson } from './request';

export function login(username, password) {
  return postJson("/login", {
    login: username,
    password: password,
  });
}

export function checkAuth(token) {
  return postJson("/authenticate", token);
}
